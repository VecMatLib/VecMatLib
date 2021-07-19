package hexagon.vecmat;

/**
 * A class to represent an immutable pair of integers
 */
public class Int2 implements BaseOperations<Int2, Integer> {

    public final int a;
    public final int b;

    /**
     * Initializes the pair with two values
     *
     * @param a First value of the pair
     * @param b Second value of the pair
     */
    public Int2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    /**
     * Initializes this pair with value {@code (0; 0)}
     */
    public Int2() {
        this(0, 0);
    }

    @Override
    public Int2 plus(Int2 operand) {
        return this.plus(operand.a, operand.b);
    }

    /**
     * Returns the sum of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code int2.plus(a, b)} is intended to work the same as {@code int2.plus(new Int2(a, b))}
     *
     * @param a First value of the operand.
     * @param b Second value of the operand.
     * @return The sum of this object and the values passed as a parameter.
     */
    public Int2 plus(int a, int b) {
        return new Int2(this.a + a, this.b + b);
    }

    /**
     * Returns the subtraction of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code int2.minus(a, b)} is intended to work the same as {@code int2.minus(new Int2(a, b))}
     *
     * @param a First value of the operand.
     * @param b Second value of the operand.
     * @return The subtraction of this object and the values passed as a parameter.
     */
    public Int2 minus(int a, int b) {
        return this.plus(-a, -b);
    }

    @Override
    public Int2 negated() {
        return new Int2(-this.a, -this.b);
    }

    @Override
    public Int2 times(Integer k) {
        return new Int2(this.a * k, this.b * k);
    }

    /**
     * Returns the multiplication of this object and a constant. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code obj.times(k)} is intended to work the same as {@code obj * k}
     *
     * @param k The constant to which the object is multiplied.
     * @return The result of the multiplication of this object and the constant passed.
     */
    public Float2 times(Float k) {
        return new Float2(this.a * k, this.b * k);
    }

    @Override
    public Int2 dividedBy(Integer k) {
        return new Int2(this.a / k, this.b / k);
    }

    /**
     * Returns the division of this object and a constant. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code obj.dividedBy(k)} is intended to work the same as {@code obj / k}
     *
     * @param k The constant to which the object is divided.
     * @return The result of the division of this object and the constant passed.
     */
    public Float2 dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public Float2 reciprocal() {
        return new Float2(1.0f / this.a, 1.0f / this.b);
    }

    @Override
    public String toString() {
        return "(" + this.a + "; " + this.b + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Int2)
            return this.a == ((Int2) obj).a && this.b == ((Int2) obj).b;
        return false;
    }
}
