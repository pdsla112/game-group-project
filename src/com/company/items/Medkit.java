package com.company.items;

import com.company.characters.Player;

public class Medkit {
    private int healValue;   // Amount that the first aid kit heals the player per use.
    private Player player;

    public Medkit(int healValue) {
//        this.healValue = 20 - player.getLevel();
//        this.player = player;
        this.healValue = healValue;
    }

    public void use() {
        int oldHp = player.getHealth();
        player.setHealth(Math.max(100,player.getHealth()+healValue));
        int changeHp = player.getHealth() - oldHp;
        System.out.println("You have used a medkit. +" + changeHp + " Hp");
    }

    public int getHealValue() {
        return this.healValue;
    }

}
