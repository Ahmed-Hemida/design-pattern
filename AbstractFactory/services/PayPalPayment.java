package services;

import payment.Payment;

public class PayPalPayment implements Payment {
    private boolean successful;

    @Override
    public String Authentication() {
        System.out.println("PayPal payment initialized.");
        String token = "token12345"; // Simulated token for authentication
        return token;
    }


    @Override
    public boolean inquery() {
        System.out.println("Checking PayPal payment status.");
        return successful;
    }

    @Override
    public void callBack(int status, String message) {
        System.out.println("PayPal callback: " + status + " - " + message);
    }
}
