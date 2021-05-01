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
                System.out.println(levelMap.getCurrentNode().getText());

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

        LevelNode root = new LevelNode(null,"Choose the location to go.", null);//home.isVisited()
        home.levelMap = new LevelMap(root);
        LevelNode option1 = new LevelNode("go to cottage","Go to cottage",null);
        //new ArrayList<>(Arrays.asList(player.setLocation(cottage),cottage.isVisited())) for actions, error:'void type not allowed here'
        //print cottage.description
        LevelNode option2 = new LevelNode("go to forest","Go to forest.",null);//forest.isVisited()
        home.levelMap.setAdjacent(root,new ArrayList<>(Arrays.asList(option1,option2)));
        //player.setLocation(cottage); should be one of actions?
        //cottage.levelMap=new LevelMap(home)? current location vs node aka option
        LevelNode option3 = new LevelNode("approach","Approach",null);
        LevelNode option4 = new LevelNode("ignore","Ignore",null);
        LevelNode option5 = new LevelNode("game end","game end",null);
        LevelNode option6 = new LevelNode("player dies", "player dies", null);
        home.levelMap.setAdjacent(option1,new ArrayList<>(Arrays.asList(option3,option4)));


        //sucessfully completed level
        home.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(option5)));

        //player dies
        home.levelMap.setDeathNodes(new ArrayList<>(Arrays.asList(option6)));

        //continue, DO THIS (NAYOON)




    }
}


