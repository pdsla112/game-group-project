package com.company;

import com.company.data.GameMapJSON;
import com.company.locations.GameMap;
import com.company.locations.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutomaticGameTester2 {



    public  static void main(String[] args) {

        String location = "cottage";

        GameMap map = GameMapJSON.deserializeJSON();

        List<String> locationNames = map.getLocationNames();
        for (String locName : locationNames) {
            List<Integer> numNodesTraversedList = getNumNodesTraversedList(map.getLocationFromName(locName).levelMap);
            int paths = numNodesTraversedList.size();
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i : numNodesTraversedList) {
                if (i > max)
                    max = i;
                if (i < min)
                    min = i;
                sum += i;
            }

            float avg = ((float) sum)/paths;
            System.out.println("Location: " + locName);
            System.out.println("Number of paths: " + paths);
            System.out.println("Average number of nodes traversed: " + avg);
            System.out.println("Max number of nodes traversed: " + max);
            System.out.println("Min number of nodes traversed: " + min);
            System.out.println("-------------------------------------\n");
        }
        //map.getAdjacent(map.getLocationFromName(location));

    }

    public static List<Integer> getNumNodesTraversedList(LevelMap levelMap) {
        List<Integer> numNodesTraversedList = new ArrayList<>();
        String currentNodeID = levelMap.getCurrentNode().id;
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
