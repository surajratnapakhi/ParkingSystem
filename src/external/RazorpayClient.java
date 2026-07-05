package external;

public class RazorpayClient {
    public void connect(String merchantId) {
        System.out.println("[Razorpay] Connected with merchant: " + merchantId);
    }

    public boolean initiateTransaction(String customerId, double amount, String currency) {
        System.out.println("[Razorpay] Processing ₹" + amount
                + " for customer: " + customerId);
        return true;   // assume success for now
    }

    public void disconnect() {
        System.out.println("[Razorpay] Disconnected");
    }
}
