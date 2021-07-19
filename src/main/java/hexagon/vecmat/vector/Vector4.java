package hexagon.vecmat.vector;

import hexagon.vecmat.Float4;

/**
 * A class that represents a four-dimensional vector,
 * a quadruplet of floats that represents a direction and a magnitude in a 4D space.
 */
public class Vector4 extends Float4 implements VectorOperations<Vector4> {

    /**
     * Initializes a vector
     *
     * @param x First component of the vector
     * @param y Second component of the vector
     * @param z Third component of the vector
     * @param w Fourth component of the vector
     */
    public Vector4(float x, float y, float z, float w) {
        super(x, y, z, w);
    }

    /**
     * Initializes a vector with value {@code {0.0; 0.0; 0.0; 0.0}}
     */
    public Vector4() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override
    public Vector4 plus(Float4 operand) {
        return this.plus(operand.x, operand.y, operand.z, operand.w);
    }

    @Override
    public Vector4 plus(float x, float y, float z, float w) {
        return new Vector4(this.x + x, this.y + y, this.z + z, this.w + w);
    }

    @Override
    public Vector4 minus(Float4 operand) {
        return this.minus(operand.x, operand.y, operand.z, operand.w);
    }

    @Override
    public Vector4 minus(float x, float y, float z, float w) {
        return new Vector4(this.x - x, this.y - y, this.z - z, this.w - w);
    }

    @Override
    public Vector4 times(Float k) {
        return new Vector4(this.x * k, this.y * k, this.z * k, this.w * k);
    }

    @Override
    public Vector4 dividedBy(Float k) {
        return new Vector4(this.x / k, this.y / k, this.z / k, this.w / k);
    }

    @Override
    public float dotProduct(Vector4 vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z + this.w * vector.w;
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
    public Vector4 normalized() {
        return this.dividedBy((float) this.length());
    }
}
