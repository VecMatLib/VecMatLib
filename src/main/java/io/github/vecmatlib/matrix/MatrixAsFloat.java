package io.github.vecmatlib.matrix;

import io.github.vecmatlib.vector.VectorFloatOperations;

/**
 * Interface to be implemented by a matrix that can be represented as
 * a float matrix without casting.
 * 
 * @param <M> A float matrix of the same size as this one
 * @param <V> A vector of the same type as that matrix
 * 
 * @author Nico
 */
public interface MatrixAsFloat<M extends MatrixFloatOperations<M, V>, V extends VectorFloatOperations<V>> {

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
	 * <p> The sum of this matrix and a float matrix is a float matrix.
	 * 
	 * @param matrix The second operand of the sum, a float matrix.
	 * 
	 * @return The sum of this matrix and the given one.
	 * 
	 * @throws MatrixMathException If the matrices have different dimensions.
	 * @throws NullPointerException if the given matrix is null.
	 */
	default M plus(M matrix) {
		return this.asFloat().plus(matrix);
	}

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
	 * <p> The subtraction of this matrix and a float matrix is a float matrix.
	 * 
	 * @param matrix The second operand of the subtraction, a float matrix.
	 * 
	 * @return The subtraction of this matrix and the given one.
	 * 
	 * @throws MatrixMathException If the matrices have different dimensions.
	 * @throws NullPointerException if the given matrix is null.
	 */
	default M minus(M matrix) {
		return this.asFloat().minus(matrix);
	}

	/**
	 * Multiplies this matrix with the given scalar.
	 * 
	 * <p> The product of a matrix m and a scalar k is a matrix m' such that
	 * every element m'-ij is the product of the element m-ij and k.
	 * 
	 * <p> The product of this matrix and a float scalar is a float matrix.
	 * 
	 * <p> Matrices are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new matrix instead.
	 * 
	 * @param k The scalar to which this matrix is multiplied.
	 * 
	 * @return The product of this matrix and the given scalar.
	 */
	default M multipliedBy(float k) {
		return this.asFloat().multipliedBy(k);
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
	 * <p> The product of this matrix and a float vector is a float vector.
	 * 
	 * @param vector The second operand of the product, a float vector.
	 * 
	 * @return The result of the product between this matrix and the given vector.
	 * 
	 * @throws MatrixMathException If the size of the vector does not match the
	 * 		number of columns of this matrix.
	 * @throws NullPointerException if the given vector is null.
	 */
	default V multiply(V vector) {
		return this.asFloat().multiply(vector);
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
	 * <p> The product of this matrix and a float matrix is a float matrix.
	 * 
	 * @param matrix The second operand of the product, a float matrix.
	 * 
	 * @return The product of this matrix and the given one.
	 * 
	 * @throws MatrixMathException If the number of rows of this matrix does not
	 * 		match the number of columns of the given matrix.
	 * @throws NullPointerException if the given matrix is null.
	 */
	default M multiply(M matrix) {
		return this.asFloat().multiply(matrix);
	}

	/**
	 * Converts this matrix to a float matrix without casting.
	 * 
	 * @return The float value of this matrix
	 */
	M asFloat();
}
