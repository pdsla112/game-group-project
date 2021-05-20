package com.company.locations;

import com.company.locations.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMap {

    Map<String, Location> locations;

    Map<String, List<String>> edges;
    Location finalLocation = null;
    Location currentLocation = null;

    public GameMap() {
        locations = new HashMap<>();
        edges = new HashMap<>();
    }

    /**
     * return location names
     * @return
     */
    public List<String> getLocationNames() {
        return new ArrayList<>(locations.keySet());
    }

    public Location getLocationFromName(String name) {
        if (locations.containsKey(name)) {
            return locations.get(name);
        }
        return null;
    }
    public Location getFinalLocation() {
        return finalLocation;
    }

//    public Location getCurrentLocation(){
//        return currentLocation;
//    }
//
//    public void setCurrentlocation(Location currentLocation){
//        this.currentLocation = currentLocation;
//    }

    public void setFinalLocation(Location finalLocation) {
        this.finalLocation = finalLocation;
    }

    public void addLocation(Location loc) {
        locations.put(loc.name, loc);
    }

    public void addEdge(Location from, Location to, int distance) {
        if (!edges.containsKey(from.name)) {
            edges.put(from.name, new ArrayList<>());
        }
        List<String> updateEdges = edges.get(from.name);
        updateEdges.add(to.name);
        edges.put(from.name, updateEdges);
    }

    public List<Location> getAdjacent(Location location) {
        List<String> adjacent = edges.get(location.name);
        List<Location> adjacentLocations = new ArrayList<>();
        for (String name : adjacent) {
            adjacentLocations.add(locations.get(name));
        }
        return adjacentLocations;
    }

}
