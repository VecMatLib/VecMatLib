package hexagon.vecmat.vector;

/**
 * Record that represents a 2D integer vector.
 * 
 * @param x First coordinate of the vector
 * @param y Second coordinate of the vector
 * 
 * @author Nico
 */
public record Int2(int x, int y) implements VectorIntOperations<Int2>, VectorAsFloat<Float2>, VectorAsDouble<Double2> {

	/**Shorthand for {@code new Int2(0, 0)} */
	public static final Int2 ZERO = new Int2(0, 0);
	/**Shorthand for {@code new Int2(1, 1)} */
	public static final Int2 ONE = new Int2(1, 1);
	/**Shorthand for {@code new Int2(0, 1)} */
	public static final Int2 UP = new Int2(0, 1);
	/**Shorthand for {@code new Int2(0, -1)} */
	public static final Int2 DOWN = new Int2(0, -1);
	/**Shorthand for {@code new Int2(-1, 0)} */
	public static final Int2 LEFT = new Int2(-1, 0);
	/**Shorthand for {@code new Int2(1, 0)} */
	public static final Int2 RIGHT = new Int2(1, 0);

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
	public Int2 plus(int x, int y) {
		return new Int2(this.x() + x, this.y() + y);
	}

	@Override
	public Int2 plus(Int2 vector) {
		return vector != null ? this.plus(vector.x(), vector.y()) : this;
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
	 * 
	 * @return The sum of this vector and the given one
	 */
	public Float2 plus(float x, float y) {
		return this.asFloat().plus(x, y);
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
	 * 
	 * @return The sum of this vector and the given one
	 */
	public Double2 plus(double x, double y) {
		return this.asDouble().plus(x, y);
	}

	@Override
	public Int2 negated() {
		return new Int2(-this.x(), -this.y());
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
	public Int2 minus(int x, int y) {
		return this.plus(-x, -y);
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
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 */
	public Float2 minus(float x, float y) {
		return this.plus(-x, -y);
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
	 * 
	 * @return The sum of this vector and the additive inverse of the
	 * 		given one
	 */
	public Double2 minus(double x, double y) {
		return this.plus(-x, -y);
	}

	@Override
	public Int2 multipliedBy(int k) {
		return new Int2(this.x() * k, this.y() * k);
	}

	@Override
	public Int2 dividedBy(int k) {
		return new Int2(this.x() / k, this.y() / k);
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
	public int dotProduct(int x, int y) {
		return this.x() * x + this.y() * y;
	}

	@Override
	public int dotProduct(Int2 vector) {
		return vector != null ? this.dotProduct(vector.x(), vector.y()) : 0;
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
	 * 
	 * @return The result of the dot product between the two vectors
	 */
	public float dotProduct(float x, float y) {
		return this.asFloat().dotProduct(x, y);
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
	 * 
	 * @return The result of the dot product between the two vectors
	 */
	public double dotProduct(double x, double y) {
		return this.asDouble().dotProduct(x, y);
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
	 * 
	 * @return The angle in radians between this vector and the given one
	 */
	public double angle(double x, double y) {
		return this.angle(new Double2(x, y));
	}

	@Override
	public Float2 asFloat() {
		return new Float2(this.x(), this.y());
	}

	@Override
	public Double2 asDouble() {
		return new Double2(this.x(), this.y());
	}
}
