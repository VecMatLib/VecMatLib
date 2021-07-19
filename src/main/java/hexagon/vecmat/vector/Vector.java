package hexagon.vecmat.vector;

import hexagon.vecmat.exceptions.UndefinedOperationException;
import hexagon.vecmat.tuple.FloatTuple;

import java.util.stream.IntStream;

public class Vector extends FloatTuple implements VectorOperations<Vector> {

    /**
     * Initializes a vector with the given values
     *
     * @param values Elements of the vector
     */
    public Vector(Float... values) {
        super(values);
    }

    @Override
    public Vector plus(FloatTuple operand) {
        if(this.dimensions() != operand.dimensions())
            throw new UndefinedOperationException("Vector sum", "vectors of different dimensions");

        return new Vector(
                IntStream.range(0, this.dimensions())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Vector minus(FloatTuple operand) {
        if(this.dimensions() != operand.dimensions())
            throw new UndefinedOperationException("Vector subtraction", "vectors of different dimensions");

        return new Vector(
                IntStream.range(0, this.dimensions())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Vector negated() {
        return new Vector(
                this.tuple.stream()
                        .map(f -> -f)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Vector times(Float k) {
        return new Vector(
                this.tuple.stream()
                        .map(f -> f * k)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public Vector dividedBy(Float k) {
        return this.times(1.0f / k);
    }

    @Override
    public Vector reciprocal() {
        return new Vector(
                this.tuple.stream()
                        .map(i -> 1.0f / i)
                        .toArray(Float[]::new)
        );
    }

    @Override
    public float dotProduct(Vector vector) {
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
    public Vector normalized() {
        return this.dividedBy((float) this.length());
    }
}
