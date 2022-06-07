package hexagon.vecmat.vector;

/**
 * Thrown when an application attempts to perform an undefined
 * operation with vectors.
 * 
 * @author Nico
 */
public class VectorMathException extends RuntimeException {

	/**
	 * Constructs a {@code VectorMathException} with no detail message.
	 */
	public VectorMathException() {
		super();
	}

	/**
	 * Constructs a {@code VectorMathException} with the specified detail message.
	 *
	 * @param message The detail message.
	 */
	public VectorMathException(String message) {
		super(message);
	}

	/**
	 * Constructs a {@code VectorMathException} with the specified detail message and cause.
	 *
	 * @param message The detail message.
	 * @param cause The cause.
	 */
	public VectorMathException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a {@code VectorMathException} with the specified cause.
	 *
	 * @param cause The cause.
	 */
	public VectorMathException(Throwable cause) {
		super(cause);
	}
}
