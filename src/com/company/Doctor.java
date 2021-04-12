package com.company;

public class Doctor extends Character {
    private int healAmount;  // Amount that the doctor can heal the player's health.
    private boolean isApproached;

    public Doctor(int attackLevel, int healAmount, boolean isApproached) {
        super(attackLevel);
        this.healAmount = healAmount;
        this.isApproached = isApproached;
    }

    public void getApproached() {
        this.isApproached = true;
    }

    public boolean getApproachedValue() {
        return this.isApproached;
    }

    public int getHealAmount() {
        return this.healAmount;
    }
}
