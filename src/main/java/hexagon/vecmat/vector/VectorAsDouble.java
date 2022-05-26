package hexagon.vecmat.vector;

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
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> The sum of this vector and a double vector will result
	 * in a double vector.
	 * 
	 * <p> If the given vector is null, in the case of fixed-size
	 * vectors it will be treated as a vector where every element
	 * is 0. In the case of vectors of unknown size, this will
	 * throw an exception, since it is not possible to check if the
	 * two vectors have the same size.
	 * 
	 * @param vector The second operand of the sum, a double vector
	 * 
	 * @return The sum of this vector and the given one or the same
	 * 		vector if the given one is null and this is a fixed-size
	 * 		vector
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
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
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> The subtraction between this vector and a double vector
	 * will result in a double vector.
	 * 
	 * <p> If the given vector is null, in the case of fixed-size
	 * vectors it will be treated as a vector where every element
	 * is 0. In the case of vectors of unknown size, this will
	 * throw an exception, since it is not possible to check if the
	 * two vectors have the same size.
	 * 
	 * @param vector The second operand of the subtraction, a double
	 * 		vector
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one or the same vector if the given one is null and
	 * 		this is a fixed-size vector
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
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
	 * @param k The scalar to which this vector is multiplied
	 * 
	 * @return The product between this vector and the given scalar
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
	 * @param k The scalar by which this vector is divided
	 * 
	 * @return The product between this vector and the multiplicative
	 * 		inverse of the given scalar
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
	 * <p> The dot product between this vector and a double vector
	 * will result in a double.
	 * 
	 * <p> If the given vector is null, in the case of fixed-size
	 * vectors it will be treated as a vector where every element
	 * is 0. In the case of vectors of unknown size, this will
	 * throw an exception, since it is not possible to check if the
	 * two vectors have the same size.
	 * 
	 * @param vector The second operand of the product, another
	 * 		double vector
	 * 
	 * @return The result of the dot product between the two vectors
	 * 		or 0 if the given vector is null
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 */
	default double dotProduct(D vector) {
		return this.asDouble().dotProduct(vector);
	}

	/**
	 * TODO
	 * @return
	 */
	default D normalized() {
		return this.asDouble().normalized();
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param vector The second vector
	 * 
	 * @return The angle in radians between this vector and the given one
	 */
	default double angle(D vector) {
		return this.asDouble().angle(vector);
	}

	/**
	 * TODO
	 * @param vector
	 * @return
	 */
	default double angle(VectorAsDouble<D> vector) {
		return vector != null ? this.angle(vector.asDouble()) : Double.NaN;
	}

	/**
	 * Converts this vector to a double without casting.
	 * 
	 * @return The double value of this vector
	 */
	D asDouble();
}
