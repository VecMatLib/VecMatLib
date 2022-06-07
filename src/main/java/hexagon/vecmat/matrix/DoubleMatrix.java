package hexagon.vecmat.matrix;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import hexagon.vecmat.vector.DoubleVector;
import hexagon.vecmat.vector.VectorMathException;

public class DoubleMatrix implements MatrixDoubleOperations<DoubleMatrix, DoubleVector> {

	public static DoubleMatrix zero(int rows, int columns) {
		return new DoubleMatrix(new double[rows][columns]);
	}

	public static DoubleMatrix identity(int size) {
		return new DoubleMatrix(IntStream.range(0, size).mapToObj(i -> IntStream.range(0, size).mapToDouble(j -> j == i ? 1.0 : 0.0)).toArray(double[][]::new));
	}

	private final double[][] values;

	public DoubleMatrix(double[][] values) {
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

	public double element(int row, int column) {
		if(row < 0 || row >= this.rows())
			throw new IndexOutOfBoundsException("Row index out of bounds");
		if(column < 0 || column >= this.columns())
			throw new IndexOutOfBoundsException("Column index out of bounds");
		return this.values[row][column];
	}

	@Override
	public DoubleMatrix plus(DoubleMatrix matrix) {
		return this.applyOperation(matrix.rows(), matrix.columns(), (r, c) -> this.values[r][c] + matrix.values[r][c]);
	}

	@Override
	public DoubleMatrix negative() {
		return this.applyOperation(m -> -m);
	}

	@Override
	public DoubleMatrix minus(DoubleMatrix matrix) {
		return this.applyOperation(matrix.rows(), matrix.columns(), (r, c) -> this.values[r][c] - matrix.values[r][c]);
	}

	@Override
	public DoubleMatrix multipliedBy(double k) {
		return this.applyOperation(m -> m * k);
	}

	public DoubleVector row(int row) {
		if(row >= 0 && row < this.rows()) {
			return new DoubleVector(this.values[row]);
		} else {
			throw new IndexOutOfBoundsException("Row index out of bounds");
		}
	}

	public DoubleVector column(int column) {
		if(column >= 0 && column < this.columns()) {
			return new DoubleVector(Arrays.stream(this.values).mapToDouble(v -> v[column]).toArray());
		} else {
			throw new IndexOutOfBoundsException("Column index out of bounds");
		}
	}

	@Override
	public DoubleVector multiply(DoubleVector vector) {
		try {
			return new DoubleVector(IntStream.range(0, this.rows()).mapToDouble(i -> this.row(i).dotProduct(vector)).toArray());
		} catch(VectorMathException e) {
			throw new MatrixMathException("The given vector's size does not match the matrix's number of columns", e);
		}
	}

	@Override
	public DoubleMatrix transposed() {
		return this.applyOperation((r, c) -> this.values[c][r]);
	}

	@Override
	public DoubleMatrix negativeTransposed() {
		return this.applyOperation((r, c) -> -this.values[c][r]);
	}

	@Override
	public DoubleMatrix multiply(DoubleMatrix matrix) {
		return this.applyOperation(matrix.rows(), matrix.columns(), (r, c) -> this.row(r).dotProduct(matrix.column(c)));
	}

	@Override
	public DoubleMatrix power(int exponent) {
		if(this.rows() != this.columns()) {
			throw new MatrixMathException("A matrix must be square to be raised to a power");
		} else if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return identity(this.rows());
		} else {
			DoubleMatrix result = this;
			for(int i = 1; i < exponent; i++) {
				result = result.multiply(this);
			}
			return result;
		}
	}

	private DoubleMatrix applyOperation(int rows, int columns, BiFunction<Integer, Integer, Double> operator) {
		return new DoubleMatrix(this.mapEach(rows, columns, operator).map(DoubleStream::toArray).toArray(double[][]::new));
	}

	private Stream<DoubleStream> mapEach(int rows, int columns, BiFunction<Integer, Integer, Double> operator) {
		if(rows == this.rows() && columns == this.columns()) {
			return IntStream.range(0, rows).mapToObj(r -> IntStream.range(0, columns).mapToDouble(c -> operator.apply(r, c)));
		} else {
			throw new MatrixMathException("The given matrix has a different size than this matrix");
		}
	}

	private DoubleMatrix applyOperation(DoubleUnaryOperator operator) {
		return new DoubleMatrix(this.mapEach(operator).map(DoubleStream::toArray).toArray(double[][]::new));
	}

	private Stream<DoubleStream> mapEach(DoubleUnaryOperator operator) {
		return Arrays.stream(this.values).map(i -> Arrays.stream(i).map(operator));
	}

	private DoubleMatrix applyOperation(BiFunction<Integer, Integer, Double> operator) {
		return new DoubleMatrix(this.mapEach(operator).map(DoubleStream::toArray).toArray(double[][]::new));
	}

	private Stream<DoubleStream> mapEach(BiFunction<Integer, Integer, Double> operator) {
		return IntStream.range(0, this.rows()).mapToObj(r -> IntStream.range(0, this.columns()).mapToDouble(c -> operator.apply(r, c)));
	}

	@Override
	public String toString() {
		return "DoubleMatrix" + this.rows() + "x" + this.columns() + Arrays.deepToString(this.values);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof DoubleMatrix that && Arrays.deepEquals(this.values, that.values);
	}
}
