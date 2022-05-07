package hexagon.vecmat.vector;

public record Int2(int x, int y) implements IntVector<Int2, Float2, Double2> {

	public Int2 plus(int x, int y) {
		return new Int2(this.x() + x, this.y() + y);
	}

	@Override
	public Int2 plus(Int2 vector) {
		return vector != null ? this.plus(vector.x(), vector.y()) : this;
	}

	public Float2 plus(float x, float y) {
		return this.asFloat().plus(x, y);
	}

	public Double2 plus(double x, double y) {
		return this.asDouble().plus(x, y);
	}

	@Override
	public Int2 negated() {
		return new Int2(-this.x(), -this.y());
	}

	public Int2 minus(int x, int y) {
		return this.plus(-x, -y);
	}

	public Float2 minus(float x, float y) {
		return this.plus(-x, -y);
	}

	public Double2 minus(double x, double y) {
		return this.plus(-x, -y);
	}

	@Override
	public Int2 multipliedBy(int k) {
		return new Int2(this.x() * k, this.y() * k);
	}

	@Override
	public Int2 dividedBy(int k) {
		return new Int2(this.x() / k, this.y() / k);
	}

	public int dotProduct(int x, int y) {
		return this.x() * x + this.y() * y;
	}

	@Override
	public int dotProduct(Int2 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y()) : 0;
	}

	public float dotProduct(float x, float y) {
		return this.asFloat().dotProduct(x, y);
	}

	public double dotProduct(double x, double y) {
		return this.asDouble().dotProduct(x, y);
	}

	@Override
	public int lengthSquared() {
		return this.dotProduct(this);
	}

	public double angle(int x, int y) {
		return this.angle(new Int2(x, y));
	}

	public double angle(double x, double y) {
		return this.angle(new Double2(x, y));
	}

	@Override
	public Float2 asFloat() {
		return new Float2(this.x(), this.y());
	}

	@Override
	public Double2 asDouble() {
		return new Double2(this.x(), this.y());
	}
}
