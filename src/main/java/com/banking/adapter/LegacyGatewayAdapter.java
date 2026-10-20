package com.banking.adapter;

/**
 * Adapter: implements the interface our app expects,
 * and translates each call into what LegacyGateway understands.
 */
public class LegacyGatewayAdapter implements PaymentProcessor {

    private final LegacyGateway gateway;

    public LegacyGatewayAdapter(LegacyGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(String accountNumber, double amountInDollars) {
        String iban = "IBAN-" + accountNumber;                    // translate the account format
        long cents = Math.round(amountInDollars * 100);           // translate dollars -> cents
        gateway.sendMoney(iban, cents);                           // call the legacy method
    }
}
