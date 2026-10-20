package com.banking.abstractfactory;

/**
 * Product interface — every SMS notification must look like this.
 */
public interface SMSNotification {
    void send(String message);
}
