package com.company;

import java.util.ArrayList;
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
        Player player = new Player(100,1,false);


        // house
        

        boolean end = false;
        Scanner in = new Scanner(System.in);
        while (end == false) {
            String input = in.nextLine();
            if (input.equals("quit")) {
                end = true;
            } else {
                map.currentLocation.runStory(player);
                System.out.println("where do you want to go?");
                ArrayList<Location> choices = map.getAdjacent(map.currentLocation);
                for (int i = 0; i < choices.size(); i++) {
                    System.out.println("[" + i + "]" + choices.get(i).name);
                }
                //print out choices
                int choice = in.nextInt();
                map.setCurrentLocation(map.getAdjacent(map.currentLocation).get(choice));
            }
        }


        // Hospital template
        Node s1 = new Node(0,"You are now in the hospital. While walking in the hallway, you found the first aid kit near the staircase",null);
        Node s2 = new Node(0,"Not wanting to risk yourself taking the lift in a hospital where the electricity supply seemed to be poor, you decided to go by staircase. At third floor, you found someone walking towards you.","kill someone");
        Node s3 = new Node(1,": He looks friendly with slightly chubby face, hooded chocolate-brown eyes, round nose and a big smile made by his heart-shaped lips. ", "dont kill him");

        StoryGraph hospitalStory = new StoryGraph(s1);
        hospitalStory.addEdge(s1,s2);
        hospitalStory.addEdge(s1,s3);

        // convert hospital story to json





	// write your code here
    }
}
