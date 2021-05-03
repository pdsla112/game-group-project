package com.company.menus;


import java.util.HashSet;
import java.util.Set;
import com.company.MenuItem;

public class GenericMenuItem implements MenuItem {
    protected String optionText;

    public GenericMenuItem(String text) {
        this.optionText = text;
    }

    public String getOptionText() {
        return optionText;
    }



}
