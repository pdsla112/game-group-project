package com.company.locations;

import com.company.characters.Player;
import com.company.locations.Location;

import java.util.Scanner;

public class Start extends Location {
    public Start(boolean visited) {
        super(visited);
    }

    @Override
    public void runStory(Player player) {
        Scanner in = new Scanner(System.in);
        // load from text file
        System.out.println("At the end of 2021, COVID-19 vaccines were being supplied smoothly and borders were loosened one by one, showing signs of recovery.");
        System.out.println("Name?");
        //player.name = in.nextLine();

    }
}
