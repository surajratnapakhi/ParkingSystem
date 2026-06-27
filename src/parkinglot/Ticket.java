package parkinglot;

import parkingspot.ParkingSpot;
import vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private static int ticketID = 000;
    private ParkingSpot spot;
    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private int fare;

    public Ticket(ParkingSpot spot, Vehicle vehicle, LocalDateTime entryTime) {
        ticketID += 1;
        this.spot = spot;
        this.vehicle = vehicle;
        this.entryTime = entryTime;
    }

    public ParkingSpot getSpot() {
        return spot;
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

    public void markExit(LocalDateTime exitTime){
        this.exitTime = exitTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "spot=" + spot +
                ", vehicle=" + vehicle +
                ", entryTime=" + entryTime +
                ", exitTime=" + exitTime +
                ", fare=" + fare +
                '}';
    }

}
