package com.company.items;

import com.company.characters.Player;

public class Meat extends Item {
    private int healValue;   // Amount that the meat heals the player
    private Player player;

    public Meat(int healValue) {
//        this.healValue = 20 - player.getLevel();
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
        System.out.println("You have consumed the meat. +" + changeHp + " Hp");
    }
}
