package com.banking.factory;

/**
 * Factory: decides which Notification object to create based on the type.
 * The client never calls new SMSNotification() or new EmailNotification() directly.
 */
public class NotificationFactory {

    public static Notification create(String type) {
        switch (type.toUpperCase()) {
            case "SMS":   return new SMSNotification();
            case "EMAIL": return new EmailNotification();
            case "PUSH":  return new PushNotification();
            default: throw new IllegalArgumentException("Unknown notification type: " + type);
        }
    }
}
