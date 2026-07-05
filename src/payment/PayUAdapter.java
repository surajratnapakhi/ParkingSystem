package payment;

import external.PayUClient;
import parkinglot.Ticket;

public class PayUAdapter implements PaymentProcessor{
    private PayUClient payUClient;

    public PayUAdapter(PayUClient payUClient){
        this.payUClient = payUClient;
    }
    @Override
    public boolean processPayment(Ticket ticket) {
        return payUClient.executeOrder(payUClient.createOrder(ticket.getFare()));
    }
}
