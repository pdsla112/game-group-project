package com.company.enemies;

import com.company.Game;
import com.company.LevelNode;
import com.company.characters.Player;
import com.company.exceptions.DeathException;
import com.company.locations.Forest;
import com.company.locations.Location;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class EnemiesinEachLocationTest {
    private Player player;
    Game game;

    @Before
    public void setUp(){
        game = new Game(player); //game.runGame();
        player = new Player("name",1,"home");
        Location location = Game.map.getLocationFromName(player.getLocationName());
    }
    @Test
    public void testAnimalsBasedOnLevel() {
        GenerateAnimal generateAnimal = new GenerateAnimal();
        assertEquals(generateAnimal.generateAnimal(0),Animal.BISON);
        assertEquals(generateAnimal.generateAnimal(1),Animal.DEER);

        // plaeyer -> new Parser(player)
        // heal
        // player.getHealht  + 20

    }

}
