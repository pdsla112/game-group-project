package com.company;

public class Zombie extends Character {
    private int attackAmount;
    private boolean deathValue;

    public Zombie(int attackLevel, int attackAmount, boolean deathValue) {
        super(attackLevel);
        this.attackAmount = attackAmount;
        this.deathValue = deathValue;
    }

    public int getAttackAmount() {
        return this.attackAmount;
    }

    public boolean isDead() {
        return this.deathValue;
    }
}
