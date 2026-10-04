package services;

import payment.Payment;
import payment.PaymentService;

public class CreditCardPaymentService extends PaymentService {
    @Override
    protected Payment createPayment() {
        return new CreditCardPayment();
    }

    @Override
    public void callBack(int status, String message) {
        System.out.println("Credit card callback: " + status + " - " + message);
    }
}
