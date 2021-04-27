package com.company.menus;

import com.company.Game;
import com.company.characters.Player;

public class MainMenu extends Menu{
    public MainMenu() {
        start();
    }

    public void start() {
        addMenuItem(new MenuItem("Start", "Starts a new Game"));
        addMenuItem(new MenuItem("Exit", "Exit game"));

        boolean running = true;
        do {
            MenuItem selectedItem = displayChooseOption();

            if (selectedItem.optionKey.equals("start")) {
                Player player = new Player();
                new Game(player);
                running = false;

            } else {
                running = false;
            }

        } while (running);
    }

}
