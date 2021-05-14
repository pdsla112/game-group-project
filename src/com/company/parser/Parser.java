package com.company.parser;

import com.company.DeathException;
import com.company.Game;
import com.company.LevelNode;
import com.company.MenuItem;
import com.company.characters.Player;
import com.company.data.PlayerJSON;
import com.company.enemies.Enemy;
import com.company.enemies.Psychopath;
import com.company.enemies.Zombie;
import com.company.items.LocationObject;
import com.company.locations.Location;
import com.company.menus.BattleMenu;
import com.company.menus.Menu;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Parser {

    Player player;
    public static String getInputString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine().toLowerCase();
    }

    public Parser(Player player) {
        this.player = player;
    }



    public boolean parse(String inputString, Menu menu) throws DeathException {

        try {
            MenuItem selected = menu.getMenuItem(Integer.parseInt(inputString));
            if (selected != null) {
                if (selected instanceof Location) {
                    player.setLocationName(((Location) selected).name);
                    Location playerLocation = Game.map.getLocationFromName(player.getLocationName());
                    playerLocation.displayInformation();
                    boolean endPrompt = false;
                    while (!endPrompt) {
                        System.out.println("Would you like to save your progress?(y/n)");
                        String response = Parser.getInputString();
                        if (response.equals("y") || response.equals("yes")) {
                            //save game (player data)
                            PlayerJSON.savePlayer(player);
                            System.out.println("game saved.");
                            System.out.println();
                            endPrompt = true;
                        } else if (response.equals("n") || response.equals("no")) {
                            System.out.println("game not saved.");;
                            System.out.println();
                            endPrompt = true;
                        }
                    }
                    player.setLocationObjects(new ArrayList<>());
                    return parseActions(playerLocation.getLevelMap().getCurrentNode().getActions());
                    //todo player.setLocationObjects(new ArrayList<>());
                } else if (selected instanceof LevelNode) {
                    Location playerLocation = Game.map.getLocationFromName(player.getLocationName());
                    playerLocation.getLevelMap().setCurrentNode((LevelNode) selected);
                    // todo does not work for root node
                    player.setLocationObjects(new ArrayList<>());
                    return parseActions(playerLocation.getLevelMap().getCurrentNode().getActions());

                }
            }

        } catch(NumberFormatException e) {
            return parseSentenceInput(inputString, menu);
        }
        return true;
    }

    public boolean parseSentenceInput(String inputString, Menu menu) {
        //add items to tokenizer
        ArrayList<String> itemNouns = new ArrayList<>();
        for (String itemName : player.itemsMap.keySet()) {
            if (player.itemsMap.get(itemName) > 0) {
                itemNouns.add(itemName);
            }
        }

        //add objects to tokenizer
        ArrayList<String> prepositions = new ArrayList<>();
        ArrayList<String> objectNouns = new ArrayList<>();
        if (player.locationObjects != null) {
            for (LocationObject lo : player.locationObjects) {
                prepositions.add(lo.getLocation());
                objectNouns.add(lo.getObjectName());
            }
        }

        player.tokenizer.setNounG3(itemNouns);
        player.tokenizer.setNounG4(objectNouns);
        player.tokenizer.setPrepositionG1(prepositions);


        player.tokenizer.setBuffer(inputString);

        if (inputString.equals("h") || inputString.equals("help")) {
            System.out.println(getHelpText(menu));
        } else {
            TokenParser tokenParser = new TokenParser(player.tokenizer);
            Sentence sentence = tokenParser.parseSentence();
            if (sentence instanceof IncorrectSentence) {
                System.out.println(sentence.show());
            } else {
                return evaluateSentence(sentence);


            }
        }
        return true;
    }

    public boolean evaluateSentence(Sentence sentence) {
        if (sentence instanceof SentenceG1) {
            SentenceG1 s = (SentenceG1) sentence;
            VerbG1 v = (VerbG1) s.verbG1;
            if (v.word.equals("exit")) {
                System.out.println("You " + sentence.show() + ".");
                return false;
            }
        }
        if (sentence instanceof SentenceG2) {
            SentenceG2 s = (SentenceG2) sentence;
            VerbG2 v = (VerbG2) s.verbG2;

            if (v.word.equals("examine")) {
                NounG2 n = (NounG2) ((ObjectG2) s.objectG2).nounG2;
                if (n.word.equals("items")) {
                    System.out.println("You " + sentence.show() + ".");
                    player.showItems();
                }
                if (n.word.equals("stats")) {
                    System.out.println("You " + sentence.show() + ".");
                    player.showStats();
                }
                if (n.word.equals("surroundings")) {
                    System.out.println("You " + sentence.show() + ".");
                    player.showSurroundings();
                }

            }
        }

        if (sentence instanceof SentenceG3) {
            SentenceG3 s = (SentenceG3) sentence;
            VerbG3 v = (VerbG3) s.verbG3;

            if (v.word.equals("use")) {
                NounG3 n = (NounG3) ((ObjectG3) s.objectG3).nounG3;
                player.useItem(n.word);
            }
        }

        if (sentence instanceof SentenceG4) {
            SentenceG4 s = (SentenceG4) sentence;
            VerbG4 v = (VerbG4) s.verbG4;

            if (v.word.equals("look")) {
                PrepositionG1 p = (PrepositionG1) s.prepositionG1;
                NounG4 n = (NounG4) ((ObjectG4) s.objectG4).nounG4;
                player.lookForItem(p.word,n.word);

            }
        }
        return true;


    }

    public String getHelpText(Menu menu) {
        String rtn = "Help:\n--------------------------------------\n";
        rtn += "Menu Items:\n";
        for (int i=0; i<menu.getSize(); i++) {
            rtn += "Type \"" + i + "\" to choose option: " + menu.getMenuItem(i).getOptionText() + "\n";
        }
        rtn += "--------------------------------------\n";
        rtn += "Addtional commands available to you:\n";
        List<Sentence> sentences = generateSentences(player);
        for (Sentence s : sentences) {
            rtn += "\t" + s.show() + "\n";
        }

        rtn += "--------------------------------------\n";



        return rtn;



    }

    public static List<Sentence> generateSentences(Player p) {
        List<Sentence> sentences = new ArrayList<>();
        Tokenizer tokenizer = p.tokenizer;
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

    public boolean parseActions(List<String> actions) throws DeathException {
        if (actions!= null) {
            for (String action : actions) {
                if (!parseAction(action)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean battleParse(String inputString, Menu menu, Enemy enemy) throws DeathException {
        try {
            int selected = Integer.parseInt(inputString);

            if (selected == 0) {
                System.out.println("You choose to attack head on.");
                player.attack(enemy, player.getDamage(), player.getLevel()+2);
            } else if (selected == 1) {
                player.attack(enemy, player.getDamage()-6, 0);
            } else {
                System.out.println("You choose to use a sneak attack.");
                battleParse(Parser.getInputString(), menu, enemy);
            }

        } catch(NumberFormatException e) {
            return parseSentenceInput(inputString, menu);

        }
        return true;
    }

    //returns true if game is still running afterwards
    //user doesn't choose to do these things
    //done when player
    public boolean parseAction(String action) throws DeathException {

        String[] userCommandSplit = action.split(" ");
       //split command
        String command = userCommandSplit[0];

        //e.g. commands
        // heal 10
        // item 12              (gives player item with id 12)
        // clearRoad
        // huntAnimal
        // psychoFight
        // zombieFight
        //locationObject table under medkit
        // how are we going to set player lose/win? will it be added as an action too eg.psychoFight, after lose
        // if hunter join the attacklevel suppposed to increase (for hunting animal in forest), add parser action for this. eg."attacklevelincrease"
        //are we still having isVisited() for visited locations -> testing? If so, will it be added in parser action? eg. when reach cottage, cottage isVisited()=true?
        //taxidriver increase speed? reduce distance?
        if(command!= null){
            if(command.equals("heal")) {
                int healAmount = Integer.parseInt(userCommandSplit[1]);
                player.setHealth(Math.max(100,player.getHealth()+healAmount));
                // heal player by set amount
            }
            if(command.equals("locationObject")) {
                String object = userCommandSplit[1];
                String location = userCommandSplit[2];
                String item = userCommandSplit[3];
                LocationObject lo = new LocationObject(object,location,item);
                player.addLocationObject(lo);


            }
            if(command.equals("psychoFight")){
                new BattleMenu(player, new Psychopath());//update
            }
            if(command.equals("zombieFight")){
                new BattleMenu(player, new Zombie());//update
            }
            if (command.equals("location")) {
                String newLocation = userCommandSplit[1];
                player.setLocationName(newLocation);
            }


            }
        return true;

        }

    }



