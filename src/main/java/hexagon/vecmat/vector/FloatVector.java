package hexagon.vecmat.vector;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Class that represents an N-dimensional float vector.
 * 
 * @author Nico
 */
public final class FloatVector implements VectorFloatOperations<FloatVector>, VectorAsDouble<DoubleVector> {

	/**Vector values */
	private float[] values;

	/**
	 * Creates a vector with the values in the given array.
	 * 
	 * @param vector Values in the vector
	 * 
	 * @throws VectorMathException if the given array is null or has length 0
	 */
	public FloatVector(float... vector) {
		if(vector == null || vector.length == 0) {
			throw new VectorMathException("A vector cannot be null or empty");
		}
		this.values = vector;
	}

	/**
	 * Creates a vector with the values in the given array.
	 * 
	 * @param vector Values in the vector
	 * 
	 * @throws VectorMathException if the given array is null or has length 0
	 */
	public FloatVector(Float... vector) {
		if(vector == null || vector.length == 0) {
			throw new VectorMathException("A vector cannot be null or empty");
		}
		this.values = new float[vector.length];
		for(int i = 0; i < vector.length; i++) {
			this.values[i] = vector[i].floatValue();
		}
	}

	/**
	 * Gets the size of this vector.
	 * 
	 * @return The size of this vector
	 */
	public int size() {
		return this.values.length;
	}

	/**
	 * Get the i-th element of this vector.
	 * 
	 * @param i Index of the element to get
	 * 
	 * @return The i-th element of this vector
	 * 
	 * @throws IndexOutOfBoundsException if the given i is less than 0
	 * 		or greater than the vector's size
	 */
	public float element(int i) {
		if(i >= 0 && i < this.size()) {
			return this.values[i];
		} else {
			throw new IndexOutOfBoundsException(i + " is out of the bounds of the vector");
		}
	}

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
	 * @param vector The second operand of the sum, a float
	 * 		vector of the same size as this one
	 * 
	 * @return The sum of this vector and the given one
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public FloatVector plus(float... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] + vector[i]);
	}

	@Override
	public FloatVector plus(FloatVector vector) {
		return this.plus(vector != null ? vector.values : new float[0]);
	}

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
	 * <p> The sum of this vector and an integer vector will result
	 * in a float vector.
	 * 
	 * @param vector The second operand of the sum, an integer
	 * 		vector of the same size as this one
	 * 
	 * @return The sum of this vector and the given one
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public FloatVector plus(int... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] + vector[i]);
	}

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
	 * @param vector The second operand of the sum, a double
	 * 		vector of the same size as this one
	 * 
	 * @return The sum of this vector and the given one
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public DoubleVector plus(double... vector) {
		return this.asDouble().plus(vector);
	}

	@Override
	public FloatVector negated() {
		return this.applyOperation(v -> -v);
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
	 * @param vector The second operand of the subtraction, an integer
	 * 		vector of the same size as this one
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public FloatVector minus(float... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] - vector[i]);
	}

	@Override
	public FloatVector minus(FloatVector vector) {
		return this.minus(vector != null ? vector.values : new float[0]);
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
	 * <p> The subtraction between this vector and an integer vector
	 * will result in a float vector.
	 * 
	 * @param vector The second operand of the subtraction, an integer
	 * 		vector of the same size as this one
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public FloatVector minus(int... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] - vector[i]);
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
	 * @param vector The second operand of the subtraction, a double
	 * 		vector of the same size as this one
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public DoubleVector minus(double... vector) {
		return this.asDouble().minus(vector);
	}

	@Override
	public FloatVector multipliedBy(float k) {
		return this.applyOperation(v -> v * k);
	}

	/**
	 * Computes the dot product (or scalar product) between this
	 * vector and the given one.
	 * 
	 * <p> The dot product between two vectors v and w of the same
	 * size is a scalar defined as the summation of the products of
	 * every element vi and wi of the two vectors.
	 * 
	 * @param vector The second operand of the product, another
	 * 		float vector
	 * 
	 * @return The result of the dot product between the two vectors
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public float dotProduct(float... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).reduce(0.0f, (v1, v2) -> v1 + v2);
	}

	@Override
	public float dotProduct(FloatVector vector) {
		return this.dotProduct(vector != null ? vector.values : new float[0]);
	}

	/**
	 * Computes the dot product (or scalar product) between this
	 * vector and the given one.
	 * 
	 * <p> The dot product between two vectors v and w of the same
	 * size is a scalar defined as the summation of the products of
	 * every element vi and wi of the two vectors.
	 * 
	 * <p> The dot product between this vector and an integer vector
	 * will result in a float.
	 * 
	 * @param vector The second operand of the product, an
	 * 		integer vector
	 * 
	 * @return The result of the dot product between the two vectors
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public float dotProduct(int... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).reduce(0.0f, (v1, v2) -> v1 + v2);
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
	 * @param vector The second operand of the product, a
	 * 		double vector
	 * 
	 * @return The result of the dot product between the two vectors
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public double dotProduct(double... vector) {
		return this.asDouble().dotProduct(vector);
	}

	@Override
	public float lengthSquared() {
		return this.dotProduct(this);
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param vector The second vector
	 * 
	 * @return The angle in radians between this vector and the given one
	 */
	public double angle(double... vector) {
		return this.angle(new DoubleVector(vector));
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param vector The second vector
	 * 
	 * @return The angle in radians between this vector and the given one
	 */
	public double angle(float... vector) {
		return this.angle(new FloatVector(vector));
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param vector The second vector
	 * 
	 * @return The angle in radians between this vector and the given one
	 */
	public double angle(int... vector) {
		return this.angle(new IntVector(vector));
	}

	/**
	 * Casts this vector to an int vector.
	 * 
	 * @return A vector with the same elements as this vector casted to int.
	 */
	public IntVector castToInt() {
		return new IntVector(IntStream.range(0, this.size()).mapToObj(i -> this.values[i]).mapToInt(f -> f.intValue()).toArray());
	}

	@Override
	public DoubleVector asDouble() {
		return new DoubleVector(IntStream.range(0, this.size()).mapToObj(i -> this.values[i]).mapToDouble(f -> f.doubleValue()).toArray());
	}

	/**
	 * Utility method that applies an operation to all values of the array.
	 * 
	 * @param length Length of the array
	 * @param operator Operation to apply
	 * 
	 * @return The result of the operation
	 * 
	 * @throws VectorMathException if the given size is different from the size of this vector
	 */
	private FloatVector applyOperation(int length, IntFunction<Float> operator) {
		return new FloatVector(this.mapEach(length, operator).toArray(Float[]::new));
	}

	/**
	 * Utility method that maps all values in the vector with a given function.
	 * 
	 * @param length Length of the array
	 * @param operator The mapper function
	 * 
	 * @return The resulting {@link Stream}
	 * 
	 * @throws VectorMathException if the given size is different from the size of this vector
	 */
	private Stream<Float> mapEach(int length, IntFunction<Float> operator) {
		if(length == this.size()) {
			return IntStream.range(0, length).mapToObj(operator);
		} else {
			throw new VectorMathException("Vector of size " + this.size() + " cannot operate with vector of size " + length);
		}
	}

	/**
	 * Utility method that applies a unary mapper function to all the values in this vector.
	 * 
	 * @param operator Operation to apply
	 * 
	 * @return The result of the operation
	 */
	private FloatVector applyOperation(Function<Float, Float> operator) {
		return new FloatVector(this.mapEach(operator).toArray(Float[]::new));
	}

	/**
	 * Utility method that applies a unary operation to all the values in this vector.
	 * 
	 * @param operator The mapper function
	 * 
	 * @return The resulting {@link Stream}
	 */
	private Stream<Float> mapEach(Function<Float, Float> operator) {
		return IntStream.range(0, this.size()).mapToObj(i -> this.values[i]).map(operator);
	}
}
