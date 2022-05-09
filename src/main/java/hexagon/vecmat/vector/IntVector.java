package hexagon.vecmat.vector;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public final class IntVector implements VectorIntOperations<IntVector, FloatVector, DoubleVector> {

	private int[] values;

	public IntVector(int... vector) {
		if(vector == null || vector.length == 0) {
			throw new VectorMathException("A vector cannot be null or empty");
		}
		this.values = vector;
	}

	public int size() {
		return this.values.length;
	}

	public int element(int i) {
		if(i >= 0 && i < this.size()) {
			return this.values[i];
		} else {
			throw new IndexOutOfBoundsException(i + " is out of the bounds of the vector");
		}
	}

	public IntVector plus(int... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] + vector[i]);
	}

	@Override
	public IntVector plus(IntVector vector) {
		return this.plus(vector.values);
	}

	public FloatVector plus(float... vector) {
		return this.asFloat().plus(vector);
	}

	public DoubleVector plus(double... vector) {
		return this.asDouble().plus(vector);
	}

	@Override
	public IntVector negated() {
		return this.applyOperation(v -> -v);
	}

	public IntVector minus(int... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] - vector[i]);
	}

	@Override
	public IntVector minus(IntVector vector) {
		return this.minus(vector != null ? vector.values : new int[0]);
	}

	public FloatVector minus(float... vector) {
		return this.asFloat().minus(vector);
	}

	public DoubleVector minus(double... vector) {
		return this.asDouble().minus(vector);
	}

	@Override
	public IntVector multipliedBy(int k) {
		return this.applyOperation(v -> v * k);
	}

	@Override
	public IntVector dividedBy(int k) {
		return this.applyOperation(v -> v * k);
	}

	public int dotProduct(int... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).sum();
	}

	@Override
	public int dotProduct(IntVector vector) {
		return this.dotProduct(vector != null ? vector.values : new int[0]);
	}

	public float dotProduct(float... vector) {
		return this.asFloat().dotProduct(vector);
	}

	public double dotProduct(double... vector) {
		return this.asDouble().dotProduct(vector);
	}

	@Override
	public int lengthSquared() {
		return this.dotProduct(this);
	}

	public double angle(int... vector) {
		return this.angle(new IntVector(vector));
	}

	public double angle(float... vector) {
		return this.angle(new FloatVector(vector));
	}

	public double angle(double... vector) {
		return this.angle(new DoubleVector(vector));
	}

	@Override
	public FloatVector asFloat() {
		return new FloatVector(Arrays.stream(this.values).mapToObj(i -> i).toArray(Float[]::new));
	}

	@Override
	public DoubleVector asDouble() {
		return new DoubleVector(Arrays.stream(this.values).mapToDouble(i -> i).toArray());
	}

	private IntVector applyOperation(int array, IntUnaryOperator operator) {
		return new IntVector(this.mapEach(array, operator).toArray());
	}

	private IntStream mapEach(int length, IntUnaryOperator operator) {
		if(length == this.size()) {
			return IntStream.range(0, length).map(operator);
		} else {
			throw new VectorMathException("Vector of size " + this.size() + " cannot operate with vector of size " + length);
		}
	}

	private IntVector applyOperation(IntUnaryOperator operator) {
		return new IntVector(this.mapEach(operator).toArray());
	}

	private IntStream mapEach(IntUnaryOperator operator) {
		return Arrays.stream(this.values).map(operator);
	}
}
