package hexagon.vecmat.vector;

/**
 * Interface that defines all base operations for any float vector.
 * 
 * @param <F> The same vector that implements this interface
 * @param <D> A double vector of the same size as this one
 * @param <I> An int vector of the same size as this one
 * 
 * @author Nico
 */
public interface VectorFloatOperations<F extends VectorFloatOperations<F, D, I>, D extends VectorDoubleOperations<D, F, I>, I extends VectorIntOperations<I, F, D>> extends VectorOperations<F>, VectorAsDouble<D> {

	/**
	 * Computes the sum of this vector with the given one.
	 * 
	 * <p> The sum of two vectors v1 and v2 of the same size is
	 * a vector v3 such that every i-th element of v3 is the
	 * sum of the i-th element of v1 and the i-th element of v2.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> If the given vector is null, in the case of fixed-size
	 * vectors it will be treated as a vector where every element
	 * is 0. In the case of vectors of unknown size, this will
	 * throw an exception, since it is not possible to check if the
	 * two vectors have the same size.
	 * 
	 * @param vector The second operand of the sum, a vector
	 * 		that can be represented as a float vector without casting
	 * 
	 * @return The sum of this vector and the given one or the same
	 * 		vector if the given one is null and this is a fixed-size
	 * 		vector
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 */
	default F plus(VectorAsFloat<F> vector) {
		return vector != null ? this.plus(vector.asFloat()) : this.multipliedBy(1);
	}

	/**
	 * Computes the subtraction of the given vector from this one.
	 * 
	 * <p> The subtraction of a vector v2 from a vector v1 is defined
	 * as the sum of v1 with the additive inverse of v2. That is
	 * v1 - v2 = v1 + (-v2)
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> If the given vector is null, in the case of fixed-size
	 * vectors it will be treated as a vector where every element
	 * is 0. In the case of vectors of unknown size, this will
	 * throw an exception, since it is not possible to check if the
	 * two vectors have the same size.
	 * 
	 * @param vector The second operand of the subtraction, a vector
	 * 		that can be represented as a float vector without casting
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one or the same vector if the given one is null and
	 * 		this is a fixed-size vector
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 */
	default F minus(VectorAsFloat<F> vector) {
		return vector != null ? this.minus(vector.asFloat()) : this.multipliedBy(1);
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
	 * @param k The scalar to which this vector is multiplied
	 * 
	 * @return The product between this vector and the given scalar
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
	 * @param k The scalar by which this vector is divided
	 * 
	 * @return The product between this vector and the multiplicative
	 * 		inverse of the given scalar
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
	 * <p> If the given vector is null, in the case of fixed-size
	 * vectors it will be treated as a vector where every element
	 * is 0. In the case of vectors of unknown size, this will
	 * throw an exception, since it is not possible to check if the
	 * two vectors have the same size.
	 * 
	 * @param vector The second operand of the product, another
	 * 		float vector
	 * 
	 * @return The result of the dot product between the two vectors
	 * 		or 0 if the given vector is null
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
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
	 * <p> If the given vector is null, in the case of fixed-size
	 * vectors it will be treated as a vector where every element
	 * is 0. In the case of vectors of unknown size, this will
	 * throw an exception, since it is not possible to check if the
	 * two vectors have the same size.
	 * 
	 * @param vector The second operand of the product, a vector
	 * 		that can be represented as a float vector without casting
	 * 
	 * @return The result of the dot product between the two vectors
	 * 		or 0 if the given vector is null
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 */
	default float dotProduct(VectorAsFloat<F> vector) {
		return vector != null ? this.dotProduct(vector.asFloat()) : 0.0f;
	}

	/**
	 * Computes the squared length (or squared magnitude) of this vector.
	 * 
	 * <p> When the user needs to compare the length of two vectors, it
	 * is best to use this method instead of {@link #length()}, since
	 * given two numbers a > b, then it also holds that a^2 > b^2, and
	 * this method is more efficient since it does not compute a
	 * square root.
	 * 
	 * @return The squared length (or squared magnitude) of this vector
	 */
	float lengthSquared();

	@Override
	default double length() {
		return Math.sqrt(this.lengthSquared());
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
		return this.dividedBy(this.length());
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param vector The second vector
	 * 
	 * @return The angle in radians between this vector and the given one
	 */
	default double angle(VectorAsDouble<D> vector) {
		return this.angle(vector.asDouble());
	}

	/**
	 * Casts this float vector to an integer vector.
	 * 
	 * <p> This methods casts all the values of this vector to int and
	 * returns an integer vector.
	 * 
	 * @return A vector whose values are this vector's values cast to int
	 */
	I castToInt();
}