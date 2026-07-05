package parkinglot;

import enums.SpotType;
import observer.ParkingObserver;
import observer.ParkingSubject;
import parkingspot.ParkingSpot;
import payment.PaymentProcessor;
import pricing.*;
import vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot implements ParkingSubject {
    private static volatile ParkingLot instance;
    private List<ParkingSpot> spots;
    private List<ParkingObserver> observers;
    private PricingStrategy pricingStrategy;
    private PaymentProcessor paymentProcessor;

    private ParkingLot(){
        spots = new ArrayList<>();
        observers = new ArrayList<>();

//        ParkingSpot H1 = new ParkingSpot("001", SpotType.HANDICAPPED);
//        spots.add(H1);
//        ParkingSpot H2 = new ParkingSpot("002", SpotType.HANDICAPPED);
//        spots.add(H2);

        ParkingSpot M1 = new ParkingSpot("101", SpotType.MOTORCYCLE);
        spots.add(M1);
        ParkingSpot M2 = new ParkingSpot("102", SpotType.MOTORCYCLE);
        spots.add(M2);

        ParkingSpot C1 = new ParkingSpot("201", SpotType.COMPACT);
        spots.add(C1);
        ParkingSpot C2 = new ParkingSpot("202", SpotType.COMPACT);
        spots.add(C2);

        ParkingSpot T1 = new ParkingSpot("301", SpotType.LARGE);
        spots.add(T1);
        ParkingSpot T2 = new ParkingSpot("302", SpotType.LARGE);
        spots.add(T2);

    }
    public void setPaymentProcessor(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }
    public static ParkingLot getInstance() {
        if(instance == null)
            synchronized (ParkingLot.class){
                if(instance == null)
                    instance = new ParkingLot();
            }

        return instance;
    }
    public Ticket assignSpot(Vehicle vehicle, boolean wantsValet){
        List<SpotType> spotTypes = vehicle.getListOfAcceptableSpotTypes();
        for(SpotType spotType : spotTypes) {
            for (ParkingSpot spot : spots) {
                if (spot.getSpotType().equals(spotType) && spot.tryPark(vehicle)) {
                    Ticket ticket = new Ticket(spot, wantsValet, vehicle, LocalDateTime.now());
                    notifyObservers();
//                    System.out.println("Assigning the spot for vehicle : " + vehicle.getLicensePlate());
                    return ticket;
                }
            }
        }
        return null;
    }
    public void releaseSpot(Ticket ticket){
        ticket.setTentativeExitTime(LocalDateTime.now());
        calculateFare(ticket);
        if(paymentProcessor == null) throw new IllegalStateException("No payment processor has been set.");
        boolean paid = paymentProcessor.processPayment(ticket);
        if(!paid){
            System.out.println("Payment failed for " + ticket.getTicketID());
        } else {
            ticket.getSpot().unParkVehicle();
            notifyObservers();
            ticket.markExit(LocalDateTime.now());
        }

    }

    @Override
    public void registerObserver(ParkingObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(ParkingObserver observer) {
        observers.remove(observer);
    }
    private void notifyObservers(){
        Map<SpotType, Long> availabilityCountByType = spots.stream()
                        .filter(ParkingSpot::isAvailable)
                                .collect(Collectors.groupingBy(ParkingSpot::getSpotType,Collectors.counting()));
        for (ParkingObserver observer : observers){
            observer.availabilityChanged(availabilityCountByType);
        }
    }
    public void setPricingStrategy(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }
    private void calculateFare(Ticket ticket){
        PricingStrategy strategy = pricingStrategy;
        if(ticket.getVehicle().isEV())
            strategy = new EVChargingSurcharge(strategy);
        if(ticket.wantsValet())
            strategy = new ValetSurcharge(strategy);
        ticket.setFare(strategy.calculateFare(ticket));
    }
}
