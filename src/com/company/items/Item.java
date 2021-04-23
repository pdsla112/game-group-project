package com.company.items;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Item {
    private final String id;
    private final String type;
    private final String name;
    private final String description;
    private final Map<String, Integer> properties;

    public Item(String id, String type, String name, String description, Map<String, Integer> properties) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.description = description;
        if (properties != null) {
            this.properties = properties;
        }
        else {
            this.properties = new TreeMap<>();
        }
    }
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public int getProperty(String property) {
        if (! properties.containsKey(property)) {
            return 0;
        }
        return properties.get(property);
    }
    public Map<String, Integer> getProperties() {
        return Collections.unmodifiableMap(properties);
    }
    public boolean containsProperty(String key) {
        return properties.containsKey(key);
    }
    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//        if (obj instanceof Item) {
//            Item i = (Item) obj;
//            return name.equals(i.name);
//        }
        return false;
    }

    public void display() {

    }
}
