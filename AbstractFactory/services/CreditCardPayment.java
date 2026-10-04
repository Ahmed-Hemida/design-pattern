package services;

import payment.Payment;

public class CreditCardPayment implements Payment {
    @Override
    public int process(int amount) {
        System.out.println("Processing credit card payment for $" + amount);
        return 200;
    }
}
