package hexagon.vecmat.vector;

import hexagon.vecmat.Float2;

/**
 * A class that represents a two-dimensional vector,
 * a pair of floats that represents a direction and a magnitude in a 2D space.
 */
public class Vector2 extends Float2 implements VectorOperations<Vector2> {

    /**
     * Initializes a vector
     *
     * @param x First component of the vector
     * @param y Second component of the vector
     */
    public Vector2(float x, float y) {
        super(x, y);
    }

    /**
     * Initializes a vector with value {@code {0.0; 0.0}}
     */
    public Vector2() {
        this(0.0f, 0.0f);
    }

    @Override
    public Vector2 plus(Float2 operand) {
        return this.plus(operand.x, operand.y);
    }

    @Override
    public Vector2 plus(float x, float y) {
        return new Vector2(this.x + x, this.y + y);
    }

    @Override
    public Vector2 minus(Float2 operand) {
        return this.minus(operand.x, operand.y);
    }

    @Override
    public Vector2 minus(float x, float y) {
        return new Vector2(this.x - x, this.y - y);
    }

    @Override
    public Vector2 times(Float k) {
        return new Vector2(this.x * k, this.y * k);
    }

    @Override
    public Vector2 dividedBy(Float k) {
        return new Vector2(this.x / k, this.y / k);
    }

    @Override
    public float dotProduct(Vector2 vector) {
        return this.x * vector.x + this.y * vector.y;
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
    public Vector2 normalized() {
        return this.dividedBy((float) this.length());
    }
}
