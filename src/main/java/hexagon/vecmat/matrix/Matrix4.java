package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Float4;
import hexagon.vecmat.vector.Int4;

public class Matrix4 implements IMatrix<Matrix4, Float4> {
    
    public static final Matrix4 ZERO = new Matrix4(
            0.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 0.0f
    );
    
    public static final Matrix4 IDENTITY = new Matrix4(
            1.0f, 0.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 0.0f, 1.0f
    );
    
    public static Matrix4 fromRows(Float4 row0, Float4 row1, Float4 row2, Float4 row3) {
        return new Matrix4(
                row0.x, row0.y, row0.z, row0.w,
                row1.x, row1.y, row1.z, row1.w,
                row2.x, row2.y, row2.z, row2.w,
                row3.x, row3.y, row3.z, row3.w
        );
    }
    
    public static Matrix4 fromColumns(Float4 column0, Float4 column1, Float4 column2, Float4 column3) {
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
    
    public Matrix4(float m00, float m01, float m02, float m03, float m10, float m11, float m12, float m13, float m20, float m21, float m22, float m23, float m30, float m31, float m32, float m33) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02; this.m03 = m03;
        this.m10 = m10; this.m11 = m11; this.m12 = m12; this.m13 = m13;
        this.m20 = m20; this.m21 = m21; this.m22 = m22; this.m23 = m23;
        this.m30 = m30; this.m31 = m31; this.m32 = m32; this.m33 = m33;
    }
    
    @Override
    public Matrix4 plus(Matrix4 matrix) {
        return new Matrix4(
                this.m00 + matrix.m00, this.m01 + matrix.m01, this.m02 + matrix.m02, this.m03 + matrix.m03,
                this.m10 + matrix.m10, this.m11 + matrix.m11, this.m12 + matrix.m12, this.m13 + matrix.m13,
                this.m20 + matrix.m20, this.m21 + matrix.m21, this.m22 + matrix.m22, this.m23 + matrix.m23,
                this.m30 + matrix.m30, this.m31 + matrix.m31, this.m32 + matrix.m32, this.m33 + matrix.m33
        );
    }
    
    @Override
    public Matrix4 minus(Matrix4 matrix) {
        return new Matrix4(
                this.m00 - matrix.m00, this.m01 - matrix.m01, this.m02 - matrix.m02, this.m03 - matrix.m03,
                this.m10 - matrix.m10, this.m11 - matrix.m11, this.m12 - matrix.m12, this.m13 - matrix.m13,
                this.m20 - matrix.m20, this.m21 - matrix.m21, this.m22 - matrix.m22, this.m23 - matrix.m23,
                this.m30 - matrix.m30, this.m31 - matrix.m31, this.m32 - matrix.m32, this.m33 - matrix.m33
        );
    }
    
    @Override
    public Matrix4 multiply(float constant) {
        return new Matrix4(
                this.m00 * constant, this.m01 * constant, this.m02 * constant, this.m03 * constant,
                this.m10 * constant, this.m11 * constant, this.m12 * constant, this.m13 * constant,
                this.m20 * constant, this.m21 * constant, this.m22 * constant, this.m23 * constant,
                this.m30 * constant, this.m31 * constant, this.m32 * constant, this.m33 * constant
        );
    }
    
    @Override
    public Float4 multiply(Float4 vector) {
        float x = this.getRow(0).dotProduct(vector);
        float y = this.getRow(1).dotProduct(vector);
        float z = this.getRow(2).dotProduct(vector);
        float w = this.getRow(3).dotProduct(vector);
        return new Float4(x, y, z, w);
    }
    
    public Float4 multiply(Int4 vector) {
        float x = this.getRow(0).dotProduct(vector);
        float y = this.getRow(1).dotProduct(vector);
        float z = this.getRow(2).dotProduct(vector);
        float w = this.getRow(3).dotProduct(vector);
        return new Float4(x, y, z, w);
    }
    
    @Override
    public boolean isSquare() {
        return true;
    }
    
    @Override
    public Float4 getRow(int row) {
        return switch (row) {
            case 0 -> new Float4(this.m00, this.m01, this.m02, this.m03);
            case 1 -> new Float4(this.m10, this.m11, this.m12, this.m13);
            case 2 -> new Float4(this.m20, this.m21, this.m22, this.m23);
            case 3 -> new Float4(this.m30, this.m31, this.m32, this.m33);
            default -> throw new IndexOutOfBoundsException("Matrix only has 4 rows");
        };
    }
    
    @Override
    public Float4 getColumn(int column) {
        return switch (column) {
            case 0 -> new Float4(this.m00, this.m10, this.m20, this.m30);
            case 1 -> new Float4(this.m01, this.m11, this.m21, this.m31);
            case 2 -> new Float4(this.m02, this.m12, this.m22, this.m32);
            case 3 -> new Float4(this.m03, this.m13, this.m23, this.m33);
            default -> throw new IndexOutOfBoundsException("Matrix only has 4 columns");
        };
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
            for(int i = 1; i < exp; i++) {
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
    
    @Override
    public String toString() {
        return "[" + this.m00 + " " + this.m01 + " " + this.m02 + " " + this.m03 + "]\n" +
                "[" + this.m10 + " " + this.m11 + " " + this.m12 + " " + this.m13 + "]\n" +
                "[" + this.m20 + " " + this.m21 + " " + this.m22 + " " + this.m23 + "]\n" +
                "[" + this.m30 + " " + this.m31 + " " + this.m32 + " " + this.m33 + "]\n";
    }
}
