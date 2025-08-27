
// Default Methods in Interfaces - Payment Gateway
interface PaymentProcessor {
    void processPayment(double amount);
    default void refund(double amount) {
        System.out.println("Refunded: " + amount);
    }
}

class PayPal implements PaymentProcessor {
    public void processPayment(double amount) { System.out.println("PayPal processed: " + amount); }
}

public class PaymentGateway {
    public static void main(String[] args) {
        PaymentProcessor paypal = new PayPal();
        paypal.processPayment(500);
        paypal.refund(200);
    }
}
