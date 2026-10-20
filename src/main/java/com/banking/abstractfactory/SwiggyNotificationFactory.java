package com.banking.abstractfactory;

// --- Swiggy concrete products ---

class SwiggySMS implements SMSNotification {
    public void send(String message) {
        System.out.println("  [Swiggy SMS]   " + message);
    }
}

class SwiggyEmail implements EmailNotification {
    public void send(String message) {
        System.out.println("  [Swiggy Email] " + message);
    }
}

class SwiggyPush implements PushNotification {
    public void send(String message) {
        System.out.println("  [Swiggy Push]  " + message);
    }
}

/**
 * Concrete factory: creates the full Swiggy family.
 */
public class SwiggyNotificationFactory implements NotificationFactory {

    @Override
    public SMSNotification createSMS()     { return new SwiggySMS(); }

    @Override
    public EmailNotification createEmail() { return new SwiggyEmail(); }

    @Override
    public PushNotification createPush()   { return new SwiggyPush(); }
}
