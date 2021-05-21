package comp2100.groupass.locations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * level map is a graph data structure for storing level nodes and adjacency information
 */
public class LevelMap {
    Map<String,List<String>> adjacentMap;
    Map<String, LevelNode> levelNodesMap;
    List<String> completionNodes;
    LevelNode currentNode;

    public LevelMap(LevelNode currentNode) {
        this.currentNode = currentNode;
        this.adjacentMap = new HashMap<>();
        this.levelNodesMap = new HashMap<>();
        this.completionNodes = new ArrayList<>();
        this.levelNodesMap.put(currentNode.id, currentNode);
    }

    /**
     * Completion nodes are nodes that signify the completion of a level
     * @param completionNodes
     */
    public void setCompletionNodes(List<LevelNode> completionNodes) {
        for (LevelNode cNode : completionNodes) {
            this.completionNodes.add(cNode.id);
        }

    }


    /**
     * checks if a node is a completion node
     * @param id
     * @return
     */
    public boolean isCompletionNode(String id) {
        return completionNodes.contains(id);
    }

    public List<String> getAdjacentID(String id) {
        return adjacentMap.get(id);
    }



    /**
     * add a level node to the graph
     * @param levelNodes
     */
    public void addLevelNodes(List<LevelNode> levelNodes) {
        for (LevelNode lo : levelNodes) {
            levelNodesMap.put(lo.id, lo);
        }
    }

    /**
     * gets current node
     * @return current node
     */
    public LevelNode getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(LevelNode currentNode) {
        this.levelNodesMap.put(currentNode.id, currentNode);
        this.currentNode = currentNode;
    }

    /**
     * sets the nodes adjacent to a particular node
     * @param n
     * @param adjacentList
     */
    public void setAdjacent(LevelNode n, List<LevelNode> adjacentList) {
        List<String> adjacentIds = new ArrayList<>();
        for (LevelNode ln : adjacentList) {
            adjacentIds.add(ln.id);
            this.levelNodesMap.put(ln.id, ln);
        }
        adjacentMap.put(n.id, adjacentIds);
    }

    /**
     * gets a list of nodes adjacent to the current node
     * @return a list of nodes adjacent to the current node
     */
    public List<LevelNode> getAdjacent() {
        List<LevelNode> adjacent = new ArrayList<>();
        for (String nodeId : adjacentMap.get(currentNode.id)) {
            adjacent.add(levelNodesMap.get(nodeId));
        }
        return adjacent;
    }


}
