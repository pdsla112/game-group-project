package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LevelNode implements MenuItem{
    String id;
    String text;
    List<String> actions;
    String option;

    public LevelNode(String option, String text, List<String> actions) {
        this.text = text;
        this.actions = actions;
        this.option = option;
        this.id = UUID.randomUUID().toString();
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
