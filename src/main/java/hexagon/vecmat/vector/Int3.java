package hexagon.vecmat.vector;

public record Int3(int x, int y, int z) implements IntVector<Int3, Float3> {

	public static final Int3 ZERO = new Int3(0, 0, 0);

	public Int3 plus(int x, int y, int z) {
		return new Int3(this.x() + x, this.y() + y, this.z() + z);
	}

	@Override
	public Int3 plus(Int3 vector) {
		return vector != null ? this.plus(vector.x(), vector.y(), vector.z()) : this;
	}

	public Float3 plus(float x, float y, float z) {
		return this.asFloat().plus(x, y, z);
	}

	@Override
	public Int3 negated() {
		return new Int3(-this.x(), -this.y(), -this.z());
	}

	public Int3 minus(int x, int y, int z) {
		return this.plus(-x, -y, -z);
	}

	public Float3 minus(float x, float y, float z) {
		return this.asFloat().minus(x, y, z);
	}

	@Override
	public Int3 multipliedBy(int k) {
		return new Int3(this.x() * k, this.y() * k, this.z() * k);
	}

	@Override
	public Int3 dividedBy(int k) {
		return new Int3(this.x() / k, this.y() / k, this.z() / k);
	}

	public int dotProduct(int x, int y, int z) {
		return this.x() * x + this.y() * y + this.z() * z;
	}

	@Override
	public int dotProduct(Int3 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y(), vector.z()) : 0;
	}

	public float dotProduct(float x, float y, float z) {
		return this.asFloat().dotProduct(x, y, z);
	}

	public Int3 crossProduct(int x, int y, int z) {
		return new Int3(this.y() * z - this.z() * y, x * this.z() - z * this.x(), this.x() * y - this.y() * x);
	}

	public Int3 crossProduct(Int3 vector) {
		return vector != null ? this.crossProduct(vector.x(), vector.y(), vector.z()) : Int3.ZERO;
	}

	public Float3 crossProduct(float x, float y, float z) {
		return this.asFloat().crossProduct(x, y, z);
	}

	public Float3 crossProduct(Float3 vector) {
		return this.asFloat().crossProduct(vector);
	}

	@Override
	public int lengthSquared() {
		return this.dotProduct(this);
	}

	public double angle(int x, int y, int z) {
		return this.angle(new Int3(x, y, z));
	}

	public double angle(float x, float y, float z) {
		return this.angle(new Float3(x, y, z));
	}

	@Override
	public Float3 asFloat() {
		return new Float3(this.x(), this.y(), this.z());
	}
}
