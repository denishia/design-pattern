package com.banking.abstractfactory;

/**
 * Product interface — every Email notification must look like this.
 */
public interface EmailNotification {
    void send(String message);
}
