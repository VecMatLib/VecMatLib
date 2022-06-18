package io.github.hexagonnico.vecmat.vector;

/**
 * Base interface implemented by all vector types.
 * Provides the most basic function for vectors that do
 * not require additional information about the vector's type.
 * 
 * @param <V> The same vector that implements this interface
 * 
 * @author Nico
 */
public interface VectorOperations<V extends VectorOperations<V>> {

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
	 * 		same type and same size as this one.
	 * 
	 * @return The sum of this vector and the given one.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	V plus(V vector);

	/**
	 * Computes the additive inverse of this vector.
	 * 
	 * <p> The additive inverse of a vector v is a vector -v such
	 * that v + (-v) is a vector where every element i is 0.
	 * 
	 * @return The additive inverse of this vector.
	 */
	V negated();

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
	 * 		of the same type and same size as this one.
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	default V minus(V vector) {
		return this.plus(vector.negated());
	}

	/**
	 * Computes the length (or magnitude) of this vector.
	 * 
	 * <p> The length (or magnitude) of a vector is the distance
	 * between the initial point and the endpoint of a vector, or
	 * the distance between the origin of the vector space and
	 * the vector in standard position.
	 * 
	 * @return The length (or magnitude) of this vector.
	 */
	double length();
}
