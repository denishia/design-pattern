package com.banking.observer;

public class Main {
    public static void main(String[] args) {

        // Channel (subject)
        YouTubeChannel channel = new YouTubeChannel("TechWithDenishia");

        // Users (observers)
        User alice = new User("Alice");
        User bob   = new User("Bob");
        User carol = new User("Carol");

        // Alice and Bob subscribe
        channel.subscribe(alice);
        channel.subscribe(bob);

        channel.uploadVideo("Builder Pattern Explained");   // Alice + Bob notified

        // Carol subscribes, Bob unsubscribes
        channel.subscribe(carol);
        channel.unsubscribe(bob);

        channel.uploadVideo("Observer Pattern in Java");    // Alice + Carol notified
    }
}
