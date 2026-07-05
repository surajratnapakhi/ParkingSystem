package vehicle;

import enums.SpotType;
import enums.VehicleType;
import parkingspot.ParkingSpot;

import java.util.List;

public abstract class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;
    private boolean isEV;

    public Vehicle(String licensePlate, VehicleType vehicleType, boolean isEV){
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
        this.isEV = isEV;
    }
    public VehicleType getType() {
        return vehicleType;
    }
    public String getLicensePlate(){
        return licensePlate;
    }
    public boolean isEV() {
        return isEV;
    }
    public abstract List<SpotType> getListOfAcceptableSpotTypes();
}
