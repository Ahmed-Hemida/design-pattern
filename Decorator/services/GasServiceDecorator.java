package Decorator.services;

public class GasServiceDecorator implements TransactionService {
    private TransactionService wrappedService;

    public GasServiceDecorator(TransactionService wrappedService) {
        this.wrappedService = wrappedService;
    }

    @Override
    public Transaction serveTransaction(Transaction tx) {
        // Perform additional operations before serving the transaction
        System.out.println("GasServiceDecorator: Performing additional operations before serving the transaction.");
        tx.setAmount(tx.getAmount()+3.5);
        // Call the original service provider's serveTransaction method
        Transaction resultTx = wrappedService.serveTransaction(tx);
        
        // Perform additional operations after serving the transaction
        System.out.println("GasServiceDecorator: Performing additional operations after serving the transaction.");
        resultTx.status = "completed"; // Update the status to "completed"

        return resultTx;
    }

}
