package hexagon.vecmat.vector_old;

import hexagon.vecmat.exceptions.UndefinedOperationException;
import hexagon.vecmat.tuple.FloatTuple;

import java.util.stream.IntStream;

public class VectorOld extends FloatTuple implements VectorOperations<VectorOld> {

    /**
     * Initializes a vector with the given values
     *
     * @param values Elements of the vector
     */
    public VectorOld(Float... values) {
        super(values);
    }

    @Override
    public VectorOld plus(FloatTuple operand) {
        if(this.dimensions() != operand.dimensions())
            throw new UndefinedOperationException("Vector sum", "vectors of different dimensions");

        return new VectorOld(
                IntStream.range(0, this.dimensions())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public VectorOld minus(FloatTuple operand) {
        if(this.dimensions() != operand.dimensions())
            throw new UndefinedOperationException("Vector subtraction", "vectors of different dimensions");

        return new VectorOld(
                IntStream.range(0, this.dimensions())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public VectorOld negated() {
        return new VectorOld(
                this.tuple.stream()
                        .map(f -> -f)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public VectorOld times(Float k) {
        return new VectorOld(
                this.tuple.stream()
                        .map(f -> f * k)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public VectorOld dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public VectorOld reciprocal() {
        return new VectorOld(
                this.tuple.stream()
                        .map(i -> 1.0f / i)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public float dotProduct(VectorOld vector) {
        if(this.dimensions() != vector.dimensions())
            throw new UndefinedOperationException("Dot product", "vectors of different dimensions");

        return (float) IntStream.range(0, this.dimensions())
                .mapToDouble(i -> this.element(i) * vector.element(i))
                .sum();
    }

    @Override
    public double length() {
        return Math.sqrt(this.lengthSquared());
    }

    @Override
    public float lengthSquared() {
        return this.dotProduct(this);
    }

    @Override
    public VectorOld normalized() {
        return this.dividedBy((float) this.length());
    }
}
