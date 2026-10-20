package com.banking.factory;

/**
 * Product interface: every notification type must implement this.
 */
public interface Notification {
    void send(String message);
}
