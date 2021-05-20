package com.company.items;

import com.company.characters.Player;

public class Medkit extends Item {
    private int healValue;   // Amount that the first aid kit heals the player per use.
    private Player player;

    public Medkit(int healValue) {
//        this.healValue = 20 - player.getLevel();
//        this.player = player;
        this.healValue = healValue;
    }

    public int getHealValue() {
        return this.healValue;
    }

    /**
     * add to player's health (max 100)
     */
    @Override
    public void use(Player player) {
        int oldHp = player.getHealth();
        player.setHealth(Math.min(100,player.getHealth()+healValue));
        int changeHp = player.getHealth() - oldHp;
        System.out.println("You have used a medkit. +" + changeHp + " Hp");
    }
}
