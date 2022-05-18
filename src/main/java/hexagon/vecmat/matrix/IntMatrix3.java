package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Double3;
import hexagon.vecmat.vector.Float3;
import hexagon.vecmat.vector.Int3;

public record IntMatrix3(
	int m11, int m12, int m13,
	int m21, int m22, int m23,
	int m31, int m32, int m33
) implements MatrixIntOperations<IntMatrix3, Int3>, MatrixAsFloat<FloatMatrix3, Float3>, MatrixAsDouble<DoubleMatrix3, Double3> {

	public static final IntMatrix3 IDENTITY = new IntMatrix3(
		1, 0, 0,
		0, 1, 0,
		0, 0, 1
	);

	public static final IntMatrix3 ZERO = new IntMatrix3(
		0, 0, 0,
		0, 0, 0,
		0, 0, 0
	);

	@Override
	public IntMatrix3 plus(IntMatrix3 matrix) {
		return matrix != null ? new IntMatrix3(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33()
		) : this;
	}

	@Override
	public IntMatrix3 negative() {
		return new IntMatrix3(
			-this.m11(), -this.m12(), -this.m13(),
			-this.m21(), -this.m22(), -this.m23(),
			-this.m31(), -this.m32(), -this.m33()
		);
	}

	@Override
	public IntMatrix3 multipliedBy(int k) {
		return new IntMatrix3(
			this.m11() * k, this.m12() * k, this.m13() * k,
			this.m21() * k, this.m22() * k, this.m23() * k,
			this.m31() * k, this.m32() * k, this.m33() * k
		);
	}

	public Int3 row1() {
		return new Int3(this.m11(), this.m12(), this.m13());
	}

	public Int3 row2() {
		return new Int3(this.m21(), this.m22(), this.m23());
	}

	public Int3 row3() {
		return new Int3(this.m31(), this.m32(), this.m33());
	}

	public Int3 column1() {
		return new Int3(this.m11(), this.m21(), this.m31());
	}

	public Int3 column2() {
		return new Int3(this.m12(), this.m22(), this.m32());
	}

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
	public IntMatrix3 transposed() {
		return new IntMatrix3(
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
	public IntMatrix3 multiply(IntMatrix3 matrix) {
		return matrix != null ? new IntMatrix3(
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
	public IntMatrix3 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			return this.multiply(this.power(exponent - 1));
		}
	}

	@Override
	public FloatMatrix3 asFloat() {
		return new FloatMatrix3(
			this.m11(), this.m12(), this.m13(),
			this.m21(), this.m22(), this.m23(),
			this.m31(), this.m32(), this.m33()
		);
	}

	/**
	 * TODO
	 * @return
	 */
	public DoubleMatrix3 asDouble() {
		return new DoubleMatrix3(
			this.m11(), this.m12(), this.m13(),
			this.m21(), this.m22(), this.m23(),
			this.m31(), this.m32(), this.m33()
		);
	}
}