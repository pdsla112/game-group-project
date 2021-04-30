package com.company.parser;

import com.company.DeathException;
import com.company.LevelNode;
import com.company.MenuItem;
import com.company.characters.Player;
import com.company.locations.Location;
import com.company.menus.GenericMenuItem;
import com.company.menus.Menu;

import java.util.List;
import java.util.Scanner;

public class Parser {

    Player player;
    public static String getInputString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public Parser(Player player) {
        this.player = player;
    }

    public boolean parse(Player player, String userCommand, Menu menu) throws DeathException {

        try {
            MenuItem selected = menu.getMenuItem(Integer.parseInt(userCommand));
            if (selected != null) {
                if (selected instanceof Location) {
                    player.setLocation((Location) selected);
                    return true;
                } else if (selected instanceof LevelNode) {
                    player.getLocation().getLevelMap().setCurrentNode((LevelNode) selected);
                    return true;
                }
            }

        } catch(NumberFormatException e) {
            return parseAction(player, userCommand, menu);
        }

        return false;
    }
    public boolean parseAction(Player player, String userCommand, Menu menu) throws DeathException {
        return false;
    }


}
