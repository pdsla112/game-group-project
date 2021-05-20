package com.company.parser;

import com.company.Game;
import com.company.LevelMap;
import com.company.LevelNode;
import com.company.characters.Player;
import com.company.exceptions.DeathException;
import com.company.locations.Location;
import com.company.menus.Menu;
import com.company.menus.MenuItem;
import org.junit.Test;
import java.util.Arrays;
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