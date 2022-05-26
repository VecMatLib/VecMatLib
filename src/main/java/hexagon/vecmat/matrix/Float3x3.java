package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Double3;
import hexagon.vecmat.vector.Float3;
import hexagon.vecmat.vector.VectorAsFloat;

public record Float3x3(
	float m11, float m12, float m13,
	float m21, float m22, float m23,
	float m31, float m32, float m33
) implements MatrixFloatOperations<Float3x3, Float3>, MatrixAsDouble<Double3x3, Double3> {

	public static final Float3x3 IDENTITY = new Float3x3(
		1.0f, 0.0f, 0.0f,
		0.0f, 1.0f, 0.0f,
		0.0f, 0.0f, 1.0f
	);

	public static final Float3x3 ZERO = new Float3x3(
		0.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 0.0f,
		0.0f, 0.0f, 0.0f
	);

	@Override
	public Float3x3 plus(Float3x3 matrix) {
		return matrix != null ? new Float3x3(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33()
		) : this;
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
	public Float3x3 multipliedBy(float k) {
		return new Float3x3(
			this.m11() * k, this.m12() * k, this.m13() * k,
			this.m21() * k, this.m22() * k, this.m23() * k,
			this.m31() * k, this.m32() * k, this.m33() * k
		);
	}

	public Float3 row1() {
		return new Float3(this.m11(), this.m12(), this.m13());
	}

	public Float3 row2() {
		return new Float3(this.m21(), this.m22(), this.m23());
	}

	public Float3 row3() {
		return new Float3(this.m31(), this.m32(), this.m33());
	}

	public Float3 column1() {
		return new Float3(this.m11(), this.m21(), this.m31());
	}

	public Float3 column2() {
		return new Float3(this.m12(), this.m22(), this.m32());
	}

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
	public Float3 multiply(VectorAsFloat<Float3> vector) {
		return vector != null ? this.multiply(vector.asFloat()) : Float3.ZERO;
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
		return matrix != null ? new Float3x3(
			this.row1().dotProduct(matrix.column1()),
			this.row1().dotProduct(matrix.column2()),
			this.row1().dotProduct(matrix.column3()),
			this.row2().dotProduct(matrix.column1()),
			this.row2().dotProduct(matrix.column2()),
			this.row2().dotProduct(matrix.column3()),
			this.row3().dotProduct(matrix.column1()),
			this.row3().dotProduct(matrix.column2()),
			this.row3().dotProduct(matrix.column3())
		) : ZERO;
	}

	@Override
	public Float3x3 power(int exponent) {
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
