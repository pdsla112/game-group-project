package com.company.menus;

import com.company.parser.Parser;

import java.util.*;

public class Menu {
    protected List<MenuItem> menuItems = new ArrayList<>();
    protected Map<String, MenuItem> optionMap = new HashMap<String, MenuItem>();

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public void addMenuItem(MenuItem m) {
        menuItems.add(m);
        optionMap.put(m.getOptionKey().toLowerCase(), m);
    }
    public void printMenuItems(List<MenuItem> m) {
        System.out.println("Options:");
        for (MenuItem menuItem: m) {
            System.out.println(menuItem.getOptionKey() + " - " + menuItem.getDescription());
        }
    }

    public MenuItem displayChooseOption(List<MenuItem> m) {
        printMenuItems(m);
        return getSelectedItem(m);
    }

    public MenuItem getSelectedItem(List<MenuItem> m) {
        try {
            String inputMessage = Parser.getInputString();
            if (optionMap.containsKey(inputMessage.toLowerCase())) {
                return optionMap.get(inputMessage.toLowerCase());
            } else {
                System.out.println("I do not understand.");
                return this.displayChooseOption(m);
            }
        } catch (Exception e) {
            return null;
        }

    }
}
