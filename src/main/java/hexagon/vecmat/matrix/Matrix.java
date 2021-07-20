package hexagon.vecmat.matrix;

import hexagon.vecmat.exceptions.UnconformableMatrixException;
import hexagon.vecmat.exceptions.UndefinedOperationException;
import hexagon.vecmat.exceptions.VectorSizeException;
import hexagon.vecmat.vector.FloatN;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Matrix implements IMatrix<Matrix, FloatN> {
    
    public static Matrix zero(int rows, int columns) {
        return new Matrix(
                rows, columns,
                IntStream.range(0, rows * columns)
                        .mapToObj(i -> 0.0f)
                        .toArray(Float[]::new)
        );
    }
    
    public static Matrix identity(int size) {
        return new Matrix(
                size, size,
                IntStream.range(0, size * size)
                        .mapToObj(i -> i % size == i / size ? 1.0f : 0.0f)
                        .toArray(Float[]::new)
        );
    }
    
    public static Matrix fromRows(FloatN... rows) {
        if(rows.length == 0)
            throw new VectorSizeException("Matrix cannot have zero rows");
        
        Arrays.stream(rows).forEach(v -> {
            if(v.size() != rows[0].size())
                throw new VectorSizeException("All rows must have the same size");
        });
        
        return new Matrix(
                rows.length, rows[0].size(),
                Arrays.stream(rows)
                        .flatMap(FloatN::stream)
                        .toArray(Float[]::new)
        );
    }
    
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
    
    public float element(int row, int column) {
        if(row >= this.rows) throw new IndexOutOfBoundsException("Tried to get row " + row + " but matrix only has " + this.rows);
        if(column >= this.columns) throw new IndexOutOfBoundsException("Tried to get column " + column + " but matrix only has " + this.columns);
        return this.values.get(row * this.columns + column);
    }
    
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
            throw new IllegalArgumentException("Matrix only has " + this.rows + " rows");
        
        return new FloatN(
                IntStream.range(0, this.columns)
                        .mapToObj(i -> this.element(row, i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public FloatN getColumn(int column) {
        if(column >= this.columns || column < 0)
            throw new IllegalArgumentException("Matrix only has " + this.columns + " columns");
    
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
