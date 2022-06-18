package io.github.hexagonnico.vecmat.matrix;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.github.hexagonnico.vecmat.vector.FloatVector;
import io.github.hexagonnico.vecmat.vector.VectorMathException;

public class FloatMatrix implements MatrixFloatOperations<FloatMatrix, FloatVector> {

	public static FloatMatrix zero(int rows, int columns) {
		return new FloatMatrix(new Float[rows][columns]);
	}

	public static FloatMatrix identity(int size) {
		return new FloatMatrix(IntStream.range(0, size).mapToObj(i -> IntStream.range(0, size).mapToObj(j -> j == i ? 1.0f : 0.0f)).toArray(Float[][]::new));
	}

	private final Float[][] values;

	public FloatMatrix(Float[][] values) {
		if(values == null || values.length == 0)
			throw new MatrixMathException("A matrix cannot be null or empty");
		if(Arrays.stream(values).filter(i -> i == null).count() != 0)
			throw new MatrixMathException("A matrix cannot contain null rows");
		if(Arrays.stream(values).mapToInt(i -> i.length).distinct().count() != 1)
			throw new MatrixMathException("All rows of a matrix must have the same length");
		this.values = values;
	}

	public int rows() {
		return this.values.length;
	}

	public int columns() {
		return this.values[0].length;
	}

	public float element(int row, int column) {
		if(row < 0 || row >= this.rows())
			throw new IndexOutOfBoundsException("Row index out of bounds");
		if(column < 0 || column >= this.columns())
			throw new IndexOutOfBoundsException("Column index out of bounds");
		return this.values[row][column];
	}

	@Override
	public FloatMatrix plus(FloatMatrix matrix) {
		return this.applyOperation(matrix.rows(), matrix.columns(), (r, c) -> this.values[r][c] + matrix.values[r][c]);
	}

	@Override
	public FloatMatrix negative() {
		return this.applyOperation(m -> -m);
	}

	@Override
	public FloatMatrix minus(FloatMatrix matrix) {
		return this.applyOperation(matrix.rows(), matrix.columns(), (r, c) -> this.values[r][c] - matrix.values[r][c]);
	}

	@Override
	public FloatMatrix multipliedBy(float k) {
		return this.applyOperation(m -> m * k);
	}

	public FloatVector row(int row) {
		if(row >= 0 && row < this.rows()) {
			return new FloatVector(this.values[row]);
		} else {
			throw new IndexOutOfBoundsException("Row index out of bounds");
		}
	}

	public FloatVector column(int column) {
		if(column >= 0 && column < this.columns()) {
			return new FloatVector(Arrays.stream(this.values).map(v -> v[column]).toArray(Float[]::new));
		} else {
			throw new IndexOutOfBoundsException("Column index out of bounds");
		}
	}

	@Override
	public FloatVector multiply(FloatVector vector) {
		try {
			return new FloatVector(IntStream.range(0, this.rows()).mapToObj(i -> this.row(i).dotProduct(vector)).toArray(Float[]::new));
		} catch(VectorMathException e) {
			throw new MatrixMathException("The given vector's size does not match the matrix's number of columns", e);
		}
	}

	@Override
	public FloatMatrix transposed() {
		return this.applyOperation((r, c) -> this.values[c][r]);
	}

	@Override
	public FloatMatrix negativeTransposed() {
		return this.applyOperation((r, c) -> -this.values[c][r]);
	}

	@Override
	public FloatMatrix multiply(FloatMatrix matrix) {
		return this.applyOperation(matrix.rows(), matrix.columns(), (r, c) -> this.row(r).dotProduct(matrix.column(c)));
	}

	@Override
	public FloatMatrix power(int exponent) {
		if(this.rows() != this.columns()) {
			throw new MatrixMathException("A matrix must be square to be raised to a power");
		} else if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return identity(this.rows());
		} else {
			FloatMatrix result = this;
			for(int i = 1; i < exponent; i++) {
				result = result.multiply(this);
			}
			return result;
		}
	}

	private FloatMatrix applyOperation(int rows, int columns, BiFunction<Integer, Integer, Float> operator) {
		return new FloatMatrix(this.mapEach(rows, columns, operator).map(Stream::toArray).toArray(Float[][]::new));
	}

	private Stream<Stream<Float>> mapEach(int rows, int columns, BiFunction<Integer, Integer, Float> operator) {
		if(rows == this.rows() && columns == this.columns()) {
			return IntStream.range(0, rows).mapToObj(r -> IntStream.range(0, columns).mapToObj(c -> operator.apply(r, c)));
		} else {
			throw new MatrixMathException("The given matrix has a different size than this matrix");
		}
	}

	private FloatMatrix applyOperation(UnaryOperator<Float> operator) {
		return new FloatMatrix(this.mapEach(operator).map(Stream::toArray).toArray(Float[][]::new));
	}

	private Stream<Stream<Float>> mapEach(UnaryOperator<Float> operator) {
		return Arrays.stream(this.values).map(i -> Arrays.stream(i).map(operator));
	}

	private FloatMatrix applyOperation(BiFunction<Integer, Integer, Float> operator) {
		return new FloatMatrix(this.mapEach(operator).map(Stream::toArray).toArray(Float[][]::new));
	}

	private Stream<Stream<Float>> mapEach(BiFunction<Integer, Integer, Float> operator) {
		return IntStream.range(0, this.rows()).mapToObj(r -> IntStream.range(0, this.columns()).mapToObj(c -> operator.apply(r, c)));
	}
}
