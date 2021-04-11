package com.company;

public class Location {
    private boolean visited;  // True => Place has been visited before. False => Never been visited by the player.

    public Location(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return this.visited;
    }
}
