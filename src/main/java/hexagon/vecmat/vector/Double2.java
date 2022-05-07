package hexagon.vecmat.vector;

public record Double2(double x, double y) implements DoubleVector<Double2, Float2, Int2> {

	public Double2 plus(double x, double y) {
		return new Double2(this.x() + x, this.y() + y);
	}

	@Override
	public Double2 plus(Double2 vector) {
		return vector != null ? this.plus(vector.x(), vector.y()) : this;
	}

	@Override
	public Double2 negated() {
		return new Double2(-this.x(), -this.y());
	}

	public Double2 minus(double x, double y) {
		return this.plus(-x, -y);
	}

	@Override
	public Double2 multipliedBy(double k) {
		return new Double2(this.x() * k, this.y() * k);
	}

	public double dotProduct(double x, double y) {
		return this.x() * x + this.y() * y;
	}

	@Override
	public double dotProduct(Double2 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y()) : 0.0;
	}

	@Override
	public double lengthSquared() {
		return this.dotProduct(this);
	}

	@Override
	public Int2 castToInt() {
		return new Int2((int) this.x(), (int) this.y());
	}

	@Override
	public Float2 castToFloat() {
		return new Float2((float) this.x(), (float) this.y());
	}
}
