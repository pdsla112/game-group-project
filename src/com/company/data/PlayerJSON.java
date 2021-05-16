package com.company.data;

import com.company.BloomFilter.BloomFilter;
import com.company.characters.Player;
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

public class PlayerJSON {
    public static void main(String[] args) {
        deserializeJSON();
    }
    public static void serializeJSON(ArrayList<Player> objectList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("PlayerDB.json")) {
//            JsonElement tree = gson.toJsonTree(objectList);
            gson.toJson(objectList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Player> deserializeJSON() {
        ArrayList<Player> data = new ArrayList<>();
        Gson gson = new Gson();
        JsonReader jsonReader = null;
        final Type listObjectType = new TypeToken<ArrayList<Player>>(){}.getType();
        try {
            jsonReader = new JsonReader(new FileReader("PlayerDB.json"));
            data = gson.fromJson(jsonReader, listObjectType);
//            System.out.println("here: " + gson.fromJson(jsonReader, listObjectType));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }


    public static Player getSpecificPlayer(String name) {
        boolean contains = BloomFilter.mightContain(name);
        if (!contains)
            return null;
        ArrayList<Player> deserializedList = deserializeJSON();
        for (Player data : deserializedList) {
            if (data.getName().equals(name))
                return data;
        }
        return null;
    }

    //returns new player if player is created (unique name)
    //return null if name already exists
    // make sure name is one word (no spaces)
    public static Player createNewPlayer(String name, int difficulty) {

    }

    //remove player from json
    public static void removePlayer(String name) {

    }

    // Debug!
    public static void savePlayer(Player player) {
//<<<<<<< HEAD
        System.out.println(player.getEmail());
        ArrayList<Player> deserializedList = new ArrayList<>();
        if (deserializeJSON() == null) {
            deserializedList.add(player);
            serializeJSON(deserializedList);
            return;
        }
        deserializedList = deserializeJSON();
        Player playerToReplace = getSpecificPlayer(player.getEmail());
        if (playerToReplace == null) {
//=======
        System.out.println(player.getName());
        ArrayList<Player> deserializedList = deserializeJSON();
        System.out.println(deserializedList.size());
        Player playerToReplace = getSpecificPlayer(player.getName());
        if (playerToReplace.equals(null)) {
//>>>>>>> 817465e7ed64df80314e71eb576d73cd452e74e8
            deserializedList.add(player);
        } else if (!playerToReplace.equals(null)) {
            deserializedList.remove(playerToReplace);
            deserializedList.add(player);
        }
        serializeJSON(deserializedList);
    }
}
