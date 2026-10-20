package com.banking.abstractfactory;

// --- Zomato concrete products ---

class ZomatoSMS implements SMSNotification {
    public void send(String message) {
        System.out.println("  [Zomato SMS]   " + message);
    }
}

class ZomatoEmail implements EmailNotification {
    public void send(String message) {
        System.out.println("  [Zomato Email] " + message);
    }
}

class ZomatoPush implements PushNotification {
    public void send(String message) {
        System.out.println("  [Zomato Push]  " + message);
    }
}

/**
 * Concrete factory: creates the full Zomato family.
 */
public class ZomatoNotificationFactory implements NotificationFactory {

    @Override
    public SMSNotification createSMS()     { return new ZomatoSMS(); }

    @Override
    public EmailNotification createEmail() { return new ZomatoEmail(); }

    @Override
    public PushNotification createPush()   { return new ZomatoPush(); }
}
