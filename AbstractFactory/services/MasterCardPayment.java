package services;

import payment.Payment;

public class MasterCardPayment implements Payment {
    @Override 
    public String Authentication() {
        System.out.println("Master card payment Authenticationed.");
        String token = "token12345"; // Simulated token for authentication
        return token;
    }


    @Override
    public boolean inquery() {
        System.out.println("Checking Master card payment status.");
        return true;
    }

    @Override
    public void callBack(int status, String message) {
        System.out.println("Master card callback: " + status + " - " + message);
    }
}
