package payment;

public abstract class PaymentService implements Payment {

    public  initPayment() {
       
    }


    public abstract void callBack(int status, String message);
}
