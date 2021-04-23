package com.company.locations;

import com.company.enemies.Animal;
import com.company.enemies.Psychopath;
import com.company.enemies.Zombie;

import java.util.ArrayList;

public class Forest extends Location {
    private Animal animal;
    private Psychopath psychopath;
    private ArrayList<Zombie> zombies;

//    public Forest(boolean visited, Animal animal, Psychopath psychopath, ArrayList<Zombie> zombies) {
//        super(visited);
//        this.animal = animal;
//        this.psychopath = psychopath;
//        this.zombies = zombies;
//    }
    public Forest() {
        super("Forest", "A place with trees");
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

//    @Override
//    public void runStory(Player player, GameMap map, String filename) {
//        //load story
//
//    }
}
