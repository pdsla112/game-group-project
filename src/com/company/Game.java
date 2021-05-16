package com.company;

import com.company.characters.Player;
import com.company.data.*;
import com.company.locations.GameMap;
import com.company.locations.Location;
import com.company.menus.MainMenu;
import com.company.menus.Menu;
import com.company.menus.GenericMenuItem;
import com.company.parser.Parser;
import com.company.LevelNode;

import java.util.ArrayList;
import java.util.Arrays;
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
        //load gamemap
        //display information

        boolean running = true;
        try {
            while (running) {
                Location playerLocation =  map.getLocationFromName(player.getLocationName());
                //System.out.println("What do you want to do?");
                LevelMap levelMap = playerLocation.levelMap;
                //print text
                System.out.println(levelMap.getCurrentNode().text+"\n");

                //check level completion
                if (levelMap.completionNodes.contains(levelMap.currentNode)) {
                    if (playerLocation == map.getFinalLocation()) {
                        throw new WinException("win");
                    } else {
                        List<Location> adjacentLocations = map.getAdjacent(playerLocation);
                        Menu locationMenu = new Menu(adjacentLocations);
                        locationMenu.printMenuItems();
                        running = parser.parse(parser.getInputString(), locationMenu);
                    }

                } else {
                    Menu levelMenu = new Menu(levelMap.getAdjacent());
                    levelMenu.printMenuItems();
                    running = parser.parse(Parser.getInputString(), levelMenu);

                }

                //String command = Parser.getInputString();
                //running = parser.parse(player, command);
            }
        } catch (DeathException e) {
            System.out.println("You died.");
        } catch (WinException e) {
            System.out.println("You win.");
            boolean endPrompt = false;
            while (!endPrompt) {
                System.out.println("Would you like to play again?");
                String response = Parser.getInputString();
                if (response.equals("y") || response.equals("yes")) {
                    PlayerJSON.removePlayer(player.getName());
                    new MainMenu();
                } else if (response.equals("n") || response.equals("no")) {
                    PlayerJSON.removePlayer(player.getName());
                    System.out.println("Game exited.");;
                }
            }
            System.out.println("Play again?");
        }

    }
}


