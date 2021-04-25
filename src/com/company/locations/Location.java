package com.company.locations;

import com.company.LevelMap;
import com.company.LevelNode;
import com.company.menus.Menu;
import com.company.menus.MenuItem;

import java.util.ArrayList;
import java.util.List;

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

    public void displayChooseOptions() {
        if (levelMap.getCurrentNode().getCommand() == null) {
            System.out.println(levelMap.getCurrentNode().getText());
        }
        List<LevelNode> adjacent = levelMap.getAdjacent();
        if (adjacent == null) {
            System.out.println("no options available");
            return;
        }

        Menu levelMenu = new Menu();
        for (LevelNode n : adjacent) {
            levelMenu.addMenuItem(new MenuItem(n.getCommand(),n.getDescription()));
        }

        String command = levelMenu.displayChooseOption(levelMenu.getMenuItems()).getOptionKey();

        for (LevelNode n : adjacent) {
            if (n.getCommand().equals(command)) {
                System.out.println(n.getText());
                levelMap.setCurrentNode(n);
                return;
            }
        }
        System.out.println("Sorry, did not understand.");




    }

}
