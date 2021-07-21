package hexagon.vecmat.matrix;

import hexagon.vecmat.exceptions.UnconformableMatrixException;
import hexagon.vecmat.exceptions.UndefinedOperationException;
import hexagon.vecmat.exceptions.VectorSizeException;
import hexagon.vecmat.vector.FloatN;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/** A class representing an NxM matrix
 *
 * @author Nico
 *
 * @see IMatrix
 * @see FloatN
 */
public class Matrix implements IMatrix<Matrix, FloatN> {
    
    /** Creates a matrix of the specified size where every element is 0
     * @param rows Number of rows
     * @param columns Number of columns
     * @return A new NxM matrix where every element is zero
     */
    public static Matrix zero(int rows, int columns) {
        return new Matrix(rows, columns,
                IntStream.range(0, rows * columns)
                        .mapToObj(i -> 0.0f)
                        .toArray(Float[]::new)
        );
    }
    
    /** Creates a square matrix of the specified size where every
     * element on the diagonal is 1 and every other element is 0
     * @param size Number of rows and columns
     * @return A new identity matrix
     */
    public static Matrix identity(int size) {
        return new Matrix(size, size,
                IntStream.range(0, size * size)
                        .mapToObj(i -> i % size == i / size ? 1.0f : 0.0f)
                        .toArray(Float[]::new)
        );
    }
    
    /** Creates a matrix from the given rows
     * @param rows Rows of the matrix
     * @return A new matrix whose rows are the given vectors
     * @throws VectorSizeException if the given rows are empty or they have different sizes
     */
    public static Matrix fromRows(FloatN... rows) {
        if(rows.length == 0)
            throw new VectorSizeException("Matrix cannot be empty");
        
        Arrays.stream(rows).forEach(v -> {
            if(v.size() != rows[0].size())
                throw new VectorSizeException("All rows must have the same size");
        });
        
        return new Matrix(rows.length, rows[0].size(),
                Arrays.stream(rows)
                        .flatMap(FloatN::stream)
                        .toArray(Float[]::new)
        );
    }
    
    /** Creates a matrix from the given columns
     * @param columns Rows of the matrix
     * @return A new matrix whose columns are the given vectors
     * @throws VectorSizeException if the given columns are empty or they have different sizes
     */
    public static Matrix fromColumns(FloatN... columns) {
        return fromRows(columns).transposed();
    }
    
    private final List<Float> values;
    public final int rows, columns;
    
    private Matrix(int rows, int columns, Float... values) {
        this.rows = rows;
        this.columns = columns;
        this.values = Arrays.asList(values);
    }
    
    /** Gets an element in the matrix
     * @param row Row index of the element
     * @param column Column index of the element
     * @return The element at the specified row and column
     * @throws IndexOutOfBoundsException if row < 0 or column < 0 or row >= rows or column >= columns
     */
    public float element(int row, int column) {
        if(row >= this.rows) throw new IndexOutOfBoundsException("Tried to get row " + row + " but matrix only has " + this.rows);
        if(column >= this.columns) throw new IndexOutOfBoundsException("Tried to get column " + column + " but matrix only has " + this.columns);
        return this.values.get(row * this.columns + column);
    }
    
    /** {@inheritDoc}
     * @param matrix Right-hand operand of the sum.
     * @return The sum of this matrix and {@code operand}
     * @throws UndefinedOperationException if the two matrices have a different form
     */
    @Override
    public Matrix plus(Matrix matrix) {
        if(this.rows != matrix.rows || this.columns != matrix.columns)
            throw new UndefinedOperationException("Matrices can only be summed if they have the same form");
        
        return new Matrix(this.rows, this.columns,
                IntStream.range(0, this.values.size())
                        .mapToObj(i -> this.values.get(i) + matrix.values.get(i))
                        .toArray(Float[]::new)
        );
    }
    
    /** {@inheritDoc}
     * @param matrix Right-hand operand of the subtraction.
     * @return The difference of this matrix and {@code operand}
     * @throws UndefinedOperationException if the two matrices have a different form
     */
    @Override
    public Matrix minus(Matrix matrix) {
        if(this.rows != matrix.rows || this.columns != matrix.columns)
            throw new UndefinedOperationException("Matrices can only be summed if they have the same form");
    
        return new Matrix(this.rows, this.columns,
                IntStream.range(0, this.values.size())
                        .mapToObj(i -> this.values.get(i) - matrix.values.get(i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public Matrix negative() {
        return new Matrix(this.rows, this.columns,
                this.values.stream()
                        .map(f -> -f)
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public Matrix multiply(float constant) {
        return new Matrix(this.rows, this.columns,
                this.values.stream()
                        .map(f -> f * constant)
                        .toArray(Float[]::new)
        );
    }
    
    /** {@inheritDoc}
     * @param vector The vector to multiply
     * @return A vector that is the product of this matrix and the given vector
     * @throws UnconformableMatrixException if the given vector's size is different from the matrix's columns
     */
    @Override
    public FloatN multiply(FloatN vector) {
        if(vector.size() != this.columns)
            throw new UnconformableMatrixException(this, vector);
    
        return new FloatN(
                IntStream.range(0, this.rows)
                        .mapToObj(i -> this.getRow(i).dotProduct(vector))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public boolean isSquare() {
        return this.rows == this.columns;
    }
    
    @Override
    public FloatN getRow(int row) {
        if(row >= this.rows || row < 0)
            throw new IndexOutOfBoundsException("Matrix only has " + this.rows + " rows");
        
        return new FloatN(
                IntStream.range(0, this.columns)
                        .mapToObj(i -> this.element(row, i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public FloatN getColumn(int column) {
        if(column >= this.columns || column < 0)
            throw new IndexOutOfBoundsException("Matrix only has " + this.columns + " columns");
    
        return new FloatN(
                IntStream.range(0, this.rows)
                        .mapToObj(i -> this.element(i, column))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public Matrix transposed() {
        return new Matrix(this.rows, this.columns,
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
        if(this.isSquare()) return this.equals(this.transposed().negative());
        else return false;
    }
    
    /** {@inheritDoc}
     * @param matrix The second operand of the multiplication
     * @return The product of the two matrices
     * @throws UnconformableMatrixException If the two matrices cannot be multiplied
     */
    @Override
    public Matrix multiply(Matrix matrix) {
        if(this.columns != matrix.rows)
            throw new UnconformableMatrixException(this, matrix);
    
        return new Matrix(this.rows, this.columns,
                IntStream.range(0, this.rows * matrix.columns)
                        .mapToObj(i -> this.getRow(i / matrix.columns).dotProduct(matrix.getColumn(i % matrix.columns)))
                        .toArray(Float[]::new)
        );
    }
    
    /** {@inheritDoc}
     * @param exp Exponent
     * @return The {@code n}-th power of this matrix
     * @throws UnconformableMatrixException if this matrix is not a square matrix
     */
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
            for(int i = 0; i < this.values.size(); i++) {
                if(this.values.get(i).floatValue() != ((Matrix) obj).values.get(i).floatValue())
                    return false;
            }
            return true;
        }
        return false;
    }
}
