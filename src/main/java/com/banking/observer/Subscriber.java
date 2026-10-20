package com.banking.observer;

/**
 * Observer interface: anyone who wants to be notified implements this.
 */
public interface Subscriber {
    void update(String channelName, String videoTitle);
}
