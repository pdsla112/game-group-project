package com.company.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LocationJSON {
    public static void main(String[] args) {
        ArrayList<LocationData> objectList = new ArrayList<>();
    }

    public static void serializeJSON(ArrayList<LocationData> objectList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("LocationDB.json")) {
            gson.toJson(objectList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
