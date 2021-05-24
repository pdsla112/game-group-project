package comp2100.groupass.parser;

import comp2100.groupass.entities.GenerateAnimal;
import comp2100.groupass.exceptions.DeathException;
import comp2100.groupass.Game;
import comp2100.groupass.locations.LevelNode;
import comp2100.groupass.menus.AnimalHunt;
import comp2100.groupass.menus.MenuItem;
import comp2100.groupass.entities.Player;
import comp2100.groupass.data.Level;
import comp2100.groupass.data.LevelJSON;
import comp2100.groupass.data.PlayerJSON;
import comp2100.groupass.items.LocationObject;
import comp2100.groupass.locations.Location;
import comp2100.groupass.menus.BattleEvent;
import comp2100.groupass.menus.Menu;
import comp2100.groupass.entities.Animal;
import comp2100.groupass.entities.Psychopath;
import comp2100.groupass.entities.Zombie;
import comp2100.groupass.parser.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parser {

    Level level;
    Player player;
    public static String getInputString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public Parser(Player player) {
        this.player = player;
        this.level = LevelJSON.getSpecificLevel(player.getLevel());
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
                } else if (selected instanceof LevelNode) {
                    Location playerLocation = Game.map.getLocationFromName(player.getLocationName());
                    playerLocation.getLevelMap().setCurrentNode((LevelNode) selected);
                    player.setLocationObjects(new ArrayList<>());

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
            if (sentence instanceof IncorrectSentence || sentence instanceof Unknown) {
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
        player.locationObjects = new ArrayList<>();
        if (actions!= null) {
            for (String action : actions) {
                if (!parseAction(action)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean parseAction(String action) throws DeathException {

        String[] userCommandSplit = action.split(" ");
        String command = userCommandSplit[0];
        if(command!= null){
            if(command.equals("heal")) {
                int healAmount = Integer.parseInt(userCommandSplit[1]);
                player.setHealth(Math.max(100,player.getHealth()+healAmount));
                // heal player by set amount
            }
            if (command.equals("item")) {
                String itemName = userCommandSplit[1];
                System.out.println(itemName + " has been added to your inventory.\n");
                player.addItem(itemName);
            }

            if(command.equals("locationObject")) {
                String object = userCommandSplit[1];
                String location = userCommandSplit[2];
                String item = userCommandSplit[3];
                LocationObject lo = new LocationObject(object,location,item);
                player.addLocationObject(lo);
            }
            if(command.equals("psychoFight")){
                Psychopath psychopath = new Psychopath(level.getPsychopathAttack1(), level.getPsychopathAttack2(), level.getPsychoHealth(), false, true);
                BattleEvent be = new BattleEvent(player, psychopath);
                return(be.enemyFight());

            }
            if(command.equals("zombieFight")){
                Zombie zombie = new Zombie(level.getZombieAttack1(), level.getZombieAttack2(), level.getZombieAttack3(), level.getZombieHealth(), false, level.getZombieApproachProb());
                BattleEvent be = new BattleEvent(player, zombie);
                return(be.enemyFight());
            }
            if (command.equals("location")) {
                String newLocation = userCommandSplit[1];
                player.setLocationName(newLocation);
            }
            if(command.equals("hunt")){
                Animal animal = new GenerateAnimal().generateAnimal(player.getLevel());
                AnimalHunt animalhunt = new AnimalHunt(player,animal);
                return(animalhunt.Animalhunt());
            }
            if(command.equals("drive")){
                player.setHealth(Math.max(100,player.getHealth()+5));
            }

            }
        return true;

        }

    }



