package com.company;

import java.util.List;

public class LevelNode {
    String text;
    List<String> actions;
    String command;
    String description;

    public LevelNode(String command, String description, String text, List<String> actions) {
        this.text = text;
        this.actions = actions;
        this.command = command;
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

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
