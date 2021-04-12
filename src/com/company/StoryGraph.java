package com.company;


import java.util.ArrayList;

public class StoryGraph {

    public class Edge {
        Node source;
        Node destination;
        public Edge(Node from, Node to) {
            this.source = from;
            this.destination = to;
        }
    }

    ArrayList<Edge> edges;
    Node root;

    public StoryGraph(Node root) {
        this.root = root;
    }

    public void addEdge(Node from, Node to) {
        edges.add(new Edge(from, to));
    }



}
