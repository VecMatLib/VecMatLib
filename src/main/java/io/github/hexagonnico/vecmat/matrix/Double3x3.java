package io.github.hexagonnico.vecmat.matrix;

import io.github.hexagonnico.vecmat.vector.Double3;

/**
 * Record that represents a 3x3 double matrix.
 * 
 * @param m11 The first element of the first row.
 * @param m12 The second element of the first row.
 * @param m13 The third element of the first row.
 * @param m21 The first element of the second row.
 * @param m22 The second element of the second row.
 * @param m23 The third element of the second row.
 * @param m31 The first element of the third row.
 * @param m32 The second element of the third row.
 * @param m33 The third element of the third row.
 * 
 * @author Nico
 */
public record Double3x3(
	double m11, double m12, double m13,
	double m21, double m22, double m23,
	double m31, double m32, double m33
) implements MatrixDoubleOperations<Double3x3, Double3> {

	/**Shorthand for a 4x4 identity matrix */
	public static final Double3x3 IDENTITY = new Double3x3(
		1.0, 0.0, 0.0,
		0.0, 1.0, 0.0,
		0.0, 0.0, 1.0
	);

	/**Shorthand for a 4x4 matrix where every element is 0 */
	public static final Double3x3 ZERO = new Double3x3(
		0.0, 0.0, 0.0,
		0.0, 0.0, 0.0,
		0.0, 0.0, 0.0
	);

	@Override
	public Double3x3 plus(Double3x3 matrix) {
		return new Double3x3(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33()
		);
	}

	@Override
	public Double3x3 negative() {
		return new Double3x3(
			-this.m11(), -this.m12(), -this.m13(),
			-this.m21(), -this.m22(), -this.m23(),
			-this.m31(), -this.m32(), -this.m33()
		);
	}

	@Override
	public Double3x3 minus(Double3x3 matrix) {
		return new Double3x3(
			this.m11() - matrix.m11(), this.m12() - matrix.m12(), this.m13() - matrix.m13(),
			this.m21() - matrix.m21(), this.m22() - matrix.m22(), this.m23() - matrix.m23(),
			this.m31() - matrix.m31(), this.m32() - matrix.m32(), this.m33() - matrix.m33()
		);
	}

	@Override
	public Double3x3 multipliedBy(double k) {
		return new Double3x3(
			this.m11() * k, this.m12() * k, this.m13() * k,
			this.m21() * k, this.m22() * k, this.m23() * k,
			this.m31() * k, this.m32() * k, this.m33() * k
		);
	}

	/**
	 * Gets the first row of this matrix.
	 * 
	 * @return A double vector with all the elements of the first row.
	 */
	public Double3 row1() {
		return new Double3(this.m11(), this.m12(), this.m13());
	}

	/**
	 * Gets the second row of this matrix.
	 * 
	 * @return A double vector with all the elements of the second row.
	 */
	public Double3 row2() {
		return new Double3(this.m21(), this.m22(), this.m23());
	}

	/**
	 * Gets the third row of this matrix.
	 * 
	 * @return A double vector with all the elements of the third row.
	 */
	public Double3 row3() {
		return new Double3(this.m31(), this.m32(), this.m33());
	}

	/**
	 * Gets the first column of this matrix.
	 * 
	 * @return A double vector with all the elements of the first column.
	 */
	public Double3 column1() {
		return new Double3(this.m11(), this.m21(), this.m31());
	}

	/**
	 * Gets the second column of this matrix.
	 * 
	 * @return A double vector with all the elements of the second column.
	 */
	public Double3 column2() {
		return new Double3(this.m12(), this.m22(), this.m32());
	}

	/**
	 * Gets the third column of this matrix.
	 * 
	 * @return A double vector with all the elements of the third column.
	 */
	public Double3 column3() {
		return new Double3(this.m13(), this.m23(), this.m33());
	}

	@Override
	public Double3 multiply(Double3 vector) {
		return new Double3(
			this.row1().dotProduct(vector),
			this.row2().dotProduct(vector),
			this.row3().dotProduct(vector)
		);
	}

	@Override
	public Double3x3 transposed() {
		return new Double3x3(
			this.m11(), this.m21(), this.m31(),
			this.m12(), this.m22(), this.m32(),
			this.m13(), this.m23(), this.m33()
		);
	}

	@Override
	public boolean isSymmetric() {
		return this.m21() == this.m12() && this.m13() == this.m31() && this.m23() == this.m32();
	}

	@Override
	public boolean isSkewSymmetric() {
		return this.m21() == -this.m12() && this.m13() == -this.m31() && this.m23() == -this.m32();
	}

	@Override
	public Double3x3 multiply(Double3x3 matrix) {
		return new Double3x3(
			this.row1().dotProduct(matrix.column1()),
			this.row1().dotProduct(matrix.column2()),
			this.row1().dotProduct(matrix.column3()),
			this.row2().dotProduct(matrix.column1()),
			this.row2().dotProduct(matrix.column2()),
			this.row2().dotProduct(matrix.column3()),
			this.row3().dotProduct(matrix.column1()),
			this.row3().dotProduct(matrix.column2()),
			this.row3().dotProduct(matrix.column3())
		);
	}

	@Override
	public Double3x3 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			Double3x3 result = this;
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
	public Float3x3 castToFloat() {
		return new Float3x3(
			(float) this.m11(), (float) this.m12(), (float) this.m13(),
			(float) this.m21(), (float) this.m22(), (float) this.m23(),
			(float) this.m31(), (float) this.m32(), (float) this.m33()
		);
	}

	/**
	 * Casts this matrix to an integer matrix.
	 * 
	 * @return A matrix with the same elements as this matrix casted to int.
	 */
	public Int3x3 castToInt() {
		return new Int3x3(
			(int) this.m11(), (int) this.m12(), (int) this.m13(),
			(int) this.m21(), (int) this.m22(), (int) this.m23(),
			(int) this.m31(), (int) this.m32(), (int) this.m33()
		);
	}
}
