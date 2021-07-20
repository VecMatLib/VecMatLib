package hexagon.vecmat.matrix_old;

import hexagon.vecmat.vector_old.Vector3;

/**
 * A class that represents a {@code 3x3} matrix. <br>
 *     This makes computations faster than using {@code Matrix}.
 */
public class Matrix3 implements MatrixOperations<Matrix3, Vector3> {

    /**
     * A {@code 3x3} matrix where every element is zero
     */
    public static final Matrix3 ZERO = new Matrix3(
            0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f
    );

    /**
     * A {@code 3x3} matrix where every element on the diagonal is one
     * and every other element is zero
     */
    public static final Matrix3 IDENTITY = new Matrix3(
            1.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 1.0f
    );

    /**
     * Creates a {@code 3x3} matrix from the three given rows
     *
     * @param row0 First row
     * @param row1 Second row
     * @param row2 Third row
     * @return A {@code 3x3} matrix whose rows are the three passed as parameters
     */
    public static Matrix3 fromRows(Vector3 row0, Vector3 row1, Vector3 row2) {
        return new Matrix3(
                row0.x, row0.y, row0.z,
                row1.x, row1.y, row1.z,
                row2.x, row2.y, row2.z
        );
    }

    /**
     * Creates a {@code 3x3} matrix from the three given columns
     *
     * @param column0 First column
     * @param column1 Second column
     * @param column2 Third column
     * @return A {@code 3x3} matrix whose columns are the three passed as parameters
     */
    public static Matrix3 fromColumns(Vector3 column0, Vector3 column1, Vector3 column2) {
        return new Matrix3(
                column0.x, column1.x, column2.x,
                column0.y, column1.y, column2.y,
                column0.z, column1.z, column2.z
        );
    }

    public final float m00, m01, m02;
    public final float m10, m11, m12;
    public final float m20, m21, m22;

    private Matrix3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
    }

    @Override
    public Vector3 multiply(Vector3 vector) {
        float x = this.getRow(0).dotProduct(vector);
        float y = this.getRow(1).dotProduct(vector);
        float z = this.getRow(2).dotProduct(vector);
        return new Vector3(x, y, z);
    }

    @Override
    public Matrix3 plus(Matrix3 operand) {
        return new Matrix3(
                this.m00 + operand.m00, this.m01 + operand.m01, this.m02 + operand.m02,
                this.m10 + operand.m10, this.m11 + operand.m11, this.m12 + operand.m12,
                this.m20 + operand.m20, this.m21 + operand.m21, this.m22 + operand.m22
        );
    }

    @Override
    public Matrix3 negated() {
        return new Matrix3(
                -this.m00, -this.m01, -this.m02,
                -this.m10, -this.m11, -this.m12,
                -this.m20, -this.m21, -this.m22
        );
    }

    @Override
    public Matrix3 times(Float constant) {
        return new Matrix3(
                this.m00 * constant, this.m01 * constant, this.m02 * constant,
                this.m10 * constant, this.m11 * constant, this.m12 * constant,
                this.m20 * constant, this.m21 * constant, this.m22 * constant
        );
    }

    @Override
    public Matrix3 dividedBy(Float constant) {
        return this.times(1.0f / constant);
    }

    @Override
    public Matrix3 reciprocal() {
        return new Matrix3(
                1.0f / this.m00, 1.0f / this.m01, 1.0f / this.m02,
                1.0f / this.m10, 1.0f / this.m11, 1.0f / this.m12,
                1.0f / this.m20, 1.0f / this.m21, 1.0f / this.m22
        );
    }

    @Override
    public boolean isSquare() {
        return true;
    }

    @Override
    public Vector3 getRow(int row) {
        switch(row) {
            case 0: return new Vector3(this.m00, this.m01, this.m02);
            case 1: return new Vector3(this.m10, this.m11, this.m12);
            case 2: return new Vector3(this.m20, this.m21, this.m22);
            default: throw new IndexOutOfBoundsException("Matrix only has 3 rows");
        }
    }

    @Override
    public Vector3 getColumn(int column) {
        switch(column) {
            case 0: return new Vector3(this.m00, this.m10, this.m20);
            case 1: return new Vector3(this.m01, this.m11, this.m21);
            case 2: return new Vector3(this.m02, this.m12, this.m22);
            default: throw new IndexOutOfBoundsException("Matrix only has 3 columns");
        }
    }

    @Override
    public Matrix3 transposed() {
        return new Matrix3(
                this.m00, this.m10, this.m20,
                this.m01, this.m11, this.m21,
                this.m02, this.m12, this.m22
        );
    }

    @Override
    public boolean isSymmetric() {
        return this.m01 == this.m10 && this.m02 == this.m20 && this.m21 == this.m12;
    }

    @Override
    public boolean isSkewSymmetric() {
        return this.m01 == -this.m10 && this.m02 == -this.m20 && this.m21 == -this.m12;
    }

    @Override
    public Matrix3 multiply(Matrix3 matrix) {
        return new Matrix3(
                this.getRow(0).dotProduct(matrix.getColumn(0)),
                this.getRow(0).dotProduct(matrix.getColumn(1)),
                this.getRow(0).dotProduct(matrix.getColumn(2)),
                this.getRow(1).dotProduct(matrix.getColumn(0)),
                this.getRow(1).dotProduct(matrix.getColumn(1)),
                this.getRow(1).dotProduct(matrix.getColumn(2)),
                this.getRow(2).dotProduct(matrix.getColumn(0)),
                this.getRow(2).dotProduct(matrix.getColumn(1)),
                this.getRow(2).dotProduct(matrix.getColumn(2))
        );
    }

    @Override
    public Matrix3 power(int exp) {
        if(exp < 0) {
            return this.transposed().power(-exp);
        } else if(exp == 0) {
            return IDENTITY;
        } else {
            Matrix3 result = this;
            for(int i = 0; i < exp - 1; i++) {
                result = result.multiply(this);
            }
            return result;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Matrix3) {
            Matrix3 mat = (Matrix3) obj;
            return this.m00 == mat.m00 && this.m01 == mat.m01 && this.m02 == mat.m02
                    && this.m10 == mat.m10 && this.m11 == mat.m11 && this.m12 == mat.m12
                    && this.m20 == mat.m20 && this.m21 == mat.m21 && this.m22 == mat.m22;
        }
        return false;
    }
}
