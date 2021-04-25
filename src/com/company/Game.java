package com.company;

import com.company.characters.Player;
import com.company.locations.Forest;
import com.company.locations.Location;
import com.company.parser.Parser;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    Player player = null;
    public Parser parser;

    public Game(Player p) {
        this.player = p;
        this.parser = new Parser();
        System.out.println(p.getIntro());
        System.out.println("Due to the zombies roaming the city streets, there are difficulties in the supply of vaccine and some people had to directly go to the laboratory in the Virus Centre and collect the vaccine.");
        System.out.println("What is your name?");
        player.setName(Parser.getInputString());
        System.out.println(player.getName()); //check name, later delete

        Location forest = new Forest(); //initial
        player.setLocation(forest);
        player.getLocation().displayInformation();
        LevelNode root = new LevelNode(null,null,"You are now in the hospital. While walking in the hallway, you found the first aid kit near the staircase. \"At third floor, you found someone walking towards you.", null);
        forest.levelMap = new LevelMap(root);
        LevelNode option1 = new LevelNode("approach", "approach the man","He looks friendly with slightly chubby face, hooded chocolate-brown eyes, round nose and a big smile made by his heart-shaped lips. He realised you coming towards him as well, and he seems to want a conversation with you. ",null);
        LevelNode option2 = new LevelNode("talk","Go and talk with him","He was holding a scapel you couldn't see from the distance. He ran towards you so that you failed to escape and got a cut.",null);
        LevelNode option3 = new LevelNode("ignore","ignore him","something happens",null);
        forest.levelMap.setAdjacent(root,new ArrayList<>(Arrays.asList(option1)));
        forest.levelMap.setAdjacent(option1,new ArrayList<>(Arrays.asList(option2, option3)));

        //continue, DO THIS (NAYOON)


        boolean running = true;
//        try {
            while (running) {
                //System.out.println("What do you want to do?");
                player.getLocation().displayChooseOptions();
                //String command = Parser.getInputString();
                //running = parser.parse(player, command);
            }
        //} catch (DeathException e) {
            //System.out.println("you died.");
        //}



    }
}
