package com.company;

import com.company.characters.Player;
import com.company.locations.GameMap;
import com.company.locations.Location;
import com.company.menus.Menu;
import com.company.menus.GenericMenuItem;
import com.company.parser.Parser;
import com.company.LevelNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    Player player = null;
    public Parser parser;
    private GameMap map;

    public Game(Player p) {
        this.player = p;
        this.parser = new Parser(p);
        System.out.println(p.getIntro());
        System.out.println("You are one of the people who decided to face the danger and go to the Laboratory for your family and neighbours.\n");
        System.out.println("What is your name?");
        player.setName(Parser.getInputString());
        System.out.println(player.getName()); //check name, later delete


        setupGameMap();

        player.getLocation().displayInformation();

        boolean running = true;
        try {
            while (running) {
                //System.out.println("What do you want to do?");
                LevelMap levelMap = player.getLocation().levelMap;

                //print text
                System.out.println(levelMap.getCurrentNode().text);

                //check level completion
                if (levelMap.completionNodes.contains(levelMap.currentNode)) {
                    if (player.getLocation() == map.getFinalLocation()) {
                        throw new WinException("win");
                    } else {
                        List<Location> adjacentLocations = map.getAdjacent(player.getLocation());
                        Menu locationMenu = new Menu(adjacentLocations);
                        locationMenu.printMenuItems();
                        running = parser.parse(player, parser.getInputString(), locationMenu);
                    }

                } else if (levelMap.deathNodes.contains(levelMap.currentNode)) {
                    throw new DeathException("You died.");
                } else {

                    Menu levelMenu = new Menu(levelMap.getAdjacent());
                    levelMenu.printMenuItems();
                    running = parser.parse(player, Parser.getInputString(), levelMenu);

                }

                //String command = Parser.getInputString();
                //running = parser.parse(player, command);
            }
        } catch (DeathException e) {
            System.out.println("You died.");
        } catch (WinException e) {
            System.out.println("You win.");
        }



    }
    public void setupGameMap() {
        map = new GameMap();
        //setup map
        Location hospital = new Location("hospital","You are now in the hospital.");
        map.addLocation(hospital);
        Location cottage = new Location("cottage", "You found a cottage while you were looking for a place to hide, avoiding zombies.");
        map.addLocation(cottage);
        Location forest = new Location("forest", "You found a forest and went in wondering if you could hunt for food.");
        map.addLocation(forest);
        Location lab = new Location("lab", "Congratulations, you finally reached the laboratory!");
        map.addLocation(lab);
        Location road = new Location("road", "You are walking down the street looking for an accessible building.");
        map.addLocation(road);
        Location home = new Location("home","Initial place");
        map.addLocation(home);

        map.addEdge(home,cottage,5);
        map.addEdge(home,forest,9);
        map.addEdge(cottage, hospital, 6);
        map.addEdge(cottage, forest, 4);
        map.addEdge(forest, hospital, 7);
        map.addEdge(forest, road, 6);
        map.addEdge(hospital, road, 10);
        map.addEdge(road, lab, 4);

        player.setLocation(home);

        LevelNode rootHome = new LevelNode(null,"Choose a place to go.", null);//home.isVisited()
        home.levelMap = new LevelMap(rootHome);

        // set home as completion node
        home.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(rootHome)));


        //cottage

        LevelNode cottageRoot = new LevelNode(null,"You go inside the cottage and catch a glimpse of a child sitting on the cozy sofa in the small living room. She is dozing off, probably because it is warm inside.", null);
        cottage.levelMap = new LevelMap(cottageRoot);
        LevelNode cottageOp1 = new LevelNode("approach","You approach the child, and take a closer look.",null);
        LevelNode cottageOp2 = new LevelNode("ignore","You ignore the child",null);
        cottage.levelMap.setAdjacent(cottageRoot,new ArrayList<>(Arrays.asList(cottageOp1,cottageOp2)));
        LevelNode cottageOp3 = new LevelNode("wake her up","You gently shake the child to wake her up.\nTo your horror, she was actually pretending to be asleep and was hiding a kitchen knife in her hand behind her.\nYou don't want to hurt child, but at the same time, you don't want to die.",null);
        LevelNode cottageOp4 = new LevelNode("leave her alone","You don't want to wake her up since she seems to be comfortable lying there, you follow your initial plan and take a break for a while.\nYou creep towards toilet, go in, and carefully close the door.",null);
        cottage.levelMap.setAdjacent(cottageOp1,new ArrayList<>(Arrays.asList(cottageOp3)));
        cottage.levelMap.setAdjacent(cottageOp2,new ArrayList<>(Arrays.asList(cottageOp4)));
        LevelNode cottageOp5 = new LevelNode("escape", "You manage to get out of the room and slam the door. You go to look around to see what else you can find in the cottage. You go into the toilet which is right next to the living room.",null);
        LevelNode cottageOp6 = new LevelNode("fight the girl","Unfortunately, you couldn't beat her as she had weapon and you didn't.",null);
        cottage.levelMap.setAdjacent(cottageOp3,new ArrayList<>(Arrays.asList(cottageOp5,cottageOp6)));
        LevelNode cottageOp7 = new LevelNode("search shelf","Trying to find something useful, you open a drawer in a shelf to your right and find a hunting kit.\nCongratulations, a hunting kit has been added to your inventory!\nYou find a storage room",null);
        cottage.levelMap.setAdjacent(cottageOp4,new ArrayList<>(Arrays.asList(cottageOp7)));
        cottage.levelMap.setAdjacent(cottageOp5,new ArrayList<>(Arrays.asList(cottageOp7)));
        LevelNode cottageOp8 = new LevelNode("go into the storage room","You go into the storage room and find a muscular man in his mid 30's.\nHe doesn't seem to have noticed you yet.",null);
        cottage.levelMap.setAdjacent(cottageOp7,new ArrayList<>(Arrays.asList(cottageOp8)));
        LevelNode cottageOp11 = new LevelNode("approach the man ","You tap him on the shoulder and ask what he is doing.\nIt turns out that he is a hunter, and had stopped by this cottage to search for useful tools and weapons.\n\nHe tells you that he found AR-15 style 12 gauge with muzzle flash and 2 mags with 10 round capacity in the room.\nThinking it will be great to accompany him, you suggest working together to find a vaccine.\n\nHunter joined your team.",null);
        LevelNode cottageOp10 = new LevelNode("ignore him","You ignore the man and leave the cottage.",null);
        cottage.levelMap.setAdjacent(cottageOp8,new ArrayList<>(Arrays.asList(cottageOp10,cottageOp11)));

        //sucessfully completed level
        cottage.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(cottageOp10,cottageOp11)));
        //player dies
        cottage.levelMap.setDeathNodes(new ArrayList<>(Arrays.asList(cottageOp6)));


        //forest
        LevelNode rootForest =  new LevelNode(null,"You are in a forest", null);
        forest.levelMap = new LevelMap(rootForest);

        //hospital
        LevelNode rootHospital = new LevelNode(null,null,null);
        hospital.levelMap = new LevelMap(rootHospital);


//        LevelNode option1 = new LevelNode("go to cottage","Go to cottage",null);
        //new ArrayList<>(Arrays.asList(player.setLocation(cottage),cottage.isVisited())) for actions, error:'void type not allowed here'
        //print cottage.description
//        LevelNode option2 = new LevelNode("go to forest","Go to forest.",null);//forest.isVisited()
//        home.levelMap.setAdjacent(root,new ArrayList<>(Arrays.asList(option1,option2)));
        //player.setLocation(cottage); should be one of actions?
        //cottage.levelMap=new LevelMap(home)? current location vs node aka option





        //continue, DO THIS (NAYOON)




    }
}


