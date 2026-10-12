package payment;

public interface Payment {
    String Authentication();
    boolean inquery();
    void callBack(int status, String message);
}
