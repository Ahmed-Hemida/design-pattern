package Proxy.services;

import Proxy.services.TransactionService;

public class GasServiceProxy implements TransactionService {
    private TransactionService GasServiceProxy = new GasTransactionService();
    final String  userRole;
    
    public GasServiceProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public Transaction serveTransaction(Transaction tx) {

        if (!userRole.toUpperCase().equals("ADMIN")) {
            throw new SecurityException("Access denied: User does not have permission to serve transactions.");
        }

        // have free threads to serve the transaction
        if (!hasFreeThreads()) {
            throw new IllegalStateException("No free threads available to serve the transaction.");
        }
        Transaction resultTx = GasServiceProxy.serveTransaction(tx);

        
       
        return resultTx;
    }

    private boolean hasFreeThreads() {
        // Implement logic to check if there are free threads available
        // For example, you can check the current thread pool size or any other relevant condition
        return true; // Placeholder implementation, replace with actual logic
    }

}
