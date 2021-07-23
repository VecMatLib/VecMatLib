package hexagon.vecmat.vector;

/** A class to represent an integer vector in a four-dimensional vector space.
 *
 * @author Nico
 *
 * @see IntVector
 * @see Float4
 */
public class Int4 implements IntVector<Int4, Float4> {
    
    public static final Int4 ZERO = new Int4(0, 0, 0, 0);
    public static final Int4 ONE = new Int4(1, 1, 1, 1);
    
    /**First element of the vector*/
    public final int a;
    /**Second element of the vector*/
    public final int b;
    /**Third element of the vector*/
    public final int c;
    /**Fourth element of the vector*/
    public final int d;
    
    /** Creates a new 4D vector with the given values
     * @param a First element of the vector
     * @param b Second element of the vector
     * @param c Third element of the vector
     * @param d Fourth element of the vector
     */
    public Int4(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public Int4 plus(Int4 operand) {
        return this.plus(operand.a, operand.b, operand.c, operand.d);
    }
    
    @Override
    public Float4 plus(Float4 operand) {
        return this.plus(operand.x, operand.y, operand.z, operand.w);
    }
    
    /** Computes the sum of this vector and a vector with the four elements passed. <p>
     * This method simplifies {@code vector.plus(new Int4(a, b, c, d))} into {@code vector.plus(a, b, c, d)}.
     * @param a First element of the vector on the right-hand side
     * @param b Second element of the vector on the right-hand side
     * @param c Third element of the vector on the right-hand side
     * @param d Fourth element of the vector on the right-hand side
     * @return The sum of this vector and the values passed
     */
    public Int4 plus(int a, int b, int c, int d) {
        return new Int4(this.a + a, this.b + b, this.c + c, this.d + d);
    }
    
    /** Computes the sum of this vector and a vector with the four elements passed. <p>
     * This method simplifies {@code vector.plus(new Float4(x, y, z, w))} into {@code vector.plus(x, y, z, w)}.
     * @param x First element of the vector on the right-hand side
     * @param y Second element of the vector on the right-hand side
     * @param z Third element of the vector on the right-hand side
     * @param w Fourth element of the vector on the right-hand side
     * @return The sum of this vector and the values passed
     */
    public Float4 plus(float x, float y, float z, float w) {
        return new Float4(this.a + x, this.b + y, this.c + z, this.d + w);
    }
    
    @Override
    public Int4 negated() {
        return new Int4(-this.a, -this.b, -this.c, -this.d);
    }
    
    /** Computes the subtraction of this vector and a vector with the four elements passed. <p>
     * This method simplifies {@code vector.minus(new Int4(a, b, c, d))} into {@code vector.minus(a, b, c, d)}.
     * @param a First element of the vector on the right-hand side
     * @param b Second element of the vector on the right-hand side
     * @param c Third element of the vector on the right-hand side
     * @param d Fourth element of the vector on the right-hand side
     * @return The difference of this vector and the values passed
     */
    public Int4 minus(int a, int b, int c, int d) {
        return this.plus(-a, -b, -c, -d);
    }
    
    /** Computes the subtraction of this vector and a vector with the four elements passed. <p>
     * This method simplifies {@code vector.minus(new Float4(x, y, z, w))} into {@code vector.minus(x, y, z, w)}.
     * @param x First element of the vector on the right-hand side
     * @param y Second element of the vector on the right-hand side
     * @param z Third element of the vector on the right-hand side
     * @param w Fourth element of the vector on the right-hand side
     * @return The difference of this vector and the values passed
     */
    public Float4 minus(float x, float y, float z, float w) {
        return this.plus(-x, -y, -z, -w);
    }
    
    @Override
    public Int4 times(int k) {
        return new Int4(this.a * k, this.b * k, this.c * k, this.d * k);
    }
    
    @Override
    public Float4 times(float k) {
        return new Float4(this.a * k, this.b * k, this.c * k, this.d * k);
    }
    
    @Override
    public Int4 dividedBy(int k) {
        return new Int4(this.a / k, this.b / k, this.c / k, this.d / k);
    }
    
    @Override
    public int dotProduct(Int4 vector) {
        return this.a * vector.a + this.b * vector.b + this.c * vector.c + this.d * vector.d;
    }
    
    @Override
    public float dotProduct(Float4 vector) {
        return this.a * vector.x + this.b * vector.y + this.c * vector.z + this.d * vector.w;
    }
    
    @Override
    public int lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public boolean equals(Int4 value) {
        return this.equals(value.a, value.b, value.c, value.d);
    }
    
    /** Checks if the elements of this vector are equal to the ones passed
     * @param a First element
     * @param b Second element
     * @param c Third element
     * @param d Fourth element
     * @return True if the first element of this vector is equal to {@code a}
     * and the second element is equal to {@code b}
     * and the third element is equal to {@code c}
     * and the fourth element is equal to {@code d}
     */
    public boolean equals(int a, int b, int c, int d) {
        return this.a == a && this.b == b && this.c == c && this.d == d;
    }
    
    @Override
    public boolean equals(Float4 value) {
        return this.equals(value.x, value.y, value.z, value.w);
    }
    
    public boolean equals(float x, float y, float z, float w) {
        return this.a == x && this.b == y && this.c == z && this.d == w;
    }
    
    @Override
    public String toString() {
        return "Int4(" + a + ", " + b + ", " + c + ", " + d + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Int4 && ((Int4) object).equals(this);
    }
}
