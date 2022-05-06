package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Float4;
import hexagon.vecmat.vector.Int4;

public record FloatMatrix4(
	float m11, float m12, float m13, float m14,
	float m21, float m22, float m23, float m24,
	float m31, float m32, float m33, float m34,
	float m41, float m42, float m43, float m44
) {

	public static final FloatMatrix4 IDENTITY = new FloatMatrix4(
		1.0f, 0.0f, 0.0f, 0.0f,
		0.0f, 1.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 1.0f, 0.0f,
		0.0f, 0.0f, 0.0f, 1.0f
	);

	public static final FloatMatrix4 ZERO = new FloatMatrix4(
		0.0f, 0.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 0.0f, 0.0f
	);

	public FloatMatrix4 plus(FloatMatrix4 matrix) {
		return matrix != null ? new FloatMatrix4(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(), this.m14() + matrix.m14(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(), this.m24() + matrix.m24(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33(), this.m34() + matrix.m34(),
			this.m41() + matrix.m41(), this.m42() + matrix.m42(), this.m43() + matrix.m43(), this.m44() + matrix.m44()
		) : this;
	}

	public FloatMatrix4 plus(IntMatrix4 matrix) {
		return matrix != null ? this.plus(matrix.asFloat()) : this;
	}

	public FloatMatrix4 minus(FloatMatrix4 matrix) {
		return matrix != null ? new FloatMatrix4(
			this.m11() - matrix.m11(), this.m12() - matrix.m12(), this.m13() - matrix.m13(), this.m14() - matrix.m14(),
			this.m21() - matrix.m21(), this.m22() - matrix.m22(), this.m23() - matrix.m23(), this.m24() - matrix.m24(),
			this.m31() - matrix.m31(), this.m32() - matrix.m32(), this.m33() - matrix.m33(), this.m34() - matrix.m34(),
			this.m41() - matrix.m41(), this.m42() - matrix.m42(), this.m43() - matrix.m43(), this.m44() - matrix.m44()
		) : this;
	}

	public FloatMatrix4 minus(IntMatrix4 matrix) {
		return matrix != null ? this.minus(matrix.asFloat()) : this;
	}

	public FloatMatrix4 multiply(float k) {
		return new FloatMatrix4(
			this.m11() * k, this.m12() * k, this.m13() * k, this.m14() * k,
			this.m21() * k, this.m22() * k, this.m23() * k, this.m24() * k,
			this.m31() * k, this.m32() * k, this.m33() * k, this.m34() * k,
			this.m41() * k, this.m42() * k, this.m43() * k, this.m44() * k
		);
	}

	public Float4 row1() {
		return new Float4(this.m11(), this.m12(), this.m13(), this.m14());
	}

	public Float4 row2() {
		return new Float4(this.m21(), this.m22(), this.m23(), this.m24());
	}

	public Float4 row3() {
		return new Float4(this.m31(), this.m32(), this.m33(), this.m34());
	}

	public Float4 row4() {
		return new Float4(this.m41(), this.m42(), this.m43(), this.m44());
	}

	public Float4 column1() {
		return new Float4(this.m11(), this.m21(), this.m31(), this.m41());
	}

	public Float4 column2() {
		return new Float4(this.m12(), this.m22(), this.m32(), this.m42());
	}

	public Float4 column3() {
		return new Float4(this.m13(), this.m23(), this.m33(), this.m43());
	}

	public Float4 column4() {
		return new Float4(this.m14(), this.m24(), this.m34(), this.m44());
	}

	public Float4 multiply(Float4 vector) {
		return new Float4(
			this.row1().dotProduct(vector),
			this.row2().dotProduct(vector),
			this.row3().dotProduct(vector),
			this.row4().dotProduct(vector)
		);
	}

	public Float4 multiply(Int4 vector) {
		return vector != null ? this.multiply(vector.asFloat()) : Float4.ZERO;
	}

	public FloatMatrix4 transposed() {
		return new FloatMatrix4(
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

	public FloatMatrix4 multiply(FloatMatrix4 matrix) {
		return matrix != null ? new FloatMatrix4(
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

	public FloatMatrix4 multiply(IntMatrix4 matrix) {
		return matrix != null ? this.multiply(matrix.asFloat()) : ZERO;
	}

	public FloatMatrix4 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			return this.multiply(this.power(exponent - 1));
		}
	}

	public IntMatrix4 castToInt() {
		return new IntMatrix4(
			(int) this.m11(), (int) this.m12(), (int) this.m13(), (int) this.m14(),
			(int) this.m21(), (int) this.m22(), (int) this.m23(), (int) this.m24(),
			(int) this.m31(), (int) this.m32(), (int) this.m33(), (int) this.m34(),
			(int) this.m41(), (int) this.m42(), (int) this.m43(), (int) this.m44()
		);
	}
}
