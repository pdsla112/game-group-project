package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelMap {
    Map<String,List<String>> adjacentMap;
    Map<String, LevelNode> levelNodesMap;
    List<LevelNode> completionNodes;
    List<LevelNode> deathNodes;
    LevelNode currentNode;

    public LevelMap(LevelNode currentNode) {
        this.adjacentMap = new HashMap<>();
        this.levelNodesMap = new HashMap<>();
        this.currentNode = currentNode;
        this.levelNodesMap.put(currentNode.id, currentNode);
    }

    public List<LevelNode> getCompletionNodes() {
        return completionNodes;
    }

    public void setCompletionNodes(List<LevelNode> completionNodes) {
        this.completionNodes = completionNodes;
    }

    public List<LevelNode> getDeathNodes() {
        return deathNodes;
    }

    public void setDeathNodes(List<LevelNode> deathNodes) {
        this.deathNodes = deathNodes;
    }

    public void addLevelNodes(List<LevelNode> levelNodes) {
        for (LevelNode lo : levelNodes) {
            levelNodesMap.put(lo.id, lo);
        }
    }

    public LevelNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(LevelNode currentNode) {
        this.levelNodesMap.put(currentNode.id, currentNode);
        this.currentNode = currentNode;
    }

    public void setAdjacent(LevelNode n, List<LevelNode> adjacentList) {
        List<String> adjacentIds = new ArrayList<>();
        for (LevelNode ln : adjacentList) {
            adjacentIds.add(ln.id);
            this.levelNodesMap.put(ln.id, ln);
        }
        adjacentMap.put(n.id, adjacentIds);
    }

    public List<LevelNode> getAdjacent() {
        List<LevelNode> adjacent = new ArrayList<>();
        for (String nodeId : adjacentMap.get(currentNode.id)) {
            adjacent.add(levelNodesMap.get(nodeId));
        }
        return adjacent;
    }


}
