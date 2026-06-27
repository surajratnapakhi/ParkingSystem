package observer;

import enums.SpotType;

import java.util.Map;

public interface ParkingObserver {
    public void availabilityChanged(Map<SpotType,Long> availabilityCountByType);
}
