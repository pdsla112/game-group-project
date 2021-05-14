package com.company.enemies;

import com.company.DeathException;
import com.company.characters.Player;

public abstract class Enemy {
    abstract public boolean isAlive();
    abstract public void setAlive(boolean a);
    abstract public void setHp(int hp);
    abstract public int getHp();
    abstract public void attack(Player p) throws DeathException;


}
