package services;

import payment.Payment;

public class PaymobPayment implements Payment {
    private boolean successful;

    @Override 
    public String Authentication() {
        System.out.println("Paymob payment Authenticationed.");
        //api call to paymob payment gateway for authentication
        String token = "token12345"; // Simulated token for authentication
        return token;
    }

    @Override
    public boolean inquery() {
        //transaction status check logic for paymob payment
        System.out.println("Checking Paymob payment status.");
        return successful;
    }

    @Override
    public void callBack(int status, String message) {
        System.out.println("Paymob callback: " + status + " - " + message);
    }
}
