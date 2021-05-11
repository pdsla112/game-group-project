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
    private String name;
    private int cash;
    private Map<Item,Integer> items;

    private Map<Integer, Integer> itemsMap = new HashMap<>();
    //protected static LocationRepo locationRepo = new LocationRepo();
    private Location location = null;
    //private boolean deathValue;  // True => Player is dead.  False => Player is alive.

    private String email;

    public Player(String name, String email, int level) {
        //temporary (load from json)
        this.location = location;
        this.email = email;
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

    public void showItems() {
        //todo
    }

    public void showStats() {
        //todo
    }

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

//    public static Player load(String fileName) {
//        return null;
//    }

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



//    public void attack(String opponentName) throws DeathException {
//
//    }


}
