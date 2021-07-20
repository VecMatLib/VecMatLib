package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Float3;
import hexagon.vecmat.vector.Int3;

public class Matrix3 implements IMatrix<Matrix3, Float3> {
    
    public static final Matrix3 ZERO = new Matrix3(
            0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f,
            0.0f, 0.0f, 0.0f
    );
    
    public static final Matrix3 IDENTITY = new Matrix3(
            1.0f, 0.0f, 0.0f,
            0.0f, 1.0f, 0.0f,
            0.0f, 0.0f, 1.0f
    );
    
    public static Matrix3 fromRows(Float3 row0, Float3 row1, Float3 row2) {
        return new Matrix3(
                row0.x, row0.y, row0.z,
                row1.x, row1.y, row1.z,
                row2.x, row2.y, row2.z
        );
    }
    
    public static Matrix3 fromColumns(Float3 column0, Float3 column1, Float3 column2) {
        return new Matrix3(
                column0.x, column1.x, column2.x,
                column0.y, column1.y, column2.y,
                column0.z, column1.z, column2.z
        );
    }
    
    public final float m00, m01, m02;
    public final float m10, m11, m12;
    public final float m20, m21, m22;
    
    public Matrix3(float m00, float m01, float m02, float m10, float m11, float m12, float m20, float m21, float m22) {
        this.m00 = m00; this.m01 = m01; this.m02 = m02;
        this.m10 = m10; this.m11 = m11; this.m12 = m12;
        this.m20 = m20; this.m21 = m21; this.m22 = m22;
    }
    
    @Override
    public Matrix3 plus(Matrix3 matrix) {
        return new Matrix3(
                this.m00 + matrix.m00, this.m01 + matrix.m01, this.m02 + matrix.m02,
                this.m10 + matrix.m10, this.m11 + matrix.m11, this.m12 + matrix.m12,
                this.m20 + matrix.m20, this.m21 + matrix.m21, this.m22 + matrix.m22
        );
    }
    
    @Override
    public Matrix3 minus(Matrix3 matrix) {
        return new Matrix3(
                this.m00 - matrix.m00, this.m01 - matrix.m01, this.m02 - matrix.m02,
                this.m10 - matrix.m10, this.m11 - matrix.m11, this.m12 - matrix.m12,
                this.m20 - matrix.m20, this.m21 - matrix.m21, this.m22 - matrix.m22
        );
    }
    
    @Override
    public Matrix3 multiply(float constant) {
        return new Matrix3(
                this.m00 * constant, this.m01 * constant, this.m02 * constant,
                this.m10 * constant, this.m11 * constant, this.m12 * constant,
                this.m20 * constant, this.m21 * constant, this.m22 * constant
        );
    }
    
    @Override
    public Float3 multiply(Float3 vector) {
        float x = this.getRow(0).dotProduct(vector);
        float y = this.getRow(1).dotProduct(vector);
        float z = this.getRow(2).dotProduct(vector);
        return new Float3(x, y, z);
    }
    
    public Float3 multiply(Int3 vector) {
        float x = this.getRow(0).dotProduct(vector);
        float y = this.getRow(1).dotProduct(vector);
        float z = this.getRow(2).dotProduct(vector);
        return new Float3(x, y, z);
    }
    
    @Override
    public boolean isSquare() {
        return true;
    }
    
    @Override
    public Float3 getRow(int row) {
        return switch (row) {
            case 0 -> new Float3(this.m00, this.m01, this.m02);
            case 1 -> new Float3(this.m10, this.m11, this.m12);
            case 2 -> new Float3(this.m20, this.m21, this.m22);
            default -> throw new IndexOutOfBoundsException("Matrix only has 3 rows");
        };
    }
    
    @Override
    public Float3 getColumn(int column) {
        return switch (column) {
            case 0 -> new Float3(this.m00, this.m10, this.m20);
            case 1 -> new Float3(this.m01, this.m11, this.m21);
            case 2 -> new Float3(this.m02, this.m12, this.m22);
            default -> throw new IndexOutOfBoundsException("Matrix only has 3 columns");
        };
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
            for(int i = 1; i < exp; i++) {
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
    
    @Override
    public String toString() {
        return '[' + this.m00 + ' ' + this.m01 + ' ' + this.m02 + "]\n" +
                '[' + this.m10 + ' ' + this.m11 + ' ' + this.m12 + "]\n" +
                '[' + this.m20 + ' ' + this.m21 + ' ' + this.m22 + "]\n";
    }
}
