package com.company;

import java.util.List;

public class LevelNode {
    String text;
    List<String> actions;
    String option;

    public LevelNode(String description, String text, List<String> actions) {
        this.text = text;
        this.actions = actions;
        this.option = description;
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


    public String getOption() {
        return option;
    }

    public void setOption(String description) {
        this.option = description;
    }
}
