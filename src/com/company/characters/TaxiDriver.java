package com.company.characters;

public class TaxiDriver extends NPC {
    private int shortcutDistance;
    private boolean isApproached;

    public TaxiDriver(String id, int shortcutDistance, boolean isApproached) {
        super(id);
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
