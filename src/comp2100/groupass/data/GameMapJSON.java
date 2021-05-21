package comp2100.groupass.data;

import comp2100.groupass.locations.LevelMap;
import comp2100.groupass.locations.LevelNode;
import comp2100.groupass.locations.GameMap;
import comp2100.groupass.locations.Location;
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
        map.setFinalLocation("lab");
        Location road = new Location("road", LocationJSON.getSpecificLocationData("road").getInitialText());
        map.addLocation(road);
        Location home = new Location("home",LocationJSON.getSpecificLocationData("home").getInitialText());
        map.addLocation(home);

        map.addEdge(home,cottage);
        map.addEdge(home,forest);
        map.addEdge(cottage, hospital);
        map.addEdge(cottage, forest);
        map.addEdge(forest, hospital);
        map.addEdge(forest, road);
        map.addEdge(hospital, road);
        map.addEdge(road, lab);


        LevelNode rootHome = new LevelNode(null,"You are at home, wondering where you should go.\nChoose a place to go.", null);//home.isVisited()
        home.levelMap = new LevelMap(rootHome);

        // set home as completion node
        home.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(rootHome)));


        //cottage
        LevelNode rootCottage = new LevelNode(null,"You head inside the cottage and see a few rooms down the hallway.", null);
        cottage.levelMap = new LevelMap(rootCottage);

        LevelNode cottageOp5 = new LevelNode("head to the bedroom","\nYou enter the bedroom and take a look around. There is a tiny drawer next to a large bed. There appears to be a trapdoor in the floor.\nType h to see more options available.",new ArrayList<>(Arrays.asList("locationObject bed under medkit")));
        LevelNode cottageOp6 = new LevelNode("explore the living room","\nYou enter the living room and catch a glimpse of a young girl dozing off on the sofa in the small living room.\nYou see a something under the table in front of her.",new ArrayList<>(Arrays.asList("locationObject table under medkit")));

        cottage.levelMap.setAdjacent(rootCottage,new ArrayList<>(Arrays.asList(cottageOp6,cottageOp5)));

        //living room
        LevelNode cottageOp4 = new LevelNode("sneak past her","\nYou don't want to wake her up since she looks so comfortable lying there. \nYou sneak towards bathroom and carefully close the door. There is a cabinet above the sink.",new ArrayList<>(Arrays.asList("locationObject cabinet inside medkit")));
        LevelNode cottageOp3 = new LevelNode("wake her up","\nYou approach the child and take a closer look. She appears to be younger than 10 years old.\nYou gently shake the child to wake her up.\nTo your horror, she suddenly awakens and pulls out a concealed knife from behind her and tries to stab you.",new ArrayList<>(Arrays.asList("psychoFight")));
        LevelNode cottageOp2 = new LevelNode("leave the room","\nYou exit the room and go back to the hallway. There is a rooms you haven't explored yet.", null);

        cottage.levelMap.setAdjacent(cottageOp6,new ArrayList<>(Arrays.asList(cottageOp3,cottageOp4, cottageOp2)));
        cottage.levelMap.setAdjacent(cottageOp2,new ArrayList<>(Arrays.asList(cottageOp5)));
        cottage.levelMap.setAdjacent(cottageOp4,new ArrayList<>(Arrays.asList(cottageOp5)));
        cottage.levelMap.setAdjacent(cottageOp3,new ArrayList<>(Arrays.asList(cottageOp5)));

        LevelNode cottageOp7 = new LevelNode("open the trap door","\nYou open the trap door and go down into the basement.\nUnfortunately there is something waiting for you at the bottom.",  Arrays.asList("zombieFight"));
        LevelNode cottageOp8 = new LevelNode("leave the room","\nYou are about to turn around to leave when you hear a loud noise outside. \nSomething is coming after you. You decide to open the trapdoor and go down into the basement.\nThe room is pitch black, so you turn on the lights.\nUnfortunately there is something waiting for you at the bottom.", Arrays.asList("zombieFight"));

        cottage.levelMap.setAdjacent(cottageOp5,new ArrayList<>(Arrays.asList(cottageOp7,cottageOp8)));

        LevelNode cottageOp9 = new LevelNode("open the closet","\nYou hear a feint noise coming closet and decide to open it.\nTo your suprise, there is a frightened man huddled inside.\n'I thought I was dead. Thank you so much for saving me.' he tells you.\nThe man gives you a medkit as a reward", Arrays.asList("item medkit"));

        cottage.levelMap.setAdjacent(cottageOp7,new ArrayList<>(Arrays.asList(cottageOp9)));
        cottage.levelMap.setAdjacent(cottageOp8,new ArrayList<>(Arrays.asList(cottageOp9)));

        LevelNode cottageOp11 = new LevelNode("leave the cottage","\nYou decide to leave the cottage and head somewhere else.",null);

        cottage.levelMap.setAdjacent(cottageOp9,new ArrayList<>(Arrays.asList(cottageOp11)));

        cottage.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(cottageOp11)));

        //forest
        LevelNode rootForest =  new LevelNode(null,"Now, you are in the forest.\nYou suddenly hear the rustling sound between the trees. Stiffened nervously, you are wondering what there is.", null);
        forest.levelMap = new LevelMap(rootForest);
        LevelNode forestOp1 = new LevelNode("Have closer look","\nAfter having a closer look, you soon realise it was an animal that was making the sound.\nGoing closer, you carefully looked through trees and soon noticed the animal.", null);
        LevelNode forestOp2 = new LevelNode("Ignore","\nFeeling suspicious, you walked to the other way.",null);
        forest.levelMap.setAdjacent(rootForest,new ArrayList<>(Arrays.asList(forestOp1,forestOp2)));
        LevelNode forestOp3 = new LevelNode("Hunt","\nHaving been hungry, you decided to hunt after confirming that you didn't have enough food.",Arrays.asList("hunt"));
        LevelNode forestOp4 = new LevelNode("Ignore","You decided to pass by the animal, looking around what else there are.",null);
        forest.levelMap.setAdjacent(forestOp1,new ArrayList<>(Arrays.asList(forestOp3,forestOp4)));
        LevelNode forestOp5 = new LevelNode("Go further inside the forest","\nWalking through the damp, dark road, you realised that there was the old man between the trees.\nHe hasn't seen your side yet.",null);
        forest.levelMap.setAdjacent(forestOp2,new ArrayList<>(Arrays.asList(forestOp5)));
        forest.levelMap.setAdjacent(forestOp3,new ArrayList<>(Arrays.asList(forestOp5)));
        LevelNode forestOp6 = new LevelNode("Ignore","\nYou quickly passed by, knowing that it is abnormal to have a person in the middle of this forest after zombie outbreak.",null);
        forest.levelMap.setAdjacent(forestOp4,new ArrayList<>(Arrays.asList(forestOp6)));
        LevelNode forestOp7 = new LevelNode("Approach","\nWondering why he was in the middle of this forest, you approached him with curiosity and tried to talk to him.\nYou didn't know because he wasn't looking in your direction, but he had dead, lifeless looking eyes with stones in his hands.\nEven before you realise, he looked back at you and started to throw stones towards you.",null);
        forest.levelMap.setAdjacent(forestOp5,new ArrayList<>(Arrays.asList(forestOp6,forestOp7)));
        LevelNode forestOp8 = new LevelNode("Look around the forest","\nIn the middle of the forest, the zombie was finding for the next prey with ears, not eyes perhaps because his eyeballs had rotted.\nFrom zombie's mouth, a liquid suitable to express as filth rather than saliva was falling slowly.\nYour muscles became stiff and bones and joints hardened as if your limbs were bound due to fear.\nUnfortunately, zombie noticed you.",null);
        forest.levelMap.setAdjacent(forestOp6,new ArrayList<>(Arrays.asList(forestOp8)));
        LevelNode forestOp9 = new LevelNode("Fight against him","\nIn the middle of the forest, the zombie was finding for the next prey with ears, not eyes perhaps because his eyeballs had rotted.\nFrom zombie's mouth, a liquid suitable to express as filth rather than saliva was falling slowly.\nYour muscles became stiff and bones and joints hardened as if your limbs were bound due to fear.\nUnfortunately, zombie noticed you.",Arrays.asList("psychoFight"));
        forest.levelMap.setAdjacent(forestOp7,new ArrayList<>(Arrays.asList(forestOp9)));
        LevelNode forestOp10 = new LevelNode("Fight back zombie","\nChoose the next location to go.",Arrays.asList("zombieFight"));
        forest.levelMap.setAdjacent(forestOp8,new ArrayList<>(Arrays.asList(forestOp10)));
        forest.levelMap.setAdjacent(forestOp9,new ArrayList<>(Arrays.asList(forestOp10)));

        forest.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(forestOp10)));


        //hospital
        LevelNode rootHospital = new LevelNode(null,"You walked upstairs and while you walk around, you found someone resting in the bed between the curtains in the hospital room.",null);
        hospital.levelMap = new LevelMap(rootHospital);
        LevelNode hospitalOp1 = new LevelNode("Check closer","\nThe person is lying on the bed, but still awake.\nYou could see the long blonde sticking out, and she was tossing and turning under the duvet.",null);
        LevelNode hospitalOp2 = new LevelNode("Ignore","\nFeeling suspicious, you decided to pass by as if you had seen nothing.",null);
        hospital.levelMap.setAdjacent(rootHospital,new ArrayList<>(Arrays.asList(hospitalOp1,hospitalOp2)));
        LevelNode hospitalOp3 = new LevelNode("Talk to her.","\nYou decided to talk to her, and after a short conversation, you found out that she was a doctor.\nYou showed her the wounds you had on the way to hospital, asking if she could give you some kind of treatment.\nFortunately, she gladly helped me.\n\nYou thanked her then explained that you were on the way to get a vaccine, and suggested her to accompany me.\nShe accepted without hesitation, and we went out of the hospital together.",Arrays.asList("heal 10"));
        LevelNode hospitalOp4 = new LevelNode("Ignore","\nFeeling suspicious, you decided to pass by as if you had seen nothing.",null);
        hospital.levelMap.setAdjacent(hospitalOp1,new ArrayList<>(Arrays.asList(hospitalOp3,hospitalOp4)));
        LevelNode hospitalOp5 = new LevelNode("Walk upstairs","\nYou walked further upstairs and while you are at fourth floor.",null);
        hospital.levelMap.setAdjacent(hospitalOp2,new ArrayList<>(Arrays.asList(hospitalOp5)));
        hospital.levelMap.setAdjacent(hospitalOp3,new ArrayList<>(Arrays.asList(hospitalOp5)));
        hospital.levelMap.setAdjacent(hospitalOp4,new ArrayList<>(Arrays.asList(hospitalOp5)));
        LevelNode hospitalOp6 = new LevelNode("Find for something useful.","\nType help in order to check available additional commands.",Arrays.asList("locationObject table under medkit"));
        hospital.levelMap.setAdjacent(hospitalOp5,new ArrayList<>(Arrays.asList(hospitalOp6)));
        LevelNode hospitalOp7 = new LevelNode("Walk downstairs","\nAt third floor, you found someone walking towards you.\n\nHe looks friendly with slightly chubby face, hooded chocolate-brown eyes, round nose and a big smile made by his heart-shaped lips.\nHe realised you coming towards him as well, and he seems to want a conversation with you.",null);
        hospital.levelMap.setAdjacent(hospitalOp6,new ArrayList<>(Arrays.asList(hospitalOp7)));
        LevelNode hospitalOp8 = new LevelNode("Go and talk with him.","\nHe was holding a scapel you couldn't see from the distance.\nHe ran towards you so that you failed to escape and got a cut.\n\nYou realised that you are not able to run away, so decided to fight back.",null);
        LevelNode hospitalOp9 = new LevelNode("Ignore","\nYou thought that it is weird to have person in the middle of the hospital hallway, so you ignored him and went towards ground floor quickly so he wouldn't follow you.",null);
        hospital.levelMap.setAdjacent(hospitalOp7,new ArrayList<>(Arrays.asList(hospitalOp8,hospitalOp9)));
        LevelNode hospitalOp10 = new LevelNode("Fight back","Choose the next location to go.",Arrays.asList("psychoFight"));
        hospital.levelMap.setAdjacent(hospitalOp8,new ArrayList<>(Arrays.asList(hospitalOp10)));
        LevelNode hospitalOp11 = new LevelNode("Get out of the hospital","Choose the next location to go.",null);
        hospital.levelMap.setAdjacent(hospitalOp9,new ArrayList<>(Arrays.asList(hospitalOp11)));

        hospital.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(hospitalOp10,hospitalOp11)));

        //road
        LevelNode rootRoad = new LevelNode(null,"You heard the crackling sound coming from chewing pieces of meat and bones. You are feeling short of breath and barely swallowing saliva.\nPanic-stricken for a moment, you unconsciously dropped onto the floor and your palms touched the rough ground full of dust, but could not even realise it.\nYou saw the zombie attacking someone, so you stepped back into the bush falteringly.",null);
        road.levelMap = new LevelMap(rootRoad);
        LevelNode roadOp1 = new LevelNode("Fight Zombie","\nZombie noticed you, and you need to fight back in order to survive.",Arrays.asList("zombieFight"));
        road.levelMap.setAdjacent(rootRoad,new ArrayList<>(Arrays.asList(roadOp1)));
        LevelNode roadOp2 = new LevelNode("Walk further towards the lab","\nAs you continue to walk, you found a taxi with a silhouette that looks like a person.",null);
        road.levelMap.setAdjacent(roadOp1,new ArrayList<>(Arrays.asList(roadOp2)));
        LevelNode roadOp4 = new LevelNode("Ignore","\nThere is no guarantee that the person in the taxi will be safe, let's continue to walk towards the lab.\n\nChoose the next location to go.",null);
        LevelNode roadOp5 = new LevelNode("Approach and have a closer look inside taxi","\nLooking closer, there is a middle-aged woman inside.",null);
        road.levelMap.setAdjacent(roadOp2,new ArrayList<>(Arrays.asList(roadOp4,roadOp5)));
        LevelNode roadOp6 = new LevelNode("Talk to her","\nYou knocked on the door to have a conversation with her.\nShe opened the taxi window and asked what you were doing on the road, not being in a safe place and you explained her your situation.\nShe said she could drive you to the place where you had to go.",null);
        LevelNode roadOp7 = new LevelNode("Walk away","\nIt's quite fishy having person in taxi alone in the middle of the nowhere.\nYou walk towards the other side quickly.\n\nChoose the next location to go.",null);
        road.levelMap.setAdjacent(roadOp5,new ArrayList<>(Arrays.asList(roadOp6,roadOp7)));
        LevelNode roadOp8 = new LevelNode("Get help","\nHowever, the road was blocked so she needed your help to clean beforehand.",null);
        LevelNode roadOp9 = new LevelNode("I'm good, thank you","\nYou are grateful for the offer, but the fuel may not be enough to reach the lab.\nNot wanting to cause any trouble, you said you're fine.\n\nChoose the next location to go.",null);
        road.levelMap.setAdjacent(roadOp6,new ArrayList<>(Arrays.asList(roadOp8,roadOp9)));
        LevelNode roadOp3 = new LevelNode("Remove the debris","\nWith her, you managed to organise blocked road and safely go to the next destination.\n\nChoose the next location to go.",Arrays.asList("drive"));
        road.levelMap.setAdjacent(roadOp8,new ArrayList<>(Arrays.asList(roadOp3)));

        //sucessfully completed level
        road.levelMap.setCompletionNodes(new ArrayList<>(Arrays.asList(roadOp3,roadOp4,roadOp7,roadOp9)));

        //lab
        LevelNode rootLab = new LevelNode(null,"Congratultions for ending the journey safely and successfully!", null);//lab.isVisited()
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
