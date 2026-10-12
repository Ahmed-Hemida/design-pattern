package services;

import payment.Payment;
import payment.PaymentService;

public class FawryPaymentService extends PaymentService {
    @Override
    protected Payment getPayment() {
        return new FawryPayment();
    }
}
