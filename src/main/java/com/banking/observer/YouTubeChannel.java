package com.banking.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete Subject: a YouTube channel.
 * Keeps a list of subscribers and notifies all of them when a video is uploaded.
 */
public class YouTubeChannel implements Channel {

    private final String name;
    private final List<Subscriber> subscribers = new ArrayList<>();

    public YouTubeChannel(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    @Override
    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    @Override
    public void uploadVideo(String videoTitle) {
        System.out.println("\n[" + name + "] uploaded: \"" + videoTitle + "\"");
        for (Subscriber s : subscribers) {
            s.update(name, videoTitle);   // notify every subscriber
        }
    }
}
