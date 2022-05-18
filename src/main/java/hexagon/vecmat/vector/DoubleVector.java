package hexagon.vecmat.vector;

import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

/**
 * Class that represents an N-dimensional double vector.
 * 
 * @author Nico
 */
public final class DoubleVector implements VectorDoubleOperations<DoubleVector> {

	/**Vector values */
	private double[] values;

	/**
	 * Creates a vector with the values in the given array.
	 * 
	 * @param vector Values in the vector
	 * 
	 * @throws VectorMathException if the given array is null or has length 0
	 */
	public DoubleVector(double... vector) {
		if(vector == null || vector.length == 0) {
			throw new VectorMathException("A vector cannot be null or empty");
		}
		this.values = vector;
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
	public double element(int i) {
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
		return this.applyOperation(vector.length, i -> this.values[i] + vector[i]);
	}

	@Override
	public DoubleVector plus(DoubleVector vector) {
		return this.plus(vector != null ? vector.values : new double[0]);
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
	 * in a double vector.
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
	public DoubleVector plus(int... vector) {
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
	 * <p> The sum of this vector and a float vector will result
	 * in a double vector.
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
	public DoubleVector plus(float... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] + vector[i]);
	}

	@Override
	public DoubleVector negated() {
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
	 * @param vector The second operand of the subtraction, an double
	 * 		vector of the same type as this one
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public DoubleVector minus(double... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] - vector[i]);
	}

	@Override
	public DoubleVector minus(DoubleVector vector) {
		return this.minus(vector != null ? vector.values : new double[0]);
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
	 * will result in a double vector.
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
	public DoubleVector minus(int... vector) {
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
	 * <p> The subtraction between this vector and a float vector
	 * will result in a double vector.
	 * 
	 * @param vector The second operand of the subtraction, a float
	 * 		vector of the same size as this one
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public DoubleVector minus(float... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] - vector[i]);
	}

	@Override
	public DoubleVector multipliedBy(double k) {
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
	 * 		double vector
	 * 
	 * @return The result of the dot product between the two vectors
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public double dotProduct(double... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).sum();
	}

	@Override
	public double dotProduct(DoubleVector vector) {
		return this.dotProduct(vector != null ? vector.values : new double[0]);
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
	 * will result in a double.
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
	public double dotProduct(int... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).sum();
	}

	/**
	 * Computes the dot product (or scalar product) between this
	 * vector and the given one.
	 * 
	 * <p> The dot product between two vectors v and w of the same
	 * size is a scalar defined as the summation of the products of
	 * every element vi and wi of the two vectors.
	 * 
	 * <p> The dot product between this vector and a float vector
	 * will result in a double.
	 * 
	 * @param vector The second operand of the product, a
	 * 		float vector
	 * 
	 * @return The result of the dot product between the two vectors
	 * 
	 * @throws VectorMathException if this vector and the given one
	 * 		have different sizes
	 * @throws NullPointerException if the given vector is null
	 */
	public double dotProduct(float... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).sum();
	}

	@Override
	public double lengthSquared() {
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
	 * TODO
	 * @return
	 */
	public IntVector castToInt() {
		return new IntVector(Arrays.stream(this.values).mapToInt(d -> (int) d).toArray());
	}

	/**
	 * TODO
	 * @return
	 */
	public FloatVector castToFloat() {
		return new FloatVector(Arrays.stream(this.values).mapToObj(d -> (float) d).toArray(Float[]::new));
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
	private DoubleVector applyOperation(int array, IntToDoubleFunction operator) {
		return new DoubleVector(this.mapEach(array, operator).toArray());
	}

	/**
	 * Utility method that maps all values in the vector with a given function.
	 * 
	 * @param length Length of the array
	 * @param operator The mapper function
	 * 
	 * @return The resulting {@link DoubleStream}
	 * 
	 * @throws VectorMathException if the given size is different from the size of this vector
	 */
	private DoubleStream mapEach(int length, IntToDoubleFunction operator) {
		if(length == this.size()) {
			return IntStream.range(0, length).mapToDouble(operator);
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
	private DoubleVector applyOperation(DoubleUnaryOperator operator) {
		return new DoubleVector(this.mapEach(operator).toArray());
	}

	/**
	 * Utility method that applies a unary operation to all the values in this vector.
	 * 
	 * @param operator The mapper function
	 * 
	 * @return The resulting {@link DoubleStream}
	 */
	private DoubleStream mapEach(DoubleUnaryOperator operator) {
		return Arrays.stream(this.values).map(operator);
	}
}
