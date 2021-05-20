package com.company.characters;

import com.company.enemies.Animal;
import com.company.exceptions.DeathException;
import com.company.data.Level;
import com.company.data.LevelJSON;
import com.company.enemies.Enemy;
import com.company.items.HuntingKit;
import com.company.items.LocationObject;
import com.company.items.Medkit;
import com.company.menus.Attack;
import com.company.parser.Tokenizer;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Player {

    private int damage1;  // Fighting level of the character. Higher => better chance of winning that battle.
    private int damage2;
//    private int damage3;
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
        Level playerLevel = LevelJSON.getSpecificLevel(level);
        this.name = name;
        this.level = level;
        this.damage1 = playerLevel.getDamage1();
        this.damage2 = playerLevel.getDamage2();
//        this.damage3 = playerLevel.getDamage3();
        this.health = playerLevel.getHealth();
        this.locationName = locationName;
        this.tokenizer = new Tokenizer();
        this.itemsMap = new HashMap<>();
    }

    //load player
//    public Player(int damage, int health, String name, int level, Map<String, Integer> itemsMap, String locationName) {
//        this.damage = damage;
//        this.health = health;
//        this.name = name;
//        this.level = level;
//        this.itemsMap = itemsMap;
//        this.locationObjects = new ArrayList<>();
//        this.tokenizer = new Tokenizer();
//        this.locationName = locationName;
//    }

    public void useItem(String name) {
        if (name.equals("medkit")) {
            Medkit medkit = new Medkit(20);
            medkit.use(this);
            itemsMap.put(name, Math.max((itemsMap.get(name)-1), 0));
        }
        if (name.equals("huntingkit")){
            HuntingKit huntingkit = new HuntingKit(1,10-level);
            huntingkit.use(this);
            itemsMap.put(name,Math.max((itemsMap.get(name)-1), 0));
        }

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

    public void attack(Enemy e, Attack attack) throws DeathException {
        e.setHp(e.getHp() - attack.getAttackDamage());
        health -= attack.getSelfDamage();
        if (health <= 0) {
            throw new DeathException("player died.");
        }
        System.out.println("You choose to use a " + attack.getAttackName().toLowerCase()+".");

    }

    public void hunt(Animal a, Attack attack){
        a.setHuntingDifficulty(a.getHuntingDifficulty()-attack.getAttackDamage());
        health -= attack.getSelfDamage();
        System.out.println("You choose " + attack.getAttackName().toLowerCase()+".");
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

//    public void showStats(){
//        String text = "--------------------------------------\nYour Stats:\n";
//        text += "\tHealth: " + this.health + "\n";
//        text += "\tDamage: " + this.damage + "\n";
//        text += "--------------------------------------\n";
//        System.out.println(text);
//    }

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


    public int getDamage1() {
        return damage1;
    }
    public int getDamage2() {
        return damage2;
    }
//    public int getDamage3() {
//        return damage3;
//    }

//    public void setDamage(int damage) {
//        this.damage = damage;
//    }

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
