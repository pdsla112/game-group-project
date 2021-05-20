package com.company.enemies;


import com.company.exceptions.DeathException;
import com.company.characters.Player;

import java.util.Random;

public class Zombie extends Enemy {
    private int attack1;
    private int attack2;
    private int attack3;
    private boolean deathValue;
    private int approachProb;
    private boolean willApproach;
    private int hp;

    public Zombie(int attack1, int attack2, int attack3, int hp, boolean deathValue, int approachProb) {
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.attack3 = attack3;
        this.hp = hp;
        this.deathValue = deathValue;
        this.approachProb = approachProb;
        this.willApproach = calculateApproach(approachProb);
    }

    public static boolean calculateApproach(int approachProb) {
        int value = (int) (Math.random() * 100) + 1;

        if (value <= approachProb)
            return true;
        else
            return false;
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
                dmg = attack1 + bonus;
                break;
            case 1:
                text += "Zombie smacks your arm.";
                dmg = attack2 + bonus;
                break;
            case 2:
                text += "Zombie tackles you and you fall down.";
                dmg = attack3 + bonus;
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
