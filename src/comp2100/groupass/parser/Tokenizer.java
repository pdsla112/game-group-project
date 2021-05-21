package comp2100.groupass.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/*
    Production Rules:
   sentence = verbG1 objectG1 | verbG2 objectG2 | verbG3 objectG3 | verbG4 prepositionG1 objectG4
   verbG1 = "exit" | "save"
   verbG2 = "examine"
   verbG3 = "use"
   verbG4 = "look"
   prepositionG1 = "above" | "below" | "inside" (get options from levelnode)
   objectG1 = determinerG1 nounG1
   objectG2 = determinerG2 nounG2
   objectG3 = determinerG2 nounG3
   objectG4 = determinerG2 nounG4
   determinerG1 = "the"
   determinerG2 = "your"
   nounG1 = "game"
   nounG2 = "items" | "stats" | "surroundings"
   nounG3 = medkit (get items from player)
   nounG4 = furniture

   e.g. commands:
   exit the game
   save the game
   examine your surroundings
   examine your stats
   examine your items
   examine your medkit
   use your medkit
   look below the table

   */

public class Tokenizer {

    private List<String> _buffer;		//save text
    private Token currentToken;	        //save token extracted from next()

    public List<String> verbG1 = new ArrayList<>(Arrays.asList("exit"));
    public List<String> verbG2 = new ArrayList<>(Arrays.asList("examine"));
    public List<String> verbG3 = new ArrayList<>(Arrays.asList("use"));
    public List<String> verbG4 = new ArrayList<>(Arrays.asList("look"));

    public List<String> prepositionG1 = new ArrayList<>();
    public List<String> determinerG1 = new ArrayList<>(Arrays.asList("the"));
    public List<String> determinerG2 = new ArrayList<>(Arrays.asList("your"));

    public List<String> nounG1 = new ArrayList<>(Arrays.asList("game"));
    public List<String> nounG2 = new ArrayList<>(Arrays.asList("items", "stats", "surroundings"));
    public List<String> nounG3 = new ArrayList<>();
    public List<String> nounG4 = new ArrayList<>();


    /**
     *  Tokenizer class constructor
     */
    public Tokenizer() {
        _buffer = new LinkedList<String>();		// save input text (string)
    }

    /**
     * sets tokenizer buffer
     * @param text
     */
    public void setBuffer(String text) {
        _buffer = new LinkedList<String>(Arrays.asList(text.trim().split(" ")));		// save input text (string)
        next();
    }

    //get these list of words dynamically
    public void setPrepositionG1(List<String> prepositions) {
        prepositionG1 = prepositions;
    }
    public void setNounG3(List<String> nouns) {
        nounG3 = nouns;
    }
    public void setNounG4(List<String> nouns) {
        nounG4 = nouns;
    }
    
    /**
     *  This function will find and extract a next token from the buffer and
     *  save the token to current
     */
    public void next() {

        if (_buffer.isEmpty()) {
            currentToken = null;	// if there's no string left, set currentToken null and return
            return;
        }

        String firstWord = _buffer.get(0).trim(); // remove whitespace

        if (verbG1.contains(firstWord))
        	currentToken = new Token(firstWord, Token.Type.VERBG1);

        if (verbG2.contains(firstWord))
            currentToken = new Token(firstWord, Token.Type.VERBG2);

        if (verbG3.contains(firstWord))
            currentToken = new Token(firstWord, Token.Type.VERBG3);

        if (verbG4.contains(firstWord))
            currentToken = new Token(firstWord, Token.Type.VERBG4);

        if (prepositionG1.contains(firstWord))
            currentToken = new Token(firstWord, Token.Type.PREPOSITIONG1);

        if (nounG1.contains(firstWord))
            currentToken = new Token(firstWord, Token.Type.NOUNG1);

        if (nounG2.contains(firstWord))
            currentToken = new Token(firstWord, Token.Type.NOUNG2);

        if (nounG3.contains(firstWord))
            currentToken = new Token(firstWord, Token.Type.NOUNG3);

        if (nounG4.contains(firstWord))
            currentToken = new Token(firstWord, Token.Type.NOUNG4);

        if (determinerG1.contains(firstWord))
            currentToken = new Token(firstWord, Token.Type.DETERMINERG1);

        if (determinerG2.contains(firstWord))
            currentToken = new Token(firstWord, Token.Type.DETERMINERG2);

        boolean unknown = (!verbG1.contains(firstWord) && !verbG2.contains(firstWord) && !verbG3.contains(firstWord)
                && !verbG4.contains(firstWord) && !prepositionG1.contains(firstWord) && !nounG1.contains(firstWord)
                && !nounG2.contains(firstWord) && !nounG3.contains(firstWord) && !nounG4.contains(firstWord)
                && !determinerG1.contains(firstWord) && !determinerG2.contains(firstWord));

        if (unknown) {
            currentToken = new Token(firstWord, Token.Type.UNKNOWN);
        }

        // Remove the extracted token from buffer
        _buffer.remove(0);
    }

    /**
     *  returned the current token
     *  
     * @return type: Token
     */
    public Token current() {
    	return currentToken;
    }

    /**
     *  check whether there still exists another tokens in the buffer or not
     *  
     * @return type: boolean
     */
    public boolean hasNext() {
    	return currentToken != null;
    }
}