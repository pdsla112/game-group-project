package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Start extends Location{
    public Start(boolean visited) {
        super(visited);
    }

    @Override
    public void runStory(Player player, GameMap map, String filename) {
        Scanner in = new Scanner(System.in);
        // load from text file
        System.out.println("At the end of 2021, COVID-19 vaccines were being supplied smoothly and borders were loosened one by one, showing signs of recovery.");
        System.out.println("Name?");
        player.name = in.nextLine();
        System.out.println("where do you want to go?");
        ArrayList<Location> choices = map.getAdjacent(this);
        for (int i = 0; i < choices.size(); i++) {
            System.out.println("[" + i + "]" + choices.get(i).name);
        }
        System.out.println("choose 0,1,2");
        //print out choices
        int choice = in.nextInt();
        if (choice == 1) {
            map.setCurrentLocation(map.getAdjacent(this).get(1));
        }

    }
}
