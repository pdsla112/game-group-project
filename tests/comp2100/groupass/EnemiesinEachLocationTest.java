package comp2100.groupass;

import comp2100.groupass.entities.Animal;
import comp2100.groupass.entities.GenerateAnimal;
import comp2100.groupass.entities.Player;
import org.junit.Assert;
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
        Player player = new Player("a",1,"home");
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
        Assert.assertEquals(generateAnimal.generateAnimal(0), Animal.BISON);
        assertEquals(generateAnimal.generateAnimal(1),Animal.DEER);
        assertEquals(generateAnimal.generateAnimal(2),Animal.TROUT);
        assertEquals(generateAnimal.generateAnimal(3),Animal.RABBIT);
    }

}
