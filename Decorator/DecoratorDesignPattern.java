package Decorator;

import Decorator.services.GasTransactionService;
import Decorator.services.GasServiceDecorator;
import Decorator.services.TransactionService;
import Decorator.services.Transaction;

public class DecoratorDesignPattern {
   public static void main(String[] args) {
        // Create a transaction
        Transaction tx = new Transaction()
                .setTransactionId(1)
                .setTransactionType("Gas")
                .setAmount(100.0)
                .setStatus("new");


        // Create a gas transaction service
        TransactionService gasProvider = new GasTransactionService();

        // Wrap the gas transaction service with the decorator
        TransactionService gasDecorator = new GasServiceDecorator(gasProvider);

        // // Serve the transaction using the decorated service provider
        Transaction resultTx = gasDecorator.serveTransaction(tx);

        // // Print the result transaction
        System.out.println("Result Transaction: " + resultTx);
    }

    

}
