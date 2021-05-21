package com.company.locations;

import com.company.characters.Hunter;
import com.company.enemies.Psychopath;
import com.company.items.HuntingKit;

public class Cottage extends Location {
    private Hunter hunter;
    private Psychopath psychopath;
    private HuntingKit huntingKit;

//    public Cottage(boolean visited, Hunter hunter, HuntingKit huntingKit, Psychopath psychopath) {
//        super(visited);
//        this.hunter = hunter;
//        this.huntingKit = huntingKit;
//        this.psychopath = psychopath;
//    }
//
//    public Cottage(boolean visited) {
//        super(visited);
//    }

    public Cottage (String name, String description) {
        super(name, description);
    }

    public void takeHuntingKit() {
        this.huntingKit = null;
    }
}
