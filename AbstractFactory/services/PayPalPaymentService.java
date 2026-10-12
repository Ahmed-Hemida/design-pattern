package services;

import payment.Payment;
import payment.PaymentService;

public class PayPalPaymentService extends PaymentService {
    @Override
    protected Payment getPayment() {
        return new MasterCardPayment();
    }
}
