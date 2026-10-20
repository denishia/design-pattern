package com.banking.decorator;

/**
 * Component interface: every pizza — base or decorated — must implement this.
 */
public interface Pizza {
    String getDescription();
    double getPrice();
}
