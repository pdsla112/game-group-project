package com.company.enemies;

import com.company.exceptions.DeathException;
import com.company.characters.Player;

public abstract class Enemy {
    abstract public boolean isAlive();
    abstract public void setHp(int hp);
    abstract public int getHp();
    abstract public void attack(Player p) throws DeathException;
}
