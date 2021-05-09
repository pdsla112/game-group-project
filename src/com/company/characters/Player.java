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
    public Player() {
        //temporary (load from json)
        ArrayList<Initialization> dataList = InitializeJSON.deserializeJSON();
        String intro = "";
        for (Initialization data : dataList) {
            intro += data;
        }

        setIntro(intro);//intro
    }

    protected static String getProfileFileName(String name) {
        //todo
        return null;
    }
    public static boolean profileExists(String name) {
        //todo
        return false;

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
