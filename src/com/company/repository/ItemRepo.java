package com.company.repository;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.company.items.Item;

public class ItemRepo {
    private Map<String, Item> items = new HashMap<>();


    public Item getItem(String id) {
        return null;
    }

    // Load all items, from the given file
    protected void load(File file) {

    }

    public void store(File file) {

    }

    void addItem(Item item) {
        items.put(item.getId(), item);
    }

}