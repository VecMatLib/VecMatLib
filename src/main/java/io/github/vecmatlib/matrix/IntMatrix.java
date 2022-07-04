package io.github.vecmatlib.matrix;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import io.github.vecmatlib.vector.IntVector;
import io.github.vecmatlib.vector.VectorMathException;

/**
 * Class that represents an NxM int matrix.
 * 
 * @author Nico
 */
public class IntMatrix implements MatrixIntOperations<IntMatrix, IntVector> {

	/**
	 * Creates an NxM matrix where every element is 0.0
	 * 
	 * @param rows Number of rows.
	 * @param columns Number of columns.
	 * 
	 * @return An NxM matrix where every element is 0.0
	 * 
	 * @throws NegativeArraySizeException if the given number of rows or columns
	 * 		is smaller than zero.
	 * @throws MatrixMathException if the given number of rows or columns is zero.
	 */
	public static IntMatrix zero(int rows, int columns) {
		return new IntMatrix(new int[rows][columns]);
	}

	/**
	 * Creates a square matrix where every element on the diagonal
	 * is 1.0 and all the other elements are 0.0
	 * 
	 * @param size Size of the matrix.
	 * 
	 * @return An identity matrix of the given size.
	 * 
	 * @throws MatrixMathException if the given size is not greater than zero.
	 */
	public static IntMatrix identity(int size) {
		return new IntMatrix(IntStream.range(0, size).mapToObj(i -> IntStream.range(0, size).map(j -> j == i ? 1 : 0).toArray()).toArray(int[][]::new));
	}

	/**Elements of the matrix */
	private final int[][] values;

	/**
	 * Creates a matrix with the values in the given array.
	 * 
	 * @param values Values in the matrix.
	 * 
	 * @throws MatrixMathException if the given array is null or has length 0
	 * 		or if any of the rows is null or if not all the rows have the same length.
	 */
	public IntMatrix(int[][] values) {
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
	public int element(int row, int column) {
		if(row < 0 || row >= this.rows())
			throw new IndexOutOfBoundsException("Row index out of bounds");
		if(column < 0 || column >= this.columns())
			throw new IndexOutOfBoundsException("Column index out of bounds");
		return this.values[row][column];
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
	public IntVector row(int row) {
		if(row >= 0 && row < this.rows()) {
			return new IntVector(this.values[row]);
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
	private IntMatrix applyOperation(int rows, int columns, IntBinaryOperator operator) {
		return new IntMatrix(this.mapEach(rows, columns, operator).map(IntStream::toArray).toArray(int[][]::new));
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
	private Stream<IntStream> mapEach(int rows, int columns, IntBinaryOperator operator) {
		if(rows == this.rows() && columns == this.columns()) {
			return IntStream.range(0, rows).mapToObj(r -> IntStream.range(0, columns).map(c -> operator.applyAsInt(r, c)));
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
	private IntMatrix applyOperation(IntUnaryOperator operator) {
		return new IntMatrix(this.mapEach(operator).map(IntStream::toArray).toArray(int[][]::new));
	}

	/**
	 * Maps each element of this matrix to a new value using the given operator.
	 * Used when operating with a single matrix.
	 * 
	 * @param operator Operator to apply to each element.
	 * 
	 * @return A stream of streams representing the result.
	 */
	private Stream<IntStream> mapEach(IntUnaryOperator operator) {
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
	private IntMatrix applyOperation(IntBinaryOperator operator) {
		return new IntMatrix(this.mapEach(operator).map(IntStream::toArray).toArray(int[][]::new));
	}

	/**
	 * Maps each element of this matrix to a new value using the given operator.
	 * Used when operating with a single matrix.
	 * 
	 * @param operator Operator to apply to each element.
	 * 
	 * @return A stream of streams representing the result.
	 */
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
