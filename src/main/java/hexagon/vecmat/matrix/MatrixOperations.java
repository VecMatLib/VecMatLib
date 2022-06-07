package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.VectorOperations;

/**
 * Base interface implemented by all matrix types.
 * Provides the most basic function for matrices that do
 * not require additional information about the matrix's type.
 * 
 * @param <M> The same matrix that implements this interface
 * @param <V> A vector of the same type as this matrix
 * 
 * @author Nico
 */
public interface MatrixOperations<M extends MatrixOperations<M, V>, V extends VectorOperations<V>> {

	/**
	 * Computes the sum of this matrix with the given one.
	 * 
	 * <p> The sum of two matrices m1 and m2 of the same dimensions is
	 * a matrix m3 such that every element m-ij of m3 is the sum of
	 * the element m-ij of m1 and the element m-ij of m2.
	 * 
	 * <p> Matrices are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new matrix instead.
	 * 
	 * @param matrix The second operand of the sum, a matrix of the
	 * 		same type as this one.
	 * 
	 * @return The sum of this matrix and the given one.
	 * 
	 * @throws MatrixMathException If the matrices have different dimensions.
	 * @throws NullPointerException if the given matrix is null.
	 */
	M plus(M matrix);

	/**
	 * Computes the additive inverse of this matrix.
	 * 
	 * <p> The additive inverse of a matrix m is a matrix -m such
	 * that m + (-m) is a matrix where every element m-ij is 0.
	 * 
	 * @return The additive inverse of this matrix.
	 */
	M negative();

	/**
	 * Computes the subtraction of the given matrix from this one.
	 * 
	 * <p> The subtraction of a matrix m2 from a matrix m1 is defined
	 * as the sum of m1 with the additive inverse of m2. That is
	 * m1 - m2 = m1 + (-m2)
	 * 
	 * <p> Matrices are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new matrix instead.
	 * 
	 * @param matrix The second operand of the subtraction, a matrix of the
	 * 		same type as this one.
	 * 
	 * @return The subtraction of this matrix and the given one.
	 * 
	 * @throws MatrixMathException If the matrices have different dimensions.
	 * @throws NullPointerException if the given matrix is null.
	 */
	default M minus(M matrix) {
		return this.plus(matrix.negative());
	}

	/**
	 * Computes the product between this matrix and the given vector.
	 * 
	 * <p> The product between a matrix and a vector is the linear combination
	 * between all the columns of the matrix and all the elements of the vector.
	 * 
	 * <p> The product can also be defined as a vector where every element is
	 * the dot product of the corresponding row of the matrix and the vector.
	 * 
	 * <p> A vector and a matrix can only be multiplied if the matrix has
	 * the same number of columns as the vector has elements.
	 * 
	 * @param vector The second operand of the product, a vector whose size is the
	 * 		same as the number of columns of this matrix.
	 * 
	 * @return The result of the product between this matrix and the given vector.
	 * 
	 * @throws MatrixMathException If the size of the vector does not match the
	 * 		number of columns of this matrix.
	 * @throws NullPointerException if the given vector is null.
	 */
	V multiply(V vector);

	/**
	 * Computes the transposed of this matrix.
	 * 
	 * <p> A transposed matrix is a matrix where every row i is the column i
	 * of the first matrix and every column j is the row j of the first matrix.
	 * 
	 * <p> Matrices are supposed to be immutable. This means that this method
	 * does not alter the object on which it is called, it returns a new matrix
	 * instead.
	 * 
	 * @return The transposed of this matrix.
	 */
	M transposed();

	/**
	 * Computes the negative transposed of this matrix.
	 * 
	 * <p> A transposed matrix is a matrix where every row i is the column i
	 * of the first matrix and every column j is the row j of the first matrix.
	 * 
	 * <p> The additive inverse of a matrix m is a matrix -m such
	 * that m + (-m) is a matrix where every element m-ij is 0.
	 * 
	 * @return The negative transposed of this matrix.
	 */
	default M negativeTransposed() {
		return this.transposed().negative();
	}

	/**
	 * Checks if this matrix is symmetric.
	 * 
	 * <p> A matrix is symmetric if it is equal to its transposed.
	 * In other words, if every element m-ij of this matrix is equal to
	 * the element m-ji of this matrix.
	 * 
	 * <p> In other words, a matrix is symmetric if it is equal to its
	 * transposed.
	 * 
	 * @return True if this matrix is symmetric, false otherwise.
	 */
	default boolean isSymmetric() {
		return this.equals(this.transposed());
	}

	/**
	 * Checks if this matrix is skew-symmetric.
	 * 
	 * <p> A matrix is skew-symmetric if it is equal to its negative transposed.
	 * In other words, if every element m-ij of this matrix is equal to
	 * the element -(m-ji) of this matrix.
	 * 
	 * <p> In other words, a matrix is skew-symmetric if it is equal to its
	 * negative transposed.
	 * 
	 * @return True if this matrix is skew-symmetric, false otherwise.
	 */
	default boolean isSkewSymmetric() {
		return this.equals(this.negativeTransposed());
	}

	/**
	 * Multiplies this matrix by the given one.
	 * 
	 * <p> Two matrices can only be multiplied if the first one has the same number
	 * of rows as the second one has columns.
	 * 
	 * <p> The product between two matrices m1 and m2 is a matrix m3 such that
	 * every element m-ij of m3 is the dot product of the i-th row of m1 and the
	 * j-th column of m2.
	 * 
	 * <p> Matrices are supposed to be immutable. This means that this method
	 * does not alter the object on which it is called, it returns a new matrix
	 * instead.
	 * 
	 * @param matrix The second operand of the product
	 * 
	 * @return The product of this matrix and the given one.
	 * 
	 * @throws MatrixMathException If the number of rows of this matrix does not
	 * 		match the number of columns of the given matrix.
	 * @throws NullPointerException if the given matrix is null.
	 */
	M multiply(M matrix);

	/**
	 * Computes the power of this matrix.
	 * 
	 * <p> The n-th power of a matrix is the product of itself n times.
	 * 
	 * <p> Only square matrices can be raised to a power.
	 * 
	 * <p> Matrices are supposed to be immutable. This means that this method
	 * does not alter the object on which it is called, it returns a new matrix
	 * instead.
	 * 
	 * @param exponent Exponent of the power.
	 * 
	 * @return The n-th power of this matrix.
	 * 
	 * @throws MatrixMathException If this matrix is not square.
	 */
	M power(int exponent);
}
