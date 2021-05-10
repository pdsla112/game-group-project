package com.company.characters;

import java.io.File;
import java.util.ArrayList;

public class NPC extends Character{
    private String id;

    public NPC(String id) {
        this.id = id;
    }

    //load items from json
    public void setItems(File file, int itemLimit, int i) {
        //todo
    }

    public String getId() {
        return id;
    }
    public boolean equals(Object obj) {
        //todo
        return false;
    }
}
