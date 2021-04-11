package com.company;

public class Doctor extends Character {
    private int healAmount;  // Amount that the doctor can heal the player's health.

    public Doctor(int attackLevel, int healAmount) {
        super(attackLevel);
        this.healAmount = healAmount;
    }

    public int getHealAmount() {
        return this.healAmount;
    }
}
