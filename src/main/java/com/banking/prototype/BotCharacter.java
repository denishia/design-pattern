package com.banking.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Concrete prototype.
 * Contains a mutable List field to demonstrate shallow vs deep copy.
 */
public class BotCharacter implements GameCharacter {

    private String name;
    private String role;
    private int health;
    private int attackPower;
    private String weapon;
    private List<String> skills;       // mutable — needs deep copy

    public BotCharacter(String name, String role, int health, int attackPower, String weapon, List<String> skills) {
        this.name        = name;
        this.role        = role;
        this.health      = health;
        this.attackPower = attackPower;
        this.weapon      = weapon;
        this.skills      = new ArrayList<>(skills);
    }

    // --- Shallow copy constructor: copies the list reference, not the list itself ---
    private BotCharacter(BotCharacter source, boolean shallow) {
        this.name        = source.name;
        this.role        = source.role;
        this.health      = source.health;
        this.attackPower = source.attackPower;
        this.weapon      = source.weapon;
        this.skills      = source.skills;              // same reference — SHALLOW
    }

    // --- Deep copy constructor: creates a brand new list ---
    private BotCharacter(BotCharacter source) {
        this.name        = source.name;
        this.role        = source.role;
        this.health      = source.health;
        this.attackPower = source.attackPower;
        this.weapon      = source.weapon;
        this.skills      = new ArrayList<>(source.skills); // new list — DEEP
    }

    @Override
    public GameCharacter clone() {
        return new BotCharacter(this);           // deep copy
    }

    public GameCharacter shallowClone() {
        return new BotCharacter(this, true);     // shallow copy
    }

    public void setName(String name)            { this.name = name; }
    public void setHealth(int health)           { this.health = health; }
    public void setAttackPower(int attackPower) { this.attackPower = attackPower; }
    public void setWeapon(String weapon)        { this.weapon = weapon; }
    public List<String> getSkills()             { return skills; }

    @Override
    public void showStats() {
        System.out.println("  Name: " + name + " | Role: " + role
                + " | HP: " + health + " | Attack: " + attackPower
                + " | Weapon: " + weapon + " | Skills: " + skills);
    }
}
