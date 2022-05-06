package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Float4;
import hexagon.vecmat.vector.Int4;

public record IntMatrix4(
	int m11, int m12, int m13, int m14,
	int m21, int m22, int m23, int m24,
	int m31, int m32, int m33, int m34,
	int m41, int m42, int m43, int m44
) {

	public static final IntMatrix4 IDENTITY = new IntMatrix4(
		1, 0, 0, 0,
		0, 1, 0, 0,
		0, 0, 1, 0,
		0, 0, 0, 1
	);

	public static final IntMatrix4 ZERO = new IntMatrix4(
		0, 0, 0, 0,
		0, 0, 0, 0,
		0, 0, 0, 0,
		0, 0, 0, 0
	);

	public IntMatrix4 plus(IntMatrix4 matrix) {
		return matrix != null ? new IntMatrix4(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(), this.m14() + matrix.m14(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(), this.m24() + matrix.m24(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33(), this.m34() + matrix.m34(),
			this.m41() + matrix.m41(), this.m42() + matrix.m42(), this.m43() + matrix.m43(), this.m44() + matrix.m44()
		) : this;
	}

	public FloatMatrix4 plus(FloatMatrix4 matrix) {
		return this.asFloat().plus(matrix);
	}

	public IntMatrix4 minus(IntMatrix4 matrix) {
		return matrix != null ? new IntMatrix4(
			this.m11() - matrix.m11(), this.m12() - matrix.m12(), this.m13() - matrix.m13(), this.m14() - matrix.m14(),
			this.m21() - matrix.m21(), this.m22() - matrix.m22(), this.m23() - matrix.m23(), this.m24() - matrix.m24(),
			this.m31() - matrix.m31(), this.m32() - matrix.m32(), this.m33() - matrix.m33(), this.m34() - matrix.m34(),
			this.m41() - matrix.m41(), this.m42() - matrix.m42(), this.m43() - matrix.m43(), this.m44() - matrix.m44()
		) : this;
	}

	public FloatMatrix4 minus(FloatMatrix4 matrix) {
		return this.asFloat().minus(matrix);
	}

	public IntMatrix4 multiply(int k) {
		return new IntMatrix4(
			this.m11() * k, this.m12() * k, this.m13() * k, this.m14() * k,
			this.m21() * k, this.m22() * k, this.m23() * k, this.m24() * k,
			this.m31() * k, this.m32() * k, this.m33() * k, this.m34() * k,
			this.m41() * k, this.m42() * k, this.m43() * k, this.m44() * k
		);
	}

	public FloatMatrix4 multiply(float k) {
		return this.asFloat().multiply(k);
	}

	public Int4 row1() {
		return new Int4(this.m11(), this.m12(), this.m13(), this.m14());
	}

	public Int4 row2() {
		return new Int4(this.m21(), this.m22(), this.m23(), this.m24());
	}

	public Int4 row3() {
		return new Int4(this.m31(), this.m32(), this.m33(), this.m34());
	}

	public Int4 row4() {
		return new Int4(this.m41(), this.m42(), this.m43(), this.m44());
	}

	public Int4 column1() {
		return new Int4(this.m11(), this.m21(), this.m31(), this.m41());
	}

	public Int4 column2() {
		return new Int4(this.m12(), this.m22(), this.m32(), this.m42());
	}

	public Int4 column3() {
		return new Int4(this.m13(), this.m23(), this.m33(), this.m43());
	}

	public Int4 column4() {
		return new Int4(this.m14(), this.m24(), this.m34(), this.m44());
	}

	public Int4 multiply(Int4 vector) {
		return new Int4(
			this.row1().dotProduct(vector),
			this.row2().dotProduct(vector),
			this.row3().dotProduct(vector),
			this.row4().dotProduct(vector)
		);
	}

	public Float4 multiply(Float4 vector) {
		return this.asFloat().multiply(vector);
	}

	public IntMatrix4 transposed() {
		return new IntMatrix4(
			this.m11(), this.m21(), this.m31(), this.m41(),
			this.m12(), this.m22(), this.m32(), this.m42(),
			this.m13(), this.m23(), this.m33(), this.m43(),
			this.m14(), this.m24(), this.m34(), this.m44() 
		);
	}

	public boolean isSymmetric() {
		return this.m21() == this.m12() &&
				this.m13() == this.m31() && this.m23() == this.m32() &&
				this.m14() == this.m41() && this.m24() == this.m42() && this.m34() == this.m43();
	}

	public boolean isSkewSymmetric() {
		return this.m21() == -this.m12() &&
				this.m13() == -this.m31() && this.m23() == -this.m32() &&
				this.m14() == -this.m41() && this.m24() == -this.m42() && this.m34() == -this.m43();
	}

	public IntMatrix4 multiply(IntMatrix4 matrix) {
		return matrix != null ? new IntMatrix4(
			this.row1().dotProduct(matrix.column1()),
			this.row1().dotProduct(matrix.column2()),
			this.row1().dotProduct(matrix.column3()),
			this.row1().dotProduct(matrix.column4()),
			this.row2().dotProduct(matrix.column1()),
			this.row2().dotProduct(matrix.column2()),
			this.row2().dotProduct(matrix.column3()),
			this.row2().dotProduct(matrix.column4()),
			this.row3().dotProduct(matrix.column1()),
			this.row3().dotProduct(matrix.column2()),
			this.row3().dotProduct(matrix.column3()),
			this.row3().dotProduct(matrix.column4()),
			this.row4().dotProduct(matrix.column1()),
			this.row4().dotProduct(matrix.column2()),
			this.row4().dotProduct(matrix.column3()),
			this.row4().dotProduct(matrix.column4())
		) : ZERO;
	}

	public FloatMatrix4 multiply(FloatMatrix4 matrix) {
		return this.asFloat().multiply(matrix);
	}

	public IntMatrix4 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			return this.multiply(this.power(exponent - 1));
		}
	}

	public FloatMatrix4 asFloat() {
		return new FloatMatrix4(
			this.m11(), this.m12(), this.m13(), this.m14(),
			this.m21(), this.m22(), this.m23(), this.m24(),
			this.m31(), this.m32(), this.m33(), this.m34(),
			this.m41(), this.m42(), this.m43(), this.m44()
		);
	}
}
