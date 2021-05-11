package com.company.parser;

import com.company.DeathException;
import com.company.LevelNode;
import com.company.MenuItem;
import com.company.characters.Player;
import com.company.data.PlayerJSON;
import com.company.locations.Location;
import com.company.menus.BattleMenu;
import com.company.menus.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  Parser {

    Player player;
    public static String getInputString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine().toLowerCase();
    }

    public Parser(Player player) {
        this.player = player;
    }

    public boolean parse(Player player, String inputString, Menu menu) throws DeathException {

        try {
            MenuItem selected = menu.getMenuItem(Integer.parseInt(inputString));
            if (selected != null) {
                if (selected instanceof Location) {
                    player.setLocation((Location) selected);
                    player.getLocation().displayInformation();
                    boolean endPrompt = false;
                    while (!endPrompt) {
                        System.out.println("Would you like to save your progress?(y/n)");
                        String response = Parser.getInputString();
                        if (response.equals("y") || response.equals("yes")) {
                            //save game (player data)
                            PlayerJSON.savePlayer(player);
                            System.out.println("game saved.");
                            endPrompt = true;
                        } else if (response.equals("n") || response.equals("no")) {
                            System.out.println("game not saved.");;
                            endPrompt = true;
                        }
                    }
                    return true;
                } else if (selected instanceof LevelNode) {
                    player.getLocation().getLevelMap().setCurrentNode((LevelNode) selected);
                    return true;

                }
            }

        } catch(NumberFormatException e) {

            if (inputString.equals("h") || inputString.equals("help")) {
                System.out.println(getHelpText(player, menu));
            } else {
                //return parse2(player, userCommand);
                Tokenizer tokenizer = new Tokenizer(inputString);
                TokenParser tokenParser = new TokenParser(tokenizer);
                Sentence sentence = tokenParser.parseSentence();
                if (sentence instanceof IncorrectSentence) {
                    System.out.println(sentence.show());
                } else {
                    System.out.println("You " + sentence.show() + ".");
                }
            }


        }

        return true;
    }

    public String getHelpText(Player player, Menu menu) {
        String rtn = "Help:\n--------------------------------------\n";
        rtn += "Menu Items:\n";
        for (int i=0; i<menu.getSize(); i++) {
            rtn += "Type \"" + i + "\" to choose option: " + menu.getMenuItem(i).getOptionText() + "\n";
        }
        rtn += "--------------------------------------\n";
        rtn += "Addtional commands available to you:\n";
        List<Sentence> sentences = generateSentences();
        for (Sentence s : sentences) {
            rtn += "\t" + s.show() + "\n";
        }

        rtn += "--------------------------------------\n";



        return rtn;



    }

    public static List<Sentence> generateSentences() {
        List<Sentence> sentences = new ArrayList<>();
        Tokenizer tokenizer = new Tokenizer();
        for (String verb : tokenizer.verbG1) {
            for (String determiner : tokenizer.determinerG1) {
                for (String noun : tokenizer.nounG1) {
                    tokenizer.setBuffer(verb + " " + determiner + " " + noun);
                    sentences.add(new TokenParser(tokenizer).parseSentence());
                }
            }
        }
        for (String verb : tokenizer.verbG2) {
            for (String determiner : tokenizer.determinerG2) {
                for (String noun : tokenizer.nounG2) {
                    tokenizer.setBuffer(verb + " " + determiner + " " + noun);
                    sentences.add(new TokenParser(tokenizer).parseSentence());
                }
            }
        }
        for (String verb : tokenizer.verbG3) {
            for (String determiner : tokenizer.determinerG2) {
                for (String noun : tokenizer.nounG3) {
                    tokenizer.setBuffer(verb + " " + determiner + " " + noun);
                    sentences.add(new TokenParser(tokenizer).parseSentence());
                }
            }
        }
        for (String verb : tokenizer.verbG4) {
            for (String preposition : tokenizer.prepositionG1) {
                for (String determiner : tokenizer.determinerG1) {
                    for (String noun : tokenizer.nounG4) {
                        tokenizer.setBuffer(verb + " " + preposition + " " + determiner + " " + noun);
                        sentences.add(new TokenParser(tokenizer).parseSentence());
                    }
                }
            }
        }
        return sentences;
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



