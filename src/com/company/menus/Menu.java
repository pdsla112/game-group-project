package com.company.menus;

import com.company.parser.Parser;

import java.util.*;

public class Menu {
    protected List<MenuItem> menuItems = new ArrayList<>();
    protected Map<String,MenuItem> optionMap = new HashMap<>();

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem m) {
        menuItems.add(m);
        optionMap.put(m.getOptionKey(), m);
    }
    public void printMenuItems(List<MenuItem> m) {
        System.out.println("Options:");
        for (int i=0; i<m.size(); i++) {
            System.out.println("[" + m.get(i).getOptionKey() + "]" + " - " + m.get(i).getDescription());
        }
    }

    public MenuItem displayChooseOption(List<MenuItem> m) {
        printMenuItems(m);
        return getSelectedItem(m);
    }

    public MenuItem getSelectedItem(List<MenuItem> m) {
        try {
            String selection = Parser.getInputString();

            for (int i=0; i<m.size(); i++)

            if (optionMap.containsKey(selection.toLowerCase())) {
                return optionMap.get(selection.toLowerCase());
            } else {
                System.out.println("I do not understand.");
                return this.displayChooseOption(m);
            }
        } catch (Exception e) {
            return null;
        }

        return null;

    }
}
