package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Double4;
import hexagon.vecmat.vector.Float4;
import hexagon.vecmat.vector.Int4;

/**
 * Record that represents a 4x4 float matrix.
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
public record Int4x4(
	int m11, int m12, int m13, int m14,
	int m21, int m22, int m23, int m24,
	int m31, int m32, int m33, int m34,
	int m41, int m42, int m43, int m44
) implements MatrixIntOperations<Int4x4, Int4>, MatrixAsFloat<Float4x4, Float4>, MatrixAsDouble<Double4x4, Double4> {

	/**Shorthand for a 4x4 identity matrix */
	public static final Int4x4 IDENTITY = new Int4x4(
		1, 0, 0, 0,
		0, 1, 0, 0,
		0, 0, 1, 0,
		0, 0, 0, 1
	);

	/**Shorthand for a 4x4 matrix where every element is 0 */
	public static final Int4x4 ZERO = new Int4x4(
		0, 0, 0, 0,
		0, 0, 0, 0,
		0, 0, 0, 0,
		0, 0, 0, 0
	);

	@Override
	public Int4x4 plus(Int4x4 matrix) {
		return matrix != null ? new Int4x4(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(), this.m14() + matrix.m14(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(), this.m24() + matrix.m24(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33(), this.m34() + matrix.m34(),
			this.m41() + matrix.m41(), this.m42() + matrix.m42(), this.m43() + matrix.m43(), this.m44() + matrix.m44()
		) : this;
	}

	@Override
	public Int4x4 negative() {
		return new Int4x4(
			-this.m11(), -this.m12(), -this.m13(), -this.m14(),
			-this.m21(), -this.m22(), -this.m23(), -this.m24(),
			-this.m31(), -this.m32(), -this.m33(), -this.m34(),
			-this.m41(), -this.m42(), -this.m43(), -this.m44()
		);
	}

	@Override
	public Int4x4 multipliedBy(int k) {
		return new Int4x4(
			this.m11() * k, this.m12() * k, this.m13() * k, this.m14() * k,
			this.m21() * k, this.m22() * k, this.m23() * k, this.m24() * k,
			this.m31() * k, this.m32() * k, this.m33() * k, this.m34() * k,
			this.m41() * k, this.m42() * k, this.m43() * k, this.m44() * k
		);
	}

	/**
	 * Gets the first row of this matrix.
	 * 
	 * @return An int vector with all the elements of the first row.
	 */
	public Int4 row1() {
		return new Int4(this.m11(), this.m12(), this.m13(), this.m14());
	}

	/**
	 * Gets the second row of this matrix.
	 * 
	 * @return An int vector with all the elements of the second row.
	 */
	public Int4 row2() {
		return new Int4(this.m21(), this.m22(), this.m23(), this.m24());
	}

	/**
	 * Gets the third row of this matrix.
	 * 
	 * @return An int vector with all the elements of the third row.
	 */
	public Int4 row3() {
		return new Int4(this.m31(), this.m32(), this.m33(), this.m34());
	}

	/**
	 * Gets the fourth row of this matrix.
	 * 
	 * @return An int vector with all the elements of the fourth row.
	 */
	public Int4 row4() {
		return new Int4(this.m41(), this.m42(), this.m43(), this.m44());
	}

	/**
	 * Gets the first column of this matrix.
	 * 
	 * @return An int vector with all the elements of the first column.
	 */
	public Int4 column1() {
		return new Int4(this.m11(), this.m21(), this.m31(), this.m41());
	}

	/**
	 * Gets the second column of this matrix.
	 * 
	 * @return An int vector with all the elements of the second column.
	 */
	public Int4 column2() {
		return new Int4(this.m12(), this.m22(), this.m32(), this.m42());
	}

	/**
	 * Gets the third column of this matrix.
	 * 
	 * @return An int vector with all the elements of the third column.
	 */
	public Int4 column3() {
		return new Int4(this.m13(), this.m23(), this.m33(), this.m43());
	}

	/**
	 * Gets the fourth column of this matrix.
	 * 
	 * @return An int vector with all the elements of the fourth column.
	 */
	public Int4 column4() {
		return new Int4(this.m14(), this.m24(), this.m34(), this.m44());
	}

	@Override
	public Int4 multiply(Int4 vector) {
		return new Int4(
			this.row1().dotProduct(vector),
			this.row2().dotProduct(vector),
			this.row3().dotProduct(vector),
			this.row4().dotProduct(vector)
		);
	}

	@Override
	public Int4x4 transposed() {
		return new Int4x4(
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
	public Int4x4 multiply(Int4x4 matrix) {
		return matrix != null ? new Int4x4(
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
	public Int4x4 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			return this.multiply(this.power(exponent - 1));
		}
	}

	@Override
	public Float4x4 asFloat() {
		return new Float4x4(
			this.m11(), this.m12(), this.m13(), this.m14(),
			this.m21(), this.m22(), this.m23(), this.m24(),
			this.m31(), this.m32(), this.m33(), this.m34(),
			this.m41(), this.m42(), this.m43(), this.m44()
		);
	}

	@Override
	public Double4x4 asDouble() {
		return new Double4x4(
			this.m11(), this.m12(), this.m13(), this.m14(),
			this.m21(), this.m22(), this.m23(), this.m24(),
			this.m31(), this.m32(), this.m33(), this.m34(),
			this.m41(), this.m42(), this.m43(), this.m44()
		);
	}
}
