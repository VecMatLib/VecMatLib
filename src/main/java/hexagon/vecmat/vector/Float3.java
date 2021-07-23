package hexagon.vecmat.vector;

/** A class to represent a float vector in a three-dimensional vector space.
 *
 * @author Nico
 *
 * @see FloatVector
 * @see Int3
 */
public class Float3 implements FloatVector<Float3, Int3> {
    
    public static final Float3 ZERO = new Float3(0.0f, 0.0f, 0.0f);
    public static final Float3 ONE = new Float3(1.0f, 1.0f, 1.0f);
    
    /**First element of the vector*/
    public final float x;
    /**Second element of the vector*/
    public final float y;
    /**Third element of the vector*/
    public final float z;
    
    /** Creates a new 3D vector with the given values
     * @param x First element of the vector
     * @param y Second element of the vector
     * @param z Third element of the vector
     */
    public Float3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public Float3 plus(Float3 operand) {
        return this.plus(operand.x, operand.y, operand.z);
    }
    
    @Override
    public Float3 plus(Int3 operand) {
        return this.plus(operand.a, operand.b, operand.c);
    }
    
    /** Computes the sum of this vector and a vector with the three elements passed. <p>
     * This method simplifies {@code vector.plus(new Float3(x, y, z))} into {@code vector.plus(x, y, z)}.
     * @param x First element of the vector on the right-hand side
     * @param y Second element of the vector on the right-hand side
     * @param z Third element of the vector on the right-hand side
     * @return The sum of this vector and the values passed
     */
    public Float3 plus(float x, float y, float z) {
        return new Float3(this.x + x, this.y + y, this.z + z);
    }
    
    @Override
    public Float3 negated() {
        return new Float3(-this.x, -this.y, -this.z);
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
    public Float3 times(float k) {
        return new Float3(this.x * k, this.y * k, this.z * k);
    }
    
    @Override
    public float dotProduct(Float3 vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }
    
    @Override
    public float dotProduct(Int3 vector) {
        return this.x * vector.a + this.y * vector.b + this.z * vector.c;
    }
    
    /** Computes the cross product of this vector and the one passed as a parameter. <p>
     * The cross product between two vectors is a vector that is perpendicular to both the two vectors. <p>
     * This method does not affect the object on which it is called, it returns a new one instead.
     * @param vector Right-hand side of the cross product
     * @return A new Float3 vector, result of the cross product
     */
    public Float3 crossProduct(Float3 vector) {
        return new Float3(this.y * vector.z - this.z * vector.y, vector.x * this.z - vector.z * this.x, this.x * vector.y - this.y * vector.x);
    }
    
    /** Computes the cross product of this vector and the one passed as a parameter. <p>
     * The cross product between two vectors is a vector that is perpendicular to both the two vectors. <p>
     * This method does not affect the object on which it is called, it returns a new one instead.
     * @param vector Right-hand side of the cross product
     * @return A new Float3 vector, result of the cross product
     */
    public Float3 crossProduct(Int3 vector) {
        return new Float3(this.y * vector.c - this.z * vector.b, vector.a * this.z - vector.c * this.x, this.x * vector.b - this.y * vector.a);
    }
    
    @Override
    public float lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public Int3 castToInt() {
        return new Int3((int) this.x, (int) this.y, (int) this.z);
    }
    
    @Override
    public boolean equals(Float3 value) {
        return this.equals(value.x, value.y, value.z);
    }
    
    @Override
    public boolean equals(Int3 value) {
        return this.equals(value.a, value.b, value.c);
    }
    
    /** Checks if the elements of this vector are equal to the ones passed
     * @param x First element
     * @param y Second element
     * @param z Third element
     * @return True if the first element of this vector is equal to {@code x}
     * and the second element is equal to {@code y}
     * and the third element is equal to {@code z}
     */
    public boolean equals(float x, float y, float z) {
        return this.x == x && this.y == y && this.z == z;
    }
    
    @Override
    public String toString() {
        return "Float3(" + x + ", " + y + ", " + z + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Float3 && ((Float3) object).equals(this);
    }
}
