package services;

import payment.Payment;

public class FawryPayment implements Payment {
    private boolean successful;

    @Override 
    public String Authentication() {
        System.out.println("Fawry payment Authenticationed.");
        String token = "token12345"; // Simulated token for authentication
        return token;
    }

    @Override
    public boolean inquery() {
        System.out.println("Checking Fawry payment status.");
        return successful;
    }

    @Override
    public void callBack(int status, String message) {
        System.out.println("Fawry callback: " + status + " - " + message);
    }
}
