package comp2100.groupass.entities;

import comp2100.groupass.entities.Animal;
import comp2100.groupass.exceptions.DeathException;
import comp2100.groupass.data.Level;
import comp2100.groupass.data.LevelJSON;
import comp2100.groupass.entities.Enemy;
import comp2100.groupass.items.HuntingKit;
import comp2100.groupass.items.LocationObject;
import comp2100.groupass.items.Medkit;
import comp2100.groupass.menus.Attack;
import comp2100.groupass.parser.Tokenizer;


import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Player {

    private int damage1;  // Fighting level of the character. Higher => better chance of winning that battle.
    private int damage2;
    private int health;
    private String name;
    private int level;
    public Map<String, Integer> itemsMap;
    public List<LocationObject> locationObjects;
    public Tokenizer tokenizer;
    private String locationName;

    public Player(String name, int level, String locationName) {
        Level playerLevel = LevelJSON.getSpecificLevel(level);
        this.name = name;
        this.level = level;
        this.damage1 = playerLevel.getDamage1();
        this.damage2 = playerLevel.getDamage2();
        this.health = playerLevel.getHealth();
        this.locationName = locationName;
        this.tokenizer = new Tokenizer();
        this.itemsMap = new HashMap<>();
    }

    public void useItem(String name) {
        if (name.equals("medkit")) {
            Medkit medkit = new Medkit(20);
            medkit.use(this);
            itemsMap.put(name, Math.max((itemsMap.get(name)-1), 0));
        }
        if (name.equals("huntingkit")){
            HuntingKit huntingkit = new HuntingKit(1,10-level);
            huntingkit.use(this);
            itemsMap.put(name,Math.max((itemsMap.get(name)-1), 0));
        }

    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLocationObjects(List<LocationObject> locationObjects) {
        this.locationObjects = locationObjects;
    }

    //returns true if item is found and added
    public boolean lookForItem(String preposition, String noun) {
        for (LocationObject lo : locationObjects) {
            if (lo.getObjectName().equals(noun)) {
                if (lo.getLocation().equals(preposition)) {
                    locationObjects.remove(lo);
                    addItem(lo.getItemName());
                    System.out.println("--------------------------------------");
                    System.out.println("You found a " + lo.getItemName() + " " + preposition + " the " + noun + ".");
                    System.out.println(lo.getItemName() + " has been added to your inventory.");
                    System.out.println("--------------------------------------");
                    System.out.println();
                    return true;
                }
            }
        }
        return false;
    }

    public void addItem(String name) {
        if (itemsMap.containsKey(name)) {
            itemsMap.put(name, itemsMap.get(name) + 1);
        } else {
            itemsMap.put(name, 1);
        }
    }

    public void attack(Enemy e, Attack attack) throws DeathException {
        e.setHp(e.getHp() - attack.getAttackDamage());
        health -= attack.getSelfDamage();
        if (health <= 0) {
            throw new DeathException("player died.");
        }
        System.out.println("You choose to use a " + attack.getAttackName().toLowerCase()+".");

    }

    public void hunt(Animal a, Attack attack){
        a.setHuntingDifficulty(a.getHuntingDifficulty()-attack.getAttackDamage());
        health -= attack.getSelfDamage();
        System.out.println("You choose " + attack.getAttackName().toLowerCase()+".");
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public void addLocationObject(LocationObject lo) {
        this.locationObjects.add(lo);
    }

    public void showItems() {
        String text = "--------------------------------------\nYour Items:\n";
        for (String itemName : itemsMap.keySet()) {
            if (itemsMap.get(itemName) > 0) {
                text += "\t" + itemName + "\t" + itemsMap.get(itemName) + "\n";
            }
        }
        text += "--------------------------------------\n";
        System.out.println(text);
        //todo
    }

    public void showSurroundings() {
        if (locationObjects == null || locationObjects.isEmpty()) {
            System.out.println("There is nothing of interest around you.");
            System.out.println();
        } else {
            String text = "--------------------------------------\nYou see:\n";
            for (LocationObject lo : locationObjects) {
                text += "\ta " + lo.getObjectName() + "\n";
            }
            text += "--------------------------------------\n";
            System.out.println(text);
        }
    }


    public int getDamage1() {
        return damage1;
    }

    public int getDamage2() {
        return damage2;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

}
