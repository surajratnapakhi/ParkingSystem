package observer;

import enums.SpotType;

import java.util.Map;

public class DisplayBoard implements ParkingObserver{
    private String id;
    public DisplayBoard(String id){
        this.id = id;
    }
    @Override
    public void availabilityChanged(Map<SpotType, Long> availabilityCountByType) {
        System.out.println(" Available count : " + "Board id:" + id);
        for(SpotType spot : SpotType.values()){
            long count = availabilityCountByType.getOrDefault(spot,0L);
            System.out.print(spot + " : " + count + "\t\t\t");
        }
        System.out.println("");
    }
}
