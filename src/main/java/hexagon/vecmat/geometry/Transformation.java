package hexagon.vecmat.geometry;

import hexagon.vecmat.matrix.Matrix4;
import hexagon.vecmat.vector.Float3;
import hexagon.vecmat.vector.Float4;

public class Transformation {
    
    /** Creates a translation matrix for the given translation. <p>
     * Multiplying this matrix by a vector {@code Float4(x, y, z, 1.0)}
     * will apply the translation to the point {@code (x, y, z)}.
     * @param vector A 3D vector containing the translation
     * @return A 4x4 translation matrix
     */
    public static Matrix4 translation(Float3 vector) {
        return Matrix4.fromRows(
                new Float4(1.0f, 0.0f, 0.0f, vector.x),
                new Float4(0.0f, 1.0f, 0.0f, vector.y),
                new Float4(0.0f, 0.0f, 1.0f, vector.z),
                new Float4(0.0f, 0.0f, 0.0f, 1.0f)
        );
    }
    
    /** Creates a rotation matrix that applies a rotation on the x axis. <p>
     * Multiplying this matrix by a vector {@code Float4(x, y, z, 1.0)}
     * will apply the rotation on the x axis to the point {@code (x, y, z)}.
     * @param angle Rotation angle on x axis (in radians)
     * @return A 4x4 rotation matrix
     */
    public static Matrix4 rotationX(float angle) {
        float sin = (float) Math.sin(-angle);
        float cos = (float) Math.cos(-angle);
        return Matrix4.fromRows(
                new Float4(1.0f, 0.0f, 0.0f, 0.0f),
                new Float4(0.0f, cos, -sin, 0.0f),
                new Float4(0.0f, sin, cos, 0.0f),
                new Float4(0.0f, 0.0f, 0.0f, 1.0f)
        );
    }
    
    /** Creates a rotation matrix that applies a rotation on the y axis. <p>
     * Multiplying this matrix by a vector {@code Float4(x, y, z, 1.0)}
     * will apply the rotation on the y axis to the point {@code (x, y, z)}.
     * @param angle Rotation angle on y axis (in radians)
     * @return A 4x4 rotation matrix
     */
    public static Matrix4 rotationY(float angle) {
        float sin = (float) Math.sin(-angle);
        float cos = (float) Math.cos(-angle);
        return Matrix4.fromRows(
                new Float4(cos, 0.0f, sin, 0.0f),
                new Float4(0.0f, 1.0f, 0.0f, 0.0f),
                new Float4(-sin, 0.0f, cos, 0.0f),
                new Float4(0.0f, 0.0f, 0.0f, 1.0f)
        );
    }
    
    /** Creates a rotation matrix that applies a rotation on the z axis. <p>
     * Multiplying this matrix by a vector {@code Float4(x, y, z, 1.0)}
     * will apply the rotation on the z axis to the point {@code (x, y, z)}.
     * @param angle Rotation angle on z axis (in radians)
     * @return A 4x4 rotation matrix
     */
    public static Matrix4 rotationZ(float angle) {
        float sin = (float) Math.sin(-angle);
        float cos = (float) Math.cos(-angle);
        return Matrix4.fromRows(
                new Float4(cos, -sin, 0.0f, 0.0f),
                new Float4(sin, cos, 0.0f, 0.0f),
                new Float4(0.0f, 0.0f, 1.0f, 0.0f),
                new Float4(0.0f, 0.0f, 0.0f, 1.0f)
        );
    }
    
    /** Creates a rotation matrix. <p>
     * Multiplying this matrix by a vector {@code Float4(x, y, z, 1.0)}
     * will apply the rotation to the point {@code (x, y, z)}.
     * @param rotation Vector representing rotation on x, y, z axis (in degrees)
     * @return A 4x4 rotation matrix
     */
    public static Matrix4 rotation(Float3 rotation) {
        Matrix4 x = rotationX((float) Math.toRadians(rotation.x));
        Matrix4 y = rotationY((float) Math.toRadians(rotation.y));
        Matrix4 z = rotationZ((float) Math.toRadians(rotation.z));
        return x.multiply(y).multiply(z);
    }
    
    /** Creates a scaling matrix. <p>
     * Multiplying this matrix by a vector {@code Float4(x, y, z, 1.0)}
     * will apply the scaling to the point {@code (x, y, z)}.
     * @param scale Vector representing scale on x, y, z axis
     * @return A 4x4 scaling matrix
     */
    public static Matrix4 scaling(Float3 scale) {
        return Matrix4.fromRows(
                new Float4(scale.x, 0.0f, 0.0f, 0.0f),
                new Float4(0.0f, scale.y, 0.0f, 0.0f),
                new Float4(0.0f, 0.0f, scale.z, 0.0f),
                new Float4(0.0f, 0.0f, 0.0f, 1.0f)
        );
    }
}
