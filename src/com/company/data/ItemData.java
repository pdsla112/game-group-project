package com.company.data;

public class ItemData {
    private String itemType;
    private String intoText;

    public ItemData(String itemType, String introText) {
        this.itemType = itemType;
        this.intoText = introText;
    }

    public String getItemType() {
        return this.itemType;
    }

    public String getIntoText() {
        return this.intoText;
    }
}
