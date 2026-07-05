package vehicle;

import enums.SpotType;
import enums.VehicleType;

import java.util.List;

public class Truck extends Vehicle{
    public Truck(String licensePlate, boolean isEV){
        super(licensePlate, VehicleType.TRUCK, isEV);
    }
    @Override
    public List<SpotType> getListOfAcceptableSpotTypes() {
        return List.of(SpotType.LARGE);
    }
}
