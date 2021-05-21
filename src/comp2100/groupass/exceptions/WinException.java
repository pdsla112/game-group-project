package comp2100.groupass.exceptions;

/**
 * thrown when player reaches final level
 */
public class WinException extends Exception{
    public WinException(String message) {
        super(message);
    }
}
