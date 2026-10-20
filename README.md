# Enterprise Banking Design Patterns: Builder Pattern in Java

A clean, production-grade Java implementation demonstrating design patterns applied directly to mission-critical banking architectures.

---

## 1. Why Builder Pattern in Banking?

In core banking, payment gateways, and wealth management platforms, domain models frequently contain dozens of parameters (e.g., account limits, currency, interest rules, compliance flags, KYC status).

### Critical Anti-Patterns Solved:
1. **Telescoping Constructor Anti-Pattern:**
   ```java
   // Hard to read, error-prone parameter ordering (e.g. swapping currency and limits)
   new BankAccount("ACC-1", "John", "USD", 1000.0, 500.0, 0.05, true, false, true, ...);
   ```
2. **JavaBean Mutability Anti-Pattern:**
   ```java
   // Thread safety & consistency risk: object is partially constructed and exposed
   BankAccount acc = new BankAccount();
   acc.setAccountNumber("ACC-1");
   // Another thread reads acc before balance or KYC is set!
   acc.setBalance(new BigDecimal("1000.00"));
   ```
3. **Immutability & Audit Safety:**
   Banking models must be **immutable** after creation to prevent unauthorized tampering or concurrency race conditions.

---

## 2. Implemented Pattern Variations

### A. Classic GoF Builder (`BankAccount`)
- **Location:** [`com.banking.builder.model.BankAccount`](src/main/java/com/banking/builder/model/BankAccount.java:1)
- **Features:**
  - Mandatory parameters (`accountNumber`, `accountHolderName`, `accountType`) passed via `BankAccount.builder(...)`.
  - Fluent chained setters for optional parameters.
  - Invariant validation before instantiation (e.g., credit card cannot be issued without KYC verification).
  - Complete immutability (no setters on `BankAccount`).

### B. Director Pattern (`AccountDirector`)
- **Location:** [`com.banking.builder.director.AccountDirector`](src/main/java/com/banking/builder/director/AccountDirector.java:1)
- **Features:**
  - Pre-assembled account product templates (`createStandardSavingsAccount`, `createCorporatePremiumAccount`, `createStudentAccount`).
  - Shields clients from complex configuration routines.

### C. Compile-Time Step Builder Pattern (`FundTransferTransaction`)
- **Location:** [`com.banking.builder.stepbuilder.FundTransferTransaction`](src/main/java/com/banking/builder/stepbuilder/FundTransferTransaction.java:1)
- **Why it matters in Banking:**
  - Standard builders allow calling `.build()` at any time, risking missing fields.
  - The **Step Builder** forces sequential completion of mandatory transfer steps via typed interfaces:
    ```
    fromAccount() -> toAccount() -> amount() -> currency() -> transferType() -> [optional modifiers] -> build()
    ```
  - The compiler prevents building incomplete payment transactions.

### D. Complex Underwriting Loan Builder (`LoanApplication`)
- **Location:** [`com.banking.builder.loan.LoanApplication`](src/main/java/com/banking/builder/loan/LoanApplication.java:1)
- **Features:**
  - Multi-field mortgage & credit line validation (income verification, credit score bounds, co-applicant rules, collateral values).

---

## 3. Project Structure

```
banking-design-patterns/
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/banking/builder/
    │   ├── Main.java                          <-- Interactive demonstration
    │   ├── director/
    │   │   └── AccountDirector.java
    │   ├── loan/
    │   │   ├── LoanApplication.java
    │   │   └── LoanType.java
    │   ├── model/
    │   │   ├── AccountType.java
    │   │   ├── BankAccount.java
    │   │   └── Currency.java
    │   └── stepbuilder/
    │       ├── FundTransferTransaction.java
    │       ├── TransactionChannel.java
    │       └── TransactionType.java
    └── test/java/com/banking/builder/
        ├── BankAccountBuilderTest.java        <-- JUnit 5 test suite
        └── FundTransferStepBuilderTest.java
```

---

## 4. How to Run & Test

### Requirements:
- Java JDK 17+
- Apache Maven 3.8+

### Compile & Run Tests:
```bash
mvn clean test
```

### Run Demo Application:
```bash
mvn compile exec:java -Dexec.mainClass="com.banking.builder.Main"
```
