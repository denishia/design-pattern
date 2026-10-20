package com.banking.strategy;

/** Regular customers pay 2% of the amount. */
public class StandardFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(double amount) {
        return amount * 0.02;
    }
}
