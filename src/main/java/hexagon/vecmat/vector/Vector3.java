package hexagon.vecmat.vector;

import hexagon.vecmat.Float3;

/**
 * A class that represents a three-dimensional vector,
 * a triplet of floats that represents a direction and a magnitude in a 3D space.
 */
public class Vector3 extends Float3 implements VectorOperations<Vector3> {

    /**
     * Initializes a vector
     *
     * @param x First component of the vector
     * @param y Second component of the vector
     * @param z Third component of the vector
     */
    public Vector3(float x, float y, float z) {
        super(x, y, z);
    }

    /**
     * Initializes a vector with value {@code {0.0; 0.0; 0.0}}
     */
    public Vector3() {
        this(0.0f, 0.0f, 0.0f);
    }

    @Override
    public Vector3 plus(Float3 operand) {
        return this.plus(operand.x, operand.y, operand.z);
    }

    @Override
    public Vector3 plus(float x, float y, float z) {
        return new Vector3(this.x + x, this.y + y, this.z + z);
    }

    @Override
    public Vector3 minus(Float3 operand) {
        return this.minus(operand.x, operand.y, operand.z);
    }

    @Override
    public Vector3 minus(float x, float y, float z) {
        return new Vector3(this.x - x, this.y - y, this.z - z);
    }

    @Override
    public Vector3 times(Float k) {
        return new Vector3(this.x * k, this.y * k, this.z * k);
    }

    @Override
    public Vector3 dividedBy(Float k) {
        return new Vector3(this.x / k, this.y / k, this.z / k);
    }

    @Override
    public float dotProduct(Vector3 vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
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
    public Vector3 normalized() {
        return this.dividedBy((float) this.length());
    }
}
