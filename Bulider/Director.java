

import Buliders.DefaultTransactionBuilder;
import Modules.PaymentMethod;
import Modules.Service;
import Modules.Transaction;
import Modules.User;

public class Director {
    
    private DefaultTransactionBuilder builder;

    public Director(DefaultTransactionBuilder builder) {
        this.builder = builder;
    }

    public Transaction constructTransaction(PaymentMethod paymentMethod, User user, Service service, float price) {
        builder.setPaymentMethod(paymentMethod)
               .setUser(user)
               .setService(service)
               .setPrice(price);
        return builder.build();
    }
}
