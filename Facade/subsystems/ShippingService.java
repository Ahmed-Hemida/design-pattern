package Facade.subsystems;

public class ShippingService {
    public String scheduleDelivery(String orderId) {
        String trackingNumber = "TRK-" + System.currentTimeMillis();
        System.out.println("[ShippingService] Delivery scheduled for order: " + orderId + ". Tracking #: " + trackingNumber);
        return trackingNumber;
    }
}
