package services;

import payment.Payment;
import payment.PaymentService;

public class MasterCardPaymentService extends PaymentService {
    @Override
    protected Payment getPayment() {
        return new MasterCardPayment();
    }
}
