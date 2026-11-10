package Facade.model;

public class OrderRequest {
    private String orderId;
    private String customerEmail;
    private String productId;
    private int quantity;
    private double amount;

    public OrderRequest(String orderId, String customerEmail, String productId, int quantity, double amount) {
        this.orderId = orderId;
        this.customerEmail = customerEmail;
        this.productId = productId;
        this.quantity = quantity;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getAmount() {
        return amount;
    }
}
