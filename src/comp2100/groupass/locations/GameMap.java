package comp2100.groupass.locations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameMap {

    Map<String, Location> locations;

    Map<String, List<String>> edges;
    String finalLocation = null;

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

    public List<String> getAdjacent(String locName) {
        return edges.get(locName);
    }

    public Location getLocationFromName(String name) {
        if (locations.containsKey(name)) {
            return locations.get(name);
        }
        return null;
    }

    public boolean isFinalLocation(String locName) {
        return locName.equals(finalLocation);
    }
    public void setFinalLocation(String finalLocation) {
        this.finalLocation = finalLocation;
    }

    public void addLocation(Location loc) {
        locations.put(loc.name, loc);
    }

    public void addEdge(Location from, Location to) {
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
