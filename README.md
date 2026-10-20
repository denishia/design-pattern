# Java Design Patterns

A clean, hands-on Java implementation of 10 classic design patterns, each in its own package with a simple, focused example.

---

## Patterns Implemented

| # | Pattern | Category | Example |
|---|---|---|---|
| 1 | Builder | Creational | BankAccount construction |
| 2 | Factory | Creational | Delivery app notifications |
| 3 | Abstract Factory | Creational | Swiggy vs Zomato notification families |
| 4 | Prototype | Creational | Game bot character cloning |
| 5 | Strategy | Behavioural | Transfer fee calculation |
| 6 | Observer | Behavioural | YouTube channel subscriptions |
| 7 | Chain of Responsibility | Behavioural | Support ticket escalation |
| 8 | Adapter | Structural | Legacy payment gateway integration |
| 9 | Decorator | Structural | Pizza and toppings pricing |
| 10 | Proxy | Structural | Lazy-loaded video streaming |

---

## Project Structure

```
src/main/java/com/banking/
├── builder/            BankAccount with mandatory + optional fields
│   └── model/          BankAccount, AccountType, Currency
├── factory/            NotificationFactory (SMS, Email, Push)
├── abstractfactory/    SwiggyNotificationFactory, ZomatoNotificationFactory
├── prototype/          BotCharacter — shallow copy vs deep copy demo
├── strategy/           TransferService with swappable FeeStrategy
├── observer/           YouTubeChannel notifying subscribed Users
├── chain/              Support ticket: Chatbot → Executive → Tech → Manager
├── adapter/            LegacyGatewayAdapter bridging incompatible payment APIs
├── decorator/          Pizza base + ExtraCheese, Mushrooms, Jalapenos toppings
└── proxy/              VideoProxy with lazy loading and caching
```

---

## Requirements

- Java 17+
- Maven 3.8+

---

## How to Run

### Compile
```bash
mvn compile
```

### Run a specific pattern
```bash
java -cp target/classes com.banking.<pattern>.Main
```

**Examples:**
```bash
java -cp target/classes com.banking.builder.Main
java -cp target/classes com.banking.factory.Main
java -cp target/classes com.banking.abstractfactory.Main
java -cp target/classes com.banking.prototype.Main
java -cp target/classes com.banking.strategy.Main
java -cp target/classes com.banking.observer.Main
java -cp target/classes com.banking.chain.Main
java -cp target/classes com.banking.adapter.Main
java -cp target/classes com.banking.decorator.Main
java -cp target/classes com.banking.proxy.Main
```

---

## Pattern Summaries

### 1. Builder — `com.banking.builder`
Constructs a complex `BankAccount` object step by step.
Mandatory fields are locked in via the constructor; optional fields are chained.
Validation runs in `.build()` before the immutable object is created.

### 2. Factory — `com.banking.factory`
`NotificationFactory.create("SMS" | "EMAIL" | "PUSH")` returns the right notification object.
The client never calls `new SMSNotification()` directly — decoupled from concrete classes.

### 3. Abstract Factory — `com.banking.abstractfactory`
`SwiggyNotificationFactory` and `ZomatoNotificationFactory` each produce a full branded family of SMS + Email + Push notifications.
Guarantees no mixing of products from different families.

### 4. Prototype — `com.banking.prototype`
`BotCharacter` is created once and cloned for each new bot.
Demonstrates the difference between **shallow copy** (shared `List` reference — dangerous) and **deep copy** (independent `List` — safe).

### 5. Strategy — `com.banking.strategy`
`TransferService` holds a `FeeStrategy` that can be swapped at runtime.
`StandardFeeStrategy` (2%), `PremiumFeeStrategy` (flat $5), `StudentFeeStrategy` (free).

### 6. Observer — `com.banking.observer`
`YouTubeChannel` maintains a list of `User` subscribers.
On `uploadVideo()`, all current subscribers are notified automatically.
Supports `subscribe()` and `unsubscribe()` at any time.

### 7. Chain of Responsibility — `com.banking.chain`
Support tickets travel through: **Chatbot → Support Executive → Tech Support → Manager**.
Each handler resolves the ticket if it can, otherwise escalates to the next level.

### 8. Adapter — `com.banking.adapter`
`LegacyGateway` uses `sendMoney(iban, cents)`.
`LegacyGatewayAdapter` implements `PaymentProcessor` and translates `pay(accountNumber, dollars)` into the legacy format.
The app never knows the legacy API exists.

### 9. Decorator — `com.banking.decorator`
`Margherita` and `FarmHouse` are base pizzas.
`ExtraCheese`, `Mushrooms`, `Jalapenos` are decorators that wrap any `Pizza` and add their description and price on top.
Any combination is possible without creating a new subclass.

### 10. Proxy — `com.banking.proxy`
`VideoProxy` wraps `RealVideo`.
On first `play()`, it loads the video from the server (lazy loading).
On subsequent plays, it serves from cache — no re-download.
