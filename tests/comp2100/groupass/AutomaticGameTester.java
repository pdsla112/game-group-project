package comp2100.groupass;

import comp2100.groupass.data.GameMapJSON;
import comp2100.groupass.locations.GameMap;
import comp2100.groupass.locations.LevelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutomaticGameTester {



    public  static void main(String[] args) {

        String location = "cottage";

        GameMap map = GameMapJSON.deserializeJSON();

        Map<String, List<Integer>> levelLengthMap = new HashMap<>();

        List<String> locationNames = map.getLocationNames();
        for (String locName : locationNames) {
            List<Integer> numNodesTraversedList = getNumNodesTraversedList(map.getLocationFromName(locName).levelMap);
            levelLengthMap.put(locName, numNodesTraversedList);

            System.out.println("Location: " + locName);
            displayNodeTraversalStats(numNodesTraversedList);
        }

        System.out.println("All levels:");
        List<Integer> allNumNodesTraversedList = getAllNumNodesTraversedList(map, levelLengthMap);
        displayNodeTraversalStats(allNumNodesTraversedList);


    }

    public static void displayNodeTraversalStats(List<Integer> list) {
        int paths = list.size();
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i : list) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
            sum += i;
        }

        float avg = ((float) sum)/paths;
        System.out.println("Number of paths: " + paths);
        System.out.println("Average number of nodes traversed: " + avg);
        System.out.println("Max number of nodes traversed: " + max);
        System.out.println("Min number of nodes traversed: " + min);
        System.out.println("-------------------------------------\n");
    }

    public static List<Integer> getAllNumNodesTraversedList(GameMap gameMap, Map<String, List<Integer>> levelLengthMap) {
        List<Integer> allNumNodesTraversedList = new ArrayList<>();
        getAllNumNodesTraversedListHelper(gameMap, levelLengthMap, "home", 1, allNumNodesTraversedList);
        return allNumNodesTraversedList;

    }


    /**
     * assumes final and initial locations have only 1 node
     * assumes adjacent is not null if not final location
     * @param gameMap
     * @param levelLengthMap
     * @param loc
     * @param nodesTraversed
     * @param allNumNodesTraversedList
     */
    public static void getAllNumNodesTraversedListHelper(GameMap gameMap, Map<String, List<Integer>> levelLengthMap, String loc, int nodesTraversed, List<Integer> allNumNodesTraversedList) {

        if (gameMap.isFinalLocation(loc)) {
            allNumNodesTraversedList.add(nodesTraversed+1);
            return;
        }

        List<String> adjacent = gameMap.getAdjacent(loc);
        for (String adj : adjacent) {
            for (int i : levelLengthMap.get(loc)) {
                getAllNumNodesTraversedListHelper(gameMap, levelLengthMap, adj, nodesTraversed+i, allNumNodesTraversedList);
            }
        }

    }

    public static List<Integer> getNumNodesTraversedList(LevelMap levelMap) {
        List<Integer> numNodesTraversedList = new ArrayList<>();
        String currentNodeID = levelMap.getCurrentNode().getID();
        getNumNodesTraversedListHelper(levelMap, currentNodeID, 1, numNodesTraversedList);
        return numNodesTraversedList;

    }

    public static void getNumNodesTraversedListHelper(LevelMap levelMap, String currentNodeID, int nodesTraversed, List<Integer> numNodesTraversedList) {
        if (levelMap.isCompletionNode(currentNodeID)) {
            numNodesTraversedList.add(nodesTraversed);
            return;
        }
        List<String> adjacentIDs = levelMap.getAdjacentID(currentNodeID);
        for (String nodeID : adjacentIDs) {
            getNumNodesTraversedListHelper(levelMap, nodeID, nodesTraversed+1, numNodesTraversedList);
        }


    }


}
