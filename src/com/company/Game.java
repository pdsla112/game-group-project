package com.company;

import com.company.characters.Player;
import com.company.locations.Forest;
import com.company.locations.Location;
import com.company.parser.Parser;

import java.sql.SQLOutput;

public class Game {
    Player player = null;
    public Parser parser;

    public Game(Player p) {
        this.player = p;
        this.parser = new Parser();
        System.out.println(p.getIntro());
        System.out.println("What is your name?");
        player.setName(Parser.getInputString());
        System.out.println("Welcome " + player.getName());

        Location forest = new Forest();
        player.setLocation(forest);
        player.getLocation().displayInformation();

        boolean running = true;
        try {
            while (running) {
                System.out.println("What do you want to do?");
                String command = Parser.getInputString();
                running = parser.parse(player, command);
            }
        } catch (DeathException e) {
            System.out.println("you died.");
        }



    }
}
