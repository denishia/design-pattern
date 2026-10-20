package com.banking.decorator;

/** Concrete component: plain FarmHouse base. */
public class FarmHouse implements Pizza {

    @Override
    public String getDescription() { return "FarmHouse"; }

    @Override
    public double getPrice() { return 10.00; }
}
