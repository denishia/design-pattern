package com.banking.abstractfactory;

/**
 * Abstract Factory: declares one creation method per product in the family.
 * Each concrete factory implements ALL three — guaranteeing they come from the same brand.
 */
public interface NotificationFactory {
    SMSNotification   createSMS();
    EmailNotification createEmail();
    PushNotification  createPush();
}
