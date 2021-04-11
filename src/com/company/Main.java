package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GameMap map = new GameMap();

        //setup map
        Location hospital = new Hospital(false);
        Location cottage = new Cottage(false);
        map.addLocation(hospital);
        map.addLocation(cottage);
        map.addEdge(hospital, cottage, 4);
        map.addEdge(cottage, hospital, 4);
        map.setCurrentLocation(hospital);

        boolean end = false;
        Scanner in = new Scanner(System.in);
        while (end == false) {
            String input = in.nextLine();
            if (input.equals("quit")) {
                end = true;
            } else {

            }
        }





	// write your code here
    }
}
