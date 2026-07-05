package payment;

import parkinglot.Ticket;

public interface PaymentProcessor {
    boolean processPayment(Ticket ticket);
}
