package pricing;

import enums.VehicleType;
import parkinglot.Ticket;
import vehicle.Vehicle;

import java.time.Duration;
import java.util.Map;

public class HourlyPricingStrategy implements PricingStrategy{
    Map<VehicleType, Double> ratePerHour;

    public HourlyPricingStrategy(Map<VehicleType, Double> ratePerHour){
        this.ratePerHour = ratePerHour;
    }


    @Override
    public double calculateFare(Ticket ticket) {

        Duration parkedDuration = Duration.between(ticket.getEntryTime(), ticket.getExitTime());
        long hours = parkedDuration.toHours();
        if(hours == 0) hours = 1;
        double rate = ratePerHour.getOrDefault(ticket.getVehicle().getType(), 20.0);
        return hours*rate;
    }
}
