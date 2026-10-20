package com.banking.proxy;

/**
 * Proxy: controls access to RealVideo.
 * - Lazy loading: creates RealVideo only when play() is first called.
 * - Caching: reuses the same RealVideo on subsequent plays — no re-download.
 */
public class VideoProxy implements Video {

    private final String title;
    private RealVideo realVideo;   // null until first play()

    public VideoProxy(String title) {
        this.title = title;
        System.out.println("  [Proxy] Registered \"" + title + "\" (not loaded yet)");
    }

    @Override
    public void play() {
        if (realVideo == null) {
            realVideo = new RealVideo(title);   // load only on first play
        } else {
            System.out.println("  [Proxy] Serving \"" + title + "\" from cache");
        }
        realVideo.play();
    }
}
