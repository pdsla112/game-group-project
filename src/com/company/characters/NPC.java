package com.company.characters;

import java.util.HashMap;
import java.util.Map;
import com.company.items.Item;

abstract class NPC {
    private int damage;  // Fighting level of the character. Higher => better chance of winning that battle.
    private int health;
    private String name;
    private String weapon = "hands";
    private int cash;
    private Map<Item,Integer> items;
    String id;

    public NPC(String id) {
        this.id = id;
    }

    public void displayItems() {
        //todo
    }

    public void addItem(Item item, int amount) {
        //todo

    }
    public void addItem(Item item) {
        //todo
    }

    public void removeItem(Item item, int amount) {
        //todo
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Item, Integer> items) {
        this.items = items;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
