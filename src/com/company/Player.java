package com.company;

public class Player {
    private int health;
    private int hunger;
    private int attackLevel;
    private boolean deathValue;  // True => Player is dead.  False => Player is alive.

    public Player(int health, int hunger, int attackLevel, boolean deathValue) {
        this.health = health;
        this.hunger = hunger;
        this.attackLevel = attackLevel;
        this.deathValue = deathValue;
    }

    public void getHealed(int hp) {
        health = health + hp;
    }

    public void getUnhealthy(int hp) {
        health = health - hp;
    }

    public void eat(int nutrition) {
        hunger = hunger + nutrition;
    }

    public void getHungry(int nutritionDeficit) {
        hunger = hunger - nutritionDeficit;
    }

    public void die() {
        deathValue = true;
    }

    public int getHealth() {
        return this.health;
    }

    public int getHunger() {
        return this.hunger;
    }

    public int getAttackLevel() {
        return this.attackLevel;
    }

    public boolean getDeathValue() {
        return this.deathValue;
    }
}
