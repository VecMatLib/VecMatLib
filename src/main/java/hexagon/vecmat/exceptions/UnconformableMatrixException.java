package hexagon.vecmat.exceptions;

import hexagon.vecmat.matrix.Matrix;
import hexagon.vecmat.vector.FloatN;

/**Thrown when multiplying two matrices that are not conformable.
 * Two matrices are conformable if the first one has exactly has
 * many columns as the second one has rows.
 */
public class UnconformableMatrixException extends RuntimeException {

    /**Constructs an {@code UnconformableMatrixException} whose detail
     * message specifies the two given matrices are not conformable.
     * @param matA First matrix
     * @param matB Second matrix
     */
    public UnconformableMatrixException(Matrix matA, Matrix matB) {
        super("Matrix " + matA.rows + "x" + matA.columns + " and matrix " + matB.rows + "x" + matB.columns + " cannot be multiplied");
    }

    /**Constructs an {@code UnconformableMatrixException} whose detail
     * message specifies the given matrix and vector are not conformable.
     * @param matrix Matrix
     * @param vector Vector
     */
    public UnconformableMatrixException(Matrix matrix, FloatN vector) {
        super("Matrix " + matrix.rows + "x" + matrix.columns + " and vector 1x" + vector.size() + " cannot be multiplied");
    }

    /**Constructs an {@code UnconformableMatrixException} with a specific error message.
     * @param message The detail message
     */
    public UnconformableMatrixException(String message) {
        super(message);
    }
}
