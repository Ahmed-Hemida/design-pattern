package services;

import payment.Payment;

public class PayPalPayment implements Payment {
    @Override
    public int process(int amount) {
        System.out.println("Processing PayPal payment for $" + amount);
        return 200;
    }
}
