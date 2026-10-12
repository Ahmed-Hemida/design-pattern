import payment.PaymentService;
import services.FawryPaymentService;
import services.PayPalPaymentService;
import services.PaymobPaymentService;

public class AbstractFactoryDesignPattern {

    public static void main(String[] args) {

        PaymentService fawryPaymentService = new FawryPaymentService();
        fawryPaymentService.pay();
        
        PaymentService payPalPaymentService = new PayPalPaymentService();
        payPalPaymentService.pay();

        PaymentService paymobPaymentService = new PaymobPaymentService();
        paymobPaymentService.pay();

    }
}
