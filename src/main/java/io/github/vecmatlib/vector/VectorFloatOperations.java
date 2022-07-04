package io.github.vecmatlib.vector;

/**
 * Interface that defines all base operations for any float vector.
 * 
 * @param <F> The same vector that implements this interface
 * 
 * @author Nico
 */
public interface VectorFloatOperations<F extends VectorFloatOperations<F>> extends VectorOperations<F> {

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
	 * @param vector The second operand of the sum, a vector of the
	 * 		same size as this one that can be represented as a
	 * 		float vector without casting.
	 * 
	 * @return The sum of this vector and the given one.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	default F plus(VectorAsFloat<F> vector) {
		return this.plus(vector.asFloat());
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
	 * @param vector The second operand of the subtraction, a vector
	 * 		of the same size as this one that can be represented as
	 * 		a float vector without casting.
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	default F minus(VectorAsFloat<F> vector) {
		return this.minus(vector.asFloat());
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
	 * @param k The scalar to which this vector is multiplied.
	 * 
	 * @return The product between this vector and the given scalar.
	 */
	F multipliedBy(float k);

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
	 * @param k The scalar by which this vector is divided.
	 * 
	 * @return The product between this vector and the multiplicative
	 * 		inverse of the given scalar.
	 */
	default F dividedBy(float k) {
		return this.multipliedBy(1.0f / k);
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
	 * @param vector The second operand of the product, another
	 * 		float vector of the same size as this one.
	 * 
	 * @return The result of the dot product between the two vectors.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	float dotProduct(F vector);

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
	 * @param vector The second operand of the product, a vector
	 * 		of the same size as this one that can be represented
	 * 		as a float vector without casting.
	 * 
	 * @return The result of the dot product between the two vectors.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	default float dotProduct(VectorAsFloat<F> vector) {
		return this.dotProduct(vector.asFloat());
	}

	/**
	 * Computes the squared length (or squared magnitude) of this vector.
	 * 
	 * <p> When one needs to compare the length of two vectors, it
	 * is best to use this method instead of {@link #length()}, since
	 * given two numbers a > b, then it also holds that a^2 > b^2, and
	 * this method is more efficient since it does not compute a
	 * square root.
	 * 
	 * @return The squared length (or squared magnitude) of this vector.
	 */
	float lengthSquared();

	@Override
	default double length() {
		return Math.sqrt(this.lengthSquared());
	}
}
