package hexagon.vecmat.vector;

public record Int2(Integer x, Integer y) implements IntVector<Int2, Float2>, Vector2<Integer, Int2> {

	@Override
	public Int2 plus(Integer x, Integer y) {
		return new Int2(this.x() + x, this.y() + y);
	}

	@Override
	public Int2 plus(Int2 vector) {
		return this.plus(vector.x(), vector.y());
	}

	public Float2 plus(Float x, Float y) {
		return this.plus(new Float2(x, y));
	}

	@Override
	public Int2 negated() {
		return new Int2(-this.x(), -this.y());
	}

	@Override
	public Int2 minus(Integer x, Integer y) {
		return this.plus(-x, -y);
	}

	public Float2 minus(Float x, Float y) {
		return this.minus(new Float2(x, y));
	}

	@Override
	public Int2 multiply(Integer k) {
		return new Int2(this.x() * k, this.y() * k);
	}

	@Override
	public Int2 divide(Integer k) {
		return new Int2(this.x() / k, this.y() / k);
	}

	@Override
	public Integer dotProduct(Integer x, Integer y) {
		return this.x() * x + this.y() * y;
	}

	@Override
	public Integer dotProduct(Int2 vector) {
		return this.dotProduct(vector.x(), vector.y());
	}

	@Override
	public Integer lengthSquared() {
		return this.dotProduct(this);
	}

	@Override
	public double angle(Integer x, Integer y) {
		return this.angle(new Int2(x, y));
	}

	@Override
	public Float2 asFloat() {
		return new Float2(this.x().floatValue(), this.y().floatValue());
	}
}
