package pricing;

import enums.VehicleType;
import parkinglot.Ticket;

import java.util.HashMap;
import java.util.Map;

public class FlatRatePricingStrategy implements PricingStrategy{
    Map<VehicleType, Double> rates = new HashMap<>();
    public FlatRatePricingStrategy(Map<VehicleType, Double> rates){
        this.rates = rates;
    }
    @Override
    public double calculateFare(Ticket ticket) {
        return rates.getOrDefault(ticket.getVehicle().getType(),20.0);
    }
}
