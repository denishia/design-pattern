package com.banking.prototype;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        BotCharacter original = new BotCharacter(
                "Bot-Alpha", "Warrior", 100, 45, "Sword",
                Arrays.asList("Slash", "Block")
        );

        // ----------------------------------------------------------------
        // SHALLOW COPY — both share the same skills list
        // ----------------------------------------------------------------
        System.out.println("=== Shallow Copy Demo ===");
        BotCharacter shallowClone = (BotCharacter) original.shallowClone();
        shallowClone.setName("Bot-Shallow");
        shallowClone.getSkills().add("FireBall");   // modifies the SHARED list

        System.out.println("Original after shallow clone's mutation:");
        original.showStats();                        // Skills: [Slash, Block, FireBall] — corrupted!
        System.out.println("Shallow clone:");
        shallowClone.showStats();

        // ----------------------------------------------------------------
        // DEEP COPY — each has its own independent skills list
        // ----------------------------------------------------------------
        System.out.println("\n=== Deep Copy Demo ===");

        // reset original skills for a clean demo
        original.getSkills().remove("FireBall");

        BotCharacter deepClone = (BotCharacter) original.clone();
        deepClone.setName("Bot-Deep");
        deepClone.getSkills().add("IceStrike");      // modifies only the clone's list

        System.out.println("Original after deep clone's mutation:");
        original.showStats();                        // Skills: [Slash, Block] — safe!
        System.out.println("Deep clone:");
        deepClone.showStats();
    }
}
