package com.company;

public class Road extends Places {
    private boolean isBlocked;           // Is the road blocked for the taxi driver? If false => Player can get a free ride without helping the taxi driver unblock the road.
    private TaxiDriver taxiDriver;
    private int hungerLossFromHelping;   // Amount of hunger that the player loses by helping the taxi driver unblock the road.

    public Road(boolean visited, TaxiDriver taxiDriver, int hungerLossFromHelping) {
        super(visited);
        this.taxiDriver = taxiDriver;
        this.hungerLossFromHelping = hungerLossFromHelping;
    }

    public void clearBlocking() {
        this.isBlocked = false;
    }

    public int getHungerLossFromHelping() {
        return this.hungerLossFromHelping;
    }
}
