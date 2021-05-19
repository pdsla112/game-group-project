package com.company.data;

import com.company.LevelMap;
import com.company.LevelNode;
import com.company.locations.GameMap;
import com.company.locations.Location;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public class GameMapJSON {
    public static void main(String[] args) {
        GameMap map = new GameMap();
        Location hospital = new Location("hospital",LocationJSON.getSpecificLocationData("hospital").getInitialText());
        map.addLocation(hospital);
        Location cottage = new Location("cottage", LocationJSON.getSpecificLocationData("cottage").getInitialText());//"You found a cottage while you were looking for a place to hide, avoiding zombies."
        map.addLocation(cottage);
        Location forest = new Location("forest", LocationJSON.getSpecificLocationData("forest").getInitialText());//"You found a forest and went in wondering if you could hunt for food."
        map.addLocation(forest);
        Location lab = new Location("lab", LocationJSON.getSpecificLocationData("lab").getInitialText());
        map.addLocation(lab);
        Location road = new Location("road", LocationJSON.getSpecificLocationData("road").getInitialText());
        map.addLocation(road);
        Location home = new Location("home",LocationJSON.getSpecificLocationData("home").getInitialText());
        map.addLocation(home);

        map.addEdge(home,cottage,5);
        map.addEdge(home,forest,9);
        map.addEdge(cottage, hospital, 6);
        map.addEdge(cottage, forest, 4);
        map.addEdge(forest, hospital, 7);
        map.addEdge(forest, road, 6);
        map.addEdge(hospital, road, 10);
        map.addEdge(road, lab, 4);

        LevelNode rootHome = new LevelNode(null,"You wake up and find that no one is home. 'Where is everyone?' you ask yourself. You head out the door.", null);//home.isVisited()
        home.levelMap = new LevelMap(rootHome);

        // set home as completion node
        home.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(rootHome)));


        //cottage
        //todo cottage.levelMap = loadlevelmapfromjson();
        //cottage.levelMap = loadlevelmapfromjson();
        //save all these into json
        //are we still having isVisited() -> testing? If so, will it be added in parser action
        LevelNode rootCottage = new LevelNode(null,"You head inside the cottage and see a few rooms down the hallway.", new ArrayList<>(Arrays.asList("locationObject table under medkit")));
        cottage.levelMap = new LevelMap(rootCottage);

        LevelNode cottageOp5 = new LevelNode("head to the bedroom","You enter the bedroom and take a look around. There is a tiny drawer next to a large bed. There appears to be a trapdoor in the floor.",new ArrayList<>(Arrays.asList("locationObject bed under medkit", "locationObject drawer inside medkit")));
        LevelNode cottageOp6 = new LevelNode("explore the living room","You enter the living room and catch a glimpse of a young girl dozing off on the sofa in the small living room.\n You see a something under the table in front of her.",new ArrayList<>(Arrays.asList("locationObject bed under medkit", "locationObject drawer inside medkit")));

        cottage.levelMap.setAdjacent(rootCottage,new ArrayList<>(Arrays.asList(cottageOp5,cottageOp6)));

        //living room
        LevelNode cottageOp4 = new LevelNode("sneak past her","You don't want to wake her up since she looks so comfortable lying there. \nYou sneak towards bathroom and carefully close the door. There is a cabinet above the sink.",new ArrayList<>(Arrays.asList("locationObject cabinet inside medkit")));
        LevelNode cottageOp3 = new LevelNode("wake her up","You approach the child and take a closer look. She appears to be younger than 10 years old.\nYou gently shake the child to wake her up.\nTo your horror, she suddenly awakens and pulls out a concealed knife from behind her and tries to stab you.",new ArrayList<>(Arrays.asList("psychoFight")));
        LevelNode cottageOp2 = new LevelNode("leave the room","You exit the room and go back to the hallway. There is a rooms you haven't explored yet.", null);

        cottage.levelMap.setAdjacent(cottageOp6,new ArrayList<>(Arrays.asList(cottageOp3,cottageOp4, cottageOp2)));
        cottage.levelMap.setAdjacent(cottageOp2,new ArrayList<>(Arrays.asList(cottageOp5)));
        cottage.levelMap.setAdjacent(cottageOp4,new ArrayList<>(Arrays.asList(cottageOp5)));



        LevelNode cottageOp7 = new LevelNode("open the trap door","You open the trap door and go down into the basement.\nUnfortunately there is something waiting for you at the bottom.",  Arrays.asList("zombieFight"));
        LevelNode cottageOp8 = new LevelNode("leave the room","You are about to turn around to leave when you hear a loud noise outside. \nSomething is coming after you. You decide to open the trapdoor and go down into the basement.\nThe room is pitch black, so you turn on the lights.\nUnfortunately there is something waiting for you at the bottom.", Arrays.asList("zombieFight"));

        cottage.levelMap.setAdjacent(cottageOp5,new ArrayList<>(Arrays.asList(cottageOp7,cottageOp8)));

        LevelNode cottageOp9 = new LevelNode("open the closet","You hear a feint noise coming closet and decide to open it.\nTo your suprise, there is a frightened man huddled inside.\n'I thought I was dead. Thank you so much for saving me.' he tells you.\nThe man gives you a medkit as a reward", Arrays.asList("item medkit"));

        cottage.levelMap.setAdjacent(cottageOp7,new ArrayList<>(Arrays.asList(cottageOp9)));
        cottage.levelMap.setAdjacent(cottageOp8,new ArrayList<>(Arrays.asList(cottageOp9)));

        LevelNode cottageOp11 = new LevelNode("leave the cottage","You decide to leave the cottage and head somewhere else.",null);

        cottage.levelMap.setAdjacent(cottageOp9,new ArrayList<>(Arrays.asList(cottageOp11)));

        cottage.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(cottageOp11)));

//        cottage.levelMap.setAdjacent(cottageOp1,new ArrayList<>(Arrays.asList(cottageOp3,cottageOp4)));
//        //LevelNode cottageOp5 = new LevelNode("go to the bathroom", "You get out of the room and look around to see what else you can find in the cottage. \nYou go into the bathroom.",null);
//        //LevelNode cottageOp6 = new LevelNode("fight the girl","Win/Lose. If lose, deathexception. If win, go to next step. Here default win\nTrying to find something useful, you open a drawer in a shelf to your right.",null);//TODO
//        //cottage.levelMap.setAdjacent(cottageOp2,new ArrayList<>(Arrays.asList(cottageOp5)));
//        //cottage.levelMap.setAdjacent(cottageOp4,new ArrayList<>(Arrays.asList(cottageOp5)));
//        cottage.levelMap.setAdjacent(cottageOp3,new ArrayList<>(Arrays.asList(cottageOp6)));
//        LevelNode cottageOp7 = new LevelNode("search the shelf","Congratulations, you found a hunting kit. Now, hunting kit has been added to your inventory!\nYou find a storage room",new ArrayList<>(Arrays.asList("item 1")));
//        LevelNode cottageOp8 = new LevelNode("close the shelf","",null);
//        cottage.levelMap.setAdjacent(cottageOp5,new ArrayList<>(Arrays.asList(cottageOp7,cottageOp8)));
//        cottage.levelMap.setAdjacent(cottageOp6,new ArrayList<>(Arrays.asList(cottageOp7,cottageOp8)));
//        LevelNode cottageOp9 = new LevelNode("go into the storage room","You go into the storage room and find a muscular man in his mid 30's.\nHe doesn't seem to have noticed you yet.",null);
//        cottage.levelMap.setAdjacent(cottageOp7,new ArrayList<>(Arrays.asList(cottageOp9)));
//        cottage.levelMap.setAdjacent(cottageOp8,new ArrayList<>(Arrays.asList(cottageOp9)));
//        LevelNode cottageOp10 = new LevelNode("approach the man ","You tap him on the shoulder and ask what he is doing.\nIt turns out that he is a hunter, and had stopped by this cottage to search for useful tools and weapons.\n\nHe tells you that he found AR-15 style 12 gauge with muzzle flash and 2 mags with 10 round capacity in the room.\nThinking it will be great to accompany him, you suggest working together to find a vaccine.\n\nHunter joined your team.\nChoose the next location to go.",new ArrayList<>(Arrays.asList("heal 10")));
//        //when hunter added are we making the hunting at forest easier aka attacklevel increase? if so, add to parser action
//        LevelNode cottageOp11 = new LevelNode("ignore him","You ignore the man and leave the cottage.\nChoose the next location to go.",null);
//        cottage.levelMap.setAdjacent(cottageOp9,new ArrayList<>(Arrays.asList(cottageOp10,cottageOp11)));

        //sucessfully completed level

        //player dies


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
//        forest.levelMap.setDeathNodes(new ArrayList<>(Arrays.asList(forestpsycholose)));


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
//        hospital.levelMap.setDeathNodes(new ArrayList<>(Arrays.asList(hospitalpsycholose)));

        //road
        LevelNode rootRoad = new LevelNode(null,"You heard the crackling sound coming from chewing pieces of meat and bones. You are feeling short of breath and barely swallowing saliva.\nPanic-stricken for a moment, you unconsciously dropped onto the floor and your palms touched the rough ground full of dust, but could not even realise it.\n" +
                "You saw the zombie attacking someone, so you stepped back into the bush falteringly.",new ArrayList<>(Arrays.asList("zombieFight")));//prob of zombie appearing?
        road.levelMap = new LevelMap(rootRoad);
        LevelNode roadOp1 = new LevelNode("approach taxidriver","As you kept walking, you found a taxi that seemed to have person inside. You knocked on the door to have a conversation with middle-aged woman inside. She rolled down the taxi window and asked what you were doing on the road, not being in a safe place and you explained her your situation. She said she could drive you to the place where you had to go. ",null);
        LevelNode roadOp2 = new LevelNode("remove the debris","However, the road was blocked so she needed your help to clean beforehand. With her, you managed to organise blocked road and safely go to the next destination. ",null);
        road.levelMap.setAdjacent(rootRoad,new ArrayList<>(Arrays.asList(roadOp1)));
        road.levelMap.setAdjacent(rootRoad,new ArrayList<>(Arrays.asList(roadOp2)));
        LevelNode roadOp3 = new LevelNode(null,"Thanks to her, you could go to the next destination safely and quickly.",new ArrayList<>(Arrays.asList("heal 10")));//distance?
        road.levelMap.setAdjacent(roadOp2,new ArrayList<>(Arrays.asList(roadOp3)));

        //sucessfully completed level
        road.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(roadOp3)));
        //player dies
//        road.levelMap.setDeathNodes(new ArrayList<>(Arrays.asList()));//TODO

        //lab
        LevelNode rootLab = new LevelNode(null,"Done.", null);//lab.isVisited()
        lab.levelMap = new LevelMap(rootLab);
        // set lab as completion node
        lab.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(rootLab)));

        GameMapJSON.serializeJSON(map);
    }

    public static void serializeJSON(GameMap gameMap) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("GameMapDB.json")) {
            JsonElement tree = gson.toJsonTree(gameMap);
            gson.toJson(tree, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameMap deserializeJSON() {
        GameMap data = null;
        Gson gson = new Gson();
        JsonReader jsonReader = null;
        final Type objectType = new TypeToken<GameMap>(){}.getType();
        try {
            jsonReader = new JsonReader(new FileReader("GameMapDB.json"));
            data = gson.fromJson(jsonReader, objectType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }
}
