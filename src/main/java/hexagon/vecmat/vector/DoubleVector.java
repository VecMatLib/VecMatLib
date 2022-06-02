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

	@Override
	public DoubleVector plus(DoubleVector vector) {
		return vector != null ? this.applyOperation(vector.size(), i -> this.values[i] + vector.values[i]) : this;
	}

	@Override
	public DoubleVector negated() {
		return this.applyOperation(v -> -v);
	}

	@Override
	public DoubleVector minus(DoubleVector vector) {
		return vector != null ? this.applyOperation(vector.size(), i -> this.values[i] - vector.values[i]) : this;
	}

	@Override
	public DoubleVector multipliedBy(double k) {
		return this.applyOperation(v -> v * k);
	}

	@Override
	public DoubleVector dividedBy(double k) {
		return this.applyOperation(v -> v / k);
	}

	@Override
	public double dotProduct(DoubleVector vector) {
		return vector != null ? this.mapEach(vector.size(), i -> this.values[i] * vector.values[i]).sum() : 0.0;
	}

	@Override
	public double lengthSquared() {
		return this.dotProduct(this);
	}

	/**
	 * Casts this vector to an int vector.
	 * 
	 * @return A vector with the same elements as this vector casted to int.
	 */
	public IntVector castToInt() {
		return new IntVector(Arrays.stream(this.values).mapToInt(d -> (int) d).toArray());
	}

	/**
	 * Casts this vector to a float vector.
	 * 
	 * @return A vector with the same elements as this vector casted to float.
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
			throw new VectorMathException("Vectors must have the same size");
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

	@Override
	public String toString() {
		return "DoubleVector[values=" + Arrays.toString(this.values) + "]";
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof DoubleVector that && Arrays.equals(this.values, that.values);
	}
}
