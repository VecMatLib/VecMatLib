package io.github.hexagonnico.vecmat.matrix;

import io.github.hexagonnico.vecmat.vector.Double3;
import io.github.hexagonnico.vecmat.vector.Float3;

/**
 * Record that represents a 3x3 float matrix.
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
public record Float3x3(
	float m11, float m12, float m13,
	float m21, float m22, float m23,
	float m31, float m32, float m33
) implements MatrixFloatOperations<Float3x3, Float3>, MatrixAsDouble<Double3x3, Double3> {

	/**Shorthand for a 3x3 identity matrix */
	public static final Float3x3 IDENTITY = new Float3x3(
		1.0f, 0.0f, 0.0f,
		0.0f, 1.0f, 0.0f,
		0.0f, 0.0f, 1.0f
	);

	/**Shorthand for a 3x3 matrix where every element is 0 */
	public static final Float3x3 ZERO = new Float3x3(
		0.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 0.0f
	);

	@Override
	public Float3x3 plus(Float3x3 matrix) {
		return new Float3x3(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33()
		);
	}

	@Override
	public Float3x3 negative() {
		return new Float3x3(
			-this.m11(), -this.m12(), -this.m13(),
			-this.m21(), -this.m22(), -this.m23(),
			-this.m31(), -this.m32(), -this.m33()
		);
	}

	@Override
	public Float3x3 minus(Float3x3 matrix) {
		return new Float3x3(
			this.m11() - matrix.m11(), this.m12() - matrix.m12(), this.m13() - matrix.m13(),
			this.m21() - matrix.m21(), this.m22() - matrix.m22(), this.m23() - matrix.m23(),
			this.m31() - matrix.m31(), this.m32() - matrix.m32(), this.m33() - matrix.m33()
		);
	}

	@Override
	public Float3x3 multipliedBy(float k) {
		return new Float3x3(
			this.m11() * k, this.m12() * k, this.m13() * k,
			this.m21() * k, this.m22() * k, this.m23() * k,
			this.m31() * k, this.m32() * k, this.m33() * k
		);
	}

	/**
	 * Gets the first row of this matrix.
	 * 
	 * @return A float vector with all the elements of the first row.
	 */
	public Float3 row1() {
		return new Float3(this.m11(), this.m12(), this.m13());
	}

	/**
	 * Gets the second row of this matrix.
	 * 
	 * @return A float vector with all the elements of the second row.
	 */
	public Float3 row2() {
		return new Float3(this.m21(), this.m22(), this.m23());
	}

	/**
	 * Gets the third row of this matrix.
	 * 
	 * @return A float vector with all the elements of the third row.
	 */
	public Float3 row3() {
		return new Float3(this.m31(), this.m32(), this.m33());
	}

	/**
	 * Gets the first column of this matrix.
	 * 
	 * @return A float vector with all the elements of the first column.
	 */
	public Float3 column1() {
		return new Float3(this.m11(), this.m21(), this.m31());
	}

	/**
	 * Gets the second column of this matrix.
	 * 
	 * @return A float vector with all the elements of the second column.
	 */
	public Float3 column2() {
		return new Float3(this.m12(), this.m22(), this.m32());
	}

	/**
	 * Gets the third column of this matrix.
	 * 
	 * @return A float vector with all the elements of the third column.
	 */
	public Float3 column3() {
		return new Float3(this.m13(), this.m23(), this.m33());
	}

	@Override
	public Float3 multiply(Float3 vector) {
		return new Float3(
			this.row1().dotProduct(vector),
			this.row2().dotProduct(vector),
			this.row3().dotProduct(vector)
		);
	}

	@Override
	public Float3x3 transposed() {
		return new Float3x3(
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
	public Float3x3 multiply(Float3x3 matrix) {
		return new Float3x3(
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
	public Float3x3 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			Float3x3 result = this;
			for(int i = 1; i < exponent; i++) {
				result = result.multiply(this);
			}
			return result;
		}
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

	@Override
	public Double3x3 asDouble() {
		return new Double3x3(
			this.m11(), this.m12(), this.m13(),
			this.m21(), this.m22(), this.m23(),
			this.m31(), this.m32(), this.m33()
		);
	}
}
