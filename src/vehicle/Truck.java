package vehicle;

import enums.SpotType;
import enums.VehicleType;

import java.util.List;

public class Truck extends Vehicle{
    public Truck(String licensePlate){
        super(licensePlate, VehicleType.TRUCK);
    }
    @Override
    public List<SpotType> getListOfAcceptableSpotTypes() {
        return List.of(SpotType.LARGE);
    }
}
