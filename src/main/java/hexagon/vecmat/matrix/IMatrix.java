package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.FloatVector;

/** A matrix is a table of numbers arranged in rows and columns. <p>
 *
 * This interface provides methods for operations between matrices.
 *
 * @param <M> The matrix class implementing this interface
 * @param <V> Vector used for some operations
 *
 * @author Nico
 *
 * @see FloatVector
 */
public interface IMatrix<M extends IMatrix<M, V>, V extends FloatVector<V, ?>> {
    
    /** Computes the sum of this matrix and the matrix passed as a parameter.
     * The sum of two matrices of the same size is a matrix where every element is
     * the sum of the corresponding elements in the first two matrices. <p>
     * This method does not change the object on which it is called,
     * calling {@code matrix = leftOperand.plus(rightOperand)} is intended to
     * work similarly as {@code matrix = leftOperand + rightOperand}.
     * @param matrix Right-hand operand of the sum.
     * @return The sum of this matrix and {@code operand}
     */
    M plus(M matrix);
    
    /** Computes the subtraction of this matrix and the matrix passed as a parameter.
     * The difference of two matrices of the same size is a matrix where every element is
     * the difference of the corresponding elements in the first two matrices. <p>
     * This method does not change the object on which it is called,
     * calling {@code matrix = leftOperand.minus(rightOperand)} is intended to
     * work similarly as {@code matrix = leftOperand - rightOperand}.
     * @param matrix Right-hand operand of the subtraction.
     * @return The difference of this matrix and {@code operand}
     */
    M minus(M matrix);
    
    /** Computes the additive inverse of this matrix,
     * a matrix where every element is the inverse of the element in the fist matrix. <p>
     * This method does not change the object on which it is called, it returns a new one instead.
     * @return The negative of this matrix
     */
    M negative();
    
    /** Computes the multiplication of this matrix by a scalar.
     * The product of a matrix and a scalar is a matrix where every element
     * is the product of the element in the first matrix and the scalar. <p>
     * This method does not change the object on which it is called,
     * calling {@code matrix = matrix.times(k)} is intended to
     * work similarly as {@code matrix = matrix * k}.
     * @param constant The real number in the multiplication
     * @return The product of this matrix by the given constant
     */
    M multiply(float constant);
    
    /** Computes the division of this matrix by a scalar.
     * The division of a matrix and a scalar is a matrix where every element
     * is the division of the element in the first matrix and the scalar. <p>
     * This method does not change the object on which it is called,
     * calling {@code matrix = matrix.dividedBy(k)} is intended to
     * work similarly as {@code matrix = matrix / k}.
     * @param constant The real number in the multiplication
     * @return The product of this matrix by the given constant
     */
    default M dividedBy(float constant) {
        return this.multiply(1.0f / constant);
    }
    
    /** Multiplies thi matrix by the given vector. <p>
     * The product of a matrix and a vector is the a vector that is
     * the sum of all the matrix's columns multiplied by every element of the vector.
     * @param vector The vector to multiply
     * @return A vector that is the product of this matrix and the given vector
     */
    V multiply(V vector);
    
    /** Checks if this matrix is a square matrix
     * (i. e.) it has the same number of rows and columns.
     * @return True if the matrix is square, otherwise false
     */
    boolean isSquare();
    
    /** Get a row in the matrix as a vector
     * @param row Index of the row (between 0 and rows-1)
     * @return A row of the matrix as a vector
     * @throws IndexOutOfBoundsException if row < 0 or if row >= rows
     */
    V getRow(int row);
    
    /** Get a column in the matrix as a vector
     * @param column Index of the column (between 0 and columns-1)
     * @return A column of the matrix as a vector
     * @throws IndexOutOfBoundsException if column < 0 or if column >= columns
     */
    V getColumn(int column);
    
    /** Computes the transpose of this matrix.
     * The transpose of a matrix is a matrix obtained by
     * interchanging its rows and columns. <p>
     * This method does not affect the object on which it is called, it returns a new one instead.
     * @return The transpose of this matrix
     */
    M transposed();
    
    /** Checks if this matrix is symmetric.
     * A matrix is symmetric if it's equal to its transpose.
     * @return True if the matrix is symmetric, otherwise false
     */
    boolean isSymmetric();
    
    /** Checks if this matrix is skew-symmetric.
     * A matrix is skew-symmetric if it's equal to its transpose negated.
     * @return True if the matrix is skew-symmetric, otherwise false
     */
    boolean isSkewSymmetric();
    
    /** Multiplies this matrix by the given matrix. <p>
     * The product of two matrices is a matrix where every element {@code (i, j)}
     * is the dot product between the {@code i}-th row of the first matrix
     * and the {@code j}-th row of the second matrix. <br>
     * Two matrices {@code A} and {@code B} can only be multiplied
     * if {@code A} has exactly as many columns as {@code B} has rows.
     * @param matrix The second operand of the multiplication
     * @return The product of the two matrices
     */
    M multiply(M matrix);
    
    /** Computes the power of this matrix. <p>
     * The power {@code n} of a matrix {@code A} is
     * the multiplication {@code A*A*A...} {@code n} times. <br>
     * The power of a matrix is only defined for square matrices.
     * @param exp Exponent
     * @return The {@code n}-th power of this matrix
     */
    M power(int exp);
}
