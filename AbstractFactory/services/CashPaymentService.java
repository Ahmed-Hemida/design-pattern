package services;

import payment.Payment;
import payment.PaymentService;

public class CashPaymentService extends PaymentService {
    @Override
    protected Payment createPayment() {
        return new CashPayment();
    }

    @Override
    public void callBack(int status, String message) {
        System.out.println("Cash callback: " + status + " - " + message);
    }
}
