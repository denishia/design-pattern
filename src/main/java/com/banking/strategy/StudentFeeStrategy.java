package com.banking.strategy;

/** Students pay no fee. */
public class StudentFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(double amount) {
        return 0.0;
    }
}
