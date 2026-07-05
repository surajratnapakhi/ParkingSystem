package pricing;

import parkinglot.Ticket;

public abstract class PricingDecorator implements PricingStrategy{

    protected PricingStrategy wrapped;
    public PricingDecorator(PricingStrategy wrapped){
        this.wrapped = wrapped;
    }
}
