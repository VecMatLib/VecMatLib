package hexagon.vecmat.matrix;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import hexagon.vecmat.vector.DoubleVector;
import hexagon.vecmat.vector.VectorMathException;

/**
 * Class that represents an NxM double matrix.
 * 
 * @author Nico
 */
public class DoubleMatrix implements MatrixDoubleOperations<DoubleMatrix, DoubleVector> {

	/**
	 * Creates an NxM matrix where every element is 0.0
	 * 
	 * @param rows Number of rows.
	 * @param columns Number of columns.
	 * 
	 * @return An NxM matrix where every element is 0.0
	 * 
	 * TODO: Throws? 
	 */
	public static DoubleMatrix zero(int rows, int columns) {
		return new DoubleMatrix(new double[rows][columns]);
	}

	/**
	 * Creates a square matrix where every element on the diagonal
	 * is 1.0 and all the other elements are 0.0
	 * 
	 * @param size Size of the matrix.
	 * 
	 * @return An identity matrix of the given size.
	 */
	public static DoubleMatrix identity(int size) {
		return new DoubleMatrix(IntStream.range(0, size).mapToObj(i -> IntStream.range(0, size).mapToDouble(j -> j == i ? 1.0 : 0.0)).toArray(double[][]::new));
	}

	/**Elements of the matrix */
	private final double[][] values;

	/**
	 * Creates a matrix with the values in the given array.
	 * 
	 * @param values Values in the matrix.
	 * 
	 * @throws MatrixMathException if the given array is null or has length 0
	 * 		or if any of the rows is null or if not all the rows have the same length.
	 */
	public DoubleMatrix(double[][] values) {
		if(values == null || values.length == 0)
			throw new MatrixMathException("A matrix cannot be null or empty");
		if(Arrays.stream(values).filter(i -> i == null).count() != 0)
			throw new MatrixMathException("A matrix cannot contain null rows");
		if(Arrays.stream(values).mapToInt(i -> i.length).distinct().count() != 1)
			throw new MatrixMathException("All rows of a matrix must have the same length");
		this.values = values;
	}

	/**
	 * Gets the number of rows of this matrix.
	 * 
	 * @return The number of rows of this matrix.
	 */
	public int rows() {
		return this.values.length;
	}

	/**
	 * Gets the number of columns of this matrix.
	 * 
	 * @return The number of columns of this matrix.
	 */
	public int columns() {
		return this.values[0].length;
	}

	/**
	 * Gets an element of this matrix.
	 * 
	 * @param row Row of the element to get.
	 * @param column Column of the element to get.
	 * 
	 * @return The element at the given row and column.
	 * 
	 * @throws IndexOutOfBoundsException if the given row or column is less than 0
	 * 		or greater than the matrix's size.
	 */
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

	/**
	 * Gets a row of this matrix.
	 * 
	 * @param row Index of the row to get.
	 * 
	 * @return The row at the given index.
	 * 
	 * @throws IndexOutOfBoundsException if the given row is less than 0
	 * 		or greater than the matrix's size.
	 */
	public DoubleVector row(int row) {
		if(row >= 0 && row < this.rows()) {
			return new DoubleVector(this.values[row]);
		} else {
			throw new IndexOutOfBoundsException("Row index out of bounds");
		}
	}

	/**
	 * Gets a column of this matrix.
	 * 
	 * @param column Index of the column to get.
	 * 
	 * @return The column at the given index.
	 * 
	 * @throws IndexOutOfBoundsException if the given column is less than 0
	 * 		or greater than the matrix's size.
	 */
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

	/**
	 * Applies the given function to each element of this matrix.
	 * Used when operating with two matrices.
	 * 
	 * @param rows Number of rows of the resulting matrix.
	 * @param columns Number of columns of the resulting matrix.
	 * @param operator Function to apply to each element.
	 * 
	 * @return The result matrix.
	 * 
	 * @throws MatrixMathException if the given size is different from the size of this matrix.
	 */
	private DoubleMatrix applyOperation(int rows, int columns, BiFunction<Integer, Integer, Double> operator) {
		return new DoubleMatrix(this.mapEach(rows, columns, operator).map(DoubleStream::toArray).toArray(double[][]::new));
	}

	/**
	 * Maps each element of this matrix to a new value using the given operator.
	 * Used when operating with two matrices.
	 * 
	 * @param rows Number of rows of the resulting matrix.
	 * @param columns Number of columns of the resulting matrix.
	 * @param operator Operator to apply to each element.
	 * 
	 * @return A stream of streams representing the result.
	 * 
	 * @throws MatrixMathException if the given size is different from the size of this matrix.
	 */
	private Stream<DoubleStream> mapEach(int rows, int columns, BiFunction<Integer, Integer, Double> operator) {
		if(rows == this.rows() && columns == this.columns()) {
			return IntStream.range(0, rows).mapToObj(r -> IntStream.range(0, columns).mapToDouble(c -> operator.apply(r, c)));
		} else {
			throw new MatrixMathException("The given matrix has a different size than this matrix");
		}
	}

	/**
	 * Applies the given function to each element of this matrix.
	 * Used when operating with a single matrix.
	 * 
	 * @param operator Operator to apply to each element.
	 * 
	 * @return The result matrix.
	 */
	private DoubleMatrix applyOperation(DoubleUnaryOperator operator) {
		return new DoubleMatrix(this.mapEach(operator).map(DoubleStream::toArray).toArray(double[][]::new));
	}

	/**
	 * Maps each element of this matrix to a new value using the given operator.
	 * Used when operating with a single matrix.
	 * 
	 * @param operator Operator to apply to each element.
	 * 
	 * @return A stream of streams representing the result.
	 */
	private Stream<DoubleStream> mapEach(DoubleUnaryOperator operator) {
		return Arrays.stream(this.values).map(i -> Arrays.stream(i).map(operator));
	}

	/**
	 * Applies the given function to each element of this matrix.
	 * Used when operating with a single matrix.
	 * 
	 * @param operator Operator to apply to each element.
	 * 
	 * @return The result matrix.
	 */
	private DoubleMatrix applyOperation(BiFunction<Integer, Integer, Double> operator) {
		return new DoubleMatrix(this.mapEach(operator).map(DoubleStream::toArray).toArray(double[][]::new));
	}

	/**
	 * Maps each element of this matrix to a new value using the given operator.
	 * Used when operating with a single matrix.
	 * 
	 * @param operator Operator to apply to each element.
	 * 
	 * @return A stream of streams representing the result.
	 */
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
