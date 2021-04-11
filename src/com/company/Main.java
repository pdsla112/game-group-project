package com.company;

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




	// write your code here
    }
}
