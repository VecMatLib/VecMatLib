package hexagon.vecmat.vector;

/** A class to represent an integer vector in a two-dimensional vector space.
 *
 * @author Nico
 *
 * @see IntVector
 * @see Float2
 */
public class Int2 implements IntVector<Int2, Float2> {
    
    public static final Int2 ZERO = new Int2(0, 0);
    public static final Int2 ONE = new Int2(1, 1);
    
    /**First element of the vector*/
    public final int a;
    /**Second element of the vector*/
    public final int b;
    
    /** Creates a new 2D vector with the given values
     * @param a First element of the vector
     * @param b Second element of the vector
     */
    public Int2(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public Int2 plus(Int2 operand) {
        return this.plus(operand.a, operand.b);
    }
    
    @Override
    public Float2 plus(Float2 operand) {
        return this.plus(operand.x, operand.y);
    }
    
    /** Computes the sum of this vector and a vector with the two elements passed. <p>
     * This method simplifies {@code vector.plus(new Int2(a, b))} into {@code vector.plus(a, b)}.
     * @param a First element of the vector on the right-hand side
     * @param b Second element of the vector on the right-hand side
     * @return The sum of this vector and the values passed
     */
    public Int2 plus(int a, int b) {
        return new Int2(this.a + a, this.b + b);
    }
    
    /** Computes the sum of this vector and a vector with the two elements passed. <p>
     * This method simplifies {@code vector.plus(new Float2(x, y))} into {@code vector.plus(x, y)}.
     * @param x First element of the vector on the right-hand side
     * @param y Second element of the vector on the right-hand side
     * @return The sum of this vector and the values passed
     */
    public Float2 plus(float x, float y) {
        return new Float2(this.a + x, this.b + y);
    }
    
    @Override
    public Int2 negated() {
        return new Int2(-this.a, -this.b);
    }
    
    /** Computes the subtraction of this vector and a vector with the two elements passed. <p>
     * This method simplifies {@code vector.minus(new Int2(a, b))} into {@code vector.minus(a, b)}.
     * @param a First element of the vector on the right-hand side
     * @param b Second element of the vector on the right-hand side
     * @return The difference of this vector and the values passed
     */
    public Int2 minus(int a, int b) {
        return this.plus(-a, -b);
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
    public Int2 times(int k) {
        return new Int2(this.a * k, this.b * k);
    }
    
    @Override
    public Float2 times(float k) {
        return new Float2(this.a * k, this.b * k);
    }
    
    @Override
    public Int2 dividedBy(int k) {
        return new Int2(this.a / k, this.b / k);
    }
    
    @Override
    public int dotProduct(Int2 vector) {
        return this.a * vector.a + this.b * vector.b;
    }
    
    @Override
    public float dotProduct(Float2 vector) {
        return this.a * vector.x + this.b * vector.y;
    }
    
    @Override
    public int lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public boolean equals(Int2 value) {
        return this.equals(value.a, value.b);
    }
    
    /** Checks if the elements of this vector are equal to the ones passed
     * @param a First element
     * @param b Second element
     * @return True if the first element of this vector is equal to {@code a} and the second element is equal to {@code b}
     */
    public boolean equals(int a, int b) {
        return this.a == a && this.b == b;
    }
    
    @Override
    public boolean equals(Float2 value) {
        return this.equals(value.x, value.y);
    }
    
    public boolean equals(float x, float y) {
        return this.a == x && this.b == y;
    }
    
    @Override
    public String toString() {
        return "Int2(" + a + ", " + b + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Int2 && ((Int2) object).equals(this);
    }
}
