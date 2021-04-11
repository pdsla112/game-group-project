package com.company;

public class Places {
    private boolean visited;  // True => Place has been visited before. False => Never been visited by the player.

    public Places(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return this.visited;
    }
}
