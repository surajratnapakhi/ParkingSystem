package pricing;

import parkinglot.Ticket;

public class EVChargingSurcharge extends PricingDecorator{
    private final static double EV_FARE = 50;
    public EVChargingSurcharge(PricingStrategy wrapped) {
        super(wrapped);
    }

    @Override
    public double calculateFare(Ticket ticket) {
        return wrapped.calculateFare(ticket) + EV_FARE;
    }
}
