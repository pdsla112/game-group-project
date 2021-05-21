package comp2100.groupass;

import comp2100.groupass.entities.Player;
import comp2100.groupass.parser.Parser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void parseActions() {
        Player player = new Player("a",1,"hospital");
        List<String> acts = null;//Arrays.asList("locationObject table under medkit","heal 10");
        Parser parser = new Parser(player);
        try{
            assertTrue(parser.parseActions(acts));
        } catch(Exception e){
            fail();
        }
    }

    @Test
    public void parseAction() {
        Player player = new Player("a",1,"home");
        int initalHealth = player.getHealth();
        Parser parser = new Parser(player);
        try {
            parser.parseAction("heal 10");
            assertEquals(player.getHealth(),initalHealth+10);
        } catch(Exception e){
            fail();
        }
    }
}