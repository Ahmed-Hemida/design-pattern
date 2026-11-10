package Facade.controller;

import Facade.facade.OrderFacade;
import Facade.facade.OrderProcessingFacade;
import Facade.model.OrderRequest;

/**
 * Controller Layer in MVC:
 * The controller only depends on the unified Facade service,
 * keeping the controller "skinny" and decoupling it from subsystem details.
 */
public class OrderController {

    private final OrderFacade orderFacade;

    public OrderController() {
        this.orderFacade = new OrderProcessingFacade();
    }

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }

    /**
     * Simulates an HTTP endpoint handler (e.g. POST /api/orders/checkout)
     */
    public String checkout(OrderRequest request) {
        System.out.println("\n[OrderController] Received checkout request for order: " + request.getOrderId());

        // Basic controller validation
        if (request.getQuantity() <= 0 || request.getAmount() <= 0) {
            return "400 Bad Request: Invalid order details.";
        }

        // Delegate entire complex business logic to the Facade
        boolean success = orderFacade.placeOrder(request);

        if (success) {
            return "200 OK: Order placed successfully!";
        } else {
            return "500 Internal Error: Order processing failed.";
        }
    }
}
