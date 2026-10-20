package com.banking.decorator;

/**
 * Base decorator: wraps a Pizza and delegates to it.
 * All topping decorators extend this.
 */
public abstract class ToppingDecorator implements Pizza {

    private final Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public String getDescription() { return pizza.getDescription(); }

    @Override
    public double getPrice() { return pizza.getPrice(); }
}
