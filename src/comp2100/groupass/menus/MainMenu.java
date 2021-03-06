package comp2100.groupass.menus;

import comp2100.groupass.Game;
import comp2100.groupass.entities.Player;
import comp2100.groupass.data.InitializeJSON;
import comp2100.groupass.data.Level;
import comp2100.groupass.data.LevelJSON;
import comp2100.groupass.parser.Parser;
import comp2100.groupass.data.PlayerJSON;
import java.util.concurrent.TimeUnit;
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
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");

        System.out.println("┌───────── •✧✧• ─────────┐\n" +
                " -Pandemic Survival Game- \n" +
                "└───────── •✧✧• ─────────┘");
        Menu mainMenu = new Menu(
                new ArrayList<>(Arrays.asList(new GenericMenuItem("Start New Game"), new GenericMenuItem("Load Existing Game"), new GenericMenuItem("Exit"))));
        boolean running = true;
        do {
            boolean endPrompt = false;

            while (!endPrompt) {
                mainMenu.printMenuItems();
                String userInput = Parser.getInputString();
                System.out.println();
                switch (userInput) {
                    case "0": {
                        System.out.println("Enter your username:");
                        String name = Parser.getInputString();
                        System.out.println("Hello " + name + ".");
                        System.out.println("Tip: Type h for additional commands available during the game.\n");

                        boolean endDifficultyPrompt = false;
                        int difficulty = 0;

                        while (!endDifficultyPrompt) {
                            System.out.println("Choose your difficulty:\n");
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
                            System.out.println();
                            System.out.println("Story:");
                            for (int i = 0; i < 9; i++) {
                                System.out.println(InitializeJSON.deserializeJSON().get(i).getText());
                                if (i == 2 || i == 5 || i == 8) {
                                    Menu nextMenu = new Menu(
                                            new ArrayList<>(Arrays.asList(new GenericMenuItem("Next"))));

                                    boolean endNextPrompt = false;
                                    while (!endNextPrompt) {
                                        nextMenu.printMenuItems();
                                        String next = Parser.getInputString();
                                        if (next.equals("0") || next.toLowerCase().equals("next")) {
                                            endNextPrompt = true;
                                        }
                                        System.out.println();
                                    }

                                }
                            }
                            new Game(player);
                            endPrompt = true;
                            running = false;
                        } else {
                            System.out.println("Username already exists. Please try again.\n");
                        }


                        break;
                    }
                    case "1": {
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
                        break;
                    }
                    case "2":
                        System.out.println("Game exited.");
                        endPrompt = true;
                        running = false;
                        break;
                    default:
                        System.out.println("Please select a valid option.\n");
                        System.out.println();
                        break;
                }
            }

        } while (running);
    }

}
