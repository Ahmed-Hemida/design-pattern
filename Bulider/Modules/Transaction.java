package Modules;

/**
 * transact
 */
public class Transaction {

    private PaymentMethod paymentMethod;
    private User user;
    private Service service;
    private float price= 0.0f;
     
    // public Transaction(PaymentMethod paymentMethod, User user, Service service, float price) {
    //     this.paymentMethod = paymentMethod;
    //     this.user = user;
    //     this.service = service;
    //     this.price = price;

    // }


    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
        "reference=" + this.hashCode()  +
                ", paymentMethod=" + paymentMethod.getMethodName() +
                ", user=" + user.getName() +
                ", service=" + service.getServiceName() +
                ", price=" + price +
                '}';
    }

 
}