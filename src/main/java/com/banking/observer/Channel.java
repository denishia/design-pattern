package com.banking.observer;

/**
 * Subject interface: the one being watched — can add, remove, notify subscribers.
 */
public interface Channel {
    void subscribe(Subscriber s);
    void unsubscribe(Subscriber s);
    void uploadVideo(String videoTitle);
}
