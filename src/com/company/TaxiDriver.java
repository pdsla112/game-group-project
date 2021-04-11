package com.company;

public class TaxiDriver extends Character {
    private int shortcutDistance;

    public TaxiDriver(int attackLevel, int shortcutDistance) {
        super(attackLevel);
        this.shortcutDistance = shortcutDistance;
    }

    public int getShortcutDistance() {
        return this.shortcutDistance;
    }
}
