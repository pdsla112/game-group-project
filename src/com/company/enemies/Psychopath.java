package com.company.enemies;

import com.company.characters.NPC;

public class Psychopath extends NPC {
    private int attackAmount;    // Amount that the psychopath deducts from the player's health.
    private boolean deathValue;  // True => Psychopath is dead. False => Psychopath is alive.
    private boolean isApproached;

    public Psychopath(String id, int attackAmount, boolean deathValue, boolean isApproached) {
        super(id);
        this.attackAmount = attackAmount;
        this.deathValue = deathValue;
        this.isApproached = isApproached;
    }

    public void getApproached() {
        this.isApproached = true;
    }

    public boolean getApproachedValue() {
        return this.isApproached;
    }

    public int getAttackAmount() {
        return this.attackAmount;
    }

    public boolean getDeathValue() {
        return this.deathValue;
    }

    public void getKilled() {
        this.deathValue = true;
    }
}
