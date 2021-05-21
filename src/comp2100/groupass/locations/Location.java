package comp2100.groupass.locations;

import comp2100.groupass.menus.MenuItem;

public class Location implements MenuItem {
    public String name;
    public String description;
    public LevelMap levelMap;

    public String getOptionText() {
        return this.name;
    }

    public Location(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public LevelMap getLevelMap() {
        return levelMap;
    }

    /**
     * prints location information
     */
    public void displayInformation() {
        System.out.println("--------------------------------------");
        System.out.println("Current location: " + name);
        System.out.println(description);
        System.out.println("--------------------------------------");
        System.out.println();
    }

}
