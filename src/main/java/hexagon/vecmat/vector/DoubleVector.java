package hexagon.vecmat.vector;

import java.util.Arrays;
import java.util.function.DoubleUnaryOperator;
import java.util.function.IntToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public final class DoubleVector implements VectorDoubleOperations<DoubleVector, FloatVector, IntVector> {

	private double[] values;

	public DoubleVector(double... vector) {
		if(vector == null || vector.length == 0) {
			throw new VectorMathException("A vector cannot be null or empty");
		}
		this.values = vector;
	}

	public int size() {
		return this.values.length;
	}

	public double element(int i) {
		if(i >= 0 && i < this.size()) {
			return this.values[i];
		} else {
			throw new IndexOutOfBoundsException(i + " is out of the bounds of the vector");
		}
	}

	public DoubleVector plus(double... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] + vector[i]);
	}

	@Override
	public DoubleVector plus(DoubleVector vector) {
		return this.plus(vector != null ? vector.values : new double[0]);
	}

	public DoubleVector plus(int... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] + vector[i]);
	}

	public DoubleVector plus(float... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] + vector[i]);
	}

	@Override
	public DoubleVector negated() {
		return this.applyOperation(v -> -v);
	}

	public DoubleVector minus(double... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] - vector[i]);
	}

	@Override
	public DoubleVector minus(DoubleVector vector) {
		return this.minus(vector != null ? vector.values : new double[0]);
	}

	public DoubleVector minus(int... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] - vector[i]);
	}

	public DoubleVector minus(float... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] - vector[i]);
	}

	@Override
	public DoubleVector multipliedBy(double k) {
		return this.applyOperation(v -> v * k);
	}

	public double dotProduct(double... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).sum();
	}

	@Override
	public double dotProduct(DoubleVector vector) {
		return this.dotProduct(vector != null ? vector.values : new double[0]);
	}

	public double dotProduct(int... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).sum();
	}

	public double dotProduct(float... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).sum();
	}

	@Override
	public double lengthSquared() {
		return this.dotProduct(this);
	}

	public double angle(double... vector) {
		return this.angle(new DoubleVector(vector));
	}

	public double angle(float... vector) {
		return this.angle(new FloatVector(vector));
	}

	public double angle(int... vector) {
		return this.angle(new IntVector(vector));
	}

	@Override
	public IntVector castToInt() {
		return new IntVector(Arrays.stream(this.values).mapToInt(d -> (int) d).toArray());
	}

	@Override
	public FloatVector castToFloat() {
		return new FloatVector(Arrays.stream(this.values).mapToObj(d -> (float) d).toArray(Float[]::new));
	}

	private DoubleVector applyOperation(int array, IntToDoubleFunction operator) {
		return new DoubleVector(this.mapEach(array, operator).toArray());
	}

	private DoubleStream mapEach(int length, IntToDoubleFunction operator) {
		if(length == this.size()) {
			return IntStream.range(0, length).mapToDouble(operator);
		} else {
			throw new VectorMathException("Vector of size " + this.size() + " cannot operate with vector of size " + length);
		}
	}

	private DoubleVector applyOperation(DoubleUnaryOperator operator) {
		return new DoubleVector(this.mapEach(operator).toArray());
	}

	private DoubleStream mapEach(DoubleUnaryOperator operator) {
		return Arrays.stream(this.values).map(operator);
	}
}
