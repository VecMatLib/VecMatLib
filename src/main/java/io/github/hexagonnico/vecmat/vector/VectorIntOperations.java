package io.github.hexagonnico.vecmat.vector;

/**
 * Interface that defines all base operations for integer vectors.
 * 
 * @param <I> The same vector that implements this interface
 * 
 * @author Nico
 */
public interface VectorIntOperations<I extends VectorIntOperations<I>> extends VectorOperations<I> {

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
	 * @param k The scalar by which this vector is divided.
	 * 
	 * @return The result of the integer division between this
	 * 		vector and the given scalar.
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
	 * <p> The dot product can only be computed between two vectors
	 * of the same size.
	 * 
	 * @param vector The second operand of the product, another
	 * 		integer vector of the same size as this one.
	 * 
	 * @return The result of the dot product between the two vectors.
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes.
	 * @throws NullPointerException if the given vector is null.
	 */
	int dotProduct(I vector);

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
	int lengthSquared();

	@Override
	default double length() {
		return Math.sqrt(this.lengthSquared());
	}
}
