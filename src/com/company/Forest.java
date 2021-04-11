package com.company;

public class Forest extends Places {
    private Animal animal;
    private Psychopath psychopath;

    public Forest(boolean visited, Animal animal, Psychopath psychopath) {
        super(visited);
        this.animal = animal;
        this.psychopath = psychopath;
    }

    public void takeOrLoseAnimal() {
        this.animal = null;
    }

    public Animal getAnimalAvailable() {
        return this.animal;
    }
}
