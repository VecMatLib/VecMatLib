package hexagon.vecmat.vector;

public record Float4(float x, float y, float z, float w) implements VectorFloatOperations<Float4, Double4, Int4> {

	public static final Float4 ZERO = new Float4(0.0f, 0.0f, 0.0f, 0.0f);

	public Float4 plus(float x, float y, float z, float w) {
		return new Float4(this.x() + x, this.y() + y, this.z() + z, this.w() + w);
	}

	@Override
	public Float4 plus(Float4 vector) {
		return vector != null ? this.plus(vector.x(), vector.y(), vector.z(), vector.w()) : this;
	}

	public Double4 plus(double x, double y, double z, double w) {
		return this.asDouble().plus(x, y, z, w);
	}

	@Override
	public Float4 negated() {
		return new Float4(-this.x(), -this.y(), -this.z(), -this.w());
	}

	public Float4 minus(float x, float y, float z, float w) {
		return this.plus(-x, -y, -z, -w);
	}

	public Double4 minus(double x, double y, double z, double w) {
		return this.plus(-x, -y, -z, -w);
	}

	@Override
	public Float4 multipliedBy(float k) {
		return new Float4(this.x() * k, this.y() * k, this.z() * k, this.w() * k);
	}

	public float dotProduct(float x, float y, float z, float w) {
		return this.x() * x + this.y() * y + this.z() * z + this.w() * w;
	}

	@Override
	public float dotProduct(Float4 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y(), vector.z(), vector.w()) : 0.0f;
	}

	public double dotProduct(double x, double y, double z, double w) {
		return this.asDouble().dotProduct(x, y, z, w);
	}

	@Override
	public float lengthSquared() {
		return this.dotProduct(this);
	}

	public double angle(double x, double y, double z, double w) {
		return this.angle(new Double4(x, y, z, w));
	}

	@Override
	public Double4 asDouble() {
		return new Double4(this.x(), this.y(), this.z(), this.w());
	}

	@Override
	public Int4 castToInt() {
		return new Int4((int) this.x(), (int) this.y(), (int) this.z(), (int) this.w());
	}
}
