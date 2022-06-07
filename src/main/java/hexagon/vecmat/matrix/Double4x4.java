package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Double4;

/**
 * Record that represents a 4x4 double matrix.
 * 
 * @param m11 The first element of the first row.
 * @param m12 The second element of the first row.
 * @param m13 The third element of the first row.
 * @param m14 The fourth element of the first row.
 * @param m21 The first element of the second row.
 * @param m22 The second element of the second row.
 * @param m23 The third element of the second row.
 * @param m24 The fourth element of the second row.
 * @param m31 The first element of the third row.
 * @param m32 The second element of the third row.
 * @param m33 The third element of the third row.
 * @param m34 The fourth element of the third row.
 * @param m41 The first element of the fourth row.
 * @param m42 The second element of the fourth row.
 * @param m43 The third element of the fourth row.
 * @param m44 The fourth element of the fourth row.
 * 
 * @author Nico
 */
public record Double4x4(
	double m11, double m12, double m13, double m14,
	double m21, double m22, double m23, double m24,
	double m31, double m32, double m33, double m34,
	double m41, double m42, double m43, double m44
) implements MatrixDoubleOperations<Double4x4, Double4> {

	/**Shorthand for a 4x4 identity matrix */
	public static final Double4x4 IDENTITY = new Double4x4(
		1.0, 0.0, 0.0, 0.0,
		0.0, 1.0, 0.0, 0.0,
		0.0, 0.0, 1.0, 0.0,
		0.0, 0.0, 0.0, 1.0
	);

	/**Shorthand for a 4x4 matrix where every element is 0 */
	public static final Double4x4 ZERO = new Double4x4(
		0.0, 0.0, 0.0, 0.0,
		0.0, 0.0, 0.0, 0.0,
		0.0, 0.0, 0.0, 0.0,
		0.0, 0.0, 0.0, 0.0
	);

	@Override
	public Double4x4 plus(Double4x4 matrix) {
		return new Double4x4(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(), this.m14() + matrix.m14(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(), this.m24() + matrix.m24(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33(), this.m34() + matrix.m34(),
			this.m41() + matrix.m41(), this.m42() + matrix.m42(), this.m43() + matrix.m43(), this.m44() + matrix.m44()
		);
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
	public Double4x4 minus(Double4x4 matrix) {
		return new Double4x4(
			this.m11() - matrix.m11(), this.m12() - matrix.m12(), this.m13() - matrix.m13(), this.m14() - matrix.m14(),
			this.m21() - matrix.m21(), this.m22() - matrix.m22(), this.m23() - matrix.m23(), this.m24() - matrix.m24(),
			this.m31() - matrix.m31(), this.m32() - matrix.m32(), this.m33() - matrix.m33(), this.m34() - matrix.m34(),
			this.m41() - matrix.m41(), this.m42() - matrix.m42(), this.m43() - matrix.m43(), this.m44() - matrix.m44()
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

	/**
	 * Gets the first row of this matrix.
	 * 
	 * @return A double vector with all the elements of the first row.
	 */
	public Double4 row1() {
		return new Double4(this.m11(), this.m12(), this.m13(), this.m14());
	}

	/**
	 * Gets the second row of this matrix.
	 * 
	 * @return A double vector with all the elements of the second row.
	 */
	public Double4 row2() {
		return new Double4(this.m21(), this.m22(), this.m23(), this.m24());
	}

	/**
	 * Gets the third row of this matrix.
	 * 
	 * @return A double vector with all the elements of the third row.
	 */
	public Double4 row3() {
		return new Double4(this.m31(), this.m32(), this.m33(), this.m34());
	}

	/**
	 * Gets the fourth row of this matrix.
	 * 
	 * @return A double vector with all the elements of the fourth row.
	 */
	public Double4 row4() {
		return new Double4(this.m41(), this.m42(), this.m43(), this.m44());
	}

	/**
	 * Gets the first column of this matrix.
	 * 
	 * @return A double vector with all the elements of the first column.
	 */
	public Double4 column1() {
		return new Double4(this.m11(), this.m21(), this.m31(), this.m41());
	}

	/**
	 * Gets the second column of this matrix.
	 * 
	 * @return A double vector with all the elements of the second column.
	 */
	public Double4 column2() {
		return new Double4(this.m12(), this.m22(), this.m32(), this.m42());
	}

	/**
	 * Gets the third column of this matrix.
	 * 
	 * @return A double vector with all the elements of the third column.
	 */
	public Double4 column3() {
		return new Double4(this.m13(), this.m23(), this.m33(), this.m43());
	}

	/**
	 * Gets the fourth column of this matrix.
	 * 
	 * @return A double vector with all the elements of the fourth column.
	 */
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
		return new Double4x4(
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
		);
	}

	@Override
	public Double4x4 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			Double4x4 result = this;
			for(int i = 1; i < exponent; i++) {
				result = result.multiply(this);
			}
			return result;
		}
	}

	/**
	 * Casts this matrix to a float matrix.
	 * 
	 * @return A matrix with the same elements as this matrix casted to float.
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
	 * Casts this matrix to an integer matrix.
	 * 
	 * @return A matrix with the same elements as this matrix casted to int.
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
