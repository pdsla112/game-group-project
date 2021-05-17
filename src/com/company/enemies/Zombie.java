package com.company.enemies;


import com.company.exceptions.DeathException;
import com.company.characters.Player;

import java.util.Random;

public class Zombie extends Enemy {
    private int attackAmount;
    private boolean deathValue;
    private int approachProb;
    private boolean willApproach;
    private int hp;

    public Zombie(int attackAmount, int hp, boolean deathValue, int approachProb) {
        this.attackAmount = attackAmount;
        this.hp = hp;
        this.deathValue = deathValue;
        this.approachProb = approachProb;
        this.willApproach = calculateApproach(approachProb);
    }

    //easy
    //player 100 hp
    //zombie 35 hp
    //zombie to player: 10 - 15 dmg
    //player to zombie: 30 - 40 dmg

    //medium
    //player 100 hp
    //zombie 37 hp
    //zombie to player: 15 - 25 dmg
    //player to zombie: 25 - 30 dmg

    //hard
    //player 100 hp
    //zombie 40 hp
    //zombie to player: 30 - 35 dmg
    //player to zombie: 30 - 35 dmg

    //expert
    //player 100 hp
    //zombie 50 hp
    //zombie to player: 35 - 40 dmg
    //player to zombie: 30 - 35 dmg

    //psychopath easier


    //zombie hp = 35 + 2*lvl

    public Zombie() {
        Random r = new Random();
        hp = 35 + r.nextInt(10);
    }

    public static boolean calculateApproach(int approachProb) {
        int value = (int) (Math.random() * 100) + 1;

        if (value <= approachProb)
            return true;
        else
            return false;
    }

    public int getAttackAmount() {
        return this.attackAmount;
    }

    public boolean isDead() {
        return this.deathValue;
    }

    @Override
    public boolean isAlive() {
        return hp > 0;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * attacks player
     * @param p
     * @throws DeathException
     */
    @Override
    public void attack(Player p) throws DeathException {
        String text = "";
        Random r = new Random();
        int attack = r.nextInt(3);
        int dmg = 0;
        int bonus = r.nextInt(p.getLevel()+2);
        switch (attack) {
            case 0:
                text += "Zombie bites your hand.";
                dmg = 10 + bonus;
                break;
            case 1:
                text += "Zombie smacks your arm.";
                dmg = 15 + bonus;
                break;
            case 2:
                text += "Zombie tackles you and you fall down.";
                dmg = 20 + bonus;
                break;

        }
        text += " -" +  dmg + "hp";
        System.out.println(text);

        p.setHealth(p.getHealth()-dmg);
        if (p.getHealth() <= 0) {
            throw new DeathException("player died");
        }



    }
}
