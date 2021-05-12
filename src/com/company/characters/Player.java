package com.company.characters;

import com.company.data.Initialization;
import com.company.data.InitializeJSON;
import com.company.items.LocationObject;
import com.company.items.Medkit;
import com.company.locations.Location;
import com.company.parser.Tokenizer;
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
    public Map<String, Integer> itemsMap = new HashMap<>();
    public List<LocationObject> locationObjects;
    public Tokenizer tokenizer = new Tokenizer();

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

    public void setLocationObjects(List<LocationObject> locationObjects) {
        this.locationObjects = locationObjects;
    }

    //returns true if item is found and added
    public boolean lookForItem(String preposition, String noun) {
        for (LocationObject lo : locationObjects) {
            if (lo.getObjectName().equals(noun)) {
                if (lo.getLocation().equals(preposition)) {
                    addItem(lo.getItemName());
                    System.out.println(lo.getItemName() + " has been added to your inventory.");
                    return true;
                }
            }
        }
        return false;
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

    public void addLocationObject(LocationObject lo) {
        this.locationObjects.add(lo);
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

    public void showSurroundings() {
        if (locationObjects == null || locationObjects.isEmpty()) {
            System.out.println("There is nothing of interest around you.");
        } else {
            String text = "You see:\n--------------------------------------\n";
            for (LocationObject lo : locationObjects) {
                text += "\ta " + lo.getObjectName() + "\n";
            }
            text += "--------------------------------------\n";
            System.out.println(text);
        }
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
