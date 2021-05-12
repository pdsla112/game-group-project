package com.company.data;

public class Level {
    private int level;
    private int health;
    private int damage;
    // Add other things that determine a level...

    public Level(int level, int health, int damage) {
        this.level = level;
        this.health = health;
        this.damage = damage;
    }

    public int getLevel() { return this.level; }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }
}
