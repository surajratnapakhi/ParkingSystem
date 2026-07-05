import enums.VehicleType;
import external.PayUClient;
import external.RazorpayClient;
import observer.DisplayBoard;
import observer.FullCapacityAlertObserver;
import observer.ParkingObserver;
import parkinglot.ParkingLot;
import parkinglot.Ticket;
import payment.PayUAdapter;
import payment.RazorPayAdapter;
import payment.RetryPaymentProcessor;
import pricing.HourlyPricingStrategy;
import vehicle.Car;
import vehicle.MotorCycle;
import vehicle.Truck;
import vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingObserver displayBoard = new DisplayBoard("001");
        ParkingObserver parkingFullAlert = new FullCapacityAlertObserver();

        parkingLot.registerObserver(displayBoard);
        parkingLot.registerObserver(parkingFullAlert);

        Map<VehicleType, Double> ratePerHour = new HashMap<>();
        ratePerHour.put(VehicleType.CAR, 40.0);
        ratePerHour.put(VehicleType.MOTORCYCLE, 20.0);
        ratePerHour.put(VehicleType.TRUCK, 80.0);

        Map<VehicleType, Double> flatRate = new HashMap<>();
        flatRate.put(VehicleType.CAR, 60.0);
        flatRate.put(VehicleType.MOTORCYCLE, 30.0);
        flatRate.put(VehicleType.TRUCK, 90.0);

        parkingLot.setPricingStrategy(new HourlyPricingStrategy(ratePerHour));

//        parkingLot.setPaymentProcessor(new RazorPayAdapter(new RazorpayClient(), "MC:001"));
//        parkingLot.setPaymentProcessor(new PayUAdapter(new PayUClient()));
        parkingLot.setPaymentProcessor(new RetryPaymentProcessor(new PayUAdapter(new PayUClient()),3));

        Vehicle v1 = new Car("MH12 AA0001", false);
        Ticket t1 = parkingLot.assignSpot(v1, true);

        Vehicle v2 = new Car("MH12 AA0002", false);
        Ticket t2 = parkingLot.assignSpot(v2, false);

        Vehicle v3 = new Car("MH12 AA0003", false);
        Ticket t3 = parkingLot.assignSpot(v3, false);

        Vehicle v4 = new MotorCycle("MH12 BB001", false);
        Ticket t4 = parkingLot.assignSpot(v4, true);

        Vehicle v5 = new MotorCycle("MH12 BB002", false);
        Ticket t5 = parkingLot.assignSpot(v5, false);

        Vehicle v6 = new Truck("MH12 TT001", false);
        Ticket t6 = parkingLot.assignSpot(v6, false);

        parkingLot.releaseSpot(t1);
        System.out.println("The ticket 1 has fare: " + t1.getFare());
    }
}