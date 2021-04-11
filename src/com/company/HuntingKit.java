package com.company;

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
}
