package hexagon.vecmat;

/**
 * This interface allows an object to implement the 4 basic arithmetic operations:
 * <ul>
 *     <li>Addition: {@link BaseOperations#plus(T)}</li>
 *     <li>Subtraction: {@link BaseOperations#minus(T)}</li>
 *     <li>Multiplication by a constant: {@link BaseOperations#times(N)}</li>
 *     <li>Division by a constant: {@link BaseOperations#dividedBy(N)}</li>
 * </ul>
 * @param <T> The class that implements this interface.
 *           Needed to make methods accept the right parameter and return the right value.
 * @param <N> Type of the constant used in multiplication and division.
 */
public interface BaseOperations<T extends BaseOperations<T, N>, N extends Number> {

    /**
     * Returns the sum of this object and the operand passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code obj1.plus(obj2)} is intended to work the same as {@code obj1 + obj2}
     *
     * @param operand The second operand of the sum.
     * @return The sum of this object and the operand passed as a parameter.
     */
    T plus(T operand);

    /**
     * Returns the subtraction of this object and the operand passed. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code obj1.minus(obj2)} is intended to work the same as {@code obj1 - obj2}
     *
     * @param operand The second operand of the subtraction.
     * @return The subtraction of this object and the operand passed as a parameter.
     */
    default T minus(T operand) {
        return this.plus(operand.negated());
    }

    /**
     * Returns the additive inverse of this object:
     * the object that when added to this one yields zero
     * @return The additive inverse of this object
     */
    T negated();

    /**
     * Returns the multiplication of this object and a constant. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code obj.times(k)} is intended to work the same as {@code obj * k}
     *
     * @param constant The constant to which the object is multiplied.
     * @return The result of the multiplication of this object and the constant passed.
     */
    T times(N constant);

    /**
     * Returns the division of this object and a constant. <br>
     * This does not affect the object on which it is called,
     * it returns a new object instead. <br>
     * Calling {@code obj.dividedBy(k)} is intended to work the same as {@code obj / k}
     *
     * @param constant The constant to which the object is divided.
     * @return The result of the division of this object and the constant passed.
     */
    T dividedBy(N constant);

    /**
     * Returns the multiplicative inverse of this object:
     * the object that when multiplied to this one yields one
     * @return The multiplicative inverse, or reciprocal, of this object
     */
    BaseOperations<?, ?> reciprocal();
}
