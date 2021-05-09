package com.company.menus;

import com.company.Game;
import com.company.MenuItem;
import com.company.characters.Player;
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
                Player player = new Player();
//                PersistDataJSON persistJson = new PersistDataJSON();
//                Player player = persistJson.load("new-player.json");
//                new Game(player);
                new Game(player);
                running = false;

            } else if (userInput.equals("1")) {
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
