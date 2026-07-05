package vehicle;

import enums.SpotType;
import enums.VehicleType;

import java.util.List;

public class MotorCycle extends Vehicle{
    public MotorCycle(String licensePlate, boolean isEV){
        super(licensePlate, VehicleType.MOTORCYCLE, isEV);
    }

    @Override
    public List<SpotType> getListOfAcceptableSpotTypes() {
        return List.of(SpotType.MOTORCYCLE, SpotType.COMPACT);
    }
}
