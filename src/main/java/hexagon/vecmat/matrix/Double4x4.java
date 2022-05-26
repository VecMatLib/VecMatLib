package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Double4;
import hexagon.vecmat.vector.VectorAsDouble;

public record Double4x4(
	double m11, double m12, double m13, double m14,
	double m21, double m22, double m23, double m24,
	double m31, double m32, double m33, double m34,
	double m41, double m42, double m43, double m44
) implements MatrixDoubleOperations<Double4x4, Double4> {

	public static final Double4x4 IDENTITY = new Double4x4(
		1.0, 0.0, 0.0, 0.0,
		0.0, 1.0, 0.0, 0.0,
		0.0, 0.0, 1.0, 0.0,
		0.0, 0.0, 0.0, 1.0
	);

	public static final Double4x4 ZERO = new Double4x4(
		0.0, 0.0, 0.0, 0.0,
		0.0, 0.0, 0.0, 0.0,
		0.0, 0.0, 0.0, 0.0,
		0.0, 0.0, 0.0, 0.0
	);

	@Override
	public Double4x4 plus(Double4x4 matrix) {
		return matrix != null ? new Double4x4(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(), this.m14() + matrix.m14(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(), this.m24() + matrix.m24(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33(), this.m34() + matrix.m34(),
			this.m41() + matrix.m41(), this.m42() + matrix.m42(), this.m43() + matrix.m43(), this.m44() + matrix.m44()
		) : this;
	}

	@Override
	public Double4x4 negative() {
		return new Double4x4(
			-this.m11(), -this.m12(), -this.m13(), -this.m14(),
			-this.m21(), -this.m22(), -this.m23(), -this.m24(),
			-this.m31(), -this.m32(), -this.m33(), -this.m34(),
			-this.m41(), -this.m42(), -this.m43(), -this.m44()
		);
	}

	@Override
	public Double4x4 multipliedBy(double k) {
		return new Double4x4(
			this.m11() * k, this.m12() * k, this.m13() * k, this.m14() * k,
			this.m21() * k, this.m22() * k, this.m23() * k, this.m24() * k,
			this.m31() * k, this.m32() * k, this.m33() * k, this.m34() * k,
			this.m41() * k, this.m42() * k, this.m43() * k, this.m44() * k
		);
	}

	public Double4 row1() {
		return new Double4(this.m11(), this.m12(), this.m13(), this.m14());
	}

	public Double4 row2() {
		return new Double4(this.m21(), this.m22(), this.m23(), this.m24());
	}

	public Double4 row3() {
		return new Double4(this.m31(), this.m32(), this.m33(), this.m34());
	}

	public Double4 row4() {
		return new Double4(this.m41(), this.m42(), this.m43(), this.m44());
	}

	public Double4 column1() {
		return new Double4(this.m11(), this.m21(), this.m31(), this.m41());
	}

	public Double4 column2() {
		return new Double4(this.m12(), this.m22(), this.m32(), this.m42());
	}

	public Double4 column3() {
		return new Double4(this.m13(), this.m23(), this.m33(), this.m43());
	}

	public Double4 column4() {
		return new Double4(this.m14(), this.m24(), this.m34(), this.m44());
	}

	@Override
	public Double4 multiply(Double4 vector) {
		return new Double4(
			this.row1().dotProduct(vector),
			this.row2().dotProduct(vector),
			this.row3().dotProduct(vector),
			this.row4().dotProduct(vector)
		);
	}

	@Override
	public Double4 multiply(VectorAsDouble<Double4> vector) {
		return vector != null ? this.multiply(vector.asDouble()) : Double4.ZERO;
	}

	@Override
	public Double4x4 transposed() {
		return new Double4x4(
			this.m11(), this.m21(), this.m31(), this.m41(),
			this.m12(), this.m22(), this.m32(), this.m42(),
			this.m13(), this.m23(), this.m33(), this.m43(),
			this.m14(), this.m24(), this.m34(), this.m44() 
		);
	}

	@Override
	public boolean isSymmetric() {
		return this.m21() == this.m12() &&
				this.m13() == this.m31() && this.m23() == this.m32() &&
				this.m14() == this.m41() && this.m24() == this.m42() && this.m34() == this.m43();
	}

	@Override
	public boolean isSkewSymmetric() {
		return this.m21() == -this.m12() &&
				this.m13() == -this.m31() && this.m23() == -this.m32() &&
				this.m14() == -this.m41() && this.m24() == -this.m42() && this.m34() == -this.m43();
	}

	@Override
	public Double4x4 multiply(Double4x4 matrix) {
		return matrix != null ? new Double4x4(
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

	@Override
	public Double4x4 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			return this.multiply(this.power(exponent - 1));
		}
	}

	/**
	 * TODO
	 * @return
	 */
	public Float4x4 castToFloat() {
		return new Float4x4(
			(float) this.m11(), (float) this.m12(), (float) this.m13(), (float) this.m14,
			(float) this.m21(), (float) this.m22(), (float) this.m23(), (float) this.m24,
			(float) this.m31(), (float) this.m32(), (float) this.m33(), (float) this.m34,
			(float) this.m41(), (float) this.m42(), (float) this.m43(), (float) this.m44
		);
	}

	/**
	 * TODO
	 * @return
	 */
	public Int4x4 castToInt() {
		return new Int4x4(
			(int) this.m11(), (int) this.m12(), (int) this.m13(), (int) this.m14(),
			(int) this.m21(), (int) this.m22(), (int) this.m23(), (int) this.m24(),
			(int) this.m31(), (int) this.m32(), (int) this.m33(), (int) this.m34(),
			(int) this.m41(), (int) this.m42(), (int) this.m43(), (int) this.m44()
		);
	}
}
