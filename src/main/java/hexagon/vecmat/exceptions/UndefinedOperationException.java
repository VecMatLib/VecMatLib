package hexagon.vecmat.exceptions;

/**
 * Thrown when the performed operation is not defined in a particular case.
 * For example, summing two vectors of different dimensions
 * throws an instance of this class.
 */
public class UndefinedOperationException extends RuntimeException {

    /**
     * Constructs a new undefined operation exception for the given operation. <br>
     * Gives a message in the form "{@code operation} is not defined for {@code reason}".
     * @param operation Operation performed
     * @param reason Explanation for why the operation is not defined
     */
    public UndefinedOperationException(String operation, String reason) {
        super(operation + " is not a defined for " + reason);
    }

    /**
     * Constructs a new undefined operation exception for the given operation. <br>
     * Gives a message in the form "{@code operation} is not defined".
     * @param operation Operation performed
     */
    public UndefinedOperationException(String operation) {
        super(operation + " is not defined");
    }

    /**
     * Constructs a new undefined operation exception without specifying any operation. <br>
     * Gives the message "Operation is not defined".
     */
    public UndefinedOperationException() {
        super("Operation is not defined");
    }
}
