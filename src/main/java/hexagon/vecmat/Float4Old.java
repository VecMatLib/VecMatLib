package hexagon.vecmat;

/**
 * A class to represent an immutable float quadruple
 */
public class Float4Old implements BaseOperations<Float4Old, Float> {

    public final float x;
    public final float y;
    public final float z;
    public final float w;

    /**
     * Initializes the quadruple with four values
     *
     * @param x First value of the quadruple
     * @param y Second value of the quadruple
     * @param z Third value of the quadruple
     * @param w Fourth value of the quadruple
     */
    public Float4Old(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    /**
     * Initializes this quadruple with value {@code (0.0; 0.0; 0.0; 0.0)}
     */
    public Float4Old() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public Float4Old plus(Float4Old operand) {
        return this.plus(operand.x, operand.y, operand.z, operand.w);
    }

    /**
     * Returns the sum of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code float4.plus(x, y, z, w)} is intended to work the same as {@code float4.plus(new Float4(x, y, z, w))}
     *
     * @param x First value of the operand.
     * @param y Second value of the operand.
     * @param z Third value of the operand.
     * @param w Fourth value of the operand.
     * @return The sum of this object and the values passed as a parameter.
     */
    public Float4Old plus(float x, float y, float z, float w) {
        return new Float4Old(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    /**
     * Returns the subtraction of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code float4.minus(x, y, z, w)} is intended to work the same as {@code float4.minus(new Float4(x, y, z, w))}
     *
     * @param x First value of the operand.
     * @param y Second value of the operand.
     * @param z Third value of the operand.
     * @param w Fourth value of the operand.
     * @return The subtraction of this object and the values passed as a parameter.
     */
    public Float4Old minus(float x, float y, float z, float w) {
        return this.plus(-x, -y, -z, -w);
    }

    @Override
    public Float4Old negated() {
        return new Float4Old(-this.x, -this.y, -this.z, -this.w);
    }

    @Override
    public Float4Old times(Float k) {
        return new Float4Old(this.x * k, this.y * k, this.z * k, this.w * k);
    }

    @Override
    public Float4Old dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public Float4Old reciprocal() {
        return new Float4Old(1.0f / this.x, 1.0f / this.y, 1.0f / this.z, 1.0f / this.w);
    }

    /**
     * Casts this float quadruple to an int quadruple
     *
     * @return A new int quadruple with the int value of this quadruple
     */
    public Int4Old castToInt() {
        return new Int4Old((int) this.x, (int) this.y, (int) this.z, (int) this.w);
    }

    @Override
    public String toString() {
        return "(" + this.x + "; " + this.y + "; " + this.z + "; " + this.w + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Float4Old)
            return this.x == ((Float4Old) obj).x && this.y == ((Float4Old) obj).y && this.z == ((Float4Old) obj).z && this.w == ((Float4Old) obj).w;
        return false;
    }
}