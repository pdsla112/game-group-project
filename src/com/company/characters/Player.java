package com.company.characters;

import com.company.data.Initialization;
import com.company.data.InitializeJSON;
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
    private int level;
    private String name;

    private Map<Integer, Integer> itemsMap = new HashMap<>();
    private Location location = null;

    private String email;

    public Player(String name, String email, int level, Map<Integer, Integer> itemsMap, Location location) {
        this.name = name;
        this.level = level;
        this.email = email;
        this.itemsMap = itemsMap;
        this.location = location;
    }

<<<<<<< HEAD
=======

//    protected static String getProfileFileName(String name) {
//        //todo
//        return null;
//    }
//    public static boolean profileExists(String name) {
//        //todo
//        return false;
//
//    }

    public void showItems() {
        //todo
    }

    public void showStats() {
        //todo
    }

>>>>>>> f71d8ffd1a27d151bd85574511a80ef33d6b298f
    public void addItem(int id) {
        if (itemsMap.containsKey(id)) {
            itemsMap.put(id, itemsMap.get(id)+1);
        } else {
            itemsMap.put(id, 1);
        }
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void getStats(){
        System.out.println("Health: " + this.health + ". Damage: " + this.damage);
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
}
