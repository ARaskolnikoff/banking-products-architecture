## Архитектура _«BankingProductsArchitecture»_

### Описание архитектуры банковских продуктов

- `BankProductInterface` (интерфейс):
    - Определяет основные методы, общие для всех банковских продуктов


- `CardInterface` (интерфейс):
    - Наследуется от `BankProductInterface`
    - Добавляет методы для работы с картами, такие как списание денег


- `CreditCardInterface` (интерфейс):
    - Наследуется от `BankProductInterface` и `CardInterface`
    - Добавляет методы, специфичные для кредитных карт, такие как получение процентной ставки и текущей задолженности


- `DepositInterface` (интерфейс):
    - Наследуется от `BankProductInterface`
    - Добавляет методы, специфичные для вкладов, такие как закрытие вклада


- `AbstractBankProduct` (абстрактный класс):
    - Содержит базовую реализацию общих методов для всех продуктов банка
    - Реализует `BankProductInterface`, предоставляющий основные методы для банковского продукта


- `DebitCard` (класс):
    - Реализует `AbstractBankProduct` и `CardInterface`
    - Представляет дебетовую карту, включая специфическую логику для списания денег


- `CreditCard` (класс):
    - Реализует `AbstractBankProduct` и `CreditCardInterface`
    - Представляет кредитную карту, включая специфическую логику для получения процентной ставки и задолженности


- `Deposit` (класс):
    - Реализует `AbstractBankProduct` и `DepositInterface`
    - Представляет банковский вклад, включая специфическую логику для закрытия вклада


- `ValidateHelper` (класс):
    - Предоставляет вспомогательные методы для валидации значений, используемых в банковских продуктах


- `BankingTests` (класс):
    - Содержит набор юнит-тестов, которые проверяют корректность функциональности каждого класса продукта

### Структура проекта

````
src
├── main
│   └── java
│       └── org
│           └── example
│               └── banking
│                   ├── abstracts
│                   │   └── AbstractBankProduct.java
│                   ├── helpers
│                   │   └── ValidateHelper.java
│                   ├── interfaces
│                   │   ├── BankProductInterface.java
│                   │   ├── CardInterface.java
│                   │   ├── CreditCardInterface.java
│                   │   └── DepositInterface.java
│                   └── products
│                       ├── CreditCard.java
│                       ├── DebitCard.java
│                       └── Deposit.java
└── test
    └── java
        └── org
            └── example
                └── banking
                    └── BankingTests.java
````

> `Java 19` | `JUnit 5`

## Запуск unit-тестов через maven-команды

- ### Запуск позитивных unit-тестов

```
mvn test -Dgroups=positive
```

- ### Запуск негативных unit-тестов

```
mvn test -Dgroups=negative
```
