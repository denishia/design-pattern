package com.banking.observer;

/**
 * Concrete Observer: a user who subscribed to one or more channels.
 */
public class User implements Subscriber {

    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String channelName, String videoTitle) {
        System.out.println("  Notified " + name + ": new video \"" + videoTitle + "\" on " + channelName);
    }
}
