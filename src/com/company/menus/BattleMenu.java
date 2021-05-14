package com.company.menus;

import com.company.DeathException;
import com.company.characters.Player;
import com.company.enemies.Enemy;
import com.company.enemies.Psychopath;
import com.company.enemies.Zombie;
import com.company.parser.Parser;

import java.util.ArrayList;
import java.util.Arrays;

public class BattleMenu {
    Player player;
    Enemy enemy;

    public BattleMenu(Player player, Enemy enemy) throws DeathException {
        this.player = player;
        this.enemy = enemy;
        enemyFight();

    }

    public void enemyFight() throws DeathException {
        String enemyName = (enemy instanceof Zombie ? "Zombie" : "Psychopath");
        Parser parser = new Parser(player);
        int enemyHpInitial = enemy.getHp();
        System.out.println("A " + enemyName + " (" + enemyHpInitial + "hp) appears in front of you.");

        while (enemy.isAlive()) {
            System.out.println("What would you like to do?");
            Menu attackMenu = new Menu(
                new ArrayList<>(Arrays.asList(
                    new GenericMenuItem("Head on attack (" + player.getDamage() +"dmg/-" + (player.getLevel()+2) + "hp)"),
                    new GenericMenuItem("Sneak attack (" + (player.getDamage()-6) + "dmg)"))));

            attackMenu.printMenuItems();
            parser.battleParse(parser.getInputString(), attackMenu, enemy);

            if (!enemy.isAlive()) {
                System.out.println("Congratulations. You have slain the " + (enemy instanceof Zombie ? "Zombie" : "Psychopath") + ".");
            } else {
                System.out.println(enemyName + " hp: " + enemy.getHp() + "(-" + (enemyHpInitial - enemy.getHp()) + ")\n");
                enemy.attack(player);
                System.out.println(player.getName() + " hp: " + player.getHealth() + "\n");
            }

        }
    }

}
