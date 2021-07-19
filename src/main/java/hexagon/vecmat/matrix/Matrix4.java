package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Vector4;

/**
 * A class that represents a {@code 4x4} matrix. <br>
 *     This makes computations faster than using {@code Matrix}.
 */
public class Matrix4 implements MatrixOperations<Matrix4, Vector4> {

    /**
     * A {@code 4x4} matrix where every element is zero
     */
    public static final Matrix4 ZERO = new Matrix4(
            0.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f
    );

    /**
     * A {@code 4x4} matrix where every element on the diagonal is one
     * and every other element is zero
     */
    public static final Matrix4 IDENTITY = new Matrix4(
            1.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 1.0f
    );

    /**
     * Creates a {@code 4x4} matrix from the four given rows
     *
     * @param row0 First row
     * @param row1 Second row
     * @param row2 Third row
     * @param row3 Fourth row
     * @return A {@code 4x4} matrix whose rows are the four passed as parameters
     */
    public static Matrix4 fromRows(Vector4 row0, Vector4 row1, Vector4 row2, Vector4 row3) {
        return new Matrix4(
                row0.x, row0.y, row0.z, row0.w,
                row1.x, row1.y, row1.z, row1.w,
                row2.x, row2.y, row2.z, row2.w,
                row3.x, row3.y, row3.z, row3.w
        );
    }

    /**
     * Creates a {@code 4x4} matrix from the four given columns
     *
     * @param column0 First column
     * @param column1 Second column
     * @param column2 Third column
     * @param column3 Fourth column
     * @return A {@code 4x4} matrix whose columns are the four passed as parameters
     */
    public static Matrix4 fromColumns(Vector4 column0, Vector4 column1, Vector4 column2, Vector4 column3) {
        return new Matrix4(
                column0.x, column1.x, column2.x, column3.x,
                column0.y, column1.y, column2.y, column3.y,
                column0.z, column1.z, column2.z, column3.z,
                column0.w, column1.w, column2.w, column3.w
        );
    }

    public final float m00, m01, m02, m03;
    public final float m10, m11, m12, m13;
    public final float m20, m21, m22, m23;
    public final float m30, m31, m32, m33;

    private Matrix4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
        this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
        this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
        this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
    }

    @Override
    public Vector4 multiply(Vector4 vector) {
        float x = this.getRow(0).dotProduct(vector);
        float y = this.getRow(1).dotProduct(vector);
        float z = this.getRow(2).dotProduct(vector);
        float w = this.getRow(3).dotProduct(vector);
        return new Vector4(x, y, z, w);
    }

    @Override
    public Matrix4 plus(Matrix4 operand) {
        return new Matrix4(
                this.m00 + operand.m00, this.m01 + operand.m01, this.m02 + operand.m02, this.m03 + operand.m03,
                this.m10 + operand.m10, this.m11 + operand.m11, this.m12 + operand.m12, this.m13 + operand.m13,
                this.m20 + operand.m20, this.m21 + operand.m21, this.m22 + operand.m22, this.m23 + operand.m23,
                this.m30 + operand.m30, this.m31 + operand.m31, this.m32 + operand.m32, this.m33 + operand.m33
        );
    }

    @Override
    public Matrix4 negated() {
        return new Matrix4(
                -this.m00, -this.m01, -this.m02, -this.m03,
                -this.m10, -this.m11, -this.m12, -this.m13,
                -this.m20, -this.m21, -this.m22, -this.m23,
                -this.m30, -this.m31, -this.m32, -this.m33
        );
    }

    @Override
    public Matrix4 times(Float constant) {
        return new Matrix4(
                this.m00 * constant, this.m01 * constant, this.m02 * constant, this.m03 * constant,
                this.m10 * constant, this.m11 * constant, this.m12 * constant, this.m13 * constant,
                this.m20 * constant, this.m21 * constant, this.m22 * constant, this.m23 * constant,
                this.m30 * constant, this.m31 * constant, this.m32 * constant, this.m33 * constant
        );
    }

    @Override
    public Matrix4 dividedBy(Float constant) {
        return this.times(1.0f / constant);
    }

    @Override
    public Matrix4 reciprocal() {
        return new Matrix4(
                1.0f / this.m00, 1.0f / this.m01, 1.0f / this.m02, 1.0f / this.m03,
                1.0f / this.m10, 1.0f / this.m11, 1.0f / this.m12, 1.0f / this.m13,
                1.0f / this.m20, 1.0f / this.m21, 1.0f / this.m22, 1.0f / this.m23,
                1.0f / this.m30, 1.0f / this.m31, 1.0f / this.m32, 1.0f / this.m33
        );
    }

    @Override
    public boolean isSquare() {
        return true;
    }

    @Override
    public Vector4 getRow(int row) {
        switch(row) {
            case 0: return new Vector4(this.m00, this.m01, this.m02, this.m03);
            case 1: return new Vector4(this.m10, this.m11, this.m12, this.m13);
            case 2: return new Vector4(this.m20, this.m21, this.m22, this.m23);
            case 3: return new Vector4(this.m30, this.m31, this.m32, this.m33);
            default: throw new IndexOutOfBoundsException("Matrix only has 4 rows");
        }
    }

    @Override
    public Vector4 getColumn(int column) {
        switch(column) {
            case 0: return new Vector4(this.m00, this.m10, this.m20, this.m30);
            case 1: return new Vector4(this.m01, this.m11, this.m21, this.m31);
            case 2: return new Vector4(this.m02, this.m12, this.m22, this.m32);
            case 3: return new Vector4(this.m03, this.m13, this.m23, this.m33);
            default: throw new IndexOutOfBoundsException("Matrix only has 4 columns");
        }
    }

    @Override
    public Matrix4 transposed() {
        return new Matrix4(
                this.m00, this.m10, this.m20, this.m30,
                this.m01, this.m11, this.m21, this.m31,
                this.m02, this.m12, this.m22, this.m32,
                this.m03, this.m13, this.m23, this.m33
        );
    }

    @Override
    public boolean isSymmetric() {
        return this.m01 == this.m10 && this.m02 == this.m20 && this.m03 == this.m30 && this.m21 == this.m12 && this.m31 == this.m13 && this.m32 == this.m23;
    }

    @Override
    public boolean isSkewSymmetric() {
        return this.m01 == -this.m10 && this.m02 == -this.m20 && this.m03 == -this.m30 && this.m21 == -this.m12 && this.m31 == -this.m13 && this.m32 == -this.m23;
    }

    @Override
    public Matrix4 multiply(Matrix4 matrix) {
        return new Matrix4(
                this.getRow(0).dotProduct(matrix.getColumn(0)),
                this.getRow(0).dotProduct(matrix.getColumn(1)),
                this.getRow(0).dotProduct(matrix.getColumn(2)),
                this.getRow(0).dotProduct(matrix.getColumn(3)),
                this.getRow(1).dotProduct(matrix.getColumn(0)),
                this.getRow(1).dotProduct(matrix.getColumn(1)),
                this.getRow(1).dotProduct(matrix.getColumn(2)),
                this.getRow(1).dotProduct(matrix.getColumn(3)),
                this.getRow(2).dotProduct(matrix.getColumn(0)),
                this.getRow(2).dotProduct(matrix.getColumn(1)),
                this.getRow(2).dotProduct(matrix.getColumn(2)),
                this.getRow(2).dotProduct(matrix.getColumn(3)),
                this.getRow(3).dotProduct(matrix.getColumn(0)),
                this.getRow(3).dotProduct(matrix.getColumn(1)),
                this.getRow(3).dotProduct(matrix.getColumn(2)),
                this.getRow(3).dotProduct(matrix.getColumn(3))
        );
    }

    @Override
    public Matrix4 power(int exp) {
        if(exp < 0) {
            return this.transposed().power(-exp);
        } else if(exp == 0) {
            return IDENTITY;
        } else {
            Matrix4 result = this;
            for(int i = 0; i < exp - 1; i++) {
                result = result.multiply(this);
            }
            return result;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Matrix4) {
            Matrix4 mat = (Matrix4) obj;
            return this.m00 == mat.m00 && this.m01 == mat.m01 && this.m02 == mat.m02 && this.m03 == mat.m03
                    && this.m10 == mat.m10 && this.m11 == mat.m11 && this.m12 == mat.m12 && this.m13 == mat.m13
                    && this.m20 == mat.m20 && this.m21 == mat.m21 && this.m22 == mat.m22 && this.m23 == mat.m23
                    && this.m30 == mat.m30 && this.m31 == mat.m31 && this.m32 == mat.m32 && this.m33 == mat.m33;
        }
        return false;
    }
}
