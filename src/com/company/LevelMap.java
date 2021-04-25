package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelMap {
    Map<Node,Node> edges;
    List<Node> nodes;
    Node rootNode;

    public LevelMap(Node rootNode) {
        this.edges = new HashMap<>();
        this.nodes = new ArrayList<>();
        this.rootNode = rootNode;
    }

    public void addEdge(Node from, Node to) {
        edges.put(from, to);
    }

    public class Node {
        String text;
        List<String> actions;

        public Node(String text, List<String> actions) {
            this.text = text;
            this.actions = actions;
        }
    }
}
