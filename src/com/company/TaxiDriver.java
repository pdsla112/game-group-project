package com.company;

public class TaxiDriver extends Character {
    private int shortcutDistance;
    private boolean isApproached;

    public TaxiDriver(int attackLevel, int shortcutDistance, boolean isApproached) {
        super(attackLevel);
        this.shortcutDistance = shortcutDistance;
        this.isApproached = isApproached;
    }

    public void getApproached() {
        this.isApproached = true;
    }

    public boolean getApproachedValue() {
        return this.isApproached;
    }

    public int getShortcutDistance() {
        return this.shortcutDistance;
    }
}
