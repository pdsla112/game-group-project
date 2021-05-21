package comp2100.groupass.menus;

import java.util.*;

/**
 * menus can display a list of options
 */
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

    /**
     * gets number of elements in the menu
     * @return number of options
     */
    public int getSize() {
        return size;
    }


    /**
     * gets menu item from key
     * @param key
     * @return menu item
     */
    public MenuItem getMenuItem(int key) {
        if (keyMap.containsKey(key)) {
            return keyMap.get(key);
        } else {
            return null;
        }

    }

    /**
     * prints the menu items with their associated indexes
     */
    public void printMenuItems() {
        System.out.println("Options:");
        for (int i = 0; i< menuItems.size(); i++) {
            System.out.println("[" + i + "]" + " - " + menuItems.get(i).getOptionText());
        }
    }
}
