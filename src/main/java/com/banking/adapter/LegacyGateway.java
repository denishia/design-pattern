package com.banking.adapter;

/**
 * Adaptee: an existing external/legacy gateway we cannot change.
 * Its method name, parameters and units are different from PaymentProcessor.
 */
public class LegacyGateway {

    public void sendMoney(String iban, long amountInCents) {
        System.out.println("LegacyGateway: sent " + amountInCents + " cents to " + iban);
    }
}
