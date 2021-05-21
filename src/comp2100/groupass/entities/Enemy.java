package comp2100.groupass.entities;

import comp2100.groupass.exceptions.DeathException;

public abstract class Enemy {
    abstract public boolean isAlive();
    abstract public void setHp(int hp);
    abstract public int getHp();
    abstract public void attack(Player p) throws DeathException;
}
