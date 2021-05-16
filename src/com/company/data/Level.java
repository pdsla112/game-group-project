package com.company.data;

import com.company.enemies.Animal;
import com.company.items.HuntingKit;
import com.company.items.Medkit;

import java.util.ArrayList;

public class Level {
    private int level;
    private int health;
    private int damage;
    private int zombieApproachProb;
    private int zombieAttack;
    private int psychopathAttack;
    private Animal animal;
    private HuntingKit huntingKit;
    private Medkit medKit;
    private int energyConsumption;     // How much energy is consumed per distance travelled.
    private int zombieHealth;
    private int psychoHealth;

    public Level(int level, int health, int damage, int zombieApproachProb, int zombieAttack, int psychopathAttack, Animal animal, HuntingKit huntingKit, Medkit medKit, int energyConsumption, int zombieHealth, int psychoHealth) {
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.zombieApproachProb = zombieApproachProb;
        this.zombieAttack = zombieAttack;
        this.psychopathAttack = psychopathAttack;
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

    public int getDamage() {
        return this.damage;
    }

    public int getZombieApproachProb() { return this.zombieApproachProb; }

    public int getZombieAttack() {
        return this.zombieAttack;
    }

    public int getPsychopathAttack() {
        return this.psychopathAttack;
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
