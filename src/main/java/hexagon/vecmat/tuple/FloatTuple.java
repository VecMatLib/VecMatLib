package hexagon.vecmat.tuple;

import hexagon.vecmat.exceptions.UndefinedOperationException;

import java.util.stream.IntStream;

/**
 * A class that represents an immutable n-tuple of floats
 */
public class FloatTuple extends NTuple<FloatTuple, Float> {

    /**
     * Initializes a tuple with the given values
     *
     * @param values Elements of the tuple
     */
    public FloatTuple(Float... values) {
        super(values);
    }

    @Override
    public FloatTuple plus(FloatTuple operand) {
        if(this.dimensions() != operand.dimensions())
            throw new UndefinedOperationException("Sum of tuples", "tuples of different size");

        return new FloatTuple(
                IntStream.range(0, this.dimensions())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public FloatTuple plus(Float n) {
        return new FloatTuple(
                IntStream.range(0, this.dimensions())
                        .mapToObj(i -> this.element(i) + n)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public FloatTuple minus(FloatTuple operand) {
        if(this.dimensions() != operand.dimensions())
            throw new UndefinedOperationException("Subtraction of tuples", "tuples of different size");

        return new FloatTuple(
                IntStream.range(0, this.dimensions())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public FloatTuple minus(Float n) {
        return this.plus(-n);
    }

    @Override
    public FloatTuple negated() {
        return new FloatTuple(
                this.tuple.stream()
                        .map(f -> -f)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public FloatTuple times(Float k) {
        return new FloatTuple(
                this.tuple.stream()
                        .map(f -> f * k)
                        .toArray(Float[]::new)
        );
    }

    @Override
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
        if(obj instanceof FloatTuple && this.dimensions() == ((FloatTuple) obj).dimensions()) {
            for(int i = 0; i < this.dimensions(); i++) {
                if(this.tuple.get(i).floatValue() != ((FloatTuple) obj).tuple.get(i).floatValue())
                    return false;
            }
            return true;
        }
        return false;
    }
}
