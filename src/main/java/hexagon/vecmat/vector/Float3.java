package hexagon.vecmat.vector;

public record Float3(float x, float y, float z) implements FloatVector<Float3, Int3> {

	public static final Float3 ZERO = new Float3(0.0f, 0.0f, 0.0f);

	public Float3 plus(float x, float y, float z) {
		return new Float3(this.x() + x, this.y() + y, this.z() + z);
	}

	@Override
	public Float3 plus(Float3 vector) {
		return vector != null ? this.plus(vector.x(), vector.y(), vector.z()) : this;
	}

	@Override
	public Float3 negated() {
		return new Float3(-this.x(), -this.y(), -this.z());
	}

	public Float3 minus(float x, float y, float z) {
		return this.plus(-x, -y, -z);
	}

	@Override
	public Float3 multipliedBy(float k) {
		return new Float3(this.x() * k, this.y() * k, this.z() * k);
	}

	public float dotProduct(float x, float y, float z) {
		return this.x() * x + this.y() * y + this.z() * z;
	}

	@Override
	public float dotProduct(Float3 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y(), vector.z()) : 0.0f;
	}

	public Float3 crossProduct(float x, float y, float z) {
		return new Float3(this.y() * z - this.z() * y, x * this.z() - z * this.x(), this.x() * y - this.y() * x);
	}

	public Float3 crossProduct(Float3 vector) {
		return vector != null ? this.crossProduct(vector.x(), vector.y(), vector.z()) : Float3.ZERO;
	}

	public Float3 crossProduct(Int3 vector) {
		return vector != null ? this.crossProduct(vector.asFloat()) : Float3.ZERO;
	}

	@Override
	public float lengthSquared() {
		return this.dotProduct(this);
	}

	public double angle(float x, float y, float z) {
		return this.angle(new Float3(x, y, z));
	}

	@Override
	public Int3 castToInt() {
		return new Int3((int) this.x(), (int) this.y(), (int) this.z());
	}
}
