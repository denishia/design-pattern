package com.banking.decorator;

public class ExtraCheese extends ToppingDecorator {

    public ExtraCheese(Pizza pizza) { super(pizza); }

    @Override
    public String getDescription() { return super.getDescription() + " + Extra Cheese"; }

    @Override
    public double getPrice() { return super.getPrice() + 1.50; }
}
