package parkingspot;

import enums.SpotType;
import vehicle.Vehicle;

public class ParkingSpot {
    private String id;
    private SpotType spotType;

    private volatile boolean isOccupied;
    private Vehicle vehicle;
    public ParkingSpot(String id, SpotType spotType){
        this.id = id;
        this.spotType = spotType;
        this.isOccupied = false;
    }

    public String getId() {
        return id;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }
    public synchronized boolean tryPark(Vehicle vehicle){
        if(isOccupied) return false;
        isOccupied = true;
        this.vehicle = vehicle;
        return true;
    }
    public synchronized void unParkVehicle(){
//        System.out.println("UnParking the vehicle "+ vehicle.getLicensePlate() + ", from the spot: " + id);
        this.vehicle = null;
        isOccupied = false;
    }

}
