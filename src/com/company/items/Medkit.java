package com.company.items;

import com.company.characters.Player;

public class Medkit {
    private int healValue;   // Amount that the first aid kit heals the player per use.
    private Player player;

    public Medkit(Player player) {
        this.healValue = 20 - player.getLevel();
        this.player = player;
    }

    public void use() {
        player.setHealth(Math.max(100,player.getHealth()+healValue));
    }

    public int getHealValue() {
        return this.healValue;
    }

}
