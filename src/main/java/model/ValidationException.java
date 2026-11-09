package model;

/**
 * Exception thrown when the data entered by the user does not meet a
 * business rule (for example, an empty title or a duplicated room number).
 * <p>
 * It is a checked exception, so every method that validates data must declare
 * it and every controller must handle it, usually by showing its message to
 * the user.
 *
 * @author Matias Rosas
 * @author Camila Larsen
 * @author Matias Nerli
 * @version 1.0
 */
public class ValidationException extends Exception {

    /**
     * Creates a new exception with a message that can be shown to the user.
     *
     * @param message the description of the validation error
     */
    public ValidationException(String message) {
        super(message);
    }
}
