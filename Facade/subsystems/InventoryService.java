package Facade.subsystems;

public class InventoryService {
    public boolean checkStock(String productId, int quantity) {
        System.out.println("[InventoryService] Checking stock for product: " + productId + " (Quantity: " + quantity + ")");
        return true; // Assume available in stock
    }

    public void deductStock(String productId, int quantity) {
        System.out.println("[InventoryService] Deducting " + quantity + " units of product: " + productId);
    }
}
