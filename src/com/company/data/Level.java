package com.company.data;

public class Level {
    private int health;
    private int damage;
    // Add other things that determine a level...

    public Level(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }
}
