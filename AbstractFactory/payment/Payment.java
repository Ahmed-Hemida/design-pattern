package payment;

public interface Payment {
    void initPayment();
    void callBack(int status, String message);
}
