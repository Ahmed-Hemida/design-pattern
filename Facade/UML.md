# Facade Pattern in MVC UML

```mermaid
classDiagram
    class OrderController {
        -orderFacade: OrderFacade
        +checkout(request: OrderRequest) String
    }

    class OrderFacade {
        <<interface>>
        +placeOrder(request: OrderRequest) boolean
    }

    class OrderProcessingFacade {
        -inventoryService: InventoryService
        -paymentService: PaymentService
        -shippingService: ShippingService
        -notificationService: NotificationService
        +placeOrder(request: OrderRequest) boolean
    }

    class InventoryService {
        +checkStock(productId: String, quantity: int) boolean
        +deductStock(productId: String, quantity: int) void
    }

    class PaymentService {
        +processPayment(orderId: String, amount: double) boolean
    }

    class ShippingService {
        +scheduleDelivery(orderId: String) String
    }

    class NotificationService {
        +sendOrderConfirmation(email: String, orderId: String, trackingNumber: String) void
        +sendFailureAlert(email: String, reason: String) void
    }

    class OrderRequest {
        -orderId: String
        -customerEmail: String
        -productId: String
        -quantity: int
        -amount: double
    }

    OrderController --> OrderFacade : delegates to
    OrderFacade <|.. OrderProcessingFacade : implements
    OrderProcessingFacade --> InventoryService : orchestrates
    OrderProcessingFacade --> PaymentService : orchestrates
    OrderProcessingFacade --> ShippingService : orchestrates
    OrderProcessingFacade --> NotificationService : orchestrates
    OrderController ..> OrderRequest : uses
    OrderProcessingFacade ..> OrderRequest : processes
```

### Architectural Role in MVC
1. **Controller (Thin Controller)**: Only handles HTTP request parsing, basic validation, and HTTP response mapping.
2. **Facade Service (OrderProcessingFacade)**: Serves as a single unified entry point that orchestrates complex business interactions among multiple independent subsystem services (`InventoryService`, `PaymentService`, `ShippingService`, `NotificationService`).
3. **Subsystems**: Independent services focusing only on their domain logic, unaware of the Facade or the Controller.
