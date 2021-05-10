package com.company.parser;

import java.util.Arrays;
import java.util.List;

/**
 * Name: Tokenizer.java
 *
 * Remind:
 * 1. Your job is to implement next() method.
 * 2. Please do not modify anything else.
 * 3. Check the correctness of implementation via "TokenizerTest.java" before the submission.
 * 4. You may create additional fields or methods to finish your implementation.
 *
 * The given code is provided to assist you to complete the required tasks. But the 
 * given code is often incomplete. You have to read and understand the given code 
 * carefully, before you can apply the code properly. You might need to implement 
 * additional procedures, such as error checking and handling, in order to apply the 
 * code properly.
 */

public class Tokenizer {

    private List<String> _buffer;		//save text
    private Token currentToken;	//save token extracted from next()

    /**
     *  Tokenizer class constructor
     *  The constructor extracts the first token and save it to currentToken
     *  **** please do not modify this part ****
     */
    public Tokenizer(String text) {
        _buffer = Arrays.asList(text.trim().split(" "));		// save input text (string)
    	next();		// extracts the first token.
    }
    
    /**
     *  This function will find and extract a next token from {@code _buffer} and
     *  save the token to {@code currentToken}.
     */
    public void next() {

        if (_buffer.isEmpty()) {
            currentToken = null;	// if there's no string left, set currentToken null and return
            return;
        }

        String firstWord = _buffer.get(0).trim(); // remove whitespace

        if(firstWord.equals("use"))
        	currentToken = new Token("+", Token.Type.USE);
        if(firstWord.equals("help"))
        	currentToken = new Token("-", Token.Type.HELP);

        if(firstWord.equals("talk"))
            currentToken = new Token("-", Token.Type.TALK);

        if(firstWord.equals("exit") || firstWord.equals("quit"))
            currentToken = new Token("-", Token.Type.EXIT);
       
        // ########## YOUR CODE ENDS HERE ##########
        
        // Remove the extracted token from buffer
        _buffer.remove(0);
    }

    /**
     *  returned the current token extracted by {@code next()}
     *  **** please do not modify this part ****
     *  
     * @return type: Token
     */
    public Token current() {
    	return currentToken;
    }

    /**
     *  check whether there still exists another tokens in the buffer or not
     *  **** please do not modify this part ****
     *  
     * @return type: boolean
     */
    public boolean hasNext() {
    	return currentToken != null;
    }
}