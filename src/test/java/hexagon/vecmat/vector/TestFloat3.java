package hexagon.vecmat.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestFloat3 {
    
    static Float3 vf1 = new Float3(1.2f, 3.4f, 5.6f);
    static Float3 vf2 = new Float3(2.5f, 2.1f, -1.4f);
    static Int3 vi1 = new Int3(4, 2, 3);
    
    @Test
    public void testPlus() {
        Float3 sum = vf1.plus(vf2);
        Assert.assertEquals(3.7f, sum.x, 0.00001f);
        Assert.assertEquals(5.5f, sum.y, 0.00001f);
        Assert.assertEquals(4.2f, sum.z, 0.00001f);
    }
    
    @Test
    public void testPlusInt() {
        Float3 sum = vf1.plus(vi1);
        Assert.assertEquals(5.2f, sum.x, 0.00001f);
        Assert.assertEquals(5.4f, sum.y, 0.00001f);
        Assert.assertEquals(8.6f, sum.z, 0.00001f);
    }
    
    @Test
    public void testPlusValues() {
        Float3 sum = vf1.plus(2.5f, 2.1f, -1.4f);
        Assert.assertEquals(3.7f, sum.x, 0.00001f);
        Assert.assertEquals(5.5f, sum.y, 0.00001f);
        Assert.assertEquals(4.2f, sum.z, 0.00001f);
    }
    
    @Test
    public void testNegated() {
        Float3 v = vf1.negated();
        Assert.assertEquals(-1.2f, v.x, 0.00001f);
        Assert.assertEquals(-3.4f, v.y, 0.00001f);
        Assert.assertEquals(-5.6f, v.z, 0.00001f);
    }
    
    @Test
    public void testMinus() {
        Float3 diff = vf1.minus(vf2);
        Assert.assertEquals(-1.3f, diff.x, 0.00001f);
        Assert.assertEquals(1.3f, diff.y, 0.00001f);
        Assert.assertEquals(7.0f, diff.z, 0.00001f);
    }
    
    @Test
    public void testMinusInt() {
        Float3 diff = vf1.minus(vi1);
        Assert.assertEquals(-2.8f, diff.x, 0.00001f);
        Assert.assertEquals(1.4f, diff.y, 0.00001f);
        Assert.assertEquals(2.6f, diff.z, 0.00001f);
    }
    
    @Test
    public void testMinusValues() {
        Float3 diff = vf1.minus(2.5f, 2.1f, -1.4f);
        Assert.assertEquals(-1.3f, diff.x, 0.00001f);
        Assert.assertEquals(1.3f, diff.y, 0.00001f);
        Assert.assertEquals(7.0f, diff.z, 0.00001f);
    }
    
    @Test
    public void testTimes() {
        Float3 prod = vf1.times(1.5f);
        Assert.assertEquals(1.8f, prod.x, 0.00001f);
        Assert.assertEquals(5.1f, prod.y, 0.00001f);
        Assert.assertEquals(8.4f, prod.z, 0.00001f);
    }
    
    @Test
    public void testDividedBy() {
        Float3 div = vf1.dividedBy(2.0f);
        Assert.assertEquals(0.6f, div.x, 0.00001f);
        Assert.assertEquals(1.7f, div.y, 0.00001f);
        Assert.assertEquals(2.8f, div.z, 0.00001f);
    }
    
    @Test
    public void testDotProduct() {
        float expected = 1.2f * 2.5f + 3.4f * 2.1f + 5.6f * -1.4f;
        Assert.assertEquals(expected, vf1.dotProduct(vf2), 0.00001f);
    }
    
    @Test
    public void testDotProductInt() {
        float expected = 1.2f * 4 + 3.4f * 2 + 5.6f * 3;
        Assert.assertEquals(expected, vf1.dotProduct(vi1), 0.00001f);
    }
    
    @Test
    public void testCrossProduct() {
        Float3 f1 = new Float3(1.0f, 0.0f, 0.0f);
        Float3 f2 = new Float3(0.0f, 0.0f, 1.0f);
        Float3 cross = new Float3(0.0f, -1.0f, 0.0f);
        Assert.assertEquals(cross, f1.crossProduct(f2));
    }
    
    @Test
    public void testCrossProductInt() {
        Float3 f1 = new Float3(1.0f, 0.0f, 0.0f);
        Int3 f2 = new Int3(0, 0, 1);
        Float3 cross = new Float3(0.0f, -1.0f, 0.0f);
        Assert.assertEquals(cross, f1.crossProduct(f2));
    }
    
    @Test
    public void testLengthSquared() {
        float expected = 1.2f * 1.2f + 3.4f * 3.4f + 5.6f * 5.6f;
        Assert.assertEquals(expected, vf1.lengthSquared(), 0.00001f);
    }
    
    @Test
    public void testLength() {
        float expected = (float) Math.sqrt(1.2f * 1.2f + 3.4f * 3.4f + 5.6f * 5.6f);
        Assert.assertEquals(expected, vf1.length(), 0.00001f);
    }
    
    @Test
    public void testNormalized() {
        Assert.assertEquals(1.0f, vf1.normalized().lengthSquared(), 0.00001f);
    }
    
    @Test
    public void testCastToInt() {
        Int3 expected = new Int3(1, 3, 5);
        Assert.assertEquals(expected, vf1.castToInt());
    }
    
    @Test
    public void testAngle() {
        Float3 f1 = new Float3(1.0f, 0.0f, 0.0f);
        Float3 f2 = new Float3(0.0f, 0.0f, 1.0f);
        Assert.assertEquals(Math.PI / 2, f1.angle(f2), 0.00001f);
    }
    
    @Test
    public void testAngleInt() {
        Float3 f1 = new Float3(1.0f, 0.0f, 0.0f);
        Int3 f2 = new Int3(0, 0, 1);
        Assert.assertEquals(Math.PI / 2, f1.angle(f2), 0.00001f);
    }
    
    @Test
    public void testEquals() {
        Assert.assertTrue(vf1.equals(1.2f, 3.4f, 5.6f));
    }
}
