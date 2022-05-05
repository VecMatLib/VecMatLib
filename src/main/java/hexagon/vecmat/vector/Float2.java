package hexagon.vecmat.vector;

public record Float2(Float x, Float y) implements FloatVector<Float2, Int2>, Vector2<Float, Float2> {

	@Override
	public Float2 plus(Float x, Float y) {
		return new Float2(this.x() + x, this.y() + y);
	}

	@Override
	public Float2 plus(Float2 vector) {
		return this.plus(vector.x(), vector.y());
	}

	@Override
	public Float2 negated() {
		return new Float2(-this.x(), -this.y());
	}

	@Override
	public Float2 minus(Float x, Float y) {
		return this.plus(-x, -y);
	}

	@Override
	public Float2 multiply(Float k) {
		return new Float2(this.x() * k, this.y() * k);
	}

	@Override
	public Float2 divide(Float k) {
		return this.multiply(1.0f / k);
	}

	@Override
	public Float dotProduct(Float x, Float y) {
		return this.x() * x + this.y() * y;
	}

	@Override
	public Float dotProduct(Float2 vector) {
		return this.dotProduct(vector.x(), vector.y());
	}

	@Override
	public Float lengthSquared() {
		return this.dotProduct(this);
	}

	@Override
	public double angle(Float x, Float y) {
		return this.angle(new Float2(x, y));
	}

	@Override
	public Int2 castToInt() {
		return new Int2(this.x().intValue(), this.y().intValue());
	}
}
