package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Double3;
import hexagon.vecmat.vector.VectorAsDouble;

public record DoubleMatrix3(
	double m11, double m12, double m13,
	double m21, double m22, double m23,
	double m31, double m32, double m33
) implements MatrixDoubleOperations<DoubleMatrix3, Double3, FloatMatrix3, IntMatrix3> {

	public static final DoubleMatrix3 IDENTITY = new DoubleMatrix3(
		1.0, 0.0, 0.0,
		0.0, 1.0, 0.0,
		0.0, 0.0, 1.0
	);

	public static final DoubleMatrix3 ZERO = new DoubleMatrix3(
		0.0, 0.0, 0.0,
		0.0, 0.0, 0.0,
		0.0, 0.0, 0.0
	);

	@Override
	public DoubleMatrix3 plus(DoubleMatrix3 matrix) {
		return matrix != null ? new DoubleMatrix3(
			this.m11() + matrix.m11(), this.m12() + matrix.m12(), this.m13() + matrix.m13(),
			this.m21() + matrix.m21(), this.m22() + matrix.m22(), this.m23() + matrix.m23(),
			this.m31() + matrix.m31(), this.m32() + matrix.m32(), this.m33() + matrix.m33()
		) : this;
	}

	@Override
	public DoubleMatrix3 negative() {
		return new DoubleMatrix3(
			-this.m11(), -this.m12(), -this.m13(),
			-this.m21(), -this.m22(), -this.m23(),
			-this.m31(), -this.m32(), -this.m33()
		);
	}

	@Override
	public DoubleMatrix3 multipliedBy(double k) {
		return new DoubleMatrix3(
			this.m11() * k, this.m12() * k, this.m13() * k,
			this.m21() * k, this.m22() * k, this.m23() * k,
			this.m31() * k, this.m32() * k, this.m33() * k
		);
	}

	public Double3 row1() {
		return new Double3(this.m11(), this.m12(), this.m13());
	}

	public Double3 row2() {
		return new Double3(this.m21(), this.m22(), this.m23());
	}

	public Double3 row3() {
		return new Double3(this.m31(), this.m32(), this.m33());
	}

	public Double3 column1() {
		return new Double3(this.m11(), this.m21(), this.m31());
	}

	public Double3 column2() {
		return new Double3(this.m12(), this.m22(), this.m32());
	}

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
	public Double3 multiply(VectorAsDouble<Double3> vector) {
		return vector != null ? this.multiply(vector.asDouble()) : Double3.ZERO;
	}

	@Override
	public DoubleMatrix3 transposed() {
		return new DoubleMatrix3(
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
	public DoubleMatrix3 multiply(DoubleMatrix3 matrix) {
		return matrix != null ? new DoubleMatrix3(
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
	public DoubleMatrix3 power(int exponent) {
		if(exponent < 0) {
			return this.transposed().power(-exponent);
		} else if(exponent == 0) {
			return IDENTITY;
		} else {
			return this.multiply(this.power(exponent - 1));
		}
	}

	@Override
	public FloatMatrix3 castToFloat() {
		return new FloatMatrix3(
			(float) this.m11(), (float) this.m12(), (float) this.m13(),
			(float) this.m21(), (float) this.m22(), (float) this.m23(),
			(float) this.m31(), (float) this.m32(), (float) this.m33()
		);
	}

	@Override
	public IntMatrix3 castToInt() {
		return new IntMatrix3(
			(int) this.m11(), (int) this.m12(), (int) this.m13(),
			(int) this.m21(), (int) this.m22(), (int) this.m23(),
			(int) this.m31(), (int) this.m32(), (int) this.m33()
		);
	}
}