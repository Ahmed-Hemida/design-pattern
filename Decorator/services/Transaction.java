package Decorator.services;

public class Transaction {
    int transactionId;
    String transactionType;
    double amount;
    String status;

    public int getTransactionId() {
        return transactionId;
    }
    public Transaction setTransactionId(int transactionId) {
        this.transactionId = transactionId;
        return this;
    }
    public String getTransactionType() {
        return transactionType;
    }
    public Transaction setTransactionType(String transactionType) {
        this.transactionType = transactionType;
        return this;
    }
    public double getAmount() {
        return amount;
    }
    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }
    public String getStatus() {
        return status;
    }
    public Transaction setStatus(String status) {
        this.status = status;
        return this;
    }
    @Override
    public String toString() {
        return "\n #Transaction [\n transactionId=" + transactionId + ",\n transactionType=" + transactionType + ",\n amount="
                + amount + ",\n status=" + status + "\n]";
    }
    

}
