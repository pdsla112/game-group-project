package comp2100.groupass.exceptions;

/**
 * thrown if player dies
 */
public class DeathException extends Exception{
    public DeathException(String message) {
        super(message);
    }
}
