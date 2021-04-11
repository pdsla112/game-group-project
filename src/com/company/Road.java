package com.company;

import java.util.ArrayList;

public class Road extends Places {
    private boolean isBlocked;           // Is the road blocked for the taxi driver? If false => Player can get a free ride without helping the taxi driver unblock the road.
    private TaxiDriver taxiDriver;
    private int hungerLossFromHelping;   // Amount of hunger that the player loses by helping the taxi driver unblock the road.
    private ArrayList<Zombie> zombies;

    public Road(boolean visited, TaxiDriver taxiDriver, int hungerLossFromHelping, ArrayList<Zombie> zombies) {
        super(visited);
        this.taxiDriver = taxiDriver;
        this.hungerLossFromHelping = hungerLossFromHelping;
        this.zombies = zombies;
    }

    public void clearBlocking() {
        this.isBlocked = false;
    }

    public int getHungerLossFromHelping() {
        return this.hungerLossFromHelping;
    }

    public ArrayList<Zombie> getZombies() {
        return this.zombies;
    }
}
