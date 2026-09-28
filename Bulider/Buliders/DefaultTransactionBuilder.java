package Buliders;

import Interfaces.TransactionBuilder;
import Modules.PaymentMethod;
import Modules.Service;
import Modules.Transaction;
import Modules.User;

/**
 * TransactionBuilder
 */
public class DefaultTransactionBuilder implements TransactionBuilder {

    private Transaction transaction;

    public DefaultTransactionBuilder () {
            this.restart();
    }
    public void restart() {
        this.transaction = new Transaction();
    }

    // @Override
    public void SetTransaction(PaymentMethod paymentMethod, User user, Service service, float price) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public DefaultTransactionBuilder setPaymentMethod(PaymentMethod paymentMethod) {
       this.transaction.setPaymentMethod(paymentMethod);
       return this;
    }

    @Override
    public DefaultTransactionBuilder setUser(User user) {
        this.transaction.setUser(user);
        return this;
    }

    @Override
    public DefaultTransactionBuilder setService(Service service) {
        this.transaction.setService(service);
        return this;
    }

    @Override
    public DefaultTransactionBuilder setPrice(float price) {
        this.transaction.setPrice(price);
        return this;
    }


    @Override
    public Transaction build() {
        Transaction tx = this.transaction;
        this.restart();
        return tx;
    }

}