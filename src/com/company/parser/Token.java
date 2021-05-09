package com.company.parser;

/**
 * Token class to save extracted token from tokenizer.
 * Each token has its surface form saved in {@code _token}
 * and type saved in {@code _type} which is one of the predefined type in Type enum.
 * INT: integer
 * ADD: +
 * SUB: -
 * MUL: *
 * DIV: /
 * LBRA: (
 * RBRA: )
 * 
 */

public class Token {
    
	public enum Type {UNKNOWN, USE, ITEM, TALK, HELP, SAVE, EXIT};
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
