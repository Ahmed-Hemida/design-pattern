package Decorator.services;

public class GasTransactionService implements TransactionService {
    @Override
    public Transaction serveTransaction(Transaction tx) {
        // Implement the logic to serve the transaction
        // For example, you can process the transaction and update its status
        System.out.println("Transaction Serving completed ");
        tx.status = "pending"; // Update the status to "completed"
        System.out.println("Serving transaction with ID: " + tx.toString());
        return tx;
    }

}
