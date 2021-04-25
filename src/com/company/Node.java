package com.company;

import java.util.List;

public class Node {
    String text;
    List<String> actions;
    String option;

    public Node(String text, List<String> actions, String option) {
        this.text = text;
        this.actions = actions;
        this.option = option;
    }
}
