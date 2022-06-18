package io.github.hexagonnico.vecmat.matrix;

/**
 * Thrown when an application attempts to perform an undefined
 * operation with matrices.
 * 
 * @author Nico
 */
public class MatrixMathException extends RuntimeException {

	/**
	 * Constructs a {@code MatrixMathException} with no detail message.
	 */
	public MatrixMathException() {
		super();
	}

	/**
	 * Constructs a {@code MatrixMathException} with the specified detail message.
	 *
	 * @param message The detail message.
	 */
	public MatrixMathException(String message) {
		super(message);
	}

	/**
	 * Constructs a {@code MatrixMathException} with the specified detail message and cause.
	 *
	 * @param message The detail message.
	 * @param cause The cause 
	 */
	public MatrixMathException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs a {@code MatrixMathException} with the specified cause.
	 *
	 * @param cause The cause 
	 */
	public MatrixMathException(Throwable cause) {
		super(cause);
	}
}
