package com.company.menus;


import java.util.HashSet;
import java.util.Set;

public class MenuItem {
    protected String optionKey;
    protected String description;

    public MenuItem(String optionKey, String description) {
        this.optionKey = optionKey.toLowerCase();
        this.description = description;
    }

    public String getOptionKey() {
        return optionKey;
    }

    public void setOptionKey(String command) {
        this.optionKey = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
