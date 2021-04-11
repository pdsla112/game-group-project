package com.company;

public class Cottage extends Places {
    private Hunter hunter;
    private Psychopath psychopath;
    private HuntingKit huntingKit;

    public Cottage(boolean visited, Hunter hunter, HuntingKit huntingKit, Psychopath psychopath) {
        super(visited);
        this.hunter = hunter;
        this.huntingKit = huntingKit;
        this.psychopath = psychopath;
    }

    public void takeHuntingKit() {
        this.huntingKit = null;
    }
}
