package com.company.menus;

import com.company.Game;
import com.company.characters.Player;
import com.company.data.PlayerJSON;
import com.company.parser.Parser;

import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu {
    public MainMenu() {
        start();
    }

    public void start() {


        Menu mainMenu = new Menu(new ArrayList<GenericMenuItem>(Arrays.asList(new GenericMenuItem("Start New Game"), new GenericMenuItem("Load Existing Game"), new GenericMenuItem("Exit"))));
        boolean running = true;
        do {
            boolean endPrompt = false;

            while (!endPrompt) {
                mainMenu.printMenuItems();
                String userInput = Parser.getInputString();
                if (userInput.equals("0")) {

                    System.out.println("Enter your username:");
                    String name = Parser.getInputString();
                    System.out.println("Hello " + name + ".");

                    //System.out.println("What is your email (for saving)?");
                    //String email = Parser.getInputString();

                    boolean endDifficultyPrompt = false;
                    int difficulty = 0;

                    while (!endDifficultyPrompt) {
                        System.out.println("Choose your difficulty");
                        Menu difficultyMenu = new Menu(
                                new ArrayList<>(Arrays.asList(new GenericMenuItem("Easy"),
                                        new GenericMenuItem("Medium"), new GenericMenuItem("Hard"),
                                        new GenericMenuItem("Expert"))));
                        difficultyMenu.printMenuItems();
                        try {
                            difficulty = Integer.parseInt(Parser.getInputString());
                            if (difficulty >= 0 && difficulty <= 3) {
                                endDifficultyPrompt = true;
                            } else {
                                System.out.println("Please enter a valid number.\n");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid number.\n");
                        }

                    }

                    Player player = PlayerJSON.createNewPlayer(name, difficulty);
                    if (player != null) {
//                        Game.printIntro();   // This is getting in the way
                        new Game(player);
                        endPrompt = true;
                        running = false;
                    } else {
                        System.out.println("Username already exists.");
                    }


                } else if (userInput.equals("1")) {
                    // Get the player to type their email.
                    System.out.println("Enter your username:");
                    String username = Parser.getInputString();
                    Player player = PlayerJSON.getSpecificPlayer(username);
                    if (player != null) {
                        new Game(player);
                        endPrompt = true;
                        running = false;
                    } else {
                        System.out.println("There was an error loading your profile.\n");
                    }
//                PersistDataJSON persistJson = new PersistDataJSON();
//                Player player = persistJson.load("player.json");
//                new Game(player);
                } else if (userInput.equals("2")) {
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
