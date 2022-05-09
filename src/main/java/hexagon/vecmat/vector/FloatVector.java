package hexagon.vecmat.vector;

import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class FloatVector implements VectorFloatOperations<FloatVector, DoubleVector, IntVector> {

	private float[] values;

	public FloatVector(float... vector) {
		if(vector == null || vector.length == 0) {
			throw new VectorMathException("A vector cannot be null or empty");
		}
		this.values = vector;
	}

	public FloatVector(Float... vector) {
		if(vector == null || vector.length == 0) {
			throw new VectorMathException("A vector cannot be null or empty");
		}
		this.values = new float[vector.length];
		for(int i = 0; i < vector.length; i++) {
			this.values[i] = vector[i].floatValue();
		}
	}

	public int size() {
		return this.values.length;
	}

	public float element(int i) {
		if(i >= 0 && i < this.size()) {
			return this.values[i];
		} else {
			throw new IndexOutOfBoundsException(i + " is out of the bounds of the vector");
		}
	}

	public FloatVector plus(float... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] + vector[i]);
	}

	@Override
	public FloatVector plus(FloatVector vector) {
		return this.plus(vector != null ? vector.values : new float[0]);
	}

	public FloatVector plus(int... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] + vector[i]);
	}

	public DoubleVector plus(double... vector) {
		return this.asDouble().plus(vector);
	}

	@Override
	public FloatVector negated() {
		return this.applyOperation(v -> -v);
	}

	public FloatVector minus(float... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] - vector[i]);
	}

	@Override
	public FloatVector minus(FloatVector vector) {
		return this.minus(vector != null ? vector.values : new float[0]);
	}

	public FloatVector minus(int... vector) {
		return this.applyOperation(vector.length, i -> this.values[i] - vector[i]);
	}

	public DoubleVector minus(double... vector) {
		return this.asDouble().minus(vector);
	}

	@Override
	public FloatVector multipliedBy(float k) {
		return this.applyOperation(v -> v * k);
	}

	public float dotProduct(float... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).reduce(0.0f, (v1, v2) -> v1 + v2);
	}

	@Override
	public float dotProduct(FloatVector vector) {
		return this.dotProduct(vector != null ? vector.values : new float[0]);
	}

	public float dotProduct(int... vector) {
		return this.mapEach(vector.length, i -> this.values[i] * vector[i]).reduce(0.0f, (v1, v2) -> v1 + v2);
	}

	public double dotProduct(double... vector) {
		return this.asDouble().dotProduct(vector);
	}

	@Override
	public float lengthSquared() {
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
		return new IntVector(IntStream.range(0, this.size()).mapToObj(i -> this.values[i]).mapToInt(f -> f.intValue()).toArray());
	}

	@Override
	public DoubleVector asDouble() {
		return new DoubleVector(IntStream.range(0, this.size()).mapToObj(i -> this.values[i]).mapToDouble(f -> f.doubleValue()).toArray());
	}

	private FloatVector applyOperation(int array, IntFunction<Float> operator) {
		return new FloatVector(this.mapEach(array, operator).toArray(Float[]::new));
	}

	private Stream<Float> mapEach(int length, IntFunction<Float> operator) {
		if(length == this.size()) {
			return IntStream.range(0, length).mapToObj(operator);
		} else {
			throw new VectorMathException("Vector of size " + this.size() + " cannot operate with vector of size " + length);
		}
	}

	private FloatVector applyOperation(Function<Float, Float> operator) {
		return new FloatVector(this.mapEach(operator).toArray(Float[]::new));
	}

	private Stream<Float> mapEach(Function<Float, Float> operator) {
		return IntStream.range(0, this.size()).mapToObj(i -> this.values[i]).map(operator);
	}
}
