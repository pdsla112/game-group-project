package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GameMap map = new GameMap();

        //setup map
        Location start = new Start(false);
        map.addLocation(start);
        Location hospital = new Hospital(false);
        map.addLocation(hospital);
        Location cottage = new Cottage(false);
        map.addLocation(cottage);
        Location forest = new Forest(false);
        map.addLocation(forest);
        Location lab = new Laboratory(false);
        map.addLocation(lab);
        Location road = new Road(false);
        map.addLocation(road);

        map.addEdge(start, cottage, 5);
        map.addEdge(start, forest, 9);
        map.addEdge(cottage, hospital, 6);
        map.addEdge(cottage, forest, 4);
        map.addEdge(forest, hospital, 7);
        map.addEdge(forest, road, 6);
        map.addEdge(hospital, road, 10);
        map.addEdge(road, lab, 4);

        map.setCurrentLocation(start);
        
        // setup story
        Player player = new Player(1,1,false);


        // house
        

        boolean end = false;
        Scanner in = new Scanner(System.in);
        while (end == false) {
            String input = in.nextLine();
            if (input.equals("quit")) {
                end = true;
            } else {
                map.currentLocation.runStory(player, map, "textfile.txt");
            }
        }





	// write your code here
    }
}
