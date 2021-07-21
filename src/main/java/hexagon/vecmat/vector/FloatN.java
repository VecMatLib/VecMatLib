package hexagon.vecmat.vector;

import hexagon.vecmat.exceptions.UndefinedOperationException;
import hexagon.vecmat.exceptions.VectorSizeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** A class to represent a float vector in an N-dimensional vector space.
 * The size of the vector is specified by the number of elements passed in the constructor.
 *
 * @author Nico
 *
 * @see FloatVector
 * @see IntN
 */
public class FloatN implements FloatVector<FloatN, IntN> {
    
    private final List<Float> values;
    
    /** Creates a new vector with the given values
     * @param values Values in the vector
     * @throws VectorSizeException if the array of elements passed is empty
     */
    public FloatN(Float... values) {
        if(values.length == 0)
            throw new VectorSizeException("Vector cannot be empty");
        
        this.values = Arrays.asList(values);
    }
    
    /** {@inheritDoc}
     * @param operand Right-hand operand of the sum.
     * @return The sum of this vector and {@code operand}
     * @throws UndefinedOperationException if the two vectors have different sizes
     */
    @Override
    public FloatN plus(FloatN operand) {
        if(this.size() != operand.size())
            throw new UndefinedOperationException("Vectors can only be summed if they have the same size");
        
        return new FloatN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Float[]::new)
        );
    }
    
    /** {@inheritDoc}
     * @param operand Right-hand operand of the sum.
     * @return The sum of this vector and {@code operand}
     * @throws UndefinedOperationException if the two vectors have different sizes
     */
    @Override
    public FloatN plus(IntN operand) {
        if(this.size() != operand.size())
            throw new UndefinedOperationException("Vectors can only be summed if they have the same size");
    
        return new FloatN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public FloatN negated() {
        return new FloatN(
                this.values.stream()
                        .map(f -> -f)
                        .toArray(Float[]::new)
        );
    }
    
    /** {@inheritDoc}
     * @param operand Right-hand operand of the subtraction.
     * @return The difference of this vector and {@code operand}
     * @throws UndefinedOperationException if the two vectors have different sizes
     */
    @Override
    public FloatN minus(FloatN operand) {
        if(this.size() != operand.size())
            throw new UndefinedOperationException("Vectors can only be summed if they have the same size");
    
        return new FloatN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Float[]::new)
        );
    }
    
    /** {@inheritDoc}
     * @param operand Right-hand operand of the subtraction.
     * @return The difference of this vector and {@code operand}
     * @throws UndefinedOperationException if the two vectors have different sizes
     */
    @Override
    public FloatN minus(IntN operand) {
        if(this.size() != operand.size())
            throw new UndefinedOperationException("Vectors can only be summed if they have the same size");
    
        return new FloatN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public FloatN times(float constant) {
        return new FloatN(
                this.values.stream()
                        .map(f -> f * constant)
                        .toArray(Float[]::new)
        );
    }
    
    /** {@inheritDoc}
     * @param vector The right-hand side of the product
     * @return The result of the dot product
     * @throws UndefinedOperationException if the two vectors have different sizes
     */
    @Override
    public float dotProduct(FloatN vector) {
        if(this.size() != vector.size())
            throw new UndefinedOperationException("Dot product is only defined for vectors of the same size");
    
        return (float) IntStream.range(0, this.size())
                .mapToDouble(i -> this.element(i) * vector.element(i))
                .sum();
    }
    
    /** {@inheritDoc}
     * @param vector The right-hand side of the product
     * @return The result of the dot product
     * @throws UndefinedOperationException if the two vectors have different sizes
     */
    @Override
    public float dotProduct(IntN vector) {
        if(this.size() != vector.size())
            throw new UndefinedOperationException("Dot product is only defined for vectors of the same size");
    
        return (float) IntStream.range(0, this.size())
                .mapToDouble(i -> this.element(i) * vector.element(i))
                .sum();
    }
    
    @Override
    public float lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public IntN castToInt() {
        return new IntN(
                this.values.stream()
                        .mapToInt(Float::intValue)
                        .boxed()
                        .toArray(Integer[]::new)
        );
    }
    
    /** Get the size of this vector
     * @return The size of the vector
     */
    public int size() {
        return this.values.size();
    }
    
    /** Get an element in the vector
     * @param i Index of the element
     * @return The requested element
     */
    public float element(int i) {
        return this.values.get(i);
    }
    
    /** Get a stream of the values in the vector
     * @return The elements in the vector as a float stream
     */
    public Stream<Float> stream() {
        return this.values.stream();
    }
    
    @Override
    public boolean equals(FloatN value) {
        return this.values.equals(value.values);
    }
    
    @Override
    public boolean equals(IntN value) {
        return IntStream.range(0, this.size()).allMatch(i -> this.element(i) == value.element(i));
    }
    
    @Override
    public String toString() {
        return "FloatN" + this.values.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "(", ")"));
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof FloatN && ((FloatN) object).equals(this);
    }
}
