package com.company.items;

public class LocationObject {
    String objectName;
    String itemName;
    String location;

    public LocationObject(String objectName, String location, String itemName) {
        this.objectName = objectName;
        this.itemName = itemName;
        this.location = location;
    }

    public String getObjectName() {
        return objectName;
    }


    public String getItemName() {
        return itemName;
    }

    public String getLocation() {
        return location;
    }

}
