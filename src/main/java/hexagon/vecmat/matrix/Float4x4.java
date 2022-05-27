package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Double4;
import hexagon.vecmat.vector.Float4;
import hexagon.vecmat.vector.VectorAsFloat;

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
public record Float4x4(
	float m11, float m12, float m13, float m14,
	float m21, float m22, float m23, float m24,
	float m31, float m32, float m33, float m34,
	float m41, float m42, float m43, float m44
) implements MatrixFloatOperations<Float4x4, Float4>, MatrixAsDouble<Double4x4, Double4> {

	/**Shorthand for a 4x4 identity matrix */
	public static final Float4x4 IDENTITY = new Float4x4(
		1.0f, 0.0f, 0.0f, 0.0f,
		0.0f, 1.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 1.0f, 0.0f,
		0.0f, 0.0f, 0.0f, 1.0f
	);

	/**Shorthand for a 4x4 matrix where every element is 0 */
	public static final Float4x4 ZERO = new Float4x4(
		0.0f, 0.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 0.0f, 0.0f
	);

	@Override
	public Float4x4 plus(Float4x4 matrix) {
		return matrix != null ? new Float4x4(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(), this.m14() + matrix.m14(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(), this.m24() + matrix.m24(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33(), this.m34() + matrix.m34(),
			this.m41() + matrix.m41(), this.m42() + matrix.m42(), this.m43() + matrix.m43(), this.m44() + matrix.m44()
		) : this;
	}

	@Override
	public Float4x4 negative() {
		return new Float4x4(
			-this.m11(), -this.m12(), -this.m13(), -this.m14(),
			-this.m21(), -this.m22(), -this.m23(), -this.m24(),
			-this.m31(), -this.m32(), -this.m33(), -this.m34(),
			-this.m41(), -this.m42(), -this.m43(), -this.m44()
		);
	}

	@Override
	public Float4x4 multipliedBy(float k) {
		return new Float4x4(
			this.m11() * k, this.m12() * k, this.m13() * k, this.m14() * k,
			this.m21() * k, this.m22() * k, this.m23() * k, this.m24() * k,
			this.m31() * k, this.m32() * k, this.m33() * k, this.m34() * k,
			this.m41() * k, this.m42() * k, this.m43() * k, this.m44() * k
		);
	}

	/**
	 * Gets the first row of this matrix.
	 * 
	 * @return A float vector with all the elements of the first row.
	 */
	public Float4 row1() {
		return new Float4(this.m11(), this.m12(), this.m13(), this.m14());
	}

	/**
	 * Gets the second row of this matrix.
	 * 
	 * @return A float vector with all the elements of the second row.
	 */
	public Float4 row2() {
		return new Float4(this.m21(), this.m22(), this.m23(), this.m24());
	}

	/**
	 * Gets the third row of this matrix.
	 * 
	 * @return A float vector with all the elements of the third row.
	 */
	public Float4 row3() {
		return new Float4(this.m31(), this.m32(), this.m33(), this.m34());
	}

	/**
	 * Gets the fourth row of this matrix.
	 * 
	 * @return A float vector with all the elements of the fourth row.
	 */
	public Float4 row4() {
		return new Float4(this.m41(), this.m42(), this.m43(), this.m44());
	}

	/**
	 * Gets the first column of this matrix.
	 * 
	 * @return A float vector with all the elements of the first column.
	 */
	public Float4 column1() {
		return new Float4(this.m11(), this.m21(), this.m31(), this.m41());
	}

	/**
	 * Gets the second column of this matrix.
	 * 
	 * @return A float vector with all the elements of the second column.
	 */
	public Float4 column2() {
		return new Float4(this.m12(), this.m22(), this.m32(), this.m42());
	}

	/**
	 * Gets the third column of this matrix.
	 * 
	 * @return A float vector with all the elements of the third column.
	 */
	public Float4 column3() {
		return new Float4(this.m13(), this.m23(), this.m33(), this.m43());
	}

	/**
	 * Gets the fourth column of this matrix.
	 * 
	 * @return A float vector with all the elements of the fourth column.
	 */
	public Float4 column4() {
		return new Float4(this.m14(), this.m24(), this.m34(), this.m44());
	}

	@Override
	public Float4 multiply(Float4 vector) {
		return new Float4(
			this.row1().dotProduct(vector),
			this.row2().dotProduct(vector),
			this.row3().dotProduct(vector),
			this.row4().dotProduct(vector)
		);
	}

	@Override
	public Float4 multiply(VectorAsFloat<Float4> vector) {
		return vector != null ? this.multiply(vector.asFloat()) : Float4.ZERO;
	}

	@Override
	public Float4x4 transposed() {
		return new Float4x4(
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
	public Float4x4 multiply(Float4x4 matrix) {
		return matrix != null ? new Float4x4(
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
	public Float4x4 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			return this.multiply(this.power(exponent - 1));
		}
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
