# Proxy Pattern UML

```mermaid
classDiagram
    class TransactionService {
        <<interface>>
        +serveTransaction(tx: Transaction) Transaction
    }

    class GasTransactionService {
        +serveTransaction(tx: Transaction) Transaction
    }

    class GasServiceProxy {
        -wrappedService: TransactionService
        +GasServiceProxy(wrappedService: TransactionService)
        +serveTransaction(tx: Transaction) Transaction
    }

    class Transaction {
        -transactionId: int
        -transactionType: String
        -amount: double
        -status: String
        +getTransactionId() int
        +getTransactionType() String
        +getAmount() double
        +getStatus() String
        +setTransactionId(transactionId: int) Transaction
        +setTransactionType(transactionType: String) Transaction
        +setAmount(amount: double) Transaction
        +setStatus(status: String) Transaction
    }

`    class ProxyDesignPattern {
        +main(args: String[]) void
    }`

    TransactionService <|.. GasTransactionService
    TransactionService <|.. GasServiceProxy
    GasServiceProxy o--> TransactionService : wraps
    TransactionService ..> Transaction : serves
   ` ProxyDesignPattern ..> GasTransactionService : creates
    ProxyDesignPattern ..> GasServiceProxy : wraps service
    ProxyDesignPattern ..> Transaction : creates`
```

`GasServiceProxy` implements the same `TransactionService` interface as the concrete service and holds a `TransactionService` reference. This lets it add behavior around the wrapped service call.
