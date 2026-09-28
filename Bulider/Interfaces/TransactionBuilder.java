package Interfaces;

import Modules.PaymentMethod;
import Modules.Service;
import Modules.Transaction;
import Modules.User;

/**
 * Transaction
 */
public interface TransactionBuilder {

    // void SetTransaction(PaymentMethod paymentMethod, User user, Service service, float price);
    TransactionBuilder setPaymentMethod(PaymentMethod paymentMethod);
    TransactionBuilder setUser(User user);
    TransactionBuilder setService(Service service);
    TransactionBuilder setPrice(float price);
    Transaction build();
    
}