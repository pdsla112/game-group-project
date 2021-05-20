package com.company.items;

import com.company.characters.Player;

public class HuntingKit {
    private int durability;  // Number of times the hunting kit can be used before becoming unusable.
    private int quality;     // Some value quantifying the quality of the hunting kit. Higher => Less health and hunger loss while hunting, and better chance of catching animal.

    public HuntingKit(int durability, int quality) {
        this.durability = durability;
        this.quality = quality;
    }

    public void getUsed() {
        this.durability--;
    }

    public int getDurability() {
        return this.durability;
    }

    public int getQuality() {
        return this.quality;
    }

    public void use(Player player) {
        int changedamage1 = player.getDamage1()+quality;
        int changedamage2 = player.getDamage2()+quality;
        System.out.println("You have used a huntingkit. +");
    }
}
