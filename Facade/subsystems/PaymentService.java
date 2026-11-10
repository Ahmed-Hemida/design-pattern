package Facade.subsystems;

public class PaymentService {
    public boolean processPayment(String orderId, double amount) {
        System.out.println("[PaymentService] Processing payment of $" + amount + " for order: " + orderId);
        return true; // Payment successful
    }
}
