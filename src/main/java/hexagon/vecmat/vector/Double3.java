package hexagon.vecmat.vector;

public record Double3(double x, double y, double z) implements VectorDoubleOperations<Double3, Float3, Int3> {

	public static final Double3 ZERO = new Double3(0.0, 0.0, 0.0);

	public Double3 plus(double x, double y, double z) {
		return new Double3(this.x() + x, this.y() + y, this.z() + z);
	}

	@Override
	public Double3 plus(Double3 vector) {
		return vector != null ? this.plus(vector.x(), vector.y(), vector.z()) : this;
	}

	@Override
	public Double3 negated() {
		return new Double3(-this.x(), -this.y(), -this.z());
	}

	public Double3 minus(double x, double y, double z) {
		return this.plus(-x, -y, -z);
	}

	@Override
	public Double3 multipliedBy(double k) {
		return new Double3(this.x() * k, this.y() * k, this.z() * k);
	}

	public double dotProduct(double x, double y, double z) {
		return this.x() * x + this.y() * y + this.z() * z;
	}

	@Override
	public double dotProduct(Double3 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y(), vector.z()) : 0.0;
	}

	public Double3 crossProduct(double x, double y, double z) {
		return new Double3(this.y() * z - this.z() * y, x * this.z() - z * this.x(), this.x() * y - this.y() * x);
	}

	public Double3 crossProduct(Double3 vector) {
		return vector != null ? this.crossProduct(vector.x(), vector.y(), vector.z()) : Double3.ZERO;
	}

	public Double3 crossProduct(VectorAsDouble<Double3> vector) {
		return vector != null ? this.crossProduct(vector.asDouble()) : Double3.ZERO;
	}

	@Override
	public double lengthSquared() {
		return this.dotProduct(this);
	}

	public double angle(double x, double y, double z) {
		return this.angle(new Double3(x, y, z));
	}

	@Override
	public Int3 castToInt() {
		return new Int3((int) this.x(), (int) this.y(), (int) this.z());
	}

	@Override
	public Float3 castToFloat() {
		return new Float3((float) this.x(), (float) this.y(), (float) this.z());
	}
}
