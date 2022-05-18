package hexagon.vecmat.vector;

/**
 * Interface that defines all base operations for integer vectors.
 * 
 * @param <I> The same vector that implements this interface
 * @param <F> A float vector of the same size as this one
 * @param <D> A double vector of the same size as this one
 * 
 * @author Nico
 */
public interface VectorIntOperations<I extends VectorIntOperations<I, F, D>, F extends VectorFloatOperations<F, D, I>, D extends VectorDoubleOperations<D, F, I>> extends VectorOperations<I>, VectorAsDouble<D>, VectorAsFloat<F> {

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
	I multipliedBy(int k);

	/**
	 * Computes the integer division between this vector and a scalar.
	 * 
	 * <p> Dividing an integer vector by an integer number performs an
	 * integer division: the result of this method is still an integer
	 * vector.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * @param k The scalar by which this vector is divided
	 * 
	 * @return The result of the integer division between this
	 * 		vector and the given scalar
	 */
	I dividedBy(int k);

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
	 * 		integer vector
	 * 
	 * @return The result of the dot product between the two vectors
	 * 		or 0 if the given vector is null
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 */
	int dotProduct(I vector);

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
	int lengthSquared();

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
}