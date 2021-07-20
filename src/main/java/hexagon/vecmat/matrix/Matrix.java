package hexagon.vecmat.matrix;

import hexagon.vecmat.exceptions.UnconformableMatrixException;
import hexagon.vecmat.exceptions.UndefinedOperationException;
import hexagon.vecmat.exceptions.VectorSizeException;
import hexagon.vecmat.vector_old.VectorOld;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * A class that represents a matrix of user-specified form
 */
public class Matrix implements MatrixOperations<Matrix, VectorOld> {

    /**
     * Creates a matrix where every element is zero
     *
     * @param rows Number of rows in the matrix
     * @param columns Number of columns in the matrix
     * @return A matrix where every element is zero
     */
    public static Matrix zero(int rows, int columns) {
        return new Matrix(
                rows, columns,
                IntStream.range(0, rows * columns)
                        .mapToObj(i -> 0.0f)
                        .toArray(Float[]::new)
        );
    }

    /**
     * A square matrix where every element on the diagonal is one
     * and every other element is zero
     *
     * @param size Number of rows and columns in the matrix
     * @return An identity matrix of the given size
     */
    public static Matrix identity(int size) {
        return new Matrix(
                size, size,
                IntStream.range(0, size * size)
                        .mapToObj(i -> i % size == i / size ? 1.0f : 0.0f)
                        .toArray(Float[]::new)
        );
    }

    /**
     * Creates a matrix from the given rows
     *
     * @param rows Rows of the matrix
     * @throws VectorSizeException if the given array of rows is empty
     * or if the given rows have different sizes.
     * @return A matrix whose rows are the rows passed as parameters
     */
    public static Matrix fromRows(VectorOld... rows) {
        if(rows.length == 0)
            throw new VectorSizeException("Matrix must have at least one row");

        Arrays.stream(rows).forEach(r -> {
            if(r.dimensions() != rows[0].dimensions())
                throw new IllegalArgumentException("All rows must have the same dimension");
        });

        return new Matrix(
                rows.length, rows[0].dimensions(),
                Arrays.stream(rows)
                        .flatMap(VectorOld::stream)
                        .toArray(Float[]::new)
        );
    }

    /**
     * Creates a matrix from the given columns
     *
     * @param columns Rows of the matrix
     * @throws VectorSizeException if the given array of rows is empty
     * or if the given rows have different sizes.
     * @return A matrix whose columns are the rows passed as parameters
     */
    public static Matrix fromColumns(VectorOld... columns) {
        return fromRows(columns).transposed();
    }

    public final int rows, columns;
    protected final List<Float> elements;

    protected Matrix(int rows, int columns, Float... values) {
        this.rows = rows;
        this.columns = columns;
        this.elements = Arrays.asList(values);
    }

    /**
     * Gets an element in the matrix
     * @param row Row of the element to get
     * @param column Column of the element to get
     * @return The element at position (row, column)
     */
    public float element(int row, int column) {
        if(row >= this.rows) throw new IndexOutOfBoundsException("Tried to get row " + row + " but matrix only has " + this.rows);
        if(column >= this.columns) throw new IndexOutOfBoundsException("Tried to get column " + column + " but matrix only has " + this.columns);
        return this.elements.get(row * this.columns + column);
    }

    @Override
    public VectorOld multiply(VectorOld vector) {
        if(vector.dimensions() != this.columns)
            throw new UnconformableMatrixException(this, vector);

        return new VectorOld(
                IntStream.range(0, this.rows)
                        .mapToObj(i -> this.getRow(i).dotProduct(vector))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Matrix plus(Matrix operand) {
        if(operand.columns != this.columns || operand.rows != this.rows)
            throw new UndefinedOperationException("Sum of two matrices", "matrices of different dimension");

        return new Matrix(
                this.rows, this.columns,
                IntStream.range(0, this.elements.size())
                        .mapToObj(i -> this.elements.get(i) + operand.elements.get(i))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Matrix minus(Matrix operand) {
        if(operand.columns != this.columns || operand.rows != this.rows)
            throw new UndefinedOperationException("Subtraction of two matrices", "matrices of different dimension");

        return new Matrix(
                this.rows, this.columns,
                IntStream.range(0, this.elements.size())
                        .mapToObj(i -> this.elements.get(i) - operand.elements.get(i))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Matrix negated() {
        return new Matrix(
                this.rows, this.columns,
                this.elements.stream()
                        .map(element -> element != 0.0f ? -element : 0.0f)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Matrix times(Float k) {
        return new Matrix(
                this.rows, this.columns,
                this.elements.stream()
                        .map(f -> f * k)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Matrix dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public Matrix reciprocal() {
        return new Matrix(
                this.rows, this.columns,
                this.elements.stream()
                        .map(element -> 1.0f / element)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public boolean isSquare() {
        return this.rows == this.columns;
    }

    @Override
    public VectorOld getRow(int row) {
        return new VectorOld(
                IntStream.range(0, this.columns)
                        .mapToObj(i -> this.element(row, i))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public VectorOld getColumn(int column) {
        return new VectorOld(
                IntStream.range(0, this.rows)
                        .mapToObj(i -> this.element(i, column))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Matrix transposed() {
        return new Matrix(
                this.columns, this.rows,
                IntStream.range(0, this.rows * this.columns)
                        .mapToObj(i -> this.element(i % this.rows, i / this.rows))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public boolean isSymmetric() {
        if(this.isSquare()) return this.equals(this.transposed());
        else return false;
    }

    @Override
    public boolean isSkewSymmetric() {
        if(this.isSquare()) return this.equals(this.transposed().negated());
        else return false;
    }

    @Override
    public Matrix multiply(Matrix matrix) {
        if(this.columns != matrix.rows)
            throw new UnconformableMatrixException(this, matrix);

        return new Matrix(
                this.rows, matrix.columns,
                IntStream.range(0, this.rows * matrix.columns)
                        .mapToObj(i -> this.getRow(i / matrix.columns).dotProduct(matrix.getColumn(i % matrix.columns)))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Matrix power(int exp) {
        if(!this.isSquare())
            throw new UnconformableMatrixException("Power of a matrix is only defined for square matrices");

        if(exp < 0) {
            return this.transposed().power(-exp);
        } else if(exp == 0) {
            return identity(this.rows);
        } else {
            Matrix result = this;
            for(int i = 1; i < exp; i++) {
                result = result.multiply(this);
            }
            return result;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Matrix && this.rows == ((Matrix) obj).rows && this.columns == ((Matrix) obj).columns) {
            for(int i = 0; i < this.elements.size(); i++) {
                if(this.elements.get(i).floatValue() != ((Matrix) obj).elements.get(i).floatValue())
                    return false;
            }
            return true;
        }
        return false;
    }
}
