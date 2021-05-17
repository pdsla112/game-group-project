package com.company.exceptions;

/**
 * thrown if player dies
 */
public class DeathException extends Exception{
    public DeathException(String message) {
        super(message);
    }
}
