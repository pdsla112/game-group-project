package com.company;

public class Player {
    private int health;
    private int attackLevel;
    public String name;
    private boolean deathValue;  // True => Player is dead.  False => Player is alive.

    public Player(int health, int attackLevel, boolean deathValue) {
        this.health = health;
        this.attackLevel = attackLevel;
        this.deathValue = deathValue;
    }

    public void getHealed(int hp) {
        health = health + hp;
    }

    public void getUnhealthy(int hp) {
        health = health - hp;
    }

    public void die() {
        deathValue = true;
    }

    public int getHealth() {
        return this.health;
    }

    public int getAttackLevel() {
        return this.attackLevel;
    }

    public boolean getDeathValue() {
        return this.deathValue;
    }
}
