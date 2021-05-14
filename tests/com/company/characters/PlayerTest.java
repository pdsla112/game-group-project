package com.company.characters;

import com.company.Game;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void useItem() {
    }

    @Test
    public void getLevel() {
    }

    @Test
    public void setLocationObjects() {
    }

    @Test
    public void lookForItem() {

    }

    @Test
    public void addItem() {
    }

    @Test
    public void getLocation() {
    }

    @Test
    public void setLocation() {
    }

    @Test
    public void addLocationObject() {
    }

    @Test
    public void showStats() {
    }

    @Test
    public void showItems() {
    }

    @Test
    public void showSurroundings() {

    }

    @Test
    public void getDamage() {
    }

    @Test
    public void setDamage() {
    }

    @Test
    public void getHealth() {
    }

    @Test
    public void setHealth() {
    }

    @Test
    public void getEmail() {
    }
}



package comp2100.groupass;

        import java.io.ByteArrayOutputStream;

        import com.company.characters.Player;
        import org.junit.Assert;
        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.rules.Timeout;
        import com.company.Game;
        import com.company.LevelMap;

/* each game to be completed by one player
 * */
public class GameMapTest {
    @Rule
    public Timeout globalTimeout = Timeout.millis(1000);

    @Test
    public void cangotocottage(){
        Game game = new Game(Player p);
    }

    @Test
    public void cangotohospital() {
        ResultOutput result;
        result = setCurrentNode();
        result = successfullygoto("hospital",null);
    }
    @Test
    public void cancollectHuntingKit(){
        ResultOutput result;
        result = map.moveUserto("cottage");
        result = successfullygoto()
    }


    private ResultOutput successfullygoto(String location, ResultOutput resultoutput){
        Assert.assertEquals(location, resultoutput.look.location);
        return resultoutput;
    }
}
