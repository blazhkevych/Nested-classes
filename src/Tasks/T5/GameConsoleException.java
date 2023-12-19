package Tasks.T5;

/**
 * The {@code GameConsoleException} class represents an exception that is thrown when a game console is not powered on.
 */
public class GameConsoleException extends Exception {
    public GameConsoleException(String message) {
        super(message);
    }
}
