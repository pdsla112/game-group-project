package com.company.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class InitializeJSON {
    public static void main(String[] args) {
        ArrayList<Initialization> objectList = new ArrayList<>();
        Initialization object1 = new Initialization(
                "At the end of 2021, COVID-19 vaccines" +
                        " were being supplied smoothly and borders" +
                        " were loosened one by one, showing signs of recovery.\n"
        );

        Initialization object2 = new Initialization(
                "However, things started to change ever" +
                        " since a shocking article from New York Times" +
                        " was published in early 2022. The article stated" +
                        " that some of the Covid-19 patients started to" +
                        " show strange symptoms throughout states.\n"
        );

        Initialization object3 = new Initialization(
                "These were not only happening in U.S.," +
                        " but other countries as well. The researchers" +
                        " from laboratories across the world announced " +
                        "that the SARS-CoV-2 has been mutated, " +
                        "causing new symptoms.\n"
        );

        Initialization object4 = new Initialization(
                "Towards November in 2022, the number of mutated" +
                        " Covid patients drastically increased and more research" +
                        " were done. People infected with this new type of virus" +
                        " -people started to call it Covid-Z - suffered three" +
                        " consecutive fevers that came randomly.\n"
        );

        Initialization object5 = new Initialization(
                "About half of Covid-Z patients, after recovering" +
                        " from the third fever, acted like zombies. They were" +
                        " still alive unlike typical zombies. In other words," +
                        " patients still had heart beating, with no vital signs."
        );

        Initialization object6 = new Initialization(
                "The common symptoms known for Covid-Z were decaying" +
                        " bodies and slow movements. Covid-Z patients recognised" +
                        " living humans as prey, lacking rationality, intellect " +
                        "and social information processing."
        );

        Initialization object7 = new Initialization(
                "The world became chaotic and all borders started to close." +
                        " Fortunately, people with high level of immunity towards Covid-Z" +
                        " voluntarily became members of the Virus Centre and soon," +
                        " vaccines for Covid-Z were invented."
        );

        Initialization object8 = new Initialization(
                "Yet, due to the zombies who were roaming the city streets," +
                        " there were difficulties in the supply of vaccine and some" +
                        " people had to directly go to the laboratory in the Virus Centre" +
                        " and collect the vaccine."
        );

        Initialization object9 = new Initialization(
               "You are one of the people who decided to face the danger and" +
                       " go to the Laboratory for your family and neighbours."
        );

        objectList.add(object1);
        objectList.add(object2);
        objectList.add(object3);
        objectList.add(object4);
        objectList.add(object5);
        objectList.add(object6);
        objectList.add(object7);
        objectList.add(object8);
        objectList.add(object9);

        serializeJSON(objectList);


        /**
         * Example of how to use the deserializeJSON method...
         */
        ArrayList<Initialization> result = InitializeJSON.deserializeJSON();
        System.out.println(result.get(0).getText());
    }

    public static void serializeJSON(ArrayList<Initialization> objectList) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("InitializationDB.json")) {
            JsonElement tree = gson.toJsonTree(objectList);
            gson.toJson(tree, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Initialization> deserializeJSON() {
        ArrayList<Initialization> list = new ArrayList<>();
        Gson gson = new Gson();
        JsonReader jsonReader = null;
        final Type CUS_LIST_TYPE = new TypeToken<ArrayList<Initialization>>() {}.getType();
        try {
            jsonReader = new JsonReader(new FileReader("InitializationDB.json"));
            ArrayList<Initialization> data = gson.fromJson(jsonReader, CUS_LIST_TYPE);
            for (Initialization init : data) {
                list.add(init);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
}
