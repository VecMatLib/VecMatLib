package hexagon.vecmat.vector;

/**
 * Record that represents a 3D integer vector.
 * 
 * @param x First coordinate of the vector
 * @param y Second coordinate of the vector
 * @param z Third coordinate of the vector
 * 
 * @author Nico
 */
public record Int3(int x, int y, int z) implements VectorIntOperations<Int3, Float3, Double3> {

	/**Shorthand for {@code new Int3(0, 0, 0)} */
	public static final Int3 ZERO = new Int3(0, 0, 0);
	/**Shorthand for {@code new Int3(1, 1, 1)} */
	public static final Int3 ONE = new Int3(1, 1, 1);
	/**Shorthand for {@code new Int3(0, 1, 0)} */
	public static final Int3 UP = new Int3(0, 1, 0);
	/**Shorthand for {@code new Int3(0, -1, 0)} */
	public static final Int3 DOWN = new Int3(0, -1, 0);
	/**Shorthand for {@code new Int3(-1, 0, 0)} */
	public static final Int3 LEFT = new Int3(-1, 0, 0);
	/**Shorthand for {@code new Int3(1, 0, 0)} */
	public static final Int3 RIGHT = new Int3(1, 0, 0);
	/**Shorthand for {@code new Int3(0, 0, 1)} */
	public static final Int3 FORWARD = new Int3(0, 0, 1);
	/**Shorthand for {@code new Int3(0, 0, -1)} */
	public static final Int3 BACKWARDS = new Int3(0, 0, -1);

	/**
	 * Computes the sum of this vector with the given one.
	 * 
	 * <p> The sum of two vectors v1 and v2 of the same size is
	 * a vector v3 such that every i-th element of v3 is the
	 * sum of the i-th element of v1 and the i-th element of v2.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The sum of this vector and the given one
	 */
	public Int3 plus(int x, int y, int z) {
		return new Int3(this.x() + x, this.y() + y, this.z() + z);
	}

	@Override
	public Int3 plus(Int3 vector) {
		return vector != null ? this.plus(vector.x(), vector.y(), vector.z()) : this;
	}

	/**
	 * Computes the sum of this vector with the given one.
	 * 
	 * <p> The sum of two vectors v1 and v2 of the same size is
	 * a vector v3 such that every i-th element of v3 is the
	 * sum of the i-th element of v1 and the i-th element of v2.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> The sum of this vector and a float vector will result
	 * in a float vector.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The sum of this vector and the given one
	 */
	public Float3 plus(float x, float y, float z) {
		return this.asFloat().plus(x, y, z);
	}

	/**
	 * Computes the sum of this vector with the given one.
	 * 
	 * <p> The sum of two vectors v1 and v2 of the same size is
	 * a vector v3 such that every i-th element of v3 is the
	 * sum of the i-th element of v1 and the i-th element of v2.
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> The sum of this vector and a double vector will result
	 * in a double vector.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The sum of this vector and the given one
	 */
	public Double3 plus(double x, double y, double z) {
		return this.asDouble().plus(x, y, z);
	}

	@Override
	public Int3 negated() {
		return new Int3(-this.x(), -this.y(), -this.z());
	}

	/**
	 * Computes the subtraction of the given vector from this one.
	 * 
	 * <p> The subtraction of a vector v2 from a vector v1 is defined
	 * as the sum of v1 with the additive inverse of v2. That is
	 * v1 - v2 = v1 + (-v2)
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 */
	public Int3 minus(int x, int y, int z) {
		return this.plus(-x, -y, -z);
	}

	/**
	 * Computes the subtraction of the given vector from this one.
	 * 
	 * <p> The subtraction of a vector v2 from a vector v1 is defined
	 * as the sum of v1 with the additive inverse of v2. That is
	 * v1 - v2 = v1 + (-v2)
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> The subtraction of this vector and a float vector will
	 * result in a float vector.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 */
	public Float3 minus(float x, float y, float z) {
		return this.asFloat().minus(x, y, z);
	}

	/**
	 * Computes the subtraction of the given vector from this one.
	 * 
	 * <p> The subtraction of a vector v2 from a vector v1 is defined
	 * as the sum of v1 with the additive inverse of v2. That is
	 * v1 - v2 = v1 + (-v2)
	 * 
	 * <p> Vectors are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new vector instead.
	 * 
	 * <p> The subtraction of this vector and a double vector will
	 * result in a double vector.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 */
	public Double3 minus(double x, double y, double z) {
		return this.asDouble().minus(x, y, z);
	}

	@Override
	public Int3 multipliedBy(int k) {
		return new Int3(this.x() * k, this.y() * k, this.z() * k);
	}

	@Override
	public Int3 dividedBy(int k) {
		return new Int3(this.x() / k, this.y() / k, this.z() / k);
	}

	/**
	 * Computes the dot product (or scalar product) between this
	 * vector and the given one.
	 * 
	 * <p> The dot product between two vectors v and w of the same
	 * size is a scalar defined as the summation of the products of
	 * every element vi and wi of the two vectors.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The result of the dot product between the two vectors
	 */
	public int dotProduct(int x, int y, int z) {
		return this.x() * x + this.y() * y + this.z() * z;
	}

	@Override
	public int dotProduct(Int3 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y(), vector.z()) : 0;
	}

	/**
	 * Computes the dot product (or scalar product) between this
	 * vector and the given one.
	 * 
	 * <p> The dot product between two vectors v and w of the same
	 * size is a scalar defined as the summation of the products of
	 * every element vi and wi of the two vectors.
	 * 
	 * <p> The dot product between this vector and a float vector
	 * will result in a float.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The result of the dot product between the two vectors
	 */
	public float dotProduct(float x, float y, float z) {
		return this.asFloat().dotProduct(x, y, z);
	}

	/**
	 * Computes the dot product (or scalar product) between this
	 * vector and the given one.
	 * 
	 * <p> The dot product between two vectors v and w of the same
	 * size is a scalar defined as the summation of the products of
	 * every element vi and wi of the two vectors.
	 * 
	 * <p> The dot product between this vector and a double vector
	 * will result in a double.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The result of the dot product between the two vectors
	 */
	public double dotProduct(double x, double y, double z) {
		return this.asDouble().dotProduct(x, y, z);
	}

	/**
	 * Computes the cross product (or vector product) between this
	 * vector and the given one.
	 * 
	 * <p> The cross product between two 3D vectors is a vector
	 * perpendicular to both of them whose magnitude equals the
	 * area of the parallelogram with the two vectors for sides.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The result of the cross product between the two vectors
	 */
	public Int3 crossProduct(int x, int y, int z) {
		return new Int3(this.y() * z - this.z() * y, x * this.z() - z * this.x(), this.x() * y - this.y() * x);
	}

	/**
	 * Computes the cross product (or vector product) between this
	 * vector and the given one.
	 * 
	 * <p> The cross product between two 3D vectors is a vector
	 * perpendicular to both of them whose magnitude equals the
	 * area of the parallelogram with the two vectors for sides.
	 * 
	 * <p> If the given vector is null, it will be treated as a
	 * vector where every element is 0.
	 * 
	 * @param vector The second operand of the product
	 * 
	 * @return The result of the cross product between the two vectors
	 */
	public Int3 crossProduct(Int3 vector) {
		return vector != null ? this.crossProduct(vector.x(), vector.y(), vector.z()) : Int3.ZERO;
	}

	/**
	 * Computes the cross product (or vector product) between this
	 * vector and the given one.
	 * 
	 * <p> The cross product between two 3D vectors is a vector
	 * perpendicular to both of them whose magnitude equals the
	 * area of the parallelogram with the two vectors for sides.
	 * 
	 * <p> The cross product between this vector and a float vector
	 * will result in a float vector.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The result of the cross product between the two vectors
	 */
	public Float3 crossProduct(float x, float y, float z) {
		return this.asFloat().crossProduct(x, y, z);
	}

	/**
	 * Computes the cross product (or vector product) between this
	 * vector and the given one.
	 * 
	 * <p> The cross product between two 3D vectors is a vector
	 * perpendicular to both of them whose magnitude equals the
	 * area of the parallelogram with the two vectors for sides.
	 * 
	 * <p> The cross product between this vector and a float vector
	 * will result in a float vector.
	 * 
	 * <p> If the given vector is null, it will be treated as a
	 * vector where every element is 0.
	 * 
	 * @param vector The second operand of the product
	 * 
	 * @return The result of the cross product between the two vectors
	 */
	public Float3 crossProduct(Float3 vector) {
		return this.asFloat().crossProduct(vector);
	}

	/**
	 * Computes the cross product (or vector product) between this
	 * vector and the given one.
	 * 
	 * <p> The cross product between two 3D vectors is a vector
	 * perpendicular to both of them whose magnitude equals the
	 * area of the parallelogram with the two vectors for sides.
	 * 
	 * <p> The cross product between this vector and a double vector
	 * will result in a double vector.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The result of the cross product between the two vectors
	 */
	public Double3 crossProduct(double x, double y, double z) {
		return this.asDouble().crossProduct(x, y, z);
	}

	/**
	 * Computes the cross product (or vector product) between this
	 * vector and the given one.
	 * 
	 * <p> The cross product between two 3D vectors is a vector
	 * perpendicular to both of them whose magnitude equals the
	 * area of the parallelogram with the two vectors for sides.
	 * 
	 * <p> The cross product between this vector and a double vector
	 * will result in a double vector.
	 * 
	 * <p> If the given vector is null, it will be treated as a
	 * vector where every element is 0.
	 * 
	 * @param vector The second operand of the product
	 * 
	 * @return The result of the cross product between the two vectors
	 */
	public Double3 crossProduct(Double3 vector) {
		return this.asDouble().crossProduct(vector);
	}

	@Override
	public int lengthSquared() {
		return this.dotProduct(this);
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * 
	 * @return The angle in radians between this vector and the given one
	 */
	public double angle(double x, double y, double z) {
		return this.angle(new Double3(x, y, z));
	}

	@Override
	public Float3 asFloat() {
		return new Float3(this.x(), this.y(), this.z());
	}

	@Override
	public Double3 asDouble() {
		return new Double3(this.x(), this.y(), this.z());
	}
}
