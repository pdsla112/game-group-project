package com.company.menus;

import com.company.characters.Player;
import com.company.data.Level;
import com.company.data.LevelJSON;
import com.company.enemies.Animal;
import com.company.enemies.GenerateAnimal;
import com.company.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class AnimalHunt {
    Player player;
    Animal animal;
    Level level;

    public AnimalHunt(Player player, Animal animal){
        this.player = player;
        this.animal = animal;
        Level level = LevelJSON.getSpecificLevel(player.getLevel());
        this.level = level;
    }

    public boolean Animalhunt(){
        Animal animal = new GenerateAnimal().generateAnimal(level.getLevel());
        Parser parser = new Parser(player);
        int animalHpInitial = animal.getHuntingDifficulty();
        System.out.println("Hunt a " + animal + " (" + animalHpInitial + "hp) in front of you.");

        while (animal.isAlive()) {
            System.out.println("What would you like to do?");
            List<Attack> playerAttacks = new ArrayList<>();
            // head on attack: do base damage but lose 10% of health
            playerAttacks.add(new Attack("Headshot", level.getDamage1()/2, (int) Math.round(player.getHealth()*0.1)));
            // sneak attack: do 70% of damage but lose 0 health
            playerAttacks.add(new Attack("Attack its leg", level.getDamage2()/2, 0));
            Menu attackMenu = new Menu(playerAttacks);
            attackMenu.printMenuItems();

            boolean attackChosen = false;

            while (!attackChosen) {
                String inputString = Parser.getInputString();
                try {
                    Attack selected = (Attack) attackMenu.getMenuItem(Integer.parseInt(inputString));
                    attackChosen = true;
                    player.hunt(animal, selected);
                } catch(NumberFormatException e) {
                    if (!parser.parseSentenceInput(inputString, attackMenu)) {
                        System.out.println("Game exited");
                        return false;
                    }
                }
            }
            if (!animal.isAlive()) {
                System.out.println("\nCongratulations. You hunt the " + animal + ".");
            } else {
                System.out.println(animal + " " + animalHpInitial + "hp(-" + (animalHpInitial - animal.getHuntingDifficulty()) + "hp)\n");
            }

        } return true;

    }
}
