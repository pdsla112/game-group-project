package com.company.data;

import com.company.locations.GameMap;
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

public class GameMapJSON {
    public void serializeJSON(GameMap gameMap) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("GameMapDB.json")) {
            JsonElement tree = gson.toJsonTree(gameMap);
            gson.toJson(tree, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameMap deserializeJSON() {
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
