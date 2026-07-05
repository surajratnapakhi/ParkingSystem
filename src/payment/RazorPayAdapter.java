package payment;

import external.RazorpayClient;
import parkinglot.Ticket;

public class RazorPayAdapter implements PaymentProcessor{
    private RazorpayClient razorpayClient;
    private String marchantID;
    public RazorPayAdapter(RazorpayClient razorpayClient, String marchantID){
        this.razorpayClient = razorpayClient;
        this.marchantID = marchantID;
    }

    @Override
    public boolean processPayment(Ticket ticket) {
        razorpayClient.connect(marchantID);

        boolean transactionSuccess = razorpayClient.initiateTransaction(
                ticket.getVehicle().getLicensePlate(),
                ticket.getFare(),
                "INR");

        razorpayClient.disconnect();

        return transactionSuccess;
    }
}
