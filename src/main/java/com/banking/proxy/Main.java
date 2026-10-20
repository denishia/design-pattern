package com.banking.proxy;

public class Main {
    public static void main(String[] args) {

        // Client only works with the Video interface — doesn't know it's a proxy
        Video movie = new VideoProxy("Inception");

        System.out.println("\n--- User clicks Play (first time) ---");
        movie.play();     // loads from server + plays

        System.out.println("\n--- User clicks Play again ---");
        movie.play();     // served from cache, no reload

        System.out.println("\n--- User clicks Play again ---");
        movie.play();     // still from cache
    }
}
