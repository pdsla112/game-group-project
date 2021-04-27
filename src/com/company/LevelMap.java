package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelMap {
    Map<LevelNode,List<LevelNode>> adjacent;
    List<LevelNode> levelNodes;
    LevelNode currentNode;

    public LevelMap(LevelNode currentNode) {
        this.adjacent = new HashMap<>();
        this.levelNodes = new ArrayList<>();
        this.currentNode = currentNode;
    }

    public void setAdjacent(Map<LevelNode, List<LevelNode>> adjacent) {
        this.adjacent = adjacent;
    }

    public List<LevelNode> getLevelNodes() {
        return levelNodes;
    }

    public void setLevelNodes(List<LevelNode> levelNodes) {
        this.levelNodes = levelNodes;
    }

    public LevelNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(LevelNode currentNode) {
        this.currentNode = currentNode;
    }

    public void setAdjacent(LevelNode n, List<LevelNode> adjacentList) {
        adjacent.put(n, adjacentList);
    }

    public List<LevelNode> getAdjacent() {
        return adjacent.get(currentNode);
    }


}