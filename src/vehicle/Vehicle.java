package vehicle;

import enums.SpotType;
import enums.VehicleType;
import parkingspot.ParkingSpot;

import java.util.List;

public abstract class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;
    public Vehicle(String licensePlate, VehicleType vehicleType){
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }
    public VehicleType getType() {
        return vehicleType;
    }
    public String getLicensePlate(){
        return licensePlate;
    }
    public abstract List<SpotType> getListOfAcceptableSpotTypes();
}
