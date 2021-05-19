package com.company.menus;

import com.company.Game;
import com.company.characters.Player;
import com.company.data.InitializeJSON;
import com.company.data.Level;
import com.company.data.LevelJSON;
import com.company.data.PlayerJSON;
import com.company.parser.Parser;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu {
    Level level;

    public MainMenu() {
        start();
    }

    /**
     * displays main menu options and handles user selection
     */
    public void start() {
        Menu mainMenu = new Menu(
                new ArrayList<>(Arrays.asList(new GenericMenuItem("Start New Game"), new GenericMenuItem("Load Existing Game"), new GenericMenuItem("Exit"))));
        boolean running = true;
        do {
            boolean endPrompt = false;

            while (!endPrompt) {
                mainMenu.printMenuItems();
                String userInput = Parser.getInputString();
                if (userInput.equals("0")) {
                    System.out.println("Enter your username:");
                    String name = Parser.getInputString();
                    System.out.println("Hello " + name + ".\n");

                    boolean endDifficultyPrompt = false;
                    int difficulty = 0;

                    while (!endDifficultyPrompt) {
                        System.out.println("Choose your difficulty:");
                        Menu difficultyMenu = new Menu(
                                        new ArrayList<>(Arrays.asList(new GenericMenuItem("Easy"),
                                        new GenericMenuItem("Medium"), new GenericMenuItem("Hard"),
                                        new GenericMenuItem("Expert"))));
                        difficultyMenu.printMenuItems();
                        try {
                            difficulty = Integer.parseInt(Parser.getInputString());
                            if (difficulty >= 0 && difficulty <= 3) {
                                endDifficultyPrompt = true;
                                level = LevelJSON.getSpecificLevel(difficulty);
                            } else {
                                System.out.println("Please enter a valid number.\n");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.\n");
                        }
                    }
                    // attempt to create new player
                    Player player = PlayerJSON.createNewPlayer(name, difficulty);
                    if (player != null) {
//                        Game.printIntro();   // todo remove later on
                        new Game(player);
                        endPrompt = true;
                        running = false;
                    } else {
                        System.out.println("Username already exists. Please try again.");
                    }


                } else if (userInput.equals("1")) {
                    System.out.println("Enter your username:");
                    String username = Parser.getInputString();
                    //load player
                    Player player = PlayerJSON.getSpecificPlayer(username);
                    if (player != null) {
                        new Game(player);
                        endPrompt = true;
                        running = false;
                    } else {
                        System.out.println("Username does not exist. Please try again\n");
                    }
                } else if (userInput.equals("2")) {
                    System.out.println("Game exited.");
                    endPrompt = true;
                    running = false;
                } else {
                    System.out.println("Please select a valid option.");
                    System.out.println();
                }
            }

        } while (running);
    }

}
