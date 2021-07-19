package hexagon.vecmat;

/**
 * A class to represent an immutable float triplet
 */
public class Float3 implements BaseOperations<Float3, Float> {

    public final float x;
    public final float y;
    public final float z;

    /**
     * Initializes the triplet with three values
     *
     * @param x First value of the triplet
     * @param y Second value of the triplet
     * @param z Third value of the triplet
     */
    public Float3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Initializes this triplet with value {@code (0.0; 0.0; 0.0)}
     */
    public Float3() {
        this(0.0f, 0.0f, 0.0f);
    }

    @Override
    public Float3 plus(Float3 operand) {
        return this.plus(operand.x, operand.y, operand.z);
    }

    /**
     * Returns the sum of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code float3.plus(x, y, z)} is intended to work the same as {@code float3.plus(new Float3(x, y, z))}
     *
     * @param x First value of the operand.
     * @param y Second value of the operand.
     * @param z Third value of the operand.
     * @return The sum of this object and the values passed as a parameter.
     */
    public Float3 plus(float x, float y, float z) {
        return new Float3(this.x + x, this.y + y, this.z + z);
    }

    /**
     * Returns the subtraction of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code float3.minus(x, y, z)} is intended to work the same as {@code float3.minus(new Float3(x, y, z))}
     *
     * @param x First value of the operand.
     * @param y Second value of the operand.
     * @param z Third value of the operand.
     * @return The subtraction of this object and the values passed as a parameter.
     */
    public Float3 minus(float x, float y, float z) {
        return this.plus(-x, -y, -z);
    }

    @Override
    public Float3 negated() {
        return new Float3(-this.x, -this.y, -this.z);
    }

    @Override
    public Float3 times(Float k) {
        return new Float3(this.x * k, this.y * k, this.z * k);
    }

    @Override
    public Float3 dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public Float3 reciprocal() {
        return new Float3(1.0f / this.x, 1.0f / this.y, 1.0f / this.z);
    }

    /**
     * Casts this float triplet to an int triplet
     *
     * @return A new int triplet with the int value of this triplet
     */
    public Int3 castToInt() {
        return new Int3((int) this.x, (int) this.y, (int) this.z);
    }

    @Override
    public String toString() {
        return "(" + this.x + "; " + this.y + "; " + this.z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Float3)
            return this.x == ((Float3) obj).x && this.y == ((Float3) obj).y && this.z == ((Float3) obj).z;
        return false;
    }
}
