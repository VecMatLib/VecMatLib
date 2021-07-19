package hexagon.vecmat;

/**
 * A class to represent an immutable float pair
 */
public class Float2 implements BaseOperations<Float2, Float> {

    public final float x;
    public final float y;

    /**
     * Initializes the pair with two values
     *
     * @param x First value of the pair
     * @param y Second value of the pair
     */
    public Float2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Initializes this pair with value {@code (0.0; 0.0)}
     */
    public Float2() {
        this(0.0f, 0.0f);
    }

    @Override
    public Float2 plus(Float2 operand) {
        return this.plus(operand.x, operand.y);
    }

    /**
     * Returns the sum of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code float2.plus(x, y)} is intended to work the same as {@code float2.plus(new Float2(x, y))}
     *
     * @param x First value of the operand.
     * @param y Second value of the operand.
     * @return The sum of this object and the values passed as a parameter.
     */
    public Float2 plus(float x, float y) {
        return new Float2(this.x + x, this.y + y);
    }

    /**
     * Returns the subtraction of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code float2.minus(x, y)} is intended to work the same as {@code float2.minus(new Float2(x, y))}
     *
     * @param x First value of the operand.
     * @param y Second value of the operand.
     * @return The subtraction of this object and the values passed as a parameter.
     */
    public Float2 minus(float x, float y) {
        return this.plus(-x, -y);
    }

    @Override
    public Float2 negated() {
        return new Float2(-this.x, -this.y);
    }

    @Override
    public Float2 times(Float k) {
        return new Float2(this.x * k, this.y * k);
    }

    @Override
    public Float2 dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public Float2 reciprocal() {
        return new Float2(1.0f / this.x, 1.0f / this.y);
    }

    /**
     * Casts this float pair to an int pair
     *
     * @return A new int pair with the int value of this pair
     */
    public Int2 castToInt() {
        return new Int2((int) this.x, (int) this.y);
    }

    @Override
    public String toString() {
        return "(" + this.x + "; " + this.y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Float2)
            return this.x == ((Float2) obj).x && this.y == ((Float2) obj).y;
        return false;
    }
}
