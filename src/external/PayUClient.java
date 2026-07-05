package external;

public class PayUClient {
    public String createOrder(double amount) {
        return "ORDER_" + System.currentTimeMillis();
    }
    public boolean executeOrder(String orderId) {
        System.out.println("[PayU] Executing order: " + orderId);
        return true;
    }
}