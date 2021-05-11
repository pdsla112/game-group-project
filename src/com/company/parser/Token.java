package com.company.parser;
 /*
    sentence = verbG1 objectG1 | verbG2 objectG2 | verbG3 objectG3 | verbG4 [prepositionG1] objectG4
    verbG1 = "exit" | "save"
    verbG2 = "examine"
    verbG3 = "use"
    verbG4 = "look"
    prepositionG1 = "above" | "below" | "inside" (get options from levelnode)
    objectG1 = [determinerG1] nounG1
    objectG2 = [determinerG2] nounG2
    objectG3 = [determinerG2] nounG3
    objectG4 = [determinerG2] nounG4
    determinerG1 = "the"
    determinerG2 = "your"
    nounG1 = "game"
    nounG2 = "items" | "stats" | "surroundings"
    nounG3 = item name e.g. medkit
    nounG4 = furniture
    */



public class Token {
    
	public enum Type {UNKNOWN, VERBG1, VERBG2, VERBG3, VERBG4, PREPOSITIONG1, DETERMINERG1, DETERMINERG2, NOUNG1, NOUNG2, NOUNG3, NOUNG4};
    private String _token = "";
    private Type _type = Type.UNKNOWN;
    
    public Token(String token, Type type) {
        _token = token;
        _type = type;
    }
    
    public String token() {
        return _token;
    }
    
    public Type type() {
        return _type;
    }
}
