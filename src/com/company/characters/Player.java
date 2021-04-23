package com.company.characters;

import com.company.locations.Location;
import com.company.repository.ItemRepo;
import com.company.items.Item;


import java.util.List;

public class Player extends Character{

    protected static ItemRepo itemRepo = new ItemRepo();
    //protected static LocationRepo locationRepo = new LocationRepo();
    private Location location;
    //private boolean deathValue;  // True => Player is dead.  False => Player is alive.
    public Player() {}

    protected static String getProfileFileName(String name) {
        //todo
        return null;
    }
    public static boolean profileExists(String name) {
        //todo
        return false;

    }

    public static Player load(String fileName) {
        return null;
    }

    public void getStats(){
        //todo
        //print out stats e.g. attack, hp
    }

    public void save() {
        // todo
    }

    public List<Item> searchItem(String itemName, List<Item> itemList) {
        //todo
        return null;
    }

    public void pickUpItem(String itemName) {
        //todo
    }

    public void dropItem(String itemName) {
        //todo
    }

    public void inspectItem(String itemName) {
        //todo
    }

    public boolean hasItem(Item item) {
        //todo
        return false;
    }

//    public void attack(String opponentName) throws DeathException {
//
//    }


}
