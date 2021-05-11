package com.company.parser;

import com.company.DeathException;
import com.company.LevelNode;
import com.company.MenuItem;
import com.company.characters.Player;
import com.company.locations.Location;
import com.company.menus.BattleMenu;
import com.company.menus.GenericMenuItem;
import com.company.menus.Menu;

import java.util.List;
import java.util.Scanner;

public class  Parser {

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
                    player.getLocation().displayInformation();
                    return true;
                } else if (selected instanceof LevelNode) {
                    player.getLocation().getLevelMap().setCurrentNode((LevelNode) selected);
                    return true;

                }
            }

        } catch(NumberFormatException e) {
            //return parse2(player, userCommand);
        }

        return false;
    }

    //returns true if game is still running afterwards
    //user doesn't choose to do these things
    //done when player
    public boolean parseAction(Player player, String userCommand) throws DeathException {

        String[] userCommandSplit = userCommand.split(" ");
       //split command
        String command = userCommandSplit[0];

        //e.g. commands
        // heal 10
        // item 12              (gives player item with id 12)
        // clearRoad
        // huntAnimal
        // psychoFight
        // zombieFight
        // how are we going to set player lose/win? will it be added as an action too eg.psychoFight, after lose
        // if hunter join the attacklevel suppposed to increase (for hunting animal in forest), add parser action for this. eg."attacklevelincrease"
        //are we still having isVisited() for visited locations -> testing? If so, will it be added in parser action? eg. when reach cottage, cottage isVisited()=true?

        if(command!= null){
            if (command.equals("item")) {
                int id = Integer.parseInt(userCommandSplit[1]);
                player.addItem(id);
            }
            else if(command.equals("heal")) {
                int healAmount = Integer.parseInt(userCommandSplit[1]);
                player.setHealth(Math.max(100,player.getHealth()+healAmount));
                // heal player by set amount
            }
            else if(command.equals("psychoFight")){
                new BattleMenu();//update
            }
            else if(command.equals("zombieFight")){
                new BattleMenu();//update
            }


            }
        return false;

        }

    }



