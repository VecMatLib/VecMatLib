package hexagon.vecmat.vector;

public record Int4(int x, int y, int z, int w) implements IntVector<Int4, Float4, Double4> {

	public Int4 plus(int x, int y, int z, int w) {
		return new Int4(this.x() + x, this.y() + y, this.z() + z, this.w() + w);
	}

	@Override
	public Int4 plus(Int4 vector) {
		return vector != null ? this.plus(vector.x(), vector.y(), vector.z(), vector.w()) : this;
	}

	public Float4 plus(float x, float y, float z, float w) {
		return this.asFloat().plus(x, y, z, w);
	}

	@Override
	public Int4 negated() {
		return new Int4(-this.y(), -this.y(), -this.z(), -this.w());
	}

	public Int4 minus(int x, int y, int z, int w) {
		return this.plus(-x, -y, -z, -w);
	}

	@Override
	public Int4 multipliedBy(int k) {
		return new Int4(this.x() * k, this.y() * k, this.z() * k, this.w() * k);
	}

	@Override
	public Int4 dividedBy(int k) {
		return new Int4(this.x() / k, this.y() / k, this.z() / k, this.w() / k);
	}

	public int dotProduct(int x, int y, int z, int w) {
		return this.x() * x + this.y() * y + this.z() * z + this.w() * w;
	}

	@Override
	public int dotProduct(Int4 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y(), vector.z(), vector.w()) : 0;
	}

	public float dotProduct(float x, float y, float z, float w) {
		return this.asFloat().dotProduct(x, y, z, w);
	}

	@Override
	public int lengthSquared() {
		return this.dotProduct(this);
	}

	public double angle(int x, int y, int z, int w) {
		return this.angle(new Int4(x, y, z, w));
	}

	public double angle(float x, float y, float z, float w) {
		return this.angle(new Float4(x, y, z, w));
	}

	@Override
	public Float4 asFloat() {
		return new Float4(this.x(), this.y(), this.z(), this.w());
	}

	@Override
	public Double4 asDouble() {
		return new Double4(this.x(), this.y(), this.z(), this.w());
	}
}
