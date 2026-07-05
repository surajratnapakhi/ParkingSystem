package vehicle;

import enums.SpotType;
import enums.VehicleType;
import parkingspot.ParkingSpot;

import java.util.List;

public class Car extends Vehicle{
    public Car(String licensePlate, boolean isEV){
        super(licensePlate, VehicleType.CAR, isEV);
    }
    @Override
    public List<SpotType> getListOfAcceptableSpotTypes() {
        return List.of(SpotType.COMPACT, SpotType.LARGE);
    }
}
