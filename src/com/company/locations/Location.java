package com.company.locations;

import com.company.LevelMap;
import com.company.characters.Player;

public class Location {
    private boolean visited;  // True => Place has been visited before. False => Never been visited by the player.
    public String name;
    public String description;
    public LevelMap levelMap;


    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }


    public boolean isVisited() {
        return this.visited;
    }

    public void displayInformation() {
        System.out.println("Location: " + name);
        System.out.println("Description: " + description);
    }
}
