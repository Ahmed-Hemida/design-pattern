package services;

import payment.Payment;
import payment.PaymentService;

public class PaymobPaymentService extends PaymentService {
    @Override
    protected Payment getPayment() {
        return new PaymobPayment();
    }
}
