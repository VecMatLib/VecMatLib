package hexagon.vecmat.tuple;

import hexagon.vecmat.exceptions.UndefinedOperationException;

import java.util.stream.IntStream;

/**
 * A class that represents an immutable n-tuple of integers
 */
public class IntTuple extends NTuple<IntTuple, Integer> {

    /**
     * Initializes a tuple with the given values
     *
     * @param values Elements of the tuple
     */
    public IntTuple(Integer... values) {
        super(values);
    }

    @Override
    public IntTuple plus(IntTuple operand) {
        if(this.dimensions() != operand.dimensions())
            throw new UndefinedOperationException("Sum of tuples", "tuples of different size");

        return new IntTuple(
                IntStream.range(0, this.dimensions())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Integer[]::new)
        );
    }

    @Override
    public IntTuple plus(Integer n) {
        return new IntTuple(
                IntStream.range(0, this.dimensions())
                        .mapToObj(i -> this.element(i) + n)
                        .toArray(Integer[]::new)
        );
    }

    @Override
    public IntTuple minus(IntTuple operand) {
        if(this.dimensions() != operand.dimensions())
            throw new UndefinedOperationException("Subtraction of tuples", "tuples of different size");

        return new IntTuple(
                IntStream.range(0, this.dimensions())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Integer[]::new)
        );
    }

    @Override
    public IntTuple minus(Integer n) {
        return this.plus(-n);
    }

    @Override
    public IntTuple negated() {
        return new IntTuple(
                this.tuple.stream()
                        .map(i -> -i)
                        .toArray(Integer[]::new)
        );
    }

    @Override
    public IntTuple times(Integer k) {
        return new IntTuple(
                this.tuple.stream()
                        .map(i -> i * k)
                        .toArray(Integer[]::new)
        );
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
    public FloatTuple times(Float k) {
        return new FloatTuple(
                this.tuple.stream()
                        .map(i -> i * k)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public IntTuple dividedBy(Integer k) {
        return new IntTuple(
                this.tuple.stream()
                        .map(i -> i / k)
                        .toArray(Integer[]::new)
        );
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
    public FloatTuple dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public FloatTuple reciprocal() {
        return new FloatTuple(
                this.tuple.stream()
                        .map(i -> 1.0f / i)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IntTuple && this.dimensions() == ((IntTuple) obj).dimensions()) {
            for(int i = 0; i < this.dimensions(); i++) {
                if(this.tuple.get(i).intValue() != ((IntTuple) obj).tuple.get(i).intValue())
                    return false;
            }
            return true;
        }
        return false;
    }
}
