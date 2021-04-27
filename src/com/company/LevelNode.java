package com.company;

import java.util.List;

public class LevelNode {
    String text;
    List<String> actions;
    String description;

    public LevelNode(String description, String text, List<String> actions) {
        this.text = text;
        this.actions = actions;
        this.description = description;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getActions() {
        return actions;
    }

    public void setActions(List<String> actions) {
        this.actions = actions;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
