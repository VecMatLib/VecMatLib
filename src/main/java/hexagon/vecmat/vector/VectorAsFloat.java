package hexagon.vecmat.vector;

/**
 * Interface to be implemented by a vector that can be represented as
 * a float vector without casting.
 * 
 * @param <F> A float vector of the same size as this one
 * 
 * @author Nico
 */
public interface VectorAsFloat<F extends VectorFloatOperations<F>> {

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
	 * <p> The sum of this vector and a float vector will result
	 * in a float vector.
	 * 
	 * <p> If the given vector is null, it will be treated as a
	 * vector where every element is 0. Which means this method
	 * will return a vector equal to this one.
	 * 
	 * @param vector The second operand of the sum, a float vector
	 * 		of the same size as this one.
	 * 
	 * @return The sum of this vector and the given one or the same
	 * 		vector if the given one is null.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 */
	default F plus(F vector) {
		return this.asFloat().plus(vector);
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
	 * <p> The subtraction between this vector and a float vector
	 * will result in a float vector.
	 * 
	 * <p> If the given vector is null, it will be treated as a
	 * vector where every element is 0. Which means this method
	 * will return a vector equal to this one.
	 * 
	 * @param vector The second operand of the subtraction, a float
	 * 		vector of the same size as this one.
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one or the same vector if the given one is null.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 */
	default F minus(F vector) {
		return this.asFloat().minus(vector);
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
	 * <p> Multiplying this vector by a float will result in a
	 * float vector.
	 * 
	 * @param k The scalar to which this vector is multiplied
	 * 
	 * @return The product between this vector and the given scalar
	 */
	default F multipliedBy(float k) {
		return this.asFloat().multipliedBy(k);
	}

	/**
	 * Computes the division between this vector and a scalar.
	 * 
	 * <p> The division of a vector v by a scalar k is defined as
	 * the multiplication between v and the multiplicative
	 * inverse 1/k. See {@link #multipliedBy(float)}.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> Dividing this vector by a float will result in a
	 * float vector.
	 * 
	 * @param k The scalar by which this vector is divided
	 * 
	 * @return The product between this vector and the multiplicative
	 * 		inverse of the given scalar
	 */
	default F dividedBy(float k) {
		return this.asFloat().dividedBy(k);
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
	 * <p> The dot product between this vector and a float vector
	 * will result in a float.
	 * 
	 * <p> If the given vector is null, it will be treated as a
	 * vector where every element is 0. Which means this method
	 * will return 0.
	 * 
	 * @param vector The second operand of the product, a float
	 * 		vector of the same size as this one.
	 * 
	 * @return The result of the dot product between the two vectors
	 * 		or 0 if the given vector is null.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 */
	default float dotProduct(F vector) {
		return this.asFloat().dotProduct(vector);
	}

	/**
	 * Converts this vector to a float vector without casting.
	 * 
	 * @return The float value of this vector
	 */
	F asFloat();
}
