package hexagon.vecmat.vector_old;

/**
 * This interface allows a vector object to implement vector operations:
 * <ul>
 *     <li>Dot product: {@link VectorOperations#dotProduct(V)}</li>
 *     <li>Magnitude: {@link VectorOperations#length()}</li>
 *     <li>Squared magnitude: {@link VectorOperations#lengthSquared()}</li>
 *     <li>Normalization: {@link VectorOperations#normalized()}</li>
 * </ul>
 * @param <V> The class that implements this interface.
 *           Needed to make methods accept the right parameter and return the right value.
 */
public interface VectorOperations<V> {

    /**
     * Computes the dot product between this vector and the vector passed as a parameter
     *
     * @param vector The other vector of the product
     * @return The dot product between this vector and the vector passed
     */
    float dotProduct(V vector);

    //cross product

    /**
     * Returns the length (or magnitude) of this vector
     *
     * @return The length of the vector
     */
    double length();

    /**
     * Returns the length (or magnitude) squared of this vector. <br>
     * Unlike {@link VectorOperations#length()} this does not use a square root.
     *
     * @return Length squared of the vector
     */
    float lengthSquared();

    /**
     * Returns a new vector that has the same direction as this one but length 1. <br>
     * This does not affect the vector on which it is called,
     * it returns a new vector instead.
     *
     * @return A normalized vector that has the same direction as this one
     */
    V normalized();
}
