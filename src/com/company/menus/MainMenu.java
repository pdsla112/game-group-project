package com.company.menus;

import com.company.Game;
import com.company.MenuItem;
import com.company.characters.Player;
import com.company.data.PlayerJSON;
import com.company.parser.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainMenu {
    public MainMenu() {
        start();
    }

    public void start() {


        Menu mainMenu = new Menu(new ArrayList<GenericMenuItem>(Arrays.asList(new GenericMenuItem("Start New Game"), new GenericMenuItem("Load Existing Game"), new GenericMenuItem("Exit"))));
        boolean running = true;
        do {
            mainMenu.printMenuItems();
            String userInput = Parser.getInputString();

            if (userInput.equals("0")) {

                System.out.println("What is your name?");
                String name = Parser.getInputString();
                System.out.println("Hello " + name + ".");

                System.out.println("What is your email (for saving)?");
                String email = Parser.getInputString();

                System.out.println("Choose your difficulty");
                Menu difficultyMenu = new Menu(new ArrayList<GenericMenuItem>(Arrays.asList(new GenericMenuItem("Easy"), new GenericMenuItem("Medium"), new GenericMenuItem("Hard"), new GenericMenuItem("Expert"))));
                difficultyMenu.printMenuItems();
                int difficulty = Integer.parseInt(Parser.getInputString());

                Player player = new Player(name, email, difficulty);

                //PlayerJSON.savePlayer(player);
//                PersistDataJSON persistJson = new PersistDataJSON();
//                Player player = persistJson.load("new-player.json");
//                new Game(player);
                new Game(player);
                running = false;

            } else if (userInput.equals("1")) {
                // Get the player to type their email.
                System.out.println("Enter your email:");
                String email = Parser.getInputString();
                ArrayList<Player> deserializedList = PlayerJSON.deserializeJSON();
                Player player = PlayerJSON.getSpecificPlayer(deserializedList, email);
//                PersistDataJSON persistJson = new PersistDataJSON();
//                Player player = persistJson.load("player.json");
//                new Game(player);
                running = false;
            } else {
                running = false;
            }

        } while (running);
    }

}
