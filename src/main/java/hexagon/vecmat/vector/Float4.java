package hexagon.vecmat.vector;

/**
 * Record that represents a 4D float vector.
 * 
 * @param x First coordinate of the vector
 * @param y Second coordinate of the vector
 * @param z Third coordinate of the vector
 * @param w Fourth coordinate of the vector
 * 
 * @author Nico
 */
public record Float4(float x, float y, float z, float w) implements VectorFloatOperations<Float4>, VectorAsDouble<Double4> {

	/**Shorthand for {@code new Float4(0.0f, 0.0f, 0.0f, 0.0f)} */
	public static final Float4 ZERO = new Float4(0.0f, 0.0f, 0.0f, 0.0f);
	/**Shorthand for {@code new Float4(1.0f, 1.0f, 1.0f, 1.0f)} */
	public static final Float4 ONE = new Float4(1.0f, 1.0f, 1.0f, 1.0f);

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
	 * @param w Fourth coordinate of the given vector
	 * 
	 * @return The sum of this vector and the given one
	 */
	public Float4 plus(float x, float y, float z, float w) {
		return new Float4(this.x() + x, this.y() + y, this.z() + z, this.w() + w);
	}

	@Override
	public Float4 plus(Float4 vector) {
		return vector != null ? this.plus(vector.x(), vector.y(), vector.z(), vector.w()) : this;
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
	 * @param w Fourth coordinate of the given vector
	 * 
	 * @return The sum of this vector and the given one
	 */
	public Double4 plus(double x, double y, double z, double w) {
		return this.asDouble().plus(x, y, z, w);
	}

	@Override
	public Float4 negated() {
		return new Float4(-this.x(), -this.y(), -this.z(), -this.w());
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
	 * @param w Fourth coordinate of the given vector
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 */
	public Float4 minus(float x, float y, float z, float w) {
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
	 * <p> The subtraction of this vector and a double vector will
	 * result in a double vector.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * @param w Fourth coordinate of the given vector
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 */
	public Double4 minus(double x, double y, double z, double w) {
		return this.plus(-x, -y, -z, -w);
	}

	@Override
	public Float4 multipliedBy(float k) {
		return new Float4(this.x() * k, this.y() * k, this.z() * k, this.w() * k);
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
	 * @param w Fourth coordinate of the given vector
	 * 
	 * @return The result of the dot product between the two vectors
	 */
	public float dotProduct(float x, float y, float z, float w) {
		return this.x() * x + this.y() * y + this.z() * z + this.w() * w;
	}

	@Override
	public float dotProduct(Float4 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y(), vector.z(), vector.w()) : 0.0f;
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
	 * @param w Fourth coordinate of the given vector
	 * 
	 * @return The result of the dot product between the two vectors
	 */
	public double dotProduct(double x, double y, double z, double w) {
		return this.asDouble().dotProduct(x, y, z, w);
	}

	@Override
	public float lengthSquared() {
		return this.dotProduct(this);
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * @param z Third coordinate of the given vector
	 * @param w Fourth coordinate of the given vector
	 * 
	 * @return The angle in radians between this vector and the given one
	 */
	public double angle(double x, double y, double z, double w) {
		return this.angle(new Double4(x, y, z, w));
	}

	/**
	 * Casts this vector to an int vector.
	 * 
	 * @return A vector with the same elements as this vector casted to int.
	 */
	public Int4 castToInt() {
		return new Int4((int) this.x(), (int) this.y(), (int) this.z(), (int) this.w());
	}

	@Override
	public Double4 asDouble() {
		return new Double4(this.x(), this.y(), this.z(), this.w());
	}
}
