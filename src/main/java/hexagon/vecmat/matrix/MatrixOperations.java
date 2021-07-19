package hexagon.vecmat.matrix;

import hexagon.vecmat.BaseOperations;
import hexagon.vecmat.exceptions.UnconformableMatrixException;
import hexagon.vecmat.vector.VectorOperations;

public interface MatrixOperations<M extends BaseOperations<M, Float>, V extends VectorOperations<V>> extends BaseOperations<M, Float> {

    /**
     * Multiplies this matrix by the given vector.
     * <p>
     *     The product of a matrix by a vector is a vector
     *     that is the combination of the matrix's columns
     * </p>
     * @param vector The vector that multiply this matrix
     * @return The vector result of the multiplication of this matrix and the given vector
     */
    V multiply(V vector);

    /**
     * Checks if this matrix is a square matrix.
     * <p>
     *     A matrix is square if it has the same number of rows and columns
     * </p>
     * @return True if this is a square matrix, false if it's rectangular
     */
    boolean isSquare();

    /**
     * Gets a row from the matrix
     *
     * @param row Index of the row to get (between 0 and rows-1)
     * @return A vector representing the requested row
     */
    V getRow(int row);

    /**
     * Gets a column from the matrix
     *
     * @param column Index of the column to get (between 0 and columns-1)
     * @return A vector representing the requested column
     */
    V getColumn(int column);

    /**
     * Gets the transpose of this matrix.
     * <p>
     *     The transpose of a matrix is a matrix obtained by
     *     interchanging its rows and columns.
     * </p>
     * @return The transpose of this matrix
     */
    M transposed();

    /**
     * Checks if this matrix is symmetric
     * <p>
     *     A matrix is symmetric if it's equal to its transpose
     * </p>
     * @return True if this matrix is symmetric, otherwise false
     */
    boolean isSymmetric();

    /**
     * Checks if this matrix is skew-symmetric
     * <p>
     *     A matrix is skew-symmetric if it's equal to its transpose negated
     * </p>
     * @return True if this matrix is skew-symmetric, otherwise false
     */
    boolean isSkewSymmetric();

    /**
     * Multiplies this matrix by the given matrix.
     * <p>
     *     The product of two matrices is a matrix where every element {@code (i, j)}
     *     is the dot product between the {@code i}-th row of the first matrix
     *     and the {@code j}-th row of the second matrix. <br>
     *         Two matrices {@code A} and {@code B} can only be multiplied
     *         if {@code A} has exactly as many columns as {@code B} has rows
     * </p>
     * @param matrix The second operand of the multiplication
     * @throws UnconformableMatrixException
     * if this matrix is not conformable with the given one
     * @return The product of the two matrices
     */
    M multiply(M matrix);

    /**
     * Computes the power of this matrix.
     * <p>
     *     The power {@code n} of a matrix {@code A} is
     *     the multiplication {@code A*A*A...} {@code n} times. <br>
     *         The power of a matrix is only defined for square matrices.
     * </p>
     * @param exp Exponent
     * @throws UnconformableMatrixException
     * if this matrix is not square
     * @return The {@code n}-th power of this matrix
     */
    M power(int exp);
}
