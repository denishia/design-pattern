package com.banking.strategy;

/**
 * Context: uses whichever FeeStrategy it is given.
 * It does not know or care how the fee is calculated.
 */
public class TransferService {

    private FeeStrategy feeStrategy;

    public TransferService(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public void transfer(double amount) {
        double fee = feeStrategy.calculateFee(amount);
        System.out.println("Transfer " + amount + " | Fee: " + fee + " | Total debited: " + (amount + fee));
    }
}
