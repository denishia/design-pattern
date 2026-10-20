package com.banking.strategy;

/**
 * Strategy interface: one way of calculating a transfer fee.
 */
public interface FeeStrategy {
    double calculateFee(double amount);
}
