
import Buliders.DefaultTransactionBuilder;
import Modules.PaymentMethod;
import Modules.Service;
import Modules.Transaction;
import Modules.User;

/**
 * BuliderDesignPattern
 */
public class BuliderDesignPattern {

    public static void main(String[] args) {

        Director director = new Director(new DefaultTransactionBuilder());
        Transaction tx = director.
        constructTransaction(new PaymentMethod("Credit Card"), 
                     new User("John Doe",1), new Service("Cleaning"), 100.0f);

      

        System.out.println(tx.toString());

    }
}
