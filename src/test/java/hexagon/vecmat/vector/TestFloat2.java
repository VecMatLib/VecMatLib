package hexagon.vecmat.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestFloat2 {
    
    static Float2 vf1 = new Float2(1.2f, 3.4f);
    static Float2 vf2 = new Float2(2.5f, 2.1f);
    static Int2 vi1 = new Int2(4, 2);
    
    @Test
    public void testPlus() {
        Float2 sum = vf1.plus(vf2);
        Assert.assertEquals(3.7f, sum.x, 0.00001f);
        Assert.assertEquals(5.5f, sum.y, 0.00001f);
    }
    
    @Test
    public void testPlusInt() {
        Float2 sum = vf1.plus(vi1);
        Assert.assertEquals(5.2f, sum.x, 0.00001f);
        Assert.assertEquals(5.4f, sum.y, 0.00001f);
    }
    
    @Test
    public void testPlusValues() {
        Float2 sum = vf1.plus(2.5f, 2.1f);
        Assert.assertEquals(3.7f, sum.x, 0.00001f);
        Assert.assertEquals(5.5f, sum.y, 0.00001f);
    }
    
    @Test
    public void testNegated() {
        Float2 v = vf1.negated();
        Assert.assertEquals(-1.2f, v.x, 0.00001f);
        Assert.assertEquals(-3.4f, v.y, 0.00001f);
    }
    
    @Test
    public void testMinus() {
        Float2 diff = vf1.minus(vf2);
        Assert.assertEquals(-1.3f, diff.x, 0.00001f);
        Assert.assertEquals(1.3f, diff.y, 0.00001f);
    }
    
    @Test
    public void testMinusInt() {
        Float2 diff = vf1.minus(vi1);
        Assert.assertEquals(-2.8f, diff.x, 0.00001f);
        Assert.assertEquals(1.4f, diff.y, 0.00001f);
    }
    
    @Test
    public void testMinusValues() {
        Float2 diff = vf1.minus(2.5f, 2.1f);
        Assert.assertEquals(-1.3f, diff.x, 0.00001f);
        Assert.assertEquals(1.3f, diff.y, 0.00001f);
    }
    
    @Test
    public void testTimes() {
        Float2 prod = vf1.times(1.5f);
        Assert.assertEquals(1.8f, prod.x, 0.00001f);
        Assert.assertEquals(5.1f, prod.y, 0.00001f);
    }
    
    @Test
    public void testDividedBy() {
        Float2 div = vf1.dividedBy(2.0f);
        Assert.assertEquals(0.6f, div.x, 0.00001f);
        Assert.assertEquals(1.7f, div.y, 0.00001f);
    }
    
    @Test
    public void testDotProduct() {
        float expected = 1.2f * 2.5f + 3.4f * 2.1f;
        Assert.assertEquals(expected, vf1.dotProduct(vf2), 0.00001f);
    }
    
    @Test
    public void testDotProductInt() {
        float expected = 1.2f * 4 + 3.4f * 2;
        Assert.assertEquals(expected, vf1.dotProduct(vi1), 0.00001f);
    }
    
    @Test
    public void testLengthSquared() {
        float expected = 1.2f * 1.2f + 3.4f * 3.4f;
        Assert.assertEquals(expected, vf1.lengthSquared(), 0.00001f);
    }
    
    @Test
    public void testLength() {
        float expected = (float) Math.sqrt(1.2f * 1.2f + 3.4f * 3.4f);
        Assert.assertEquals(expected, vf1.length(), 0.00001f);
    }
    
    @Test
    public void testNormalized() {
        Assert.assertEquals(1.0f, vf1.normalized().lengthSquared(), 0.00001f);
    }
    
    @Test
    public void testCastToInt() {
        Int2 expected = new Int2(1, 3);
        Assert.assertEquals(expected, vf1.castToInt());
    }
    
    @Test
    public void testAngle() {
        Float2 f1 = new Float2(1.0f, 0.0f);
        Float2 f2 = new Float2(1.0f, -1.0f);
        Assert.assertEquals(Math.PI / 4, f1.angle(f2), 0.00001f);
    }
    
    @Test
    public void testAngleInt() {
        Float2 f1 = new Float2(1.0f, 0.0f);
        Int2 f2 = new Int2(1, -1);
        Assert.assertEquals(Math.PI / 4, f1.angle(f2), 0.00001f);
    }
    
    @Test
    public void testEquals() {
        Assert.assertTrue(vf1.equals(1.2f, 3.4f));
    }
}
