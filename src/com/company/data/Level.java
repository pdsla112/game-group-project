package com.company.data;

import com.company.enemies.Animal;
import com.company.items.HuntingKit;
import com.company.items.Medkit;

public class Level {
    private int level;
    private int health;
    private int damage1;
    private int damage2;
//    private int damage3;
    private int zombieApproachProb;
    private int zombieAttack1;
    private int zombieAttack2;
    private int zombieAttack3;
    private int psychopathAttack1;
    private int psychopathAttack2;
    private Animal animal;
    private HuntingKit huntingKit;
    private Medkit medKit;
    private int energyConsumption;     // How much energy is consumed per distance travelled.
    private int zombieHealth;
    private int psychoHealth;

    public Level(
            int level,
            int health,
            int damage1,
            int damage2,
            int zombieApproachProb,
            int zombieAttack1,
            int zombieAttack2,
            int zombieAttack3,
            int psychopathAttack1,
            int psychopathAttack2,
            Animal animal,
            HuntingKit huntingKit,
            Medkit medKit,
            int energyConsumption,
            int zombieHealth,
            int psychoHealth
    ) {
        this.level = level;
        this.health = health;
        this.damage1 = damage1;
        this.damage2 = damage2;
//        this.damage3 = damage3;
        this.zombieApproachProb = zombieApproachProb;
        this.zombieAttack1 = zombieAttack1;
        this.zombieAttack2 = zombieAttack2;
        this.zombieAttack3 = zombieAttack3;
        this.psychopathAttack1 = psychopathAttack1;
        this.psychopathAttack2 = psychopathAttack2;
        this.animal = animal;
        this.huntingKit = huntingKit;
        this.medKit = medKit;
        this.energyConsumption = energyConsumption;
        this.zombieHealth = zombieHealth;
        this.psychoHealth = psychoHealth;
    }

    public int getLevel() { return this.level; }

    public int getHealth() {
        return this.health;
    }

    public int getDamage1() {
        return this.damage1;
    }

    public int getDamage2() {
        return this.damage2;
    }

//    public int getDamage3() {
//        return this.damage3;
//    }

    public int getZombieApproachProb() { return this.zombieApproachProb; }

    public int getZombieAttack1() {
        return this.zombieAttack1;
    }

    public int getZombieAttack2() {
        return this.zombieAttack2;
    }

    public int getZombieAttack3() {
        return this.zombieAttack3;
    }

    public int getPsychopathAttack1() {
        return this.psychopathAttack1;
    }

    public int getPsychopathAttack2() {
        return this.psychopathAttack2;
    }

    public Animal getAnimals() {
        return this.animal;
    }

    public HuntingKit getHuntingKits() {
        return this.huntingKit;
    }

    public Medkit getMedKits() {
        return this.medKit;
    }

    public int getEnergyConsumption() {
        return this.energyConsumption;
    }

    public int getZombieHealth() {
        return this.zombieHealth;
    }

    public int getPsychoHealth() {
        return this.psychoHealth;
    }
}
