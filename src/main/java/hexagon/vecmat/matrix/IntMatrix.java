package hexagon.vecmat.matrix;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import hexagon.vecmat.vector.IntVector;
import hexagon.vecmat.vector.VectorMathException;

public class IntMatrix implements MatrixIntOperations<IntMatrix, IntVector> {

	public static IntMatrix zero(int rows, int columns) {
		return new IntMatrix(new int[rows][columns]);
	}

	public static IntMatrix identity(int size) {
		return new IntMatrix(IntStream.range(0, size).mapToObj(i -> IntStream.range(0, size).map(j -> j == i ? 1 : 0)).toArray(int[][]::new));
	}

	private final int[][] values;

	public IntMatrix(int[][] values) {
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

	@Override
	public IntMatrix plus(IntMatrix matrix) {
		return this.applyOperation(matrix.rows(), matrix.columns(), (r, c) -> this.values[r][c] + matrix.values[r][c]);
	}

	@Override
	public IntMatrix negative() {
		return this.applyOperation(m -> -m);
	}

	@Override
	public IntMatrix minus(IntMatrix matrix) {
		return this.applyOperation(matrix.rows(), matrix.columns(), (r, c) -> this.values[r][c] - matrix.values[r][c]);
	}

	@Override
	public IntMatrix multipliedBy(int k) {
		return this.applyOperation(m -> m * k);
	}

	public IntVector row(int row) {
		if(row >= 0 && row < this.rows()) {
			return new IntVector(this.values[row]);
		} else {
			throw new IndexOutOfBoundsException("Row index out of bounds");
		}
	}

	public IntVector column(int column) {
		if(column >= 0 && column < this.columns()) {
			return new IntVector(Arrays.stream(this.values).mapToInt(v -> v[column]).toArray());
		} else {
			throw new IndexOutOfBoundsException("Column index out of bounds");
		}
	}

	@Override
	public IntVector multiply(IntVector vector) {
		try {
			return new IntVector(IntStream.range(0, this.rows()).map(i -> this.row(i).dotProduct(vector)).toArray());
		} catch(VectorMathException e) {
			throw new MatrixMathException("The given vector's size does not match the matrix's number of columns", e);
		}
	}

	@Override
	public IntMatrix transposed() {
		return this.applyOperation((r, c) -> this.values[c][r]);
	}

	@Override
	public IntMatrix negativeTransposed() {
		return this.applyOperation((r, c) -> -this.values[c][r]);
	}

	@Override
	public IntMatrix multiply(IntMatrix matrix) {
		return this.applyOperation(matrix.rows(), matrix.columns(), (r, c) -> this.row(r).dotProduct(matrix.column(c)));
	}

	@Override
	public IntMatrix power(int exponent) {
		if(this.rows() != this.columns()) {
			throw new MatrixMathException("A matrix must be square to be raised to a power");
		} else if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return identity(this.rows());
		} else {
			return this.multiply(this.power(exponent - 1));
		}
	}

	private IntMatrix applyOperation(int rows, int columns, IntBinaryOperator operator) {
		return new IntMatrix(this.mapEach(rows, columns, operator).map(IntStream::toArray).toArray(int[][]::new));
	}

	private Stream<IntStream> mapEach(int rows, int columns, IntBinaryOperator operator) {
		if(rows == this.rows() && columns == this.columns()) {
			return IntStream.range(0, rows).mapToObj(r -> IntStream.range(0, columns).map(c -> operator.applyAsInt(r, c)));
		} else {
			throw new MatrixMathException("The given matrix has a different size than this matrix");
		}
	}

	private IntMatrix applyOperation(IntUnaryOperator operator) {
		return new IntMatrix(this.mapEach(operator).map(IntStream::toArray).toArray(int[][]::new));
	}

	private Stream<IntStream> mapEach(IntUnaryOperator operator) {
		return Arrays.stream(this.values).map(i -> Arrays.stream(i).map(operator));
	}

	private IntMatrix applyOperation(IntBinaryOperator operator) {
		return new IntMatrix(this.mapEach(operator).map(IntStream::toArray).toArray(int[][]::new));
	}

	private Stream<IntStream> mapEach(IntBinaryOperator operator) {
		return IntStream.range(0, this.rows()).mapToObj(r -> IntStream.range(0, this.columns()).map(c -> operator.applyAsInt(r, c)));
	}

	@Override
	public String toString() {
		return "IntMatrix" + this.rows() + "x" + this.columns() + Arrays.deepToString(this.values);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof IntMatrix that && Arrays.deepEquals(this.values, that.values);
	}
}
