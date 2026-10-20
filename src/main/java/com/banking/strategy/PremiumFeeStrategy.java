package com.banking.strategy;

/** Premium customers pay a flat 5. */
public class PremiumFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(double amount) {
        return 5.00;
    }
}
