package com.banking.decorator;

public class Jalapenos extends ToppingDecorator {

    public Jalapenos(Pizza pizza) { super(pizza); }

    @Override
    public String getDescription() { return super.getDescription() + " + Jalapenos"; }

    @Override
    public double getPrice() { return super.getPrice() + 1.00; }
}
