package com.company;

import com.company.characters.Player;
import com.company.locations.Forest;
import com.company.locations.Hospital;
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
        System.out.println("Yet, due to the zombies who were roaming the city streets, there were difficulties in the supply of vaccine and some people had to directly go to the laboratory in the Virus Centre and collect the vaccine.");
        System.out.println("What is your name?");
        player.setName(Parser.getInputString());
        System.out.println(player.getName()); //check name, later delete

        Location forest = new Forest(); //initial
        player.setLocation(forest);
        player.getLocation().displayInformation();
        Node root = new Node("You are now in the hospital. While walking in the hallway, you found the first aid kit near the staircase. \"At third floor, you found someone walking towards you.",null,null);
        forest.levelMap = new LevelMap(root);
        Node option1 = new Node("He looks friendly with slightly chubby face, hooded chocolate-brown eyes, round nose and a big smile made by his heart-shaped lips. He realised you coming towards him as well, and he seems to want a conversation with you. ",null, "approach");
        Node option2 = new Node("He was holding a scapel you couldn't see from the distance. He ran towards you so that you failed to escape and got a cut.",null,"Go and talk with him");
        Node option3 = new Node("aaa",null,"Ignore");
        forest.levelMap.addEdge(option1,option2);
        forest.levelMap.addEdge(option1,option3);
        forest.levelMap.addEdge(root,option1);
        //continue, DO THIS (NAYOON)


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
