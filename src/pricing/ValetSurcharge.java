package pricing;

import parkinglot.Ticket;

public class ValetSurcharge extends PricingDecorator {
    private static final double VALET_FEE = 30;
    public ValetSurcharge(PricingStrategy wrapped) {
        super(wrapped);
    }

    @Override
    public double calculateFare(Ticket ticket) {
        return wrapped.calculateFare(ticket) + VALET_FEE;
    }
}
