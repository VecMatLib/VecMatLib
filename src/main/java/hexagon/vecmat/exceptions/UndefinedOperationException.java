package hexagon.vecmat.exceptions;

/**Thrown when the performed operation is not defined in a particular case.
 * For example, summing two vectors of different dimensions
 * throws an instance of this class.
 */
public class UndefinedOperationException extends RuntimeException {

    /**Constructs a new undefined operation exception with the specified detail message
     * @param message The detail message
     */
    public UndefinedOperationException(String message) {
        super(message);
    }

    /**Constructs a new undefined operation exception without specifying any operation. <br>
     * Gives the message "Operation is not defined".
     */
    public UndefinedOperationException() {
        super("Operation is not defined");
    }
}
