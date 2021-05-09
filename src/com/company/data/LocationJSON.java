package com.company.data;

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
import java.util.List;

public class LocationJSON {
    public static void main(String[] args) {
        ArrayList<LocationData> objectList = new ArrayList<>();

        PsychoData psychoData1 = new PsychoData(
                "On the third floor, you found someone walking towards you. " +
                        "He looks friendly with slightly chubby face, " +
                        "hooded chocolate-brown eyes, round nose and a big smile" +
                        " made by his heart-shaped lips. He realised you coming towards" +
                        " him as well, and he seems to want a conversation with you.",
                "He was holding a scalpel you couldn't see from the distance." +
                        " He ran towards you so that you failed to escape and got a cut." +
                        " You realised that you are not able to run away, so decided to fight back.",
                "You thought that it is weird to have person in the middle of the hospital hallway," +
                        " so you ignored him and went up the staircase quickly so he wouldn't follow you."
        );

        GoodCharacterData goodCharacterData1 = new GoodCharacterData(
                "doctor",
                "You walked further upstairs and while you walk around fifth floor," +
                        " you found someone resting in the bed between the curtains in the hospital room. " +
                        "The person is laying on the bed, but it seems like they are still awake." +
                        " You could see the long blonde hair sticking out, " +
                        "and she was tossing and turning under the duvet.",
                "You decided to talk to her, and after a short conversation," +
                        " you found out that she was a doctor." +
                        " You showed her the wounds you had on the way to hospital," +
                        " asking if she could give you some kind of treatment." +
                        " Fortunately, she gladly helps you.",
                "Feeling suspicious, you decided to pass by as if you had seen nothing."
        );

        ItemData itemData1 = new ItemData(
                "first-aid kit",
                "You found the first aid kit near the staircase."
        );

        LocationData object1 = new LocationData(
                "hospital",
                "You are now in the hospital. Not wanting to risk yourself" +
                        " taking the lift in a hospital where the electricity" +
                        " supply seemed to be poor, you decided to go by staircase.",
                psychoData1,
                goodCharacterData1,
                itemData1,
                null
        );


        PsychoData psychoData2 = new PsychoData(
                "Inside the cottage, you see the silhouette of a child laying" +
                        " on the cozy sofa in the small living room. She was dozing off," +
                        " probably because it was warm inside.",
                "You gently wake the child. Actually, she was pretending to be" +
                        " asleep and had a kitchen knife in her hand, hidden behind her." +
                        " You didn't want to hurt the child, but at the same time, you couldn't" +
                        " die. You fight to defend yourself. ",
                "You didn't want to wake her up since your initial plan was to take a break" +
                        " for a while, and as she seemed to be comfortable. You carefully tip-toe" +
                        " past her and continue on with your business."
        );

        GoodCharacterData goodCharacterData2 = new GoodCharacterData(
                "hunter",
                "After looking around the cottage, you then go into the storage" +
                        " room and there was a muscular man who looked to be in his mid-30’s." +
                        " He doesn't seem to have noticed you yet.",
                "You tap him on the shoulder and ask what he is doing." +
                        " He turns out to be a hunter, and this is his cottage. " +
                        "He sees you pitifully, and gives you one of the games that" +
                        " he had hunted a couple hours ago.",
                "Seeing the size of the man, you realise there is no" +
                        " way to win him if you got into a fight. Hence, you quietly close the door."
        );

        ItemData itemData2 = new ItemData(
                "hunting kit",
                "You carefully head into the bathroom. " +
                        "Trying to find something useful, you open the " +
                        "cabinet to find a hunting kit."
        );

        LocationData object2 = new LocationData(
                "cottage",
                "You found a country-style cottage. Maybe you can steal some food?" +
                        " After all, you are very hungry and wanted to stock up more food and supplies.",
                psychoData2,
                goodCharacterData2,
                itemData2,
                null
        );


        GoodCharacterData goodCharacterData3 = new GoodCharacterData(
                "taxi driver",
                "You hear muffling from your right. " +
                        "You turn your head to see that the sound is coming from" +
                        " a woman in a taxi. She looks like a human, so you walk towards" +
                        " the taxi. A middle-aged woman rolls the taxi window down. " +
                        "She scans your appearance up and down. " +
                        "She says you can get a short ride on the way to her children.",
                "However, the road in front of the taxi is blocked with debris." +
                        " She asks if you can help her remove this debris so that she can drive on the road.",
                "Thankfully, she gives you a ride. Your health will temporarily not go down."
        );

        ZombieData zombieData3 = new ZombieData(
                "You hear crackling sound coming from your left. " +
                        "You turn your head and see a bloody scene of zombies chewing" +
                        " on the limbs of freshly-dead humans. You are feeling short of breath " +
                        "and your palms get sweaty.",
                "Some of the zombies notice you and approach you.",
                "You immediately crouch and quietly leave the scene."
        );

        LocationData object3 = new LocationData(
                "road",
                "You continue on your journey to the laboratory, and you end up on a concrete road.",
                null,
                goodCharacterData3,
                null,
                zombieData3
        );


        PsychoData psychoData4 = new PsychoData(
                "Walking through the damp, dark soil, you realise that there is an" +
                        " old man between the trees. He hasn't seen you yet.",
                "Wondering why he was in the middle of this forest, " +
                        "you approach him and try to start a conversation. You didn't know " +
                        "because he wasn't looking in your direction, but he had dead, lifeless" +
                        " eyes with a stone in his hand. Even before you realise, he look back " +
                        "at you and throws the stone at your head.",
                "You quickly pass by, it’s usually better to keep to yourself during this apocalypse."
        );

        GoodCharacterData goodCharacterData4 = new GoodCharacterData(
                "animal",
                "When you heard a rustling sound between the trees, you were stiffened nervously," +
                        " but soon realised it was an animal that was making the sound. " +
                        "Standing behind a tree, you peep to see a very plump animal.",
                "Having been hungry for a long time, you decide to hunt.",
                "You decide to pass by as you are not confident enough to hunt it." +
                        " Oh well, can’t help that you’re a wimp."
        );

        ZombieData zombieData4 = new ZombieData(
                "In the middle of the forest, the zombie was finding its next prey with ears," +
                        " not eyes, perhaps because his eyeballs had rotted. " +
                        "Filthy, black liquid was flowing out of the zombies’ mouths. " +
                        "Your muscles become stiff, locking your limbs still, due to fear.",
                "You accidentally step some crunchy leaves, and" +
                        " the zombie immediately sense you. They hungrily approach you.",
                " You somehow manage to slowly and silently back-away and escape. What a miracle!"
        );

        LocationData object4 = new LocationData(
                "forest",
                "You notice that the more you walk, the more densely packed the trees stand. You are entering a forest.",
                psychoData4,
                goodCharacterData4,
                null,
                zombieData4
        );

        LocationData object5 = new LocationData(
                "lab",
                "This journey just never seems to end. You miss the warm embrace of your family" +
                        " and the smell of home. This journey has been unforgiving to you mentally" +
                        " and physically. You get flashbacks of your loved ones who had died before" +
                        " you in your arms. You wonder, “maybe it’s time for me to go too…”. But " +
                        "then, as you walk over a hill, you slowly see a pristine white building over the horizon." +
                        " It seems to be… it seems to be… Congratulations, you finally reached the laboratory!" +
                        " Thankfully, there are no zombies as there are many soldiers inside, so you are safe now." +
                        " You walk into the laboratory, and there are researchers who are ready to provide you with vaccines.",
                null,
                null,
                null,
                null
        );

        objectList.add(object1);
        objectList.add(object2);
        objectList.add(object3);
        objectList.add(object4);
        objectList.add(object5);

        serializeJSON(objectList);

        ArrayList<LocationData> result = deserializeJSON();
        System.out.println(result.size());
    }

    public static void serializeJSON(ArrayList<LocationData> objectList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("LocationDB.json")) {
            JsonElement tree = gson.toJsonTree(objectList);
            gson.toJson(tree, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<LocationData> deserializeJSON() {
        ArrayList<LocationData> data = new ArrayList<>();
        Gson gson = new Gson();
        JsonReader jsonReader = null;
        final Type listObjectType = new TypeToken<ArrayList<LocationData>>(){}.getType();
        try {
            jsonReader = new JsonReader(new FileReader("LocationDB.json"));
            data = gson.fromJson(jsonReader, listObjectType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static LocationData getSpecificLocationData(ArrayList<LocationData> deserializedList, String locationName) {
        for (LocationData data : deserializedList) {
            if (data.getLocation().equals(locationName))
                return data;
        }
        return null;
    }
}
