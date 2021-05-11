package com.company.menus;

import com.company.MenuItem;

import java.util.*;

public class Menu{
    protected List<? extends MenuItem> menuItems;
    protected Map<Integer, MenuItem> keyMap = new HashMap<>();
    private int size;


    public Menu(List<? extends MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.size = menuItems.size();
        for (int i = 0; i< menuItems.size(); i++) {
            keyMap.put(i,menuItems.get(i));
        }
    }

    public int getSize() {
        return size;
    }


    public MenuItem getMenuItem(int key) {
        if (keyMap.containsKey(key)) {
            return keyMap.get(key);
        } else {
            return null;
        }

    }


    public void printMenuItems() {
        System.out.println("Options:");
        for (int i = 0; i< menuItems.size(); i++) {
            System.out.println("[" + i + "]" + " - " + menuItems.get(i).getOptionText());
        }
    }
//
//    public MenuItem displayChooseOption() {
//        printMenuItems();
//        return getSelectedItem();
//    }

//    public MenuItem getSelectedItem() {
//        try {
//            String selection = Parser.getInputString();
//
//            for (int i=0; i<menuItems.size(); i++)
//
//            if (keyMap.containsKey(selection.toLowerCase())) {
//                return keyMap.get(selection.toLowerCase());
//            } else {
//                if (!Parser.parse(selection)) {
//                    System.out.println("I do not understand.");
//                }
//                return this.displayChooseOption();
//            }
//        } catch (Exception e) {
//            return null;
//        }
//
//        return null;
//
//    }
}
