package com.company.data;

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

public class LevelJSON {
    public static void serializeJSON(ArrayList<Level> objectList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("LevelDB.json")) {
            JsonElement tree = gson.toJsonTree(objectList);
            gson.toJson(tree, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Level> deserializeJSON() {
        ArrayList<Level> objectList = new ArrayList<>();
        Gson gson = new Gson();
        JsonReader jsonReader = null;
        final Type objectType = new TypeToken<ArrayList<Level>>(){}.getType();
        try {
            jsonReader = new JsonReader(new FileReader("LevelDB.json"));
            objectList = gson.fromJson(jsonReader, objectType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return objectList;
    }

    public static Level getSpecificLevel(int wantedLevel) {
        ArrayList<Level> objectList = deserializeJSON();
        for (Level level : objectList) {
            if (level.getLevel() == wantedLevel)
                return level;
        }
        return null;
    }
}
