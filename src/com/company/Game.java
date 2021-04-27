package com.company;

import com.company.characters.Player;
import com.company.locations.Forest;
import com.company.locations.GameMap;
import com.company.locations.*;
import com.company.locations.Location;
import com.company.menus.Menu;
import com.company.menus.MenuItem;
import com.company.parser.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    Player player = null;
    public Parser parser;
    private GameMap map;

    public Game(Player p) {
        this.player = p;
        this.parser = new Parser();
        System.out.println(p.getIntro());
        System.out.println("Due to the zombies roaming the city streets, there are difficulties in the supply of vaccine and some people had to directly go to the laboratory in the Virus Centre and collect the vaccine.");
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
                System.out.println(levelMap.getCurrentNode().getText());

                //check level completion
                if (levelMap.completionNodes.contains(levelMap.currentNode)) {
                    if (player.getLocation() == map.getFinalLocation()) {
                        throw new WinException("win");
                    } else {
                        Menu locationMenu = new Menu();
                        List<Location> adjacentLocations = map.getAdjacent(player.getLocation());
                        for (int i=0;i<adjacentLocations.size();i++) {
                            locationMenu.addMenuItem(new MenuItem(i+"",adjacentLocations.get(i).name));
                        }
                        MenuItem selectedLocation = locationMenu.displayChooseOption();
                        for (int i=0;i<adjacentLocations.size();i++) {
                            if ((i+"").equals(selectedLocation.getOptionKey())) {
                                //change location
                                player.setLocation(adjacentLocations.get(i));
                                player.getLocation().displayInformation();
                            }
                        }
                    }

                } else if (levelMap.deathNodes.contains(levelMap.currentNode)) {
                    throw new DeathException("You died");
                } else {
                    List<LevelNode> options = levelMap.getAdjacent();

//                    if (options == null) {
//                        System.out.println("no options available");
//                        return;
//                    }
                    Menu levelMenu = new Menu();

                    for (int i=0;i<options.size();i++) {
                        levelMenu.addMenuItem(new MenuItem(i+"",options.get(i).getOption()));
                    }

                    MenuItem item = levelMenu.displayChooseOption();

                    for (int i=0;i<options.size();i++) {
                        if ((i+"").equals(item.getOptionKey())) {
                            LevelNode n = options.get(i);
                            levelMap.setCurrentNode(n);
                        }
                    }

                }

                //String command = Parser.getInputString();
                //running = parser.parse(player, command);
            }
        } catch (DeathException e) {
            System.out.println("you died.");
        } catch (WinException e) {
            System.out.println("you win.");
        }



    }
    public void setupGameMap() {
        map = new GameMap();
        //setup map
        Location hospital = new Location("hospital","a dark hospital");
        map.addLocation(hospital);
        Location cottage = new Location("cottage", "a small cottage");
        map.addLocation(cottage);
        Location forest = new Location("forest", "a small forest");
        map.addLocation(forest);
        Location lab = new Location("lab", "a small lab");
        map.addLocation(lab);
        Location road = new Location("road", "a long road");
        map.addLocation(road);

        map.addEdge(cottage, hospital, 6);
        map.addEdge(cottage, forest, 4);
        map.addEdge(forest, hospital, 7);
        map.addEdge(forest, road, 6);
        map.addEdge(hospital, road, 10);
        map.addEdge(road, lab, 4);

        player.setLocation(hospital);

        LevelNode root = new LevelNode(null,"You are now in the hospital. While walking in the hallway, you found the first aid kit near the staircase. \"At third floor, you found someone walking towards you.", null);
        hospital.levelMap = new LevelMap(root);
        LevelNode option1 = new LevelNode("approach the man","He looks friendly with slightly chubby face, hooded chocolate-brown eyes, round nose and a big smile made by his heart-shaped lips. He realised you coming towards him as well, and he seems to want a conversation with you. ",null);
        LevelNode option2 = new LevelNode("Go and talk with him","He was holding a scapel you couldn't see from the distance. He ran towards you so that you failed to escape and got a cut.",null);
        LevelNode option3 = new LevelNode("ignore him","something happens",null);
        hospital.levelMap.setAdjacent(root,new ArrayList<>(Arrays.asList(option1)));
        hospital.levelMap.setAdjacent(option1,new ArrayList<>(Arrays.asList(option2, option3)));

        //sucessfully completed level
        hospital.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(option3)));

        //player dies
        hospital.levelMap.setDeathNodes(new ArrayList<>(Arrays.asList(option2)));

        //continue, DO THIS (NAYOON)



    }
}


