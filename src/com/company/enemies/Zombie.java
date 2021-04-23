package com.company.enemies;

import com.company.characters.NPC;

public class Zombie extends NPC {
    private int attackAmount;
    private boolean deathValue;
    private int approachProb;
    private boolean willApproach;

    public Zombie(String id, int attackAmount, boolean deathValue, int approachProb) {
        super(id);
        this.attackAmount = attackAmount;
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

    public int getAttackAmount() {
        return this.attackAmount;
    }

    public boolean isDead() {
        return this.deathValue;
    }
}
