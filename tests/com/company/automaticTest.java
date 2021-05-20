package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonParseException;
import com.company.data.GameMapJSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import java.lang.reflect.Type;
import com.google.gson.stream.JsonReader;



class automaticTest {
    public void traverseObject(JsonObject obj) {

    }

    public  static void main(String[] args) {
        try {
        // JSONParser parser = new JSONParser();
        // Object obj = parser.parse(new FileReader("GameMapDB.json"));
        // JSONObject jsonObject = (JSONObject) obj;
        // System.out.println(jsonObject);
        //... JSONObject jsonOb =
        // JsonNode jsonNode = convertJsonFormat(jsonObj);
        // ObjectMapper mapper = new ObjectMapper();
        // MyPojoClass myPojo = mapper.readValue(new TreeTraversingParser(jsonNode), MyPojoClass.class);
            JsonReader jsonObject = new JsonReader(new FileReader("GameMapDB.json"));
            Type mapTokenType = new TypeToken<Map<String, Map>>(){}.getType();
            Map<String, String[]> jsonMap = new Gson().fromJson(jsonObject, mapTokenType);
            System.out.println(jsonMap);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}


