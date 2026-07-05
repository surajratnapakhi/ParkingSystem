package payment;

import parkinglot.Ticket;

public class RetryPaymentProcessor implements PaymentProcessor{
    private PaymentProcessor wrapped;
    private int maxRetries;
    public RetryPaymentProcessor(PaymentProcessor wrapped, int maxRetries){
        this.wrapped = wrapped;
        this.maxRetries = maxRetries;
    }
    @Override
    public boolean processPayment(Ticket ticket) {
        for(int i=1; i<=maxRetries; i++){
            System.out.println("Attempting payment, attempt:" + i);
            if(wrapped.processPayment(ticket)) return true;
        }
        System.out.println("All the attempts failed, please pay cash");
        return false;
    }
}
