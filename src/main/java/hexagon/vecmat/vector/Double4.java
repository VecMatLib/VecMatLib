package hexagon.vecmat.vector;

public record Double4(double x, double y, double z, double w) implements DoubleVector<Double4, Float4, Int4> {

	public static final Double4 ZERO = new Double4(0.0, 0.0, 0.0, 0.0);

	public Double4 plus(double x, double y, double z, double w) {
		return new Double4(this.x() + x, this.y() + y, this.z() + z, this.w() + w);
	}

	@Override
	public Double4 plus(Double4 vector) {
		return vector != null ? this.plus(vector.x(), vector.y(), vector.z(), vector.w()) : this;
	}

	@Override
	public Double4 negated() {
		return new Double4(-this.x(), -this.y(), -this.z(), -this.w());
	}

	public Double4 minus(double x, double y, double z, double w) {
		return this.plus(-x, -y, -z, -w);
	}

	@Override
	public Double4 multipliedBy(double k) {
		return new Double4(this.x() * k, this.y() * k, this.z() * k, this.w() * w);
	}

	public double dotProduct(double x, double y, double z, double w) {
		return this.x() * x + this.y() * y + this.z() * z + this.w() * w;
	}

	@Override
	public double dotProduct(Double4 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y(), vector.z(), vector.w()) : 0.0;
	}

	@Override
	public double lengthSquared() {
		return this.dotProduct(this);
	}

	@Override
	public Int4 castToInt() {
		return new Int4((int) this.x(), (int) this.y(), (int) this.z(), (int) this.w());
	}

	@Override
	public Float4 castToFloat() {
		return new Float4((float) this.x(), (float) this.y(), (float) this.z(), (float) this.w());
	}
}
