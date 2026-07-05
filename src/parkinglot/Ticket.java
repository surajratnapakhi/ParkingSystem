package parkinglot;

import parkingspot.ParkingSpot;
import vehicle.Vehicle;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

public class Ticket {
    private static final AtomicInteger ticketIDCounter = new AtomicInteger(0);
    private final int ticketID;
    private ParkingSpot spot;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double fare;
    private boolean wantsValet;

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public Ticket(ParkingSpot spot, boolean wantsValet, Vehicle vehicle, LocalDateTime entryTime) {
        this.ticketID = ticketIDCounter.incrementAndGet();
        this.spot = spot;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
        this.wantsValet = wantsValet;
    }
    public int getTicketID(){
        return ticketID;
    }
    public ParkingSpot getSpot() {
        return spot;
    }
    public boolean wantsValet(){
        return wantsValet;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }
    public void setTentativeExitTime(LocalDateTime exitTime){
        this.exitTime = exitTime;
    }

    public void markExit(LocalDateTime exitTime){
        this.exitTime = exitTime;
    }


}
