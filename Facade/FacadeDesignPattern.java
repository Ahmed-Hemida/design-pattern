package Facade;

import Facade.controller.OrderController;
import Facade.model.OrderRequest;

public class FacadeDesignPattern {
    public static void main(String[] args) {
        System.out.println("=== Facade Design Pattern in MVC Architecture ===");

        // In MVC, Client/User interacts with the Controller
        OrderController orderController = new OrderController();

        // 1. Client creates an order request
        OrderRequest request = new OrderRequest(
                "ORD-9876",
                "customer@example.com",
                "PROD-LAPTOP-01",
                1,
                1299.99
        );

        // 2. Client triggers checkout via the Controller
        String response = orderController.checkout(request);

        // 3. Controller returns the result
        System.out.println("[Client] Controller Response: " + response);
    }
}
