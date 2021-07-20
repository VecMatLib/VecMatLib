package hexagon.vecmat.exceptions;

/**Thrown when the given size for vectors or tuples is not valid.
 * For example, creating a vector with no elements
 * throws an instance of this class.
 */
public class VectorSizeException extends RuntimeException {

    /**Constructs a vector size exception with the specified error message.
     * @param message The detail message
     */
    public VectorSizeException(String message) {
        super(message);
    }
}
