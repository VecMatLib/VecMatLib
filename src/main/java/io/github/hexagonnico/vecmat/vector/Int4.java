package io.github.hexagonnico.vecmat.vector;

/**
 * Record that represents a 4D integer vector.
 * 
 * @param x First coordinate of the vector
 * @param y Second coordinate of the vector
 * @param z Third coordinate of the vector
 * @param w Fourth coordinate of the vector
 * 
 * @author Nico
 */
public record Int4(int x, int y, int z, int w) implements VectorIntOperations<Int4>, VectorAsFloat<Float4>, VectorAsDouble<Double4> {

	/**Shorthand for {@code new Int4(0, 0, 0, 0)} */
	public static final Int4 ZERO = new Int4(0, 0, 0, 0);
	/**Shorthand for {@code new Int4(1, 1, 1, 1)} */
	public static final Int4 ONE = new Int4(1, 1, 1, 1);

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
	 * @param w Fourth coordinate of the given vector.
	 * 
	 * @return The sum of this vector and the given one.
	 */
	public Int4 plus(int x, int y, int z, int w) {
		return new Int4(this.x() + x, this.y() + y, this.z() + z, this.w() + w);
	}

	@Override
	public Int4 plus(Int4 vector) {
		return this.plus(vector.x(), vector.y(), vector.z(), vector.w());
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
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * @param w Fourth coordinate of the given vector.
	 * 
	 * @return The sum of this vector and the given one.
	 */
	public Float4 plus(float x, float y, float z, float w) {
		return this.asFloat().plus(x, y, z, w);
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
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * @param w Fourth coordinate of the given vector.
	 * 
	 * @return The sum of this vector and the given one.
	 */
	public Double4 plus(double x, double y, double z, double w) {
		return this.asDouble().plus(x, y, z, w);
	}

	@Override
	public Int4 negated() {
		return new Int4(-this.x(), -this.y(), -this.z(), -this.w());
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
	 * @param w Fourth coordinate of the given vector.
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one.
	 */
	public Int4 minus(int x, int y, int z, int w) {
		return this.plus(-x, -y, -z, -w);
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
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * @param w Fourth coordinate of the given vector.
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one.
	 */
	public Float4 minus(float x, float y, float z, float w) {
		return this.asFloat().minus(x, y, z, w);
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
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * @param w Fourth coordinate of the given vector.
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one.
	 */
	public Double4 minus(double x, double y, double z, double w) {
		return this.asDouble().minus(x, y, z, w);
	}

	@Override
	public Int4 multipliedBy(int k) {
		return new Int4(this.x() * k, this.y() * k, this.z() * k, this.w() * k);
	}

	@Override
	public Int4 dividedBy(int k) {
		return new Int4(this.x() / k, this.y() / k, this.z() / k, this.w() / k);
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
	 * @param w Fourth coordinate of the given vector.
	 * 
	 * @return The result of the dot product between the two vectors.
	 */
	public int dotProduct(int x, int y, int z, int w) {
		return this.x() * x + this.y() * y + this.z() * z + this.w() * w;
	}

	@Override
	public int dotProduct(Int4 vector) {
		return this.dotProduct(vector.x(), vector.y(), vector.z(), vector.w());
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
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * @param w Fourth coordinate of the given vector.
	 * 
	 * @return The result of the dot product between the two vectors.
	 */
	public float dotProduct(float x, float y, float z, float w) {
		return this.asFloat().dotProduct(x, y, z, w);
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
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * @param w Fourth coordinate of the given vector.
	 * 
	 * @return The result of the dot product between the two vectors.
	 */
	public double dotProduct(double x, double y, double z, double w) {
		return this.asDouble().dotProduct(x, y, z, w);
	}

	@Override
	public int lengthSquared() {
		return this.dotProduct(this);
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param x First coordinate of the given vector.
	 * @param y Second coordinate of the given vector.
	 * @param z Third coordinate of the given vector.
	 * @param w Fourth coordinate of the given vector.
	 * 
	 * @return The angle in radians between this vector and the given one.
	 */
	public double angle(double x, double y, double z, double w) {
		return this.angle(new Double4(x, y, z, w));
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
