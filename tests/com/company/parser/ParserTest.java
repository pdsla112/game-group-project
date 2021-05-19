package com.company.parser;

import com.company.characters.Player;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void getInputString() {
    }

    @Test
    public void parse() {
    }

    @Test
    public void evaluateSentence() {
    }

    @Test
    public void getHelpText() {
    }

    @Test
    public void generateSentences() {
    }

    @Test
    public void parseActions() {
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