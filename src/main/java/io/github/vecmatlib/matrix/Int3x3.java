package io.github.vecmatlib.matrix;

import io.github.vecmatlib.vector.Double3;
import io.github.vecmatlib.vector.Float3;
import io.github.vecmatlib.vector.Int3;

/**
 * Record that represents a 3x3 int matrix.
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
public record Int3x3(
	int m11, int m12, int m13,
	int m21, int m22, int m23,
	int m31, int m32, int m33
) implements MatrixIntOperations<Int3x3, Int3>, MatrixAsFloat<Float3x3, Float3>, MatrixAsDouble<Double3x3, Double3> {

	/**Shorthand for a 3x3 identity matrix */
	public static final Int3x3 IDENTITY = new Int3x3(
		1, 0, 0,
		0, 1, 0,
		0, 0, 1
	);

	/**Shorthand for a 3x3 matrix where every element is 0 */
	public static final Int3x3 ZERO = new Int3x3(
		0, 0, 0,
		0, 0, 0,
		0, 0, 0
	);

	@Override
	public Int3x3 plus(Int3x3 matrix) {
		return new Int3x3(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33()
		);
	}

	@Override
	public Int3x3 negative() {
		return new Int3x3(
			-this.m11(), -this.m12(), -this.m13(),
			-this.m21(), -this.m22(), -this.m23(),
			-this.m31(), -this.m32(), -this.m33()
		);
	}

	@Override
	public Int3x3 multipliedBy(int k) {
		return new Int3x3(
			this.m11() * k, this.m12() * k, this.m13() * k,
			this.m21() * k, this.m22() * k, this.m23() * k,
			this.m31() * k, this.m32() * k, this.m33() * k
		);
	}

	/**
	 * Gets the first row of this matrix.
	 * 
	 * @return An int vector with all the elements of the first row.
	 */
	public Int3 row1() {
		return new Int3(this.m11(), this.m12(), this.m13());
	}

	/**
	 * Gets the second row of this matrix.
	 * 
	 * @return An int vector with all the elements of the second row.
	 */
	public Int3 row2() {
		return new Int3(this.m21(), this.m22(), this.m23());
	}

	/**
	 * Gets the third row of this matrix.
	 * 
	 * @return An int vector with all the elements of the third row.
	 */
	public Int3 row3() {
		return new Int3(this.m31(), this.m32(), this.m33());
	}

	/**
	 * Gets the first column of this matrix.
	 * 
	 * @return An int vector with all the elements of the first column.
	 */
	public Int3 column1() {
		return new Int3(this.m11(), this.m21(), this.m31());
	}

	/**
	 * Gets the second column of this matrix.
	 * 
	 * @return An int vector with all the elements of the second column.
	 */
	public Int3 column2() {
		return new Int3(this.m12(), this.m22(), this.m32());
	}

	/**
	 * Gets the third column of this matrix.
	 * 
	 * @return An int vector with all the elements of the third column.
	 */
	public Int3 column3() {
		return new Int3(this.m13(), this.m23(), this.m33());
	}

	@Override
	public Int3 multiply(Int3 vector) {
		return new Int3(
			this.row1().dotProduct(vector),
			this.row2().dotProduct(vector),
			this.row3().dotProduct(vector)
		);
	}

	@Override
	public Int3x3 transposed() {
		return new Int3x3(
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
	public Int3x3 multiply(Int3x3 matrix) {
		return new Int3x3(
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
	public Int3x3 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			return this.multiply(this.power(exponent - 1));
		}
	}

	@Override
	public Float3x3 asFloat() {
		return new Float3x3(
			this.m11(), this.m12(), this.m13(),
			this.m21(), this.m22(), this.m23(),
			this.m31(), this.m32(), this.m33()
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