package payment;

public abstract class PaymentService {

    private Payment activePayment;

    /** Factory method implemented by each payment provider. */
    protected abstract Payment getPayment();



    /** Submits the payment through the initialized provider. */
    public boolean pay() {
        activePayment = getPayment();
        return activePayment != null && activePayment.Authentication() != null;
    }


    /** Receives the provider's P2P callback and forwards it to the payment. */
    public void callBack(int status, String message) {
        Payment payment = activePayment;
        if (payment == null) {
            System.out.println("Callback received before payment initialization.");
            return;
        }
        payment.callBack(status, message);
    }
}
