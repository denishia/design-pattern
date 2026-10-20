package com.banking.decorator;

public class Mushrooms extends ToppingDecorator {

    public Mushrooms(Pizza pizza) { super(pizza); }

    @Override
    public String getDescription() { return super.getDescription() + " + Mushrooms"; }

    @Override
    public double getPrice() { return super.getPrice() + 2.00; }
}
