package com.company;

import java.util.ArrayList;

public class Forest extends Places {
    private Animal animal;
    private Psychopath psychopath;
    private ArrayList<Zombie> zombies;

    public Forest(boolean visited, Animal animal, Psychopath psychopath, ArrayList<Zombie> zombies) {
        super(visited);
        this.animal = animal;
        this.psychopath = psychopath;
        this.zombies = zombies;
    }

    public void takeOrLoseAnimal() {
        this.animal = null;
    }

    public Animal getAnimalAvailable() {
        return this.animal;
    }

    public ArrayList<Zombie> getZombies() {
        return this.zombies;
    }
}
