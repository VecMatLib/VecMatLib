package hexagon.vecmat.geometry;

import hexagon.vecmat.matrix.Matrix4;
import hexagon.vecmat.vector.Float3;
import hexagon.vecmat.vector.Float4;
import org.junit.Assert;
import org.junit.Test;

public class TestTransformation {
    
    @Test
    public void testTranslation() {
        Float4 position = new Float4(1.0f, 0.0f, -5.0f, 1.0f);
        Float3 translation = new Float3(2.0f, 2.0f, 0.0f);
        Float4 expected = new Float4(3.0f, 2.0f, -5.0f, 1.0f);
        Matrix4 matrix = Transformation.translation(translation);
        Assert.assertEquals(expected, matrix.multiply(position));
    }
    
    @Test
    public void testScale() {
        Float4 position = new Float4(1.0f, -1.0f, 1.0f, 1.0f);
        Float3 scale = new Float3(2.0f, 0.5f, 1.0f);
        Float4 expected = new Float4(2.0f, -0.5f, 1.0f, 1.0f);
        Matrix4 matrix = Transformation.scaling(scale);
        Assert.assertEquals(expected, matrix.multiply(position));
    }
}
