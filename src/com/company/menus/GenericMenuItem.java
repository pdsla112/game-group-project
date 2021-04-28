package com.company.menus;


import java.util.HashSet;
import java.util.Set;
import com.company.MenuItem;

public class GenericMenuItem implements MenuItem {
    protected String text;

    public GenericMenuItem(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }



}
