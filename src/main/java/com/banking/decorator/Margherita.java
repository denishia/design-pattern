package com.banking.decorator;

/** Concrete component: plain Margherita base. */
public class Margherita implements Pizza {

    @Override
    public String getDescription() { return "Margherita"; }

    @Override
    public double getPrice() { return 8.00; }
}
