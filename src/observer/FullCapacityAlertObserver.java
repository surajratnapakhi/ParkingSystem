package observer;

import enums.SpotType;

import java.util.List;
import java.util.Map;

public class FullCapacityAlertObserver implements ParkingObserver{
    @Override
    public void availabilityChanged(Map<SpotType, Long> availabilityCountByType) {
        long totalAvailableCount = availabilityCountByType.values()
                .stream()
                .mapToLong(Long::longValue)
                .sum();
        if(totalAvailableCount == 0){
            System.out.println("-------The parking is full-------");
        }
    }
}
