package com.banking.builder;

import com.banking.builder.model.AccountType;
import com.banking.builder.model.BankAccount;
import com.banking.builder.model.Currency;

public class Main {
    public static void main(String[] args) {

        // Step 1: Start the builder with mandatory fields
        // Step 2: Chain optional fields
        // Step 3: Call .build() — validates rules and creates the object
        BankAccount account = BankAccount.builder("ACC-001", "Denishia Maria", AccountType.SAVINGS)
                .balance(5000.00)
                .currency(Currency.USD)
                .interestRate(3.5)
                .debitCardIssued(true)
                .kycVerified(true)
                .onlineBankingEnabled(true)
                .build();

        // Step 4: Use the immutable object — no setters exist on BankAccount
        System.out.println(account);
    }
}
