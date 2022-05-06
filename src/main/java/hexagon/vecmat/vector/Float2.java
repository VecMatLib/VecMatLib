package hexagon.vecmat.vector;

public record Float2(float x, float y) implements FloatVector<Float2, Int2> {

	public Float2 plus(float x, float y) {
		return new Float2(this.x() + x, this.y() + y);
	}

	@Override
	public Float2 plus(Float2 vector) {
		return vector != null ? this.plus(vector.x(), vector.y()) : this;
	}

	@Override
	public Float2 negated() {
		return new Float2(-this.x(), -this.y());
	}

	public Float2 minus(float x, float y) {
		return this.plus(-x, -y);
	}

	@Override
	public Float2 multipliedBy(float k) {
		return new Float2(this.x() * k, this.y() * k);
	}

	public float dotProduct(float x, float y) {
		return this.x() * x + this.y() * y;
	}

	@Override
	public float dotProduct(Float2 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y()) : 0.0f;
	}

	@Override
	public float lengthSquared() {
		return this.dotProduct(this);
	}

	public double angle(float x, float y) {
		return this.angle(new Float2(x, y));
	}

	@Override
	public Int2 castToInt() {
		return new Int2((int) this.x(), (int) this.y());
	}
}
