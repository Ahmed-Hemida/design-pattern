package services;

import payment.Payment;
import payment.PaymentService;

public class PayPalPaymentService extends PaymentService {
    @Override
    protected Payment createPayment() {
        return new PayPalPayment();
    }

    @Override
    public void callBack(int status, String message) {
        System.out.println("PayPal callback: " + status + " - " + message);
    }
}
