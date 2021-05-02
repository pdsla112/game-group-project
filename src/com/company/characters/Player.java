package com.company.characters;

import com.company.locations.Location;
import com.company.repository.ItemRepo;
import com.company.items.Item;


import java.util.List;

public class Player extends Character{

    protected static ItemRepo itemRepo = new ItemRepo();
    //protected static LocationRepo locationRepo = new LocationRepo();
    private Location location;
    //private boolean deathValue;  // True => Player is dead.  False => Player is alive.
    public Player() {
        //temporary (load from json)
        setIntro("At the end of 2021, COVID-19 vaccines were being supplied smoothly and borders were loosened one by one, showing signs of recovery.\n\n" +
                "However, things started to change ever since a shocking article from New York Times was published in early 2022.\nThe article stated that some of the Covid-19 patients started to show strange symptoms throughout states.\n" +
                "These were not only happening in U.S., but other countries as well.\n\nThe researchers from laboratories across the world announced that the SARS-CoV-2 has been mutated, causing new symptoms.\n" +
                "Towards November in 2022, the number of mutated Covid patients drastically increased and more research were done.\n\nPeople infected with this new type of virus -people started to call it Covid-Z - suffered three consecutive fevers that came randomly.\n" +
                "About half of Covid-Z patients, after recovering from the third fever, acted like zombies.\nThey were still alive unlike typical zombies.\nIn other words, patients still had heart beating, with no vital signs.\n" +
                "\nThe common symptoms known for Covid-Z were decaying bodies and slow movements.\nCovid-Z patients recognised living humans as prey, lacking rationality, intellect and social information processing.\n" +
                "The world became chaotic and all borders started to close.\n\nFortunately, people with high level of immunity towards Covid-Z voluntarily became members of the Virus Centre and soon, vaccines for Covid-Z were invented.\n" +
                "Yet, due to the zombies who were roaming the city streets, there were difficulties in the supply of vaccine and some people had to directly go to the laboratory in the Virus Centre and collect the vaccine.\n");//intro
    }

    protected static String getProfileFileName(String name) {
        //todo
        return null;
    }
    public static boolean profileExists(String name) {
        //todo
        return false;

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static Player load(String fileName) {
        return null;
    }

    public void getStats(){
        //todo
        //print out stats e.g. attack, hp
    }

    public void save() {
        // todo
    }

    public List<Item> searchItem(String itemName, List<Item> itemList) {
        //todo
        return null;
    }

    public void pickUpItem(String itemName) {
        //todo
    }

    public void dropItem(String itemName) {
        //todo
    }

    public void inspectItem(String itemName) {
        //todo
    }

    public boolean hasItem(Item item) {
        //todo
        return false;
    }



//    public void attack(String opponentName) throws DeathException {
//
//    }


}
