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
    private ArrayList<Animal> animals;
    private ArrayList<HuntingKit> huntingKits;
    private ArrayList<Medkit> medKits;
    private int energyConsumption;     // How much energy is consumed per distance travelled.

    public Level(int level, int health, int damage, int zombieApproachProb, int zombieAttack, int psychopathAttack, ArrayList<Animal> animals, ArrayList<HuntingKit> huntingKits, ArrayList<Medkit> medKits, int energyConsumption) {
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.zombieApproachProb = zombieApproachProb;
        this.zombieAttack = zombieAttack;
        this.psychopathAttack = psychopathAttack;
        this.animals = animals;
        this.huntingKits = huntingKits;
        this.medKits = medKits;
        this.energyConsumption = energyConsumption;
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

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    public ArrayList<HuntingKit> getHuntingKits() {
        return this.huntingKits;
    }

    public ArrayList<Medkit> getMedKits() {
        return this.medKits;
    }

    public int getEnergyConsumption() {
        return this.energyConsumption;
    }
}
