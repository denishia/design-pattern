package com.banking.prototype;

/**
 * Prototype interface: any class that supports cloning implements this.
 */
public interface GameCharacter {
    GameCharacter clone();
    void showStats();
}
