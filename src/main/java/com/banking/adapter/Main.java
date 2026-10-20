package com.banking.adapter;

public class Main {
    public static void main(String[] args) {

        // The app only knows PaymentProcessor. It never sees LegacyGateway's API.
        PaymentProcessor processor = new LegacyGatewayAdapter(new LegacyGateway());

        processor.pay("ACC-001", 250.75);
    }
}
