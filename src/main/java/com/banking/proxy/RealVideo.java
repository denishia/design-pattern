package com.banking.proxy;

/**
 * Real Subject: the actual video — expensive to load (simulated with a delay).
 */
public class RealVideo implements Video {

    private final String title;

    public RealVideo(String title) {
        this.title = title;
        loadFromServer();          // heavy operation — happens only once
    }

    private void loadFromServer() {
        System.out.println("  [RealVideo] Loading \"" + title + "\" from server...");
    }

    @Override
    public void play() {
        System.out.println("  [RealVideo] Playing \"" + title + "\"");
    }
}
