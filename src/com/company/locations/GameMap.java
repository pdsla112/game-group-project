package com.company.locations;

import com.company.locations.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameMap {

    public class Edge {
        Location source;
        Location destination;
        int distance;
        public Edge(Location from, Location to, int distance) {
            this.source = from;
            this.destination = to;
            this.distance = distance;
        }
    }

    Map<String, Location> locations;

    ArrayList<Edge> edges;
    Location finalLocation = null;

    public GameMap() {
        locations = new HashMap<>();
        edges = new ArrayList<>();
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

    public void setFinalLocation(Location finalLocation) {
        this.finalLocation = finalLocation;
    }

    public void addLocation(Location loc) {
        locations.put(loc.name, loc);
    }

    public void addEdge(Location from, Location to, int distance) {
        edges.add(new Edge(from, to, distance));
    }

    public ArrayList<Location> getAdjacent(Location location) {
        ArrayList<Location> adjacent = new ArrayList<>();
        for (Edge e : edges) {
            if (e.source == location) {
                adjacent.add(e.destination);
            }
        }
        return adjacent;
    }

    public int getDistance(Location from, Location to) {
        for (Edge e : edges) {
            if (e.source == from && e.destination == to) {
                return e.distance;
            }
        }
        return -1;
    }


}
