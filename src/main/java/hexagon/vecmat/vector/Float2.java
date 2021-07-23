package hexagon.vecmat.vector;

/** A class to represent a float vector in a two-dimensional vector space.
 *
 * @author Nico
 *
 * @see FloatVector
 * @see Int2
 */
public class Float2 implements FloatVector<Float2, Int2> {
    
    public static final Float2 ZERO = new Float2(0.0f, 0.0f);
    public static final Float2 ONE = new Float2(1.0f, 1.0f);
    
    /**First element of the vector*/
    public final float x;
    /**Second element of the vector*/
    public final float y;
    
    /** Creates a new 2D vector with the given values
     * @param x First element of the vector
     * @param y Second element of the vector
     */
    public Float2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public Float2 plus(Float2 operand) {
        return this.plus(operand.x, operand.y);
    }
    
    @Override
    public Float2 plus(Int2 operand) {
        return this.plus(operand.a, operand.b);
    }
    
    /** Computes the sum of this vector and a vector with the two elements passed. <p>
     * This method simplifies {@code vector.plus(new Float2(x, y))} into {@code vector.plus(x, y)}.
     * @param x First element of the vector on the right-hand side
     * @param y Second element of the vector on the right-hand side
     * @return The sum of this vector and the values passed
     */
    public Float2 plus(float x, float y) {
        return new Float2(this.x + x, this.y + y);
    }
    
    @Override
    public Float2 negated() {
        return new Float2(-this.x, -this.y);
    }
    
    /** Computes the subtraction of this vector and a vector with the two elements passed. <p>
     * This method simplifies {@code vector.minus(new Float2(x, y))} into {@code vector.minus(x, y)}.
     * @param x First element of the vector on the right-hand side
     * @param y Second element of the vector on the right-hand side
     * @return The difference of this vector and the values passed
     */
    public Float2 minus(float x, float y) {
        return this.plus(-x, -y);
    }
    
    @Override
    public Float2 times(float k) {
        return new Float2(this.x * k, this.y * k);
    }
    
    @Override
    public float dotProduct(Float2 vector) {
        return this.x * vector.x + this.y * vector.y;
    }
    
    @Override
    public float dotProduct(Int2 vector) {
        return this.x * vector.a + this.y * vector.b;
    }
    
    @Override
    public float lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public Int2 castToInt() {
        return new Int2((int) this.x, (int) this.y);
    }
    
    @Override
    public boolean equals(Float2 value) {
        return this.equals(value.x, value.y);
    }
    
    @Override
    public boolean equals(Int2 value) {
        return this.equals(value.a, value.b);
    }
    
    /** Checks if the elements of this vector are equal to the ones passed
     * @param x First element
     * @param y Second element
     * @return True if the first element of this vector is equal to {@code x} and the second element is equal to {@code y}
     */
    public boolean equals(float x, float y) {
        return this.x == x && this.y == y;
    }
    
    @Override
    public String toString() {
        return "Float2(" + x + ", " + y + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Float2 && ((Float2) object).equals(this);
    }
}
