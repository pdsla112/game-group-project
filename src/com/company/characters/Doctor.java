package com.company.characters;

public class Doctor extends NPC {
    private int healAmount;  // Amount that the doctor can heal the player's health.
    private boolean isApproached;

    public Doctor(String id, int healAmount, boolean isApproached) {
        super(id);
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
