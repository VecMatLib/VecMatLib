package hexagon.vecmat;

/**
 * A class to represent an immutable quadruple of integers
 */
public class Int4Old implements BaseOperations<Int4Old, Integer> {

    public final int a;
    public final int b;
    public final int c;
    public final int d;

    /**
     * Initializes the quadruple with four values
     *
     * @param a First value of the quadruple
     * @param b Second value of the quadruple
     * @param c Third value of the quadruple
     * @param d Fourth value of the quadruple
     */
    public Int4Old(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    /**
     * Initializes this quadruple with value {@code (0; 0; 0; 0)}
     */
    public Int4Old() {
        this(0, 0, 0, 0);
    }

    @Override
    public Int4Old plus(Int4Old operand) {
        return this.plus(operand.a, operand.b, operand.c, operand.d);
    }

    /**
     * Returns the sum of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code int4.plus(a, b, c, d)} is intended to work the same as {@code int4.plus(new Int4(a, b, c, d))}
     *
     * @param a First value of the operand.
     * @param b Second value of the operand.
     * @param c Third value of the operand.
     * @param d Fourth value of the operand.
     * @return The sum of this object and the values passed as a parameter.
     */
    public Int4Old plus(int a, int b, int c, int d) {
        return new Int4Old(this.a + a, this.b + b, this.c + c, this.d + d);
    }

    /**
     * Returns the subtraction of this object and the values passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code int4.minus(a, b, c, d)} is intended to work the same as {@code int4.minus(new Int4(a, b, c, d))}
     *
     * @param a First value of the operand.
     * @param b Second value of the operand.
     * @param c Third value of the operand.
     * @param d Fourth value of the operand.
     * @return The subtraction of this object and the values passed as a parameter.
     */
    public Int4Old minus(int a, int b, int c, int d) {
        return this.plus(-a, -b, -c, -d);
    }

    @Override
    public Int4Old negated() {
        return new Int4Old(-this.a, -this.b, -this.c, -this.d);
    }

    @Override
    public Int4Old times(Integer k) {
        return new Int4Old(this.a * k, this.b * k, this.c * k, this.d * k);
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
    public Float4Old times(Float k) {
        return new Float4Old(this.a * k, this.b * k, this.c * k, this.d * k);
    }

    @Override
    public Int4Old dividedBy(Integer k) {
        return new Int4Old(this.a / k, this.b / k, this.c / k, this.d / k);
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
    public Float4Old dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public Float4Old reciprocal() {
        return new Float4Old(1.0f / this.a, 1.0f / this.b, 1.0f / this.c, 1.0f / this.d);
    }

    @Override
    public String toString() {
        return "(" + this.a + "; " + this.b + "; " + this.c + "; " + this.d + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Int4Old)
            return this.a == ((Int4Old) obj).a && this.b == ((Int4Old) obj).b && this.c == ((Int4Old) obj).c && this.d == ((Int4Old) obj).d;
        return false;
    }
}