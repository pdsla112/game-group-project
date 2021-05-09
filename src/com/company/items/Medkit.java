package com.company.items;

public class Medkit {
    private int healValue;   // Amount that the first aid kit heals the player per use.
    private int durability;  // Number of times the first aid kit can be used before it becomes unusable.

    public Medkit(int healValue, int durability) {
        this.healValue = healValue;
        this.durability = durability;
    }

    public void getUsed() {
        this.durability--;
    }

    public int getHealValue() {
        return this.healValue;
    }

    public int getDurability() {
        return this.durability;
    }
}
