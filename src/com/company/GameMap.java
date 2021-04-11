package com.company;

import java.util.ArrayList;

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

    ArrayList<Location> locations;
    ArrayList<Edge> edges;
    Location currentLocation = null;

    public GameMap() {
        locations = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void setCurrentLocation(Location loc) {
        this.currentLocation = loc;
    }

    public void addLocation(Location loc) {
        locations.add(loc);
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
