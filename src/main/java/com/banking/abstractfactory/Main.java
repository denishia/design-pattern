package com.banking.abstractfactory;

public class Main {
    public static void main(String[] args) {

        // Swiggy order lifecycle — all notifications from Swiggy family
        System.out.println("--- Swiggy Order ---");
        sendOrderNotifications(new SwiggyNotificationFactory());

        // Zomato order lifecycle — all notifications from Zomato family
        System.out.println("\n--- Zomato Order ---");
        sendOrderNotifications(new ZomatoNotificationFactory());
    }

    // Client only depends on the NotificationFactory interface
    // It has no idea whether it is Swiggy or Zomato inside
    private static void sendOrderNotifications(NotificationFactory factory) {
        factory.createSMS().send("Order placed successfully.");
        factory.createEmail().send("Your order is out for delivery.");
        factory.createPush().send("Order delivered! Rate your experience.");
    }
}
