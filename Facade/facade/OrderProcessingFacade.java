package Facade.facade;

import Facade.model.OrderRequest;
import Facade.subsystems.InventoryService;
import Facade.subsystems.NotificationService;
import Facade.subsystems.PaymentService;
import Facade.subsystems.ShippingService;

/**
 * Concrete Facade:
 * Encapsulates the complexity and coordination of multiple underlying subsystems
 * (Inventory, Payment, Shipping, Notification).
 */
public class OrderProcessingFacade implements OrderFacade {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    // Subsystems can be injected via dependency injection or instantiated directly
    public OrderProcessingFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
        this.notificationService = new NotificationService();
    }

    public OrderProcessingFacade(InventoryService inventoryService,
                                 PaymentService paymentService,
                                 ShippingService shippingService,
                                 NotificationService notificationService) {
        this.inventoryService = inventoryService;
        this.paymentService = paymentService;
        this.shippingService = shippingService;
        this.notificationService = notificationService;
    }

    @Override
    public boolean placeOrder(OrderRequest request) {
        System.out.println("--- [OrderProcessingFacade] Starting order placement workflow ---");

        // Step 1: Check inventory
        boolean isAvailable = inventoryService.checkStock(request.getProductId(), request.getQuantity());
        if (!isAvailable) {
            notificationService.sendFailureAlert(request.getCustomerEmail(), "Item out of stock.");
            return false;
        }

        // Step 2: Process payment
        boolean paymentSuccess = paymentService.processPayment(request.getOrderId(), request.getAmount());
        if (!paymentSuccess) {
            notificationService.sendFailureAlert(request.getCustomerEmail(), "Payment failed.");
            return false;
        }

        // Step 3: Deduct inventory stock
        inventoryService.deductStock(request.getProductId(), request.getQuantity());

        // Step 4: Schedule delivery
        String trackingNumber = shippingService.scheduleDelivery(request.getOrderId());

        // Step 5: Send notification to customer
        notificationService.sendOrderConfirmation(request.getCustomerEmail(), request.getOrderId(), trackingNumber);

        System.out.println("--- [OrderProcessingFacade] Order completed successfully! ---");
        return true;
    }
}
