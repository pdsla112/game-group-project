package com.company;

public class Location {
    private boolean visited;  // True => Place has been visited before. False => Never been visited by the player.
    public String name = "";


    public Location(boolean visited) {
        this.visited = visited;
    }

    private StoryGraph story;
    public void runStory(Player player, GameMap map, String filename) {

    }

    public boolean isVisited() {
        return this.visited;
    }
}
