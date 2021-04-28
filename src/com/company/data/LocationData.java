package com.company.data;

public class LocationData {
    private String location;
    private String initialText;
    private PsychoData psychoData;
    private GoodCharacterData goodCharacterData;
    private ItemData itemData;
    private ZombieData zombieData;

    public LocationData(String location, String initialText, PsychoData psychoData, GoodCharacterData goodCharacterData, ItemData itemData, ZombieData zombieData) {
        this.location = location;
        this.initialText = initialText;
        this.psychoData = psychoData;
        this.goodCharacterData = goodCharacterData;
        this.itemData = itemData;
        this.zombieData = zombieData;
    }
}
