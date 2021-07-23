package hexagon.vecmat.vector;

/** A class to represent an integer vector in a three-dimensional vector space.
 *
 * @author Nico
 *
 * @see IntVector
 * @see Float3
 */
public class Int3 implements IntVector<Int3, Float3> {
    
    public static final Int3 ZERO = new Int3(0, 0, 0);
    public static final Int3 ONE = new Int3(1, 1, 1);
    
    /**First element of the vector*/
    public final int a;
    /**Second element of the vector*/
    public final int b;
    /**Third element of the vector*/
    public final int c;
    
    /** Creates a new 3D vector with the given values
     * @param a First element of the vector
     * @param b Second element of the vector
     * @param c Third element of the vector
     */
    public Int3(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public Int3 plus(Int3 operand) {
        return this.plus(operand.a, operand.b, operand.c);
    }
    
    @Override
    public Float3 plus(Float3 operand) {
        return this.plus(operand.x, operand.y, operand.z);
    }
    
    /** Computes the sum of this vector and a vector with the three elements passed. <p>
     * This method simplifies {@code vector.plus(new Int3(a, b, c))} into {@code vector.plus(a, b, c)}.
     * @param a First element of the vector on the right-hand side
     * @param b Second element of the vector on the right-hand side
     * @param c Third element of the vector on the right-hand side
     * @return The sum of this vector and the values passed
     */
    public Int3 plus(int a, int b, int c) {
        return new Int3(this.a + a, this.b + b, this.c + c);
    }
    
    /** Computes the sum of this vector and a vector with the three elements passed. <p>
     * This method simplifies {@code vector.plus(new Float3(x, y, z))} into {@code vector.plus(x, y, z)}.
     * @param x First element of the vector on the right-hand side
     * @param y Second element of the vector on the right-hand side
     * @param z Third element of the vector on the right-hand side
     * @return The sum of this vector and the values passed
     */
    public Float3 plus(float x, float y, float z) {
        return new Float3(this.a + x, this.b + y, this.c + z);
    }
    
    @Override
    public Int3 negated() {
        return new Int3(-this.a, -this.b, -this.c);
    }
    
    /** Computes the subtraction of this vector and a vector with the three elements passed. <p>
     * This method simplifies {@code vector.minus(new Int3(a, b, c))} into {@code vector.minus(a, b, c)}.
     * @param a First element of the vector on the right-hand side
     * @param b Second element of the vector on the right-hand side
     * @param c Third element of the vector on the right-hand side
     * @return The difference of this vector and the values passed
     */
    public Int3 minus(int a, int b, int c) {
        return this.plus(-a, -b, -c);
    }
    
    /** Computes the subtraction of this vector and a vector with the three elements passed. <p>
     * This method simplifies {@code vector.minus(new Float3(x, y, z))} into {@code vector.minus(x, y, z)}.
     * @param x First element of the vector on the right-hand side
     * @param y Second element of the vector on the right-hand side
     * @param z Third element of the vector on the right-hand side
     * @return The difference of this vector and the values passed
     */
    public Float3 minus(float x, float y, float z) {
        return this.plus(-x, -y, -z);
    }
    
    @Override
    public Int3 times(int k) {
        return new Int3(this.a * k, this.b * k, this.c * k);
    }
    
    @Override
    public Float3 times(float k) {
        return new Float3(this.a * k, this.b * k, this.c * k);
    }
    
    @Override
    public Int3 dividedBy(int k) {
        return new Int3(this.a / k, this.b / k, this.c / k);
    }
    
    @Override
    public int dotProduct(Int3 vector) {
        return this.a * vector.a + this.b * vector.b + this.c * vector.c;
    }
    
    @Override
    public float dotProduct(Float3 vector) {
        return this.a * vector.x + this.b * vector.y + this.c * vector.z;
    }
    
    /** Computes the cross product of this vector and the one passed as a parameter. <p>
     * The cross product between two vectors is a vector that is perpendicular to both the two vectors. <p>
     * This method does not affect the object on which it is called, it returns a new one instead.
     * @param vector Right-hand side of the cross product
     * @return A new Int3 vector, result of the cross product
     */
    public Int3 crossProduct(Int3 vector) {
        return new Int3(this.b * vector.c - this.c * vector.b, vector.a * this.c - vector.c * this.a, this.a * vector.b - this.b * vector.a);
    }
    
    /** Computes the cross product of this vector and the one passed as a parameter. <p>
     * The cross product between two vectors is a vector that is perpendicular to both the two vectors. <p>
     * This method does not affect the object on which it is called, it returns a new one instead.
     * @param vector Right-hand side of the cross product
     * @return A new Float3 vector, result of the cross product
     */
    public Float3 crossProduct(Float3 vector) {
        return new Float3(this.b * vector.z - this.c * vector.y, vector.x * this.c - vector.z * this.a, this.a * vector.y - this.b * vector.x);
    }
    
    @Override
    public int lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public boolean equals(Int3 value) {
        return this.equals(value.a, value.b, value.c);
    }
    
    /** Checks if the elements of this vector are equal to the ones passed
     * @param a First element
     * @param b Second element
     * @param c Third element
     * @return True if the first element of this vector is equal to {@code a}
     * and the second element is equal to {@code b}
     * and the third element is equal to {@code c}
     */
    public boolean equals(int a, int b, int c) {
        return this.a == a && this.b == b && this.c == c;
    }
    
    @Override
    public boolean equals(Float3 value) {
        return this.equals(value.x, value.y, value.z);
    }
    
    public boolean equals(float x, float y, float z) {
        return this.a == x && this.b == y && this.c == z;
    }
    
    @Override
    public String toString() {
        return "Int3(" + a + ", " + b + ", " + c + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Int3 && ((Int3) object).equals(this);
    }
}
