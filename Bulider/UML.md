# UML Class Diagram

```mermaid
classDiagram
    class TransactionBuilder {
        <<interface>>
        +setPaymentMethod(PaymentMethod) TransactionBuilder
        +setUser(User) TransactionBuilder
        +setService(Service) TransactionBuilder
        +setPrice(float) TransactionBuilder
        +build() Transaction
    }

    class DefaultTransactionBuilder {
        -transaction: Transaction
        +DefaultTransactionBuilder()
        +restart() void
        +setPaymentMethod(PaymentMethod) DefaultTransactionBuilder
        +setUser(User) DefaultTransactionBuilder
        +setService(Service) DefaultTransactionBuilder
        +setPrice(float) DefaultTransactionBuilder
        +build() Transaction
    }

    class Transaction {
        -paymentMethod: PaymentMethod
        -user: User
        -service: Service
        -price: float
        +getPaymentMethod() PaymentMethod
        +setPaymentMethod(PaymentMethod) void
        +getUser() User
        +setUser(User) void
        +getService() Service
        +setService(Service) void
        +getPrice() float
        +setPrice(float) void
        +toString() String
    }

    class User {
        -name: String
        -id: int
        +User(name: String, id: int)
        +getName() String
        +getId() int
        +setName(String) void
        +setId(int) void
    }

    class PaymentMethod {
        -methodName: String
        +PaymentMethod(methodName: String)
        +getMethodName() String
        +setMethodName(String) void
    }

    class Service {
        -serviceName: String
        +Service(serviceName: String)
        +getServiceName() String
        +setServiceName(String) void
    }

    class BuliderDesignPattern {
        +main(String[]) void
    }

    TransactionBuilder <|.. DefaultTransactionBuilder : implements
    DefaultTransactionBuilder ..> Transaction : creates
    Transaction *-- User : user
    Transaction *-- PaymentMethod : payment method
    Transaction *-- Service : service
    BuliderDesignPattern ..> DefaultTransactionBuilder : uses
```

`Transaction *-- User`, `PaymentMethod`, and `Service` show that `Transaction` holds references to these objects. They are associations in the code; the filled diamonds are used here to show the transaction's conceptual ownership of those fields.
