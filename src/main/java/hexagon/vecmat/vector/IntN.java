package hexagon.vecmat.vector;

import hexagon.vecmat.exceptions.UndefinedOperationException;
import hexagon.vecmat.exceptions.VectorSizeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/** A class to represent an integer vector in an N-dimensional vector space.
 * The size of the vector is specified by the number of elements passed in the constructor.
 *
 * @author Nico
 *
 * @see IntVector
 * @see FloatN
 */
public class IntN implements IntVector<IntN, FloatN> {
    
    private final List<Integer> values;
    
    /** Creates a new vector with the given values
     * @param values Values in the vector
     * @throws VectorSizeException if the array of elements passed is empty
     */
    public IntN(Integer... values) {
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
    public IntN plus(IntN operand) {
        if(this.size() != operand.size())
            throw new UndefinedOperationException("Vectors can only be summed if they have the same size");
    
        return new IntN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Integer[]::new)
        );
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
    
    @Override
    public IntN negated() {
        return new IntN(
                this.values.stream()
                        .map(i -> -i)
                        .toArray(Integer[]::new)
        );
    }
    
    /** {@inheritDoc}
     * @param operand Right-hand operand of the subtraction.
     * @return The difference of this vector and {@code operand}
     * @throws UndefinedOperationException if the two vectors have different sizes
     */
    @Override
    public IntN minus(IntN operand) {
        if(this.size() != operand.size())
            throw new UndefinedOperationException("Vectors can only be summed if they have the same size");
    
        return new IntN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Integer[]::new)
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
    
    @Override
    public IntN times(int constant) {
        return new IntN(
                this.values.stream()
                        .map(i -> i * constant)
                        .toArray(Integer[]::new)
        );
    }
    
    @Override
    public FloatN times(float constant) {
        return new FloatN(
                this.values.stream()
                        .map(i -> i * constant)
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public IntN dividedBy(int constant) {
        return new IntN(
                this.values.stream()
                        .map(i -> i / constant)
                        .toArray(Integer[]::new)
        );
    }
    
    /** {@inheritDoc}
     * @param vector The right-hand side of the product
     * @return The result of the dot product
     * @throws UndefinedOperationException if the two vectors have different sizes
     */
    @Override
    public int dotProduct(IntN vector) {
        if(this.size() != vector.size())
            throw new UndefinedOperationException("Dot product is only defined for vectors of the same size");
    
        return IntStream.range(0, this.size())
                .map(i -> this.element(i) * vector.element(i))
                .sum();
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
    
    @Override
    public int lengthSquared() {
        return this.dotProduct(this);
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
    public int element(int i) {
        return this.values.get(i);
    }
    
    /** Get a stream of the values in the vector
     * @return The elements in the vector as a float stream
     */
    public Stream<Integer> stream() {
        return this.values.stream();
    }
    
    @Override
    public boolean equals(IntN value) {
        return this.values.equals(value.values);
    }
    
    @Override
    public boolean equals(FloatN value) {
        return IntStream.range(0, this.size()).allMatch(i -> this.element(i) == value.element(i));
    }
    
    @Override
    public String toString() {
        return "IntN" + this.values.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "(", ")"));
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof IntN && ((IntN) object).equals(this);
    }
}
