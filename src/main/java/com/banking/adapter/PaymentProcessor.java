package com.banking.adapter;

/**
 * Target interface: what our banking app expects every payment provider to look like.
 */
public interface PaymentProcessor {
    void pay(String accountNumber, double amountInDollars);
}
