package hexagon.vecmat.vector;

/** A vector is an element of a vector space.
 * Vectors of the same vector space may be summed, subtracted and scaled by a real number. <p>
 *
 * This interface provides methods for operations in common between vector spaces.
 * It is assumed that the implementing class uses integer numbers,
 * this helps defining some of the operations.
 *
 * @param <F> The vector class implementing this interface
 * @param <I> The corresponding float vector of the same vector space
 *
 * @author Nico
 *
 * @see FloatVector
 */
public interface IntVector<I extends IntVector<I, F>, F extends FloatVector<F, I>> {
    
    /** Computes the sum of this vector and the vector passed as a parameter. <p>
     * This method does not change the object on which it is called,
     * calling {@code vector = leftOperand.plus(rightOperand)} is intended to
     * work similarly as {@code vector = leftOperand + rightOperand}. <p>
     * The sum of two integer vectors is an integer vector.
     * @param operand Right-hand operand of the sum.
     * @return The sum of this vector and {@code operand}
     */
    I plus(I operand);
    
    /** Computes the sum of this vector and the vector passed as a parameter. <p>
     * This method does not change the object on which it is called,
     * calling {@code vector = leftOperand.plus(rightOperand)} is intended to
     * work similarly as {@code vector = leftOperand + rightOperand}. <p>
     * The sum of an integer vector and a float vector is a float vector.
     * @param operand Right-hand operand of the sum.
     * @return The sum of this vector and {@code operand}
     */
    F plus(F operand);
    
    /** Computes the additive inverse of this vector,
     * a vector {@code -v} such that {@code v + (-v) = v0}, where {@code v0} is the zero vector. <p>
     * This method does not change the object on which it is called.
     * @return The negative of this vector
     */
    I negated();
    
    /** Computes the subtraction of this vector and the vector passed as a parameter. <p>
     * This method does not change the object on which it is called,
     * calling {@code vector = leftOperand.minus(rightOperand)} is intended to
     * work similarly as {@code vector = leftOperand - rightOperand}. <p>
     * The difference of two integer vectors is an integer vector.
     * @param operand Right-hand operand of the subtraction.
     * @return The difference of this vector and {@code operand}
     */
    default I minus(I operand) {
        return this.plus(operand.negated());
    }
    
    /** Computes the subtraction of this vector and the vector passed as a parameter. <p>
     * This method does not change the object on which it is called,
     * calling {@code vector = leftOperand.minus(rightOperand)} is intended to
     * work similarly as {@code vector = leftOperand - rightOperand}. <p>
     * The difference an integer vector and a float vector is a float vector.
     * @param operand Right-hand operand of the subtraction.
     * @return The difference of this vector and {@code operand}
     */
    default F minus(F operand) {
        return this.plus(operand.negated());
    }
    
    /** Computes the multiplication of this vector by an integer number. <p>
     * This method does not change the object on which it is called,
     * calling {@code vector = vector.times(k)} is intended to
     * work similarly as {@code vector = vector * k}. <p>
     * Multiplying an integer vector by an int gives an integer vector.
     * @param constant The real number in the multiplication
     * @return The product of this vector by the given constant
     */
    I times(int constant);
    
    /** Computes the multiplication of this vector by a real number. <p>
     * This method does not change the object on which it is called,
     * calling {@code vector = vector.times(k)} is intended to
     * work similarly as {@code vector = vector * k}. <p>
     * Multiplying an integer vector by a float gives a float vector.
     * @param constant The real number in the multiplication
     * @return The product of this vector by the given constant
     */
    F times(float constant);
    
    /** Computes the division of this vector by an integer number. <p>
     * This method does not change the object on which it is called,
     * calling {@code vector = vector.dividedBy(k)} is intended to
     * work similarly as {@code vector = vector / k}. <p>
     * Dividing an integer vector by an int performs an integer division.
     * @param constant The real number in the division
     * @return The division between this vector by the given constant
     */
    I dividedBy(int constant);
    
    /** Computes the division of this vector by a real number. <p>
     * This method does not change the object on which it is called,
     * calling {@code vector = vector.dividedBy(k)} is intended to
     * work similarly as {@code vector = vector / k}. <p>
     * Dividing an integer vector by a float gives a float vector.
     * @param constant The real number in the division
     * @return The division between this vector by the given constant
     */
    default F dividedBy(float constant) {
        return this.times(1.0f / constant);
    }
    
    /** Computes the dot product between this vector and the one passed as a parameter. <p>
     * The dot product of two vectors is a scalar and it is the summations of the products
     * of all the elements of the two vectors.
     * @param vector The right-hand side of the product
     * @return The result of the dot product
     */
    int dotProduct(I vector);
    
    /** Computes the dot product between this vector and the one passed as a parameter. <p>
     * The dot product of two vectors is a scalar and it is the summations of the products
     * of all the elements of the two vectors.
     * @param vector The right-hand side of the product
     * @return The result of the dot product
     */
    float dotProduct(F vector);
    
    /** Computes the length (or magnitude) of this vector. <p>
     * The length of a vector is defined as the square of the dot product of the vector by itself.
     * @return The length (or magnitude) of this vector.
     */
    default float length() {
        return (float) Math.sqrt(this.lengthSquared());
    }
    
    /** Computes the squared length (or magnitude) of this vector. <p>
     * This is more efficient than {@link IntVector#length()}, since it does not compute a square root.
     * @return The length (or magnitude) of this vector.
     */
    int lengthSquared();
    
    /** Normalizes this vector. A normalized vector as the same direction but a magnitude of 1. <p>
     * The normalized vector is computed by dividing it by its magnitude. <p>
     * This method does not affect the object on which it is called, it returns a new one instead.
     * @return A new FloatVector that has the same direction as the previous one but a magnitude of 1
     */
    default F normalized() {
        return this.dividedBy(this.length());
    }
    
    /** Computes the angle between this vector and the one passed as a parameter. <p>
     * The angle between two vectors is computed as the arc cosine of the dot product
     * of the two vectors divided by the product of their lengths.
     * @param vector The second vector
     * @return The angle in radians between the two vectors
     */
    default float angle(I vector) {
        return (float) Math.acos(this.dotProduct(vector) / (this.length() * vector.length()));
    }
    
    /** Computes the angle between this vector and the one passed as a parameter. <p>
     * The angle between two vectors is computed as the arc cosine of the dot product
     * of the two vectors divided by the product of their lengths.
     * @param vector The second vector
     * @return The angle in radians between the two vectors
     */
    default float angle(F vector) {
        return (float) Math.acos(this.dotProduct(vector) / (this.length() * vector.length()));
    }
    
    /** Checks if this vector is equal to the given one
     * @param value The vector to check
     * @return True if the two vectors have the same value, otherwise false
     */
    boolean equals(I value);
    
    /** Checks if this vector is equal to the given one
     * @param value The vector to check
     * @return True if the two vectors have the same value, otherwise false
     */
    boolean equals(F value);
}
