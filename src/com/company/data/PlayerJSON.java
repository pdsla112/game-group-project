package com.company.data;

import com.company.BloomFilter.BloomFilter;
import com.company.BloomFilter.BloomFilterJSON;
import com.company.characters.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
        BloomFilter bloomFilter = BloomFilterJSON.loadBloomFilter();
        boolean contains = bloomFilter.mightContain(name);
        if (!contains)
            return null;
        ArrayList<Player> deserializedList = deserializeJSON();
        for (Player data : deserializedList) {
            if (data.getName().equals(name)) {
                return data;
            }
        }
        return null;
    }

    public static Player createNewPlayer(String name, int level) {
        BloomFilter bloomFilter = BloomFilterJSON.loadBloomFilter();
        if (!bloomFilter.mightContain(name)) {
            return new Player(name, level, "home");
        }
        if (getSpecificPlayer(name) == null) {
            return new Player(name, level, "home");
        }
        return null;
    }

    //remove player from json
    public static void removePlayer(String name) {
        BloomFilter bloomFilter = BloomFilterJSON.loadBloomFilter();
        if (!bloomFilter.mightContain(name)) {
            return;
        } else {
            Player player = getSpecificPlayer(name);
            ArrayList<Player> playerList = remove(player.getName());
            serializeJSON(playerList);
        }
    }

    // Debug!
    public static void savePlayer(Player player) {
        removePlayer(player.getName());
        ArrayList<Player> playerList = new ArrayList<>();
        if (deserializeJSON() != null) {
            playerList = deserializeJSON();
        }
        playerList.add(player);
        BloomFilter bloomFilter = BloomFilterJSON.loadBloomFilter();
        bloomFilter.add(player.getName());
        BloomFilterJSON.saveBloomFilter(bloomFilter);
        serializeJSON(playerList);
    }

    public static boolean hasPlayer(){
        ArrayList<Player> playerList = deserializeJSON();
        return !playerList.isEmpty();
    }

    public static ArrayList<Player> remove(String name) {
        ArrayList<Player> playerList = deserializeJSON();
        for (Player player : playerList) {
            if (player.getName().equals(name)) {
                playerList.remove(player);
                break;
            }
        }
        return playerList;
    }
}
