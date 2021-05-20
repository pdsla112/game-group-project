package com.company;

import com.company.characters.Player;
import com.company.data.*;
import com.company.exceptions.DeathException;
import com.company.exceptions.WinException;
import com.company.locations.GameMap;
import com.company.locations.Location;
import com.company.menus.MainMenu;
import com.company.menus.Menu;

import com.company.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class Game {
    Player player;
    public Parser parser;
    public static GameMap map = GameMapJSON.deserializeJSON();
    Level level;

    public Game(Player p) {
        this.player = p;
        this.parser = new Parser(p);
        this.level = LevelJSON.getSpecificLevel(p.getLevel());

        runGame();
    }

    /**
     * main loop of the game which gets and processes user input and updates player's location and level node
     */
    public void runGame() {
        boolean running = true;
        Location playerLocation =  map.getLocationFromName(player.getLocationName());
        playerLocation.displayInformation();
        try {
            while (running) {
                playerLocation =  map.getLocationFromName(player.getLocationName());
                LevelMap levelMap = playerLocation.levelMap;
                System.out.println(levelMap.getCurrentNode().text+"\n");

                parser.parseActions(playerLocation.getLevelMap().getCurrentNode().getActions());

                // check level completion
                if (levelMap.completionNodes.contains(levelMap.currentNode.id)) {
                    if (playerLocation.name.equals(map.getFinalLocation().name)) {
                        throw new WinException("win");
                    } else {
                        // create menu with adjacent levels
                        List<Location> adjacentLocations = map.getAdjacent(playerLocation);
                        Menu locationMenu = new Menu(adjacentLocations);
                        locationMenu.printMenuItems();
                        running = parser.parse(parser.getInputString(), locationMenu);
                    }
                } else {
                    Menu levelMenu = new Menu(levelMap.getAdjacent());
                    // print options
                    levelMenu.printMenuItems();
                    running = parser.parse(Parser.getInputString(), levelMenu);

                }
            }
        } catch (DeathException e) {
            System.out.println("You died.");
            boolean endPrompt = false;
            while (!endPrompt) {
                System.out.println("Would you like to load from last save?");
                String response = Parser.getInputString();
                if (response.equals("y") || response.equals("yes")) {
                    player = PlayerJSON.getSpecificPlayer(player.getName());
                    new Game(player);
                } else if (response.equals("n") || response.equals("no")) {
                    System.out.println("Game exited.");;
                }
            }
        } catch (WinException e) {
            System.out.println("You win.");
            boolean endPrompt = false;
            while (!endPrompt) {
                System.out.println("Would you like to play again?");
                String response = Parser.getInputString();
                if (response.equals("y") || response.equals("yes")) {
                    // remove player save file
                    PlayerJSON.removePlayer(player.getName());
                    new MainMenu();
                } else if (response.equals("n") || response.equals("no")) {
                    PlayerJSON.removePlayer(player.getName());
                    System.out.println("Game exited.");;
                }
            }
        }
    }


}


