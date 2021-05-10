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
        System.out.println("Hello " + player.getName() + "."); //check name, later delete


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

                        boolean endPrompt = false;
                        while (!endPrompt) {
                            System.out.println("Would you like to save your progress?(y/n)");
                            String response = parser.getInputString();
                            if (response.equals("y") || response.equals("yes")) {
                                //save game (player data)
                                //
                                System.out.println("game saved.");
                                endPrompt = true;
                            } else if (response.equals("n") || response.equals("no")) {
                                System.out.println("game not saved.");;
                                endPrompt = true;
                            }
                        }
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
        //map = loadfromjson();
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
        //todo cottage.levelMap = loadlevelmapfromjson();

        LevelNode cottageRoot = new LevelNode(null,"You go inside the cottage and catch a glimpse of a child sitting on the cozy sofa in the small living room. She is dozing off, probably because it is warm inside.", null);
        cottage.levelMap = new LevelMap(cottageRoot);
        LevelNode cottageOp1 = new LevelNode("approach\",\"You approach the child, and take a closer look.\",null);\n");
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
        LevelNode forestpsycho = new LevelNode(null,"Walking through the damp, dark road, you realised that there was the old man between the trees.\nHe hasn't seen your side yet.", null);
        forest.levelMap.setAdjacent(rootForest,new ArrayList<>(Arrays.asList(forestpsycho)));
        LevelNode forestOp1 = new LevelNode(null,"Approach.",null);
        LevelNode forestOp2 = new LevelNode(null,"Ignore.",null);
        forest.levelMap.setAdjacent(forestpsycho,new ArrayList<>(Arrays.asList(forestOp1,forestOp2)));
        LevelNode forestpsychoapproach = new LevelNode(null,"Wondering why he was in the middle of this forest, you approached him with curiosity and tried to talk to him.\nYou didn't know because he wasn't looking in your direction, but he had dead, lifeless looking eyes with stones in his hands.\nEven before you realise, he looked back at you and started to throw stones towards you.",null);
        LevelNode forestpsychoignore = new LevelNode(null,"You quickly passed by, knowing that it is abnormal to have a person in the middle of this forest after zombie outbreak.",null);
        forest.levelMap.setAdjacent(forestOp1,new ArrayList<>(Arrays.asList(forestpsychoapproach)));
        forest.levelMap.setAdjacent(forestOp2,new ArrayList<>(Arrays.asList(forestpsychoignore)));
        LevelNode forestpsychowin = new LevelNode(null,"Win.",null);
        LevelNode forestpsycholose = new LevelNode(null,"Lose.",null);//edit accordingly
        forest.levelMap.setAdjacent(forestpsychoapproach,new ArrayList<>(Arrays.asList(forestpsychowin,forestpsycholose)));
        LevelNode forestanimal = new LevelNode(null,"When you heard the rustling sound between the trees, you were stiffened nervously, but soon realised it was an animal that was making the sound.\nGoing closer, you carefully looked through trees and soon noticed that the animal was a (deer).",null); //how to generate different for different animals?
        forest.levelMap.setAdjacent(forestpsychowin,new ArrayList<>(Arrays.asList(forestanimal)));
        forest.levelMap.setAdjacent(forestpsychoignore,new ArrayList<>(Arrays.asList(forestanimal)));
        LevelNode forestOp3 = new LevelNode(null,"Hunt.",null);
        LevelNode forestOp4 = new LevelNode(null,"Ignore.",null);
        forest.levelMap.setAdjacent(forestanimal,new ArrayList<>(Arrays.asList(forestOp3,forestOp4)));
        LevelNode forestanimalhunt = new LevelNode(null,"Having been hungry, you decided to hunt after confirming that you didn't have enough food.",null);
        LevelNode forestanimalignore = new LevelNode(null,"You decided to pass by as you were not confident enough to hunt it.",null);
        forest.levelMap.setAdjacent(forestOp3,new ArrayList<>(Arrays.asList(forestanimalhunt)));
        forest.levelMap.setAdjacent(forestOp4,new ArrayList<>(Arrays.asList(forestanimalignore)));
        LevelNode forestanimalhuntwin = new LevelNode(null,"You successfully hunt and get meat.",null);
        LevelNode forestanimalhuntlose = new LevelNode(null,"Hunting failed.",null);
        //what if hunting fails? what happens: no food gained
        forest.levelMap.setAdjacent(forestanimalhunt,new ArrayList<>(Arrays.asList(forestanimalhuntwin,forestanimalhuntlose)));
        LevelNode forestzombie = new LevelNode(null,"In the middle of the forest, the zombie was finding for the next prey with ears, not eyes perhaps because his eyeballs had rotted.\nFrom zombie's mouth, a liquid suitable to express as filth rather than saliva was falling slowly.\nYour muscles became stiff and bones and joints hardened as if your limbs were binded due to fear.\nOnce you make a big enough sound, the zombie will find you.",null);
        //depends on approachProb?



        forest.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(forestpsycho)));
        forest.levelMap.setDeathNodes(new ArrayList<>(Arrays.asList(forestpsycholose)));


        //hospital
        LevelNode rootHospital = new LevelNode(null,"You are now in the hospital.",null);
        hospital.levelMap = new LevelMap(rootHospital);
        LevelNode hospitalfirstaid = new LevelNode(null,"While walking in the hallway, you found the first aid kit near the staircase.\nCongratulations, you collected a first aid kit!",new ArrayList<>(Arrays.asList("item 1"))); //item 1 = medkit
        hospital.levelMap.setAdjacent(rootHospital,new ArrayList<>(Arrays.asList(hospitalfirstaid)));
        LevelNode hospitalpsycho = new LevelNode(null,"Not wanting to risk yourself taking the lift in a hospital where the electricity supply seemed to be poor, you decided to go by staircase.\nAt third floor, you found someone walking towards you.\n\nHe looks friendly with slightly chubby face, hooded chocolate-brown eyes, round nose and a big smile made by his heart-shaped lips.\nHe realised you coming towards him as well, and he seems to want a conversation with you.",null);
        LevelNode hospitalOp1 = new LevelNode(null,"Go and talk with him.",null);
        LevelNode hospitalOp2 = new LevelNode(null, "Ignore.",null);
        hospital.levelMap.setAdjacent(hospitalfirstaid,new ArrayList<>(Arrays.asList(hospitalpsycho)));
        hospital.levelMap.setAdjacent(hospitalpsycho,new ArrayList<>(Arrays.asList(hospitalOp1,hospitalOp2)));
        LevelNode hospitalpsychoapproach = new LevelNode(null,"He was holding a scapel you couldn't see from the distance.\nHe ran towards you so that you failed to escape and got a cut.\n\nYou realised that you are not able to run away, so decided to fight back.",new ArrayList<>(Arrays.asList("psychofight")));
        LevelNode hospitalpsychoignore = new LevelNode(null,"You thought that it is weird to have person in the middle of the hospital hallway, so you ignored him and went up the staircase quickly so he wouldn't follow you.",null);
        hospital.levelMap.setAdjacent(hospitalOp1,new ArrayList<>(Arrays.asList(hospitalpsychoapproach)));
        hospital.levelMap.setAdjacent(hospitalOp2,new ArrayList<>(Arrays.asList(hospitalpsychoignore)));
        LevelNode hospitalpsychowin = new LevelNode(null,"Won.",null);
        LevelNode hospitalpsycholose = new LevelNode(null,"Lost.",null);//to be edited once fight decided
        hospital.levelMap.setAdjacent(hospitalpsychoapproach,new ArrayList<>(Arrays.asList(hospitalpsychowin, hospitalpsycholose)));
        LevelNode hospitaldoc = new LevelNode(null,"You walked further upstairs and while you walk around fifth floor, you found someone resting in the bed between the curtains in the hospital room.\n\nThe person is lying on the bed, but still awake.\nYou could see the long blonde sticking out, and she was tossing and turning under the duvet.",null);
        LevelNode hospitalOp3 = new LevelNode(null,"Talk to her.",null);
        LevelNode hospitalOp4 = new LevelNode(null,"Ignore.",null);
        hospital.levelMap.setAdjacent(hospitalpsychoignore,new ArrayList<>(Arrays.asList(hospitaldoc)));
        hospital.levelMap.setAdjacent(hospitalpsychowin,new ArrayList<>(Arrays.asList(hospitaldoc)));
        hospital.levelMap.setAdjacent(hospitaldoc,new ArrayList<>(Arrays.asList(hospitalOp3,hospitalOp4)));
        LevelNode hospitaldocapproach = new LevelNode(null,"You decided to talk to her, and after a short conversation, you found out that she was a doctor.\nYou showed her the wounds you had on the way to hospital, asking if she could give you some kind of treatment.\nFortunately, she gladly helped me.",new ArrayList<>(Arrays.asList("heal 10")));//change value accoridngly
        LevelNode hospitaldocteam = new LevelNode(null,"You thanked her then explained that you were on the way to get a vaccine, and suggested her to accompany me.\nShe accepted without hesitation, and we went out of the hospital together.",null);//combine? depends on how healAmount works
        LevelNode hospitaldocignore = new LevelNode(null,"Feeling suspicious, you decided to pass by as if you had seen nothing.",null);
        hospital.levelMap.setAdjacent(hospitalOp3,new ArrayList<>(Arrays.asList(hospitaldocapproach)));
        hospital.levelMap.setAdjacent(hospitaldocapproach,new ArrayList<>(Arrays.asList(hospitaldocteam)));
        hospital.levelMap.setAdjacent(hospitalOp4,new ArrayList<>(Arrays.asList(hospitaldocignore)));

        hospital.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(hospitaldocteam,hospitaldocignore)));
        hospital.levelMap.setDeathNodes(new ArrayList<>(Arrays.asList(hospitalpsycholose)));


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


