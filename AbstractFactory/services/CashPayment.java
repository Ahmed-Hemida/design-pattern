package services;

import payment.Payment;

public class CashPayment implements Payment {
    @Override
    public int process(int amount) {
        System.out.println("Processing cash payment for $" + amount);
        return 200;
    }
}
