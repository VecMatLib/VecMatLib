package hexagon.vecmat.geometry;

import hexagon.vecmat.matrix.Matrix4;
import hexagon.vecmat.vector.Float3;
import hexagon.vecmat.vector.Float4;

public class Transformation {
    
    public static Matrix4 transformationMatrix(Float3 translation, Float3 rotation, Float3 scale) {
        Matrix4 translationMatrix = translation(translation);
        Matrix4 rotationMatrix = rotation(rotation);
        Matrix4 scalingMatrix = scaling(scale);
        return translationMatrix.multiply(rotationMatrix).multiply(scalingMatrix);
    }
    
    public static Matrix4 translation(Float3 vector) {
        return Matrix4.fromRows(
                new Float4(1.0f, 0.0f, 0.0f, vector.x),
                new Float4(0.0f, 1.0f, 0.0f, vector.y),
                new Float4(0.0f, 0.0f, 1.0f, vector.z),
                new Float4(0.0f, 0.0f, 0.0f, 1.0f)
        );
    }
    
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
    
    public static Matrix4 rotation(Float3 rotation) {
        Matrix4 x = rotationX((float) Math.toRadians(rotation.x));
        Matrix4 y = rotationY((float) Math.toRadians(rotation.y));
        Matrix4 z = rotationZ((float) Math.toRadians(rotation.z));
        return x.multiply(y).multiply(z);
    }
    
    public static Matrix4 scaling(Float3 scale) {
        return Matrix4.fromRows(
                new Float4(scale.x, 0.0f, 0.0f, 0.0f),
                new Float4(0.0f, scale.y, 0.0f, 0.0f),
                new Float4(0.0f, 0.0f, scale.z, 0.0f),
                new Float4(0.0f, 0.0f, 0.0f, 1.0f)
        );
    }
}
