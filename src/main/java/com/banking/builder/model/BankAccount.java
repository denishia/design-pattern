package com.banking.builder.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Real-world Banking Account model representing an immutable customer account.
 * Implements the Classic GoF Builder Pattern to solve:
 * 1. Telescoping Constructor anti-pattern (constructors with 10+ overloaded arguments)
 * 2. JavaBean mutability risk (setters leaving objects in inconsistent states in multi-threaded banking systems)
 * 3. Atomic validation prior to object instantiation.
 */
public final class BankAccount {

    // Mandatory core banking fields
    private final String accountNumber;
    private final String accountHolderName;
    private final AccountType accountType;
    private final BigDecimal balance;
    private final Currency currency;

    // Optional attributes with sensible defaults
    private final BigDecimal interestRate;
    private final BigDecimal overdraftLimit;
    private final BigDecimal dailyTransferLimit;
    private final boolean debitCardIssued;
    private final boolean creditCardIssued;
    private final boolean onlineBankingEnabled;
    private final boolean paperlessStatementEnabled;
    private final boolean internationalTransactionsAllowed;
    private final boolean kycVerified;
    private final String branchCode;
    private final String swiftBic;
    private final LocalDate openingDate;

    // Private constructor: Only accessible via BankAccount.Builder
    private BankAccount(Builder builder) {
        this.accountNumber = builder.accountNumber;
        this.accountHolderName = builder.accountHolderName;
        this.accountType = builder.accountType;
        this.balance = builder.balance;
        this.currency = builder.currency;
        this.interestRate = builder.interestRate;
        this.overdraftLimit = builder.overdraftLimit;
        this.dailyTransferLimit = builder.dailyTransferLimit;
        this.debitCardIssued = builder.debitCardIssued;
        this.creditCardIssued = builder.creditCardIssued;
        this.onlineBankingEnabled = builder.onlineBankingEnabled;
        this.paperlessStatementEnabled = builder.paperlessStatementEnabled;
        this.internationalTransactionsAllowed = builder.internationalTransactionsAllowed;
        this.kycVerified = builder.kycVerified;
        this.branchCode = builder.branchCode;
        this.swiftBic = builder.swiftBic;
        this.openingDate = builder.openingDate;
    }

    public static Builder builder(String accountNumber, String accountHolderName, AccountType accountType) {
        return new Builder(accountNumber, accountHolderName, accountType);
    }

    // --- Getters (Immutable - no setters) ---
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolderName() { return accountHolderName; }
    public AccountType getAccountType() { return accountType; }
    public BigDecimal getBalance() { return balance; }
    public Currency getCurrency() { return currency; }
    public BigDecimal getInterestRate() { return interestRate; }
    public BigDecimal getOverdraftLimit() { return overdraftLimit; }
    public BigDecimal getDailyTransferLimit() { return dailyTransferLimit; }
    public boolean isDebitCardIssued() { return debitCardIssued; }
    public boolean isCreditCardIssued() { return creditCardIssued; }
    public boolean isOnlineBankingEnabled() { return onlineBankingEnabled; }
    public boolean isPaperlessStatementEnabled() { return paperlessStatementEnabled; }
    public boolean isInternationalTransactionsAllowed() { return internationalTransactionsAllowed; }
    public boolean isKycVerified() { return kycVerified; }
    public String getBranchCode() { return branchCode; }
    public String getSwiftBic() { return swiftBic; }
    public LocalDate getOpeningDate() { return openingDate; }

    @Override
    public String toString() {
        return "BankAccount {\n" +
                "  accountNumber = '" + accountNumber + "',\n" +
                "  accountHolderName = '" + accountHolderName + "',\n" +
                "  accountType = " + accountType + ",\n" +
                "  balance = " + balance + " " + currency + ",\n" +
                "  interestRate = " + interestRate + "%,\n" +
                "  overdraftLimit = " + overdraftLimit + " " + currency + ",\n" +
                "  dailyTransferLimit = " + dailyTransferLimit + " " + currency + ",\n" +
                "  debitCardIssued = " + debitCardIssued + ",\n" +
                "  creditCardIssued = " + creditCardIssued + ",\n" +
                "  onlineBankingEnabled = " + onlineBankingEnabled + ",\n" +
                "  paperlessStatement = " + paperlessStatementEnabled + ",\n" +
                "  internationalAllowed = " + internationalTransactionsAllowed + ",\n" +
                "  kycVerified = " + kycVerified + ",\n" +
                "  branchCode = '" + branchCode + "',\n" +
                "  swiftBic = '" + swiftBic + "',\n" +
                "  openingDate = " + openingDate + "\n" +
                "}";
    }

    /**
     * Static nested Builder class.
     */
    public static class Builder {
        // Mandatory fields
        private final String accountNumber;
        private final String accountHolderName;
        private final AccountType accountType;

        // Optional fields with sensible banking defaults
        private BigDecimal balance = BigDecimal.ZERO;
        private Currency currency = Currency.USD;
        private BigDecimal interestRate = BigDecimal.ZERO;
        private BigDecimal overdraftLimit = BigDecimal.ZERO;
        private BigDecimal dailyTransferLimit = new BigDecimal("5000.00");
        private boolean debitCardIssued = false;
        private boolean creditCardIssued = false;
        private boolean onlineBankingEnabled = true;
        private boolean paperlessStatementEnabled = true;
        private boolean internationalTransactionsAllowed = false;
        private boolean kycVerified = false;
        private String branchCode = "BR-MAIN-001";
        private String swiftBic = "GALXUS33XXX";
        private LocalDate openingDate = LocalDate.now();

        /**
         * Builder constructor accepting mandatory parameters.
         */
        public Builder(String accountNumber, String accountHolderName, AccountType accountType) {
            this.accountNumber = Objects.requireNonNull(accountNumber, "Account number cannot be null");
            this.accountHolderName = Objects.requireNonNull(accountHolderName, "Account holder name cannot be null");
            this.accountType = Objects.requireNonNull(accountType, "Account type cannot be null");
        }

        public Builder balance(BigDecimal balance) {
            this.balance = balance != null ? balance : BigDecimal.ZERO;
            return this;
        }

        public Builder balance(double balance) {
            this.balance = BigDecimal.valueOf(balance);
            return this;
        }

        public Builder currency(Currency currency) {
            this.currency = currency != null ? currency : Currency.USD;
            return this;
        }

        public Builder interestRate(BigDecimal interestRate) {
            this.interestRate = interestRate;
            return this;
        }

        public Builder interestRate(double interestRate) {
            this.interestRate = BigDecimal.valueOf(interestRate);
            return this;
        }

        public Builder overdraftLimit(BigDecimal overdraftLimit) {
            this.overdraftLimit = overdraftLimit;
            return this;
        }

        public Builder overdraftLimit(double overdraftLimit) {
            this.overdraftLimit = BigDecimal.valueOf(overdraftLimit);
            return this;
        }

        public Builder dailyTransferLimit(BigDecimal dailyTransferLimit) {
            this.dailyTransferLimit = dailyTransferLimit;
            return this;
        }

        public Builder dailyTransferLimit(double dailyTransferLimit) {
            this.dailyTransferLimit = BigDecimal.valueOf(dailyTransferLimit);
            return this;
        }

        public Builder debitCardIssued(boolean debitCardIssued) {
            this.debitCardIssued = debitCardIssued;
            return this;
        }

        public Builder creditCardIssued(boolean creditCardIssued) {
            this.creditCardIssued = creditCardIssued;
            return this;
        }

        public Builder onlineBankingEnabled(boolean onlineBankingEnabled) {
            this.onlineBankingEnabled = onlineBankingEnabled;
            return this;
        }

        public Builder paperlessStatementEnabled(boolean paperlessStatementEnabled) {
            this.paperlessStatementEnabled = paperlessStatementEnabled;
            return this;
        }

        public Builder internationalTransactionsAllowed(boolean allowed) {
            this.internationalTransactionsAllowed = allowed;
            return this;
        }

        public Builder kycVerified(boolean kycVerified) {
            this.kycVerified = kycVerified;
            return this;
        }

        public Builder branchCode(String branchCode) {
            this.branchCode = branchCode;
            return this;
        }

        public Builder swiftBic(String swiftBic) {
            this.swiftBic = swiftBic;
            return this;
        }

        public Builder openingDate(LocalDate openingDate) {
            this.openingDate = openingDate != null ? openingDate : LocalDate.now();
            return this;
        }

        /**
         * Validates business invariants before creating the BankAccount instance.
         */
        public BankAccount build() {
            validate();
            return new BankAccount(this);
        }

        private void validate() {
            if (accountNumber.trim().isEmpty()) {
                throw new IllegalStateException("Account number cannot be empty or blank.");
            }
            if (accountHolderName.trim().length() < 2) {
                throw new IllegalStateException("Account holder name must be at least 2 characters long.");
            }
            if (balance.compareTo(BigDecimal.ZERO) < 0 && overdraftLimit.compareTo(BigDecimal.ZERO) <= 0) {
                throw new IllegalStateException("Initial balance cannot be negative without overdraft protection configured.");
            }
            if (balance.compareTo(BigDecimal.ZERO) < 0 && balance.abs().compareTo(overdraftLimit) > 0) {
                throw new IllegalStateException("Initial negative balance exceeds the approved overdraft limit.");
            }
            if (creditCardIssued && !kycVerified) {
                throw new IllegalStateException("Credit Card cannot be issued for an unverified KYC customer.");
            }
            if (accountType == AccountType.STUDENT && dailyTransferLimit.compareTo(new BigDecimal("2000.00")) > 0) {
                throw new IllegalStateException("Student accounts cannot have a daily transfer limit exceeding $2,000.00.");
            }
        }
    }
}
