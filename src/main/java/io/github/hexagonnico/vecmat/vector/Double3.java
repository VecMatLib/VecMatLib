package io.github.hexagonnico.vecmat.vector;

/**
 * Record that represents a 3D double vector.
 * 
 * @param x First coordinate of the vector
 * @param y Second coordinate of the vector
 * @param z Third coordinate of the vector
 * 
 * @author Nico
 */
public record Double3(double x, double y, double z) implements VectorDoubleOperations<Double3> {

	/**Shorthand for {@code new Double3(0.0, 0.0, 0.0)} */
	public static final Double3 ZERO = new Double3(0.0, 0.0, 0.0);
	/**Shorthand for {@code new Double3(1.0, 1.0, 1.0)} */
	public static final Double3 ONE = new Double3(1.0, 1.0, 1.0);
	/**Shorthand for {@code new Double3(0.0, 1.0, 0.0)} */
	public static final Double3 UP = new Double3(0.0, 1.0, 0.0);
	/**Shorthand for {@code new Double3(0.0, -1.0, 0.0)} */
	public static final Double3 DOWN = new Double3(0.0, -1.0, 0.0);
	/**Shorthand for {@code new Double3(-1.0, 0.0, 0.0)} */
	public static final Double3 LEFT = new Double3(-1.0, 0.0, 0.0);
	/**Shorthand for {@code new Double3(1.0, 0.0, 0.0)} */
	public static final Double3 RIGHT = new Double3(1.0, 0.0, 0.0);
	/**Shorthand for {@code new Double3(0.0, 0.0, 1.0)} */
	public static final Double3 FORWARD = new Double3(0.0, 0.0, 1.0);
	/**Shorthand for {@code new Double3(0.0, 0.0, -1.0)} */
	public static final Double3 BACKWARDS = new Double3(0.0, 0.0, -1.0);

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
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * 
	 * @return The sum of this vector and the given one.
	 */
	public Double3 plus(double x, double y, double z) {
		return new Double3(this.x() + x, this.y() + y, this.z() + z);
	}

	@Override
	public Double3 plus(Double3 vector) {
		return this.plus(vector.x(), vector.y(), vector.z());
	}

	@Override
	public Double3 negated() {
		return new Double3(-this.x(), -this.y(), -this.z());
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
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one.
	 */
	public Double3 minus(double x, double y, double z) {
		return this.plus(-x, -y, -z);
	}

	@Override
	public Double3 multipliedBy(double k) {
		return new Double3(this.x() * k, this.y() * k, this.z() * k);
	}

	@Override
	public Double3 dividedBy(double k) {
		return new Double3(this.x() / k, this.y() / k, this.z() / k);
	}

	/**
	 * Computes the dot product (or scalar product) between this
	 * vector and the given one.
	 * 
	 * <p> The dot product between two vectors v and w of the same
	 * size is a scalar defined as the summation of the products of
	 * every element vi and wi of the two vectors.
	 * 
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * 
	 * @return The result of the dot product between the two vectors.
	 */
	public double dotProduct(double x, double y, double z) {
		return this.x() * x + this.y() * y + this.z() * z;
	}

	@Override
	public double dotProduct(Double3 vector) {
		return this.dotProduct(vector.x(), vector.y(), vector.z());
	}

	/**
	 * Computes the cross product (or vector product) between this
	 * vector and the given one.
	 * 
	 * <p> The cross product between two 3D vectors is a vector
	 * perpendicular to both of them whose magnitude equals the
	 * area of the parallelogram with the two vectors for sides.
	 * 
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * 
	 * @return The result of the cross product between the two vectors.
	 */
	public Double3 crossProduct(double x, double y, double z) {
		return new Double3(this.y() * z - this.z() * y, x * this.z() - z * this.x(), this.x() * y - this.y() * x);
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
	 * @param vector The second operand of the product.
	 * 
	 * @return The result of the cross product between the two vectors.
	 * 
	 * @throws NullPointerException If the given vector is null.
	 */
	public Double3 crossProduct(Double3 vector) {
		return this.crossProduct(vector.x(), vector.y(), vector.z());
	}

	/**
	 * Computes the cross product (or vector product) between this
	 * vector and the given one.
	 * 
	 * <p> The cross product between two 3D vectors is a vector
	 * perpendicular to both of them whose magnitude equals the
	 * area of the parallelogram with the two vectors for sides.
	 * 
	 * <p> The cross product between this vector and a vector that
	 * can be represented as a double vector without casting will
	 * result in a double vector.
	 * 
	 * @param vector The second operand of the product.
	 * 
	 * @return The result of the cross product between the two vectors.
	 * 
	 * @throws NullPointerException If the given vector is null.
	 */
	public Double3 crossProduct(VectorAsDouble<Double3> vector) {
		return this.crossProduct(vector.asDouble());
	}

	@Override
	public double lengthSquared() {
		return this.dotProduct(this);
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * 
	 * @return The angle in radians between this vector and the given one.
	 */
	public double angle(double x, double y, double z) {
		return this.angle(new Double3(x, y, z));
	}

	/**
	 * Casts this vector to an int vector.
	 * 
	 * @return A vector with the same elements as this vector casted to int.
	 */
	public Int3 castToInt() {
		return new Int3((int) this.x(), (int) this.y(), (int) this.z());
	}

	/**
	 * Casts this vector to a float vector.
	 * 
	 * @return A vector with the same elements as this vector casted to float.
	 */
	public Float3 castToFloat() {
		return new Float3((float) this.x(), (float) this.y(), (float) this.z());
	}
}
