package hexagon.vecmat;

/**
 * A class to represent an immutable triplet of integers
 */
public class Int3Old implements BaseOperations<Int3Old, Integer> {

    public final int a;
    public final int b;
    public final int c;

    /**
     * Initializes the triplet with three values
     *
     * @param a First value of the triplet
     * @param b Second value of the triplet
     * @param c Third value of the triplet
     */
    public Int3Old(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Initializes this triplet with value {@code (0; 0; 0)}
     */
    public Int3Old() {
        this(0, 0, 0);
    }

    @Override
    public Int3Old plus(Int3Old operand) {
        return this.plus(operand.a, operand.b, operand.c);
    }

    /**
     * Returns the sum of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code int3.plus(a, b, c)} is intended to work the same as {@code int3.plus(new Int3(a, b, c))}
     *
     * @param a First value of the operand.
     * @param b Second value of the operand.
     * @param c Third value of the operand.
     * @return The sum of this object and the values passed as a parameter.
     */
    public Int3Old plus(int a, int b, int c) {
        return new Int3Old(this.a + a, this.b + b, this.c + c);
    }

    /**
     * Returns the subtraction of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code int3.minus(a, b, c)} is intended to work the same as {@code int3.minus(new Int3(a, b, c))}
     *
     * @param a First value of the operand.
     * @param b Second value of the operand.
     * @param c Third value of the operand.
     * @return The subtraction of this object and the values passed as a parameter.
     */
    public Int3Old minus(int a, int b, int c) {
        return this.plus(-a, -b, -c);
    }

    @Override
    public Int3Old negated() {
        return new Int3Old(-this.a, -this.b, -this.c);
    }

    @Override
    public Int3Old times(Integer k) {
        return new Int3Old(this.a * k, this.b * k, this.c * k);
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
    public Float3Old times(Float k) {
        return new Float3Old(this.a * k, this.b * k, this.c * k);
    }

    @Override
    public Int3Old dividedBy(Integer k) {
        return new Int3Old(this.a / k, this.b / k, this.c / k);
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
    public Float3Old dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public Float3Old reciprocal() {
        return new Float3Old(1.0f / this.a, 1.0f / this.b, 1.0f / this.c);
    }

    @Override
    public String toString() {
        return "(" + this.a + "; " + this.b + "; " + this.c + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Int3Old)
            return this.a == ((Int3Old) obj).a && this.b == ((Int3Old) obj).b && this.c == ((Int3Old) obj).c;
        return false;
    }
}
