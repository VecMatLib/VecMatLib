package hexagon.vecmat.vector;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

/**
 * Class that represents an N-dimensional integer vector.
 * 
 * @author Nico
 */
public final class IntVector implements VectorIntOperations<IntVector>, VectorAsFloat<FloatVector>, VectorAsDouble<DoubleVector> {

	/**Vector values */
	private int[] values;

	/**
	 * Creates a vector with the values in the given array.
	 * 
	 * @param vector Values in the vector.
	 * 
	 * @throws VectorMathException if the given array is null or has length 0.
	 */
	public IntVector(int... vector) {
		if(vector == null || vector.length == 0) {
			throw new VectorMathException("A vector cannot be null or empty");
		}
		this.values = vector;
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
	public int element(int i) {
		if(i >= 0 && i < this.size()) {
			return this.values[i];
		} else {
			throw new IndexOutOfBoundsException(i + " is out of the bounds of the vector");
		}
	}

	@Override
	public IntVector plus(IntVector vector) {
		return this.applyOperation(vector.size(), i -> this.values[i] + vector.values[i]);
	}

	@Override
	public IntVector negated() {
		return this.applyOperation(v -> -v);
	}

	@Override
	public IntVector minus(IntVector vector) {
		return this.applyOperation(vector.size(), i -> this.values[i] - vector.values[i]);
	}

	@Override
	public IntVector multipliedBy(int k) {
		return this.applyOperation(v -> v * k);
	}

	@Override
	public IntVector dividedBy(int k) {
		return this.applyOperation(v -> v / k);
	}

	@Override
	public int dotProduct(IntVector vector) {
		return this.mapEach(vector.size(), i -> this.values[i] * vector.values[i]).sum();
	}

	@Override
	public int lengthSquared() {
		return this.dotProduct(this);
	}

	@Override
	public FloatVector asFloat() {
		return new FloatVector(Arrays.stream(this.values).mapToObj(i -> (float) i).toArray(Float[]::new));
	}

	@Override
	public DoubleVector asDouble() {
		return new DoubleVector(Arrays.stream(this.values).mapToDouble(i -> i).toArray());
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
	private IntVector applyOperation(int length, IntUnaryOperator operator) {
		return new IntVector(this.mapEach(length, operator).toArray());
	}

	/**
	 * Utility method that maps all values in the vector with a given function.
	 * 
	 * @param length Length of the array.
	 * @param operator The mapper function.
	 * 
	 * @return The resulting {@link IntStream}.
	 * 
	 * @throws VectorMathException if the given size is different from the size of this vector.
	 */
	private IntStream mapEach(int length, IntUnaryOperator operator) {
		if(length == this.size()) {
			return IntStream.range(0, length).map(operator);
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
	private IntVector applyOperation(IntUnaryOperator operator) {
		return new IntVector(this.mapEach(operator).toArray());
	}

	/**
	 * Utility method that applies a unary operation to all the values in this vector.
	 * 
	 * @param operator The mapper function.
	 * 
	 * @return The resulting {@link IntStream}.
	 */
	private IntStream mapEach(IntUnaryOperator operator) {
		return Arrays.stream(this.values).map(operator);
	}

	@Override
	public String toString() {
		return "IntVector" + Arrays.toString(this.values);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof IntVector that && Arrays.equals(this.values, that.values);
	}
}
