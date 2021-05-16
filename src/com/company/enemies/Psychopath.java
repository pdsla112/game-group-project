package com.company.enemies;

import com.company.DeathException;
import com.company.characters.Player;

import java.util.Random;

public class Psychopath extends Enemy {
    private boolean isAlive;
    private int hp;
    private int attackAmount;    // Amount that the psychopath deducts from the player's health.
    private boolean deathValue;  // True => Psychopath is dead. False => Psychopath is alive.
    private boolean isApproached;

    public Psychopath(int attackAmount, int hp, boolean deathValue, boolean isApproached) {
        this.attackAmount = attackAmount;
        this.hp = hp;
        this.deathValue = deathValue;
        this.isApproached = isApproached;
    }

    public Psychopath() {
        Random r = new Random();
        isAlive = true;
        int hp = 47 + r.nextInt(7);
    }


    public void getApproached() {
        this.isApproached = true;
    }

    public boolean getApproachedValue() {
        return this.isApproached;
    }

    public int getAttackAmount() {
        return this.attackAmount;
    }

    public boolean getDeathValue() {
        return this.deathValue;
    }

    public void getKilled() {
        this.deathValue = true;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean a) {
        isAlive = a;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void attack(Player p) throws DeathException {
        String text = "";
        Random r = new Random();
        int attack = r.nextInt(2);
        int dmg = 0;
        int bonus = r.nextInt(p.getLevel());
        switch (attack) {
            case 0:
                text += "Psychopath cuts your arm.";
                dmg = 8 + bonus;
                break;
            case 1:
                text += "Psychopath punches you in the stomach.";
                dmg = 18 + bonus;
                break;
        }
        text += " -" + dmg + "hp";
        System.out.println(text);

        p.setHealth(p.getHealth() - dmg);
        if (p.getHealth() <= 0) {
            throw new DeathException("player died");
        }
    }
}
