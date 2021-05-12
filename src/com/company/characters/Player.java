package com.company.characters;

import com.company.data.Initialization;
import com.company.data.InitializeJSON;
import com.company.items.Medkit;
import com.company.locations.Location;
import com.company.repository.ItemRepo;
import com.company.items.Item;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    private int damage;  // Fighting level of the character. Higher => better chance of winning that battle.
    private int health;
    private String name;
    private int level;
    private Map<String, Integer> itemsMap = new HashMap<>();

    //protected static LocationRepo locati
    // onRepo = new LocationRepo();
    private Location location = null;
    //private boolean deathValue;  // True => Player is dead.  False => Player is alive.

    private String email;

    public Player(String name, String email, int level) {
        //temporary (load from json)
        this.name = name;
        this.level = level;
        this.email = email;
    }

    public void useItem(String name) {
        if (name.equals("medkit")) {
            Medkit medkit = new Medkit(this);
            medkit.use();
        }

    }

    public int getLevel() {
        return level;
    }

    public void lookForItem(String preposition, String noun) {

    }


//    protected static String getProfileFileName(String name) {
//        //todo
//        return null;
//    }
//    public static boolean profileExists(String name) {
//        //todo
//        return false;
//
//    }

    public void addItem(String name) {
        if (itemsMap.containsKey(name)) {
            itemsMap.put(name, itemsMap.get(name)+1);
        } else {
            itemsMap.put(name, 1);
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void showStats(){
        String text = "Your Stats:\n--------------------------------------\n";
        text += "\tHealth: " + this.health + "\n";
        text += "\tDamage: " + this.damage + "\n";
        text += "--------------------------------------\n";
        System.out.println(text);
    }

    public void showItems() {
        String text = "Your Items:\n--------------------------------------\n";
        for (String itemName : itemsMap.keySet()) {
            if (itemsMap.get(itemName) > 0) {
                text += "\t" + itemName + "\t" + itemsMap.get(itemName) + "\n";
            }
        }
        text += "--------------------------------------\n";
        System.out.println(text);
        //todo
    }

//    public List<Item> searchItem(String itemName, List<Item> itemList) {
//        //todo
//        return null;
//    }
//
//    public void pickUpItem(String itemName) {
//        //todo
//    }
//
//    public void dropItem(String itemName) {
//        //todo
//    }
//
//    public void inspectItem(String itemName) {
//        //todo
//    }
//
//    public boolean hasItem(Item item) {
//        //todo
//        return false;


    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getEmail() {
        return this.email;
    }



//    public void attack(String opponentName) throws DeathException {
//
//    }


}
