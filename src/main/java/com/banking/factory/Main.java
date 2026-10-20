package com.banking.factory;

public class Main {
    public static void main(String[] args) {

        // Delivery app events — client only knows the type string
        // It never calls new SMSNotification() etc. directly
        notify("SMS",   "Order #101 placed successfully.");
        notify("EMAIL", "Your order #101 is out for delivery.");
        notify("PUSH",  "Order #101 delivered! Rate your experience.");
    }

    private static void notify(String type, String message) {
        Notification notification = NotificationFactory.create(type);
        notification.send(message);
    }
}
