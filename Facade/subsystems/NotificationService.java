package Facade.subsystems;

public class NotificationService {
    public void sendOrderConfirmation(String email, String orderId, String trackingNumber) {
        System.out.println("[NotificationService] Sending confirmation email to " + email + 
                           " for order " + orderId + " with tracking " + trackingNumber);
    }

    public void sendFailureAlert(String email, String reason) {
        System.out.println("[NotificationService] Sending failure alert to " + email + ": " + reason);
    }
}
