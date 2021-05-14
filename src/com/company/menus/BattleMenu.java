package com.company.menus;

import com.company.DeathException;
import com.company.characters.Player;

public class BattleMenu {
    Player player;

    public BattleMenu(Player player) throws DeathException {
        this.player = player;
        zombieFight();
    }

    public void zombieFight() throws DeathException {

    }


}
