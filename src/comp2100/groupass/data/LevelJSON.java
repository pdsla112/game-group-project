package comp2100.groupass.data;

import comp2100.groupass.entities.Animal;
import comp2100.groupass.items.HuntingKit;
import comp2100.groupass.items.Meat;
import comp2100.groupass.items.Medkit;
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
    public static void main(String[] args) {
        ArrayList<Level> levelList = new ArrayList<>();

        Level easy = new Level(
                0,
                100,
                60,
                35,
                20,
                10,
                15,
                20,
                10,
                15,
                Animal.BISON,
                new HuntingKit(100, 100),
                new Medkit(50),
                new Meat(20),
                2,
                60,
                60
        );

        Level normal = new Level(
                1,
                100,
                60,
                35,
                40,
                20,
                25,
                30,
                20,
                30,
                Animal.DEER,
                new HuntingKit(100, 80),
                new Medkit(50),
                new Meat(15),
                5,
                70,
                70
        );

        Level hard = new Level(
                2,
                80,
                50,
                30,
                70,
                30,
                35,
                40,
                30,
                40,
                Animal.TROUT,
                new HuntingKit(80, 60),
                new Medkit(30),
                new Meat(10),
                10,
                100,
                100
        );

        Level expert = new Level(
                3,
                60,
                50,
                30,
                100,
                40,
                45,
                50,
                45,
                50,
                Animal.RABBIT,
                new HuntingKit(50, 50),
                new Medkit(20),
                new Meat(5),
                10,
                100,
                100
        );

        levelList.add(easy);
        levelList.add(normal);
        levelList.add(hard);
        levelList.add(expert);

        serializeJSON(levelList);
    }

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
