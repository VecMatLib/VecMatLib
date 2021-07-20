package hexagon.vecmat;

/**
 * A class to represent an immutable float pair
 */
public class Float2Old implements BaseOperations<Float2Old, Float> {

    public final float x;
    public final float y;

    /**
     * Initializes the pair with two values
     *
     * @param x First value of the pair
     * @param y Second value of the pair
     */
    public Float2Old(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Initializes this pair with value {@code (0.0; 0.0)}
     */
    public Float2Old() {
        this(0.0f, 0.0f);
    }

    @Override
    public Float2Old plus(Float2Old operand) {
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
    public Float2Old plus(float x, float y) {
        return new Float2Old(this.x + x, this.y + y);
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
    public Float2Old minus(float x, float y) {
        return this.plus(-x, -y);
    }

    @Override
    public Float2Old negated() {
        return new Float2Old(-this.x, -this.y);
    }

    @Override
    public Float2Old times(Float k) {
        return new Float2Old(this.x * k, this.y * k);
    }

    @Override
    public Float2Old dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public Float2Old reciprocal() {
        return new Float2Old(1.0f / this.x, 1.0f / this.y);
    }

    /**
     * Casts this float pair to an int pair
     *
     * @return A new int pair with the int value of this pair
     */
    public Int2Old castToInt() {
        return new Int2Old((int) this.x, (int) this.y);
    }

    @Override
    public String toString() {
        return "(" + this.x + "; " + this.y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Float2Old)
            return this.x == ((Float2Old) obj).x && this.y == ((Float2Old) obj).y;
        return false;
    }
}
