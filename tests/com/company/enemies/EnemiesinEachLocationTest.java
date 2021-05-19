package com.company.enemies;

import com.company.Game;
import com.company.LevelNode;
import com.company.characters.Player;
import com.company.data.GameMapJSON;
import com.company.data.PsychoData;
import com.company.exceptions.DeathException;
import com.company.locations.Forest;
import com.company.locations.Location;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class EnemiesinEachLocationTest {

    @Before
    public void setUp(){
        //Game game = new Game(player); //game.runGame();
        //Location location = Game.map.getLocationFromName(player.getLocationName());
    }
    @Test
    public void testPsychoinLoc(){
        /*Player player = new Player("a",1,"home");
        PsychoData
        try{
            player.setLocationName("cottage");
            Location location = GameMapJSON.deserializeJSON().getCurrentLocation();
            GameMapJSON.deserializeJSON().get //contains(Psychopath)
        }catch(Exception e){
            fail();
        }*/
    }
    @Test
    public void testAnimalsBasedOnLevel() {
        Player player = new Player("a",1,"forest");
        GenerateAnimal generateAnimal = new GenerateAnimal();
        assertEquals(generateAnimal.generateAnimal(0),Animal.BISON);
        assertEquals(generateAnimal.generateAnimal(1),Animal.DEER);
        assertEquals(generateAnimal.generateAnimal(2),Animal.TROUT);
        assertEquals(generateAnimal.generateAnimal(3),Animal.RABBIT);
    }

}
