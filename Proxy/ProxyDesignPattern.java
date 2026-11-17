package Proxy;

import Proxy.services.GasTransactionService;
import Proxy.services.GasServiceProxy;
import Proxy.services.TransactionService;
import Proxy.services.Transaction;

public class ProxyDesignPattern {
   public static void main(String[] args) {
        // Create a transaction
        Transaction tx = new Transaction()
                .setTransactionId(1)
                .setTransactionType("Gas")
                .setAmount(100.0)
                .setStatus("new");


        // Create a gas transaction service
       

        // Wrap the gas transaction service with the Proxy
        TransactionService gasProxy = new GasServiceProxy("ADMIN");

        // // Serve the transaction using the decorated service provider
        Transaction resultTx = gasProxy.serveTransaction(tx);

        // Print the result transaction
        System.out.println("Result Transaction: " + resultTx);
    }

    

}
