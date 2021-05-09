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

public class Player extends Character{

    private Map<Integer, Integer> itemsMap = new HashMap<>();
    //protected static LocationRepo locationRepo = new LocationRepo();
    private Location location;
    //private boolean deathValue;  // True => Player is dead.  False => Player is alive.

    private String email;

    public Player(int damage, int health, String name, String intro, int cash, Map<Item,Integer> items, String email, Location location) {
        //temporary (load from json)
        super(damage, health, name, cash, items);
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
        System.out.println("Health: " + this.getHealth() + ". Damage: " + this.getDamage());
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

    public String getEmail() {
        return this.email;
    }



//    public void attack(String opponentName) throws DeathException {
//
//    }


}
