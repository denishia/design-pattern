package com.banking.abstractfactory;

/**
 * Product interface — every Push notification must look like this.
 */
public interface PushNotification {
    void send(String message);
}
