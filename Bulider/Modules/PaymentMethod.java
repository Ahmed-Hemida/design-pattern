package Modules;

/**
 * PaymentMethod
 */
public class PaymentMethod {
    private String methodName;

    public PaymentMethod(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    
}