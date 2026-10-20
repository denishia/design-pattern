package com.banking.strategy;

public class Main {
    public static void main(String[] args) {

        TransferService service = new TransferService(new StandardFeeStrategy());
        System.out.println("Standard customer:");
        service.transfer(1000.00);

        // Swap the strategy at runtime - TransferService code does not change
        service.setFeeStrategy(new PremiumFeeStrategy());
        System.out.println("Premium customer:");
        service.transfer(1000.00);

        service.setFeeStrategy(new StudentFeeStrategy());
        System.out.println("Student customer:");
        service.transfer(1000.00);
    }
}
