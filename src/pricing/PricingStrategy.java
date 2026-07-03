package pricing;

import parkinglot.Ticket;

public interface PricingStrategy {
    double calculateFare(Ticket ticket);
}
