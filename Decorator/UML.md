# Decorator Pattern UML

```mermaid
classDiagram
    class TransactionService {
        <<interface>>
        +serveTransaction(tx: Transaction) Transaction
    }

    class GasTransactionService {
        +serveTransaction(tx: Transaction) Transaction
    }

    class GasServiceDecorator {
        -wrappedService: TransactionService
        +GasServiceDecorator(wrappedService: TransactionService)
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

`    class DecoratorDesignPattern {
        +main(args: String[]) void
    }`

    TransactionService <|.. GasTransactionService
    TransactionService <|.. GasServiceDecorator
    GasServiceDecorator o--> TransactionService : wraps
    TransactionService ..> Transaction : serves
   ` DecoratorDesignPattern ..> GasTransactionService : creates
    DecoratorDesignPattern ..> GasServiceDecorator : wraps service
    DecoratorDesignPattern ..> Transaction : creates`
```

`GasServiceDecorator` implements the same `TransactionService` interface as the concrete service and holds a `TransactionService` reference. This lets it add behavior around the wrapped service call.
