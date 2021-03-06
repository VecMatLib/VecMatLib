package io.github.vecmatlib.vector;

/**
 * Interface to be implemented by a vector that can be represented as
 * a double vector without casting.
 * 
 * @param <D> A double vector of the same size as this one
 * 
 * @author Nico
 */
public interface VectorAsDouble<D extends VectorDoubleOperations<D>> {

	/**
	 * Computes the sum of this vector with the given one.
	 * 
	 * <p> The sum of two vectors v1 and v2 of the same size is
	 * a vector v3 such that every i-th element of v3 is the
	 * sum of the i-th element of v1 and the i-th element of v2.
	 * 
	 * <p> Two vectors can only be summed if their size is the same.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> The sum of this vector and a double vector will result
	 * in a double vector.
	 * 
	 * @param vector The second operand of the sum, a double vector
	 * 		of the same size as this one.
	 * 
	 * @return The sum of this vector and the given one.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	default D plus(D vector) {
		return this.asDouble().plus(vector);
	}

	/**
	 * Computes the subtraction of the given vector from this one.
	 * 
	 * <p> The subtraction of a vector v2 from a vector v1 is defined
	 * as the sum of v1 with the additive inverse of v2. That is
	 * v1 - v2 = v1 + (-v2)
	 * 
	 * <p> Two vectors can only be subtracted if their size is the same.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> The subtraction between this vector and a double vector
	 * will result in a double vector.
	 * 
	 * @param vector The second operand of the subtraction, a double
	 * 		vector of the same size as this one.
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	default D minus(D vector) {
		return this.asDouble().minus(vector);
	}

	/**
	 * Computes the multiplication between this vector and a scalar.
	 * 
	 * <p> The product between a vector v and a scalar k is a vector
	 * where every element i is the i-th element of v multiplied by k.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> Multiplying this vector by a double will result in a
	 * double vector.
	 * 
	 * @param k The scalar to which this vector is multiplied.
	 * 
	 * @return The product between this vector and the given scalar.
	 */
	default D multipliedBy(double k) {
		return this.asDouble().multipliedBy(k);
	}

	/**
	 * Computes the division between this vector and a scalar.
	 * 
	 * <p> The division of a vector v by a scalar k is defined as
	 * the multiplication between v and the multiplicative
	 * inverse 1/k. See {@link #multipliedBy(double)}.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> Dividing this vector by a double will result in a
	 * double vector.
	 * 
	 * @param k The scalar by which this vector is divided.
	 * 
	 * @return The product between this vector and the multiplicative
	 * 		inverse of the given scalar.
	 */
	default D dividedBy(double k) {
		return this.asDouble().dividedBy(k);
	}

	/**
	 * Computes the dot product (or scalar product) between this
	 * vector and the given one.
	 * 
	 * <p> The dot product between two vectors v and w of the same
	 * size is a scalar defined as the summation of the products of
	 * every element vi and wi of the two vectors.
	 * 
	 * <p> The dot product can only be computed between two vectors
	 * of the same size.
	 * 
	 * <p> The dot product between this vector and a double vector
	 * will result in a double.
	 * 
	 * @param vector The second operand of the product, a double
	 * 		vector of the same size as this one.
	 * 
	 * @return The result of the dot product between the two vectors.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	default double dotProduct(D vector) {
		return this.asDouble().dotProduct(vector);
	}

	/**
	 * Normalizes this vector.
	 * 
	 * <p> A normalized vector is a vector of length 1.
	 * 
	 * <p> This method returns a vector with the same direction as the
	 * first one but with length 1.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * @return A double vector that has the same direction as this one
	 * 		but length 1.
	 */
	default D normalized() {
		return this.asDouble().normalized();
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param vector The second vector.
	 * 
	 * @return The angle in radians between this vector and the given one.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	default double angle(D vector) {
		return this.asDouble().angle(vector);
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param vector The second vector, a vector that can be represented
	 * 		as a double vector without casting.
	 * 
	 * @return The angle in radians between this vector and the given one.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	default double angle(VectorAsDouble<D> vector) {
		return this.angle(vector.asDouble());
	}

	/**
	 * Converts this vector to a double without casting.
	 * 
	 * @return The double value of this vector.
	 */
	D asDouble();
}
