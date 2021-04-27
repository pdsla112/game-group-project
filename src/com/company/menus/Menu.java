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
    public void printMenuItems() {
        System.out.println("Options:");
        for (int i=0; i<menuItems.size(); i++) {
            System.out.println("[" + menuItems.get(i).getOptionKey() + "]" + " - " + menuItems.get(i).getDescription());
        }
    }

    public MenuItem displayChooseOption() {
        printMenuItems();
        return getSelectedItem();
    }

    public MenuItem getSelectedItem() {
        try {
            String selection = Parser.getInputString();

            for (int i=0; i<menuItems.size(); i++)

            if (optionMap.containsKey(selection.toLowerCase())) {
                return optionMap.get(selection.toLowerCase());
            } else {
                System.out.println("I do not understand.");
                return this.displayChooseOption();
            }
        } catch (Exception e) {
            return null;
        }

        return null;

    }
}
