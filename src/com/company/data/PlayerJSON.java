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
    public static Player createNewPlayer(String name, int level) {
        if (!BloomFilter.mightContain(name)) {
            return new Player(name, level, "home");
        }
        if (getSpecificPlayer(name) == null) {
            return new Player(name, level, "home");
        }
        return null;
    }

    //remove player from json
    public static void removePlayer(String name) {
        if (!BloomFilter.mightContain(name))
            return;
        else {
            Player player = getSpecificPlayer(name);
            if (player == null)
                return;
            else {
                ArrayList<Player> playerList = deserializeJSON();
                playerList.remove(player);
                serializeJSON(playerList);
            }
        }
    }

    // Debug!
    public static void savePlayer(Player player) {
        removePlayer(player.getName());
        ArrayList<Player> playerList = deserializeJSON();
        playerList.add(player);
        serializeJSON(playerList);
    }
}
