package com.company;

public class Character {
    private int attackLevel;  // Fighting level of the character. Higher => better chance of winning that battle.

    public Character(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getAttackLevel() {
        return this.attackLevel;
    }
}
