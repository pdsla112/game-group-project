package comp2100.groupass.menus;

import comp2100.groupass.exceptions.DeathException;
import comp2100.groupass.entities.Player;
import comp2100.groupass.data.Level;
import comp2100.groupass.data.LevelJSON;
import comp2100.groupass.entities.Enemy;
import comp2100.groupass.entities.Psychopath;
import comp2100.groupass.entities.Zombie;
import comp2100.groupass.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class BattleEvent {
    Player player;
    Enemy enemy;
    Level level;

    public BattleEvent(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
        int playerLevel = player.getLevel();
        Level level = LevelJSON.getSpecificLevel(playerLevel);
        this.level = level;
    }

    /**
     * enter a fight with an enemy where player and enemy take turns attacking each other
     * @throws DeathException
     */
    public boolean enemyFight() throws DeathException {
        String enemyName = (enemy instanceof Zombie ? "Zombie" : "Psychopath");
        Parser parser = new Parser(player);
        int enemyHpInitial = 0;
        if (enemy instanceof Zombie) {
            enemyHpInitial = level.getZombieHealth();
        } else if (enemy instanceof Psychopath) {
            enemyHpInitial = level.getPsychoHealth();
        }
        System.out.println("A " + enemyName + " (" + enemyHpInitial + "hp) appears in front of you.");

        while (enemy.isAlive()) {
            System.out.println("What would you like to do?");
            List<Attack> playerAttacks = new ArrayList<>();
            // head on attack: do base damage but lose 10% of health
            playerAttacks.add(new Attack("Head on attack", level.getDamage1(), (int) Math.round(player.getHealth()*0.1)));
            // sneak attack: do 70% of damage but lose 0 health
            playerAttacks.add(new Attack("Sneak attack", level.getDamage2(), 0));
            Menu attackMenu = new Menu(playerAttacks);
            attackMenu.printMenuItems();

            boolean attackChosen = false;

            while (!attackChosen) {
                String inputString = Parser.getInputString();
                try {
                    Attack selected = (Attack) attackMenu.getMenuItem(Integer.parseInt(inputString));
                    attackChosen = true;
                    player.attack(enemy, selected);
                } catch(NumberFormatException e) {
                    if (!parser.parseSentenceInput(inputString, attackMenu)) {
                        System.out.println("Game exited");
                        return false;
                    }
                }
            }
            if (!enemy.isAlive()) {
                System.out.println("\nCongratulations. You have slain the " + enemyName + ".");
            } else {
                System.out.println(enemyName + " " + enemy.getHp() + "hp(-" + (enemyHpInitial - enemy.getHp()) + "hp)\n");
                enemy.attack(player);
                System.out.println(player.getName() + ": " + player.getHealth() + "hp\n");
            }

        }
        return true;
    }

}
