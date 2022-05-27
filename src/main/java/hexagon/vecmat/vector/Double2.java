package hexagon.vecmat.vector;

/**
 * Record that represents a 2D double vector.
 * 
 * @param x First coordinate of the vector
 * @param y Second coordinate of the vector
 * 
 * @author Nico
 */
public record Double2(double x, double y) implements VectorDoubleOperations<Double2> {

	/**Shorthand for {@code new Double2(0.0, 0.0)} */
	public static final Double2 ZERO = new Double2(0.0, 0.0);
	/**Shorthand for {@code new Double2(1.0, 1.0)} */
	public static final Double2 ONE = new Double2(1.0, 1.0);
	/**Shorthand for {@code new Double2(0.0, 1.0)} */
	public static final Double2 UP = new Double2(0.0, 1.0);
	/**Shorthand for {@code new Double2(0.0, -1.0)} */
	public static final Double2 DOWN = new Double2(0.0, -1.0);
	/**Shorthand for {@code new Double2(-1.0, 0.0)} */
	public static final Double2 LEFT = new Double2(-1.0, 0.0);
	/**Shorthand for {@code new Double2(1.0, 0.0)} */
	public static final Double2 RIGHT = new Double2(1.0, 0.0);

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
	 * 
	 * @return The sum of this vector and the given one
	 */
	public Double2 plus(double x, double y) {
		return new Double2(this.x() + x, this.y() + y);
	}

	@Override
	public Double2 plus(Double2 vector) {
		return vector != null ? this.plus(vector.x(), vector.y()) : this;
	}

	@Override
	public Double2 negated() {
		return new Double2(-this.x(), -this.y());
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
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 */
	public Double2 minus(double x, double y) {
		return this.plus(-x, -y);
	}

	@Override
	public Double2 multipliedBy(double k) {
		return new Double2(this.x() * k, this.y() * k);
	}

	@Override
	public Double2 dividedBy(double k) {
		return new Double2(this.x() / k, this.y() / k);
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
	 * 
	 * @return The result of the dot product between the two vectors
	 */
	public double dotProduct(double x, double y) {
		return this.x() * x + this.y() * y;
	}

	@Override
	public double dotProduct(Double2 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y()) : 0.0;
	}

	@Override
	public double lengthSquared() {
		return this.dotProduct(this);
	}

	/**
	 * Computes the angle in radians between this vector and the given one.
	 * 
	 * @param x First coordinate of the given vector
	 * @param y Second coordinate of the given vector
	 * 
	 * @return The angle in radians between this vector and the given one
	 */
	public double angle(double x, double y) {
		return this.angle(new Double2(x, y));
	}

	/**
	 * Casts this vector to an int vector.
	 * 
	 * @return A vector with the same elements as this vector casted to int.
	 */
	public Int2 castToInt() {
		return new Int2((int) this.x(), (int) this.y());
	}

	/**
	 * Casts this vector to a float vector.
	 * 
	 * @return A vector with the same elements as this vector casted to float.
	 */
	public Float2 castToFloat() {
		return new Float2((float) this.x(), (float) this.y());
	}
}
