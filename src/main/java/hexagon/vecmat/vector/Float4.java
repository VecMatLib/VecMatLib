package hexagon.vecmat.vector;

/** A class to represent a float vector in a four-dimensional vector space.
 *
 * @author Nico
 *
 * @see FloatVector
 * @see Int4
 */
public class Float4 implements FloatVector<Float4, Int4> {
    
    /**First element of the vector*/
    public final float x;
    /**Second element of the vector*/
    public final float y;
    /**Third element of the vector*/
    public final float z;
    /**Fourth element of the vector*/
    public final float w;
    
    /** Creates a new 4D vector with the given values
     * @param x First element of the vector
     * @param y Second element of the vector
     * @param z Third element of the vector
     * @param w Fourth element of the vector
     */
    public Float4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    @Override
    public Float4 plus(Float4 operand) {
        return this.plus(operand.x, operand.y, operand.z, operand.w);
    }
    
    @Override
    public Float4 plus(Int4 operand) {
        return this.plus(operand.a, operand.b, operand.c, operand.d);
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
        return new Float4(this.x + x, this.y + y, this.z + z, this.w + w);
    }
    
    @Override
    public Float4 negated() {
        return new Float4(-this.x, -this.y, -this.z, -this.w);
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
    public Float4 times(float k) {
        return new Float4(this.x * k, this.y * k, this.z * k, this.w * k);
    }
    
    @Override
    public float dotProduct(Float4 vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z + this.w * vector.w;
    }
    
    @Override
    public float dotProduct(Int4 vector) {
        return this.x * vector.a + this.y * vector.b + this.z * vector.c + this.w * vector.d;
    }
    
    @Override
    public float lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public Int4 castToInt() {
        return new Int4((int) this.x, (int) this.y, (int) this.z, (int) this.w);
    }
    
    @Override
    public boolean equals(Float4 value) {
        return this.equals(value.x, value.y, value.z, value.w);
    }
    
    @Override
    public boolean equals(Int4 value) {
        return this.equals(value.a, value.b, value.c, value.d);
    }
    
    /** Checks if the elements of this vector are equal to the ones passed
     * @param x First element
     * @param y Second element
     * @param z Third element
     * @param w Fourth element
     * @return True if the first element of this vector is equal to {@code x}
     * and the second element is equal to {@code y}
     * and the third element is equal to {@code z}
     * and the fourth element is equal to {@code w}
     */
    public boolean equals(float x, float y, float z, float w) {
        return this.x == x && this.y == y && this.z == z && this.w == w;
    }
    
    @Override
    public String toString() {
        return "Float4(" + x + ", " + y + ", " + z + ", " + w + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Float4 && ((Float4) object).equals(this);
    }
}
