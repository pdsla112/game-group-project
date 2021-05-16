package com.company.characters;

import com.company.DeathException;
import com.company.data.Initialization;
import com.company.data.InitializeJSON;
import com.company.enemies.Enemy;
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
    public Map<String, Integer> itemsMap;
    public List<LocationObject> locationObjects;
    public Tokenizer tokenizer;
    private String locationName;

    // new player
    public Player(String name, int level, String locationName) {
        //temporary (load from json)
        this.name = name;
        this.level = level;
        this.damage = 30 - 2*level;
        this.health = 100;
        this.locationName = locationName;
        this.tokenizer = new Tokenizer();
        this.itemsMap = new HashMap<>();
    }



    //load player
    public Player(int damage, int health, String name, int level, Map<String, Integer> itemsMap, String locationName) {
        this.damage = damage;
        this.health = health;
        this.name = name;
        this.level = level;
        this.itemsMap = itemsMap;
        this.locationObjects = new ArrayList<>();
        this.tokenizer = new Tokenizer();
        this.locationName = locationName;
    }

    public void useItem(String name) {
//        if (name.equals("medkit")) {
//            Medkit medkit = new Medkit(this);
//            medkit.use();
//            itemsMap.put(name, Math.max((itemsMap.get(name)-1), 0));
//        }

    }

    public String getName() {
        return name;
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
                    locationObjects.remove(lo);
                    addItem(lo.getItemName());
                    System.out.println("--------------------------------------");
                    System.out.println("You found a " + lo.getItemName() + " " + preposition + " the " + noun + ".");
                    System.out.println(lo.getItemName() + " has been added to your inventory.");
                    System.out.println("--------------------------------------");
                    System.out.println();
                    return true;
                }
            }
        }
        return false;
    }

    public void addItem(String name) {
        if (itemsMap.containsKey(name)) {
            itemsMap.put(name, itemsMap.get(name) + 1);
        } else {
            itemsMap.put(name, 1);
        }
    }

    public void attack(Enemy e, int dmg, int selfDmg) throws DeathException {
        e.setHp(e.getHp() - dmg);
        health -= selfDmg;
        if (health <= 0) {
            throw new DeathException("player died.");
        }
        if (e.getHp() <= 0) {
            e.setAlive(false);
        }

    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void addLocationObject(LocationObject lo) {
        this.locationObjects.add(lo);
    }

    public void showStats(){
        String text = "--------------------------------------\nYour Stats:\n";
        text += "\tHealth: " + this.health + "\n";
        text += "\tDamage: " + this.damage + "\n";
        text += "--------------------------------------\n";
        System.out.println(text);
    }

    public void showItems() {
        String text = "--------------------------------------\nYour Items:\n";
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
            System.out.println();
        } else {
            String text = "--------------------------------------\nYou see:\n";
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



//    public void attack(String opponentName) throws DeathException {
//
//    }


}
