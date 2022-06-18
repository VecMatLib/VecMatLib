package io.github.hexagonnico.vecmat.vector;

import java.util.Arrays;
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
	 * @param vector Values in the vector.
	 * 
	 * @throws VectorMathException if the given array is null or has length 0.
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
	 * @return The size of this vector.
	 */
	public int size() {
		return this.values.length;
	}

	/**
	 * Get the i-th element of this vector.
	 * 
	 * @param i Index of the element to get.
	 * 
	 * @return The i-th element of this vector.
	 * 
	 * @throws IndexOutOfBoundsException if the given i is less than 0
	 * 		or greater than the vector's size.
	 */
	public float element(int i) {
		if(i >= 0 && i < this.size()) {
			return this.values[i];
		} else {
			throw new IndexOutOfBoundsException(i + " is out of the bounds of the vector");
		}
	}

	@Override
	public FloatVector plus(FloatVector vector) {
		return this.applyOperation(vector.size(), i -> this.values[i] + vector.values[i]);
	}

	@Override
	public FloatVector negated() {
		return this.applyOperation(v -> -v);
	}

	@Override
	public FloatVector minus(FloatVector vector) {
		return this.applyOperation(vector.size(), i -> this.values[i] - vector.values[i]);
	}

	@Override
	public FloatVector multipliedBy(float k) {
		return this.applyOperation(v -> v * k);
	}

	@Override
	public FloatVector dividedBy(float k) {
		return this.applyOperation(v -> v / k);
	}

	@Override
	public float dotProduct(FloatVector vector) {
		return this.mapEach(vector.size(), i -> this.values[i] * vector.values[i]).reduce(0.0f, (v1, v2) -> v1 + v2);
	}

	@Override
	public float lengthSquared() {
		return this.dotProduct(this);
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
	 * @param length Length of the array.
	 * @param operator Operation to apply.
	 * 
	 * @return The result of the operation.
	 * 
	 * @throws VectorMathException if the given size is different from the size of this vector.
	 */
	private FloatVector applyOperation(int length, IntFunction<Float> operator) {
		return new FloatVector(this.mapEach(length, operator).toArray(Float[]::new));
	}

	/**
	 * Utility method that maps all values in the vector with a given function.
	 * 
	 * @param length Length of the array.
	 * @param operator The mapper function.
	 * 
	 * @return The resulting {@link Stream}
	 * 
	 * @throws VectorMathException if the given size is different from the size of this vector.
	 */
	private Stream<Float> mapEach(int length, IntFunction<Float> operator) {
		if(length == this.size()) {
			return IntStream.range(0, length).mapToObj(operator);
		} else {
			throw new VectorMathException("Vectors must have the same size");
		}
	}

	/**
	 * Utility method that applies a unary mapper function to all the values in this vector.
	 * 
	 * @param operator Operation to apply.
	 * 
	 * @return The result of the operation.
	 */
	private FloatVector applyOperation(Function<Float, Float> operator) {
		return new FloatVector(this.mapEach(operator).toArray(Float[]::new));
	}

	/**
	 * Utility method that applies a unary operation to all the values in this vector.
	 * 
	 * @param operator The mapper function.
	 * 
	 * @return The resulting {@link Stream}.
	 */
	private Stream<Float> mapEach(Function<Float, Float> operator) {
		return IntStream.range(0, this.size()).mapToObj(i -> this.values[i]).map(operator);
	}

	@Override
	public String toString() {
		return "FloatVector" + Arrays.toString(this.values);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof FloatVector that && Arrays.equals(this.values, that.values);
	}
}
