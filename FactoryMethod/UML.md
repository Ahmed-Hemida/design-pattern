# Factory Method project UML

``` mermaid
classDiagram
    direction TB

    class Reader {
        <<interface>>
        +read(path: String) String
    }

    class ReaderService {
        <<abstract>>
        +readData(path: String) String
        #getReader() Reader
    }

    class CsvReader {
        +read(path: String) String
    }

    class ExelReader {
        +read(path: String) String
    }

    class CsvService {
        +getReader() Reader
    }

    class ExelService {
        #getReader() Reader
    }

   ` class FactoryMethodDesignPattern {
        +main(args: String[]) void
    }`

    Reader <|.. CsvReader
    Reader <|.. ExelReader
    ReaderService <|-- CsvService
    ReaderService <|-- ExelService
    ReaderService ..> Reader : uses returned product
    `CsvService ..> CsvReader : creates
    ExelService ..> ExelReader : creates`
    `FactoryMethodDesignPattern ..> CsvService : instantiates
    FactoryMethodDesignPattern ..> ExelService : instantiates`
```

## Pattern assessment

 The current code follows the Factory Method pattern:

- `Reader` is the product interface; `CsvReader` and `ExelReader` are concrete products.
- `ReaderService` is the creator. Its `readData` method is the shared operation, and `getReader` is the factory method.
- `CsvService` and `ExelService` are concrete creators that choose which `Reader` to create.

Both concrete services inherit `ReaderService.readData()`. That method calls the overridden `getReader()` factory method and delegates reading to the resulting concrete reader. `CsvService` creates a `CsvReader`; `ExelService` creates an `ExelReader`.
