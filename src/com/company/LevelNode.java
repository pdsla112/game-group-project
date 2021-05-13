package com.company;

import java.util.ArrayList;
import java.util.List;

public class LevelNode implements MenuItem{
    String text;
    List<String> actions;
    String option;

    public LevelNode(String description, String text, List<String> actions) {
        this.text = text;
        this.actions = actions;
        this.option = description;
    }

    public String getOptionText() {
        return option;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getActions() {
        List<String> temp = actions;
        actions = new ArrayList<>();
        return temp;
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
