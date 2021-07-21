package hexagon.vecmat.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestFloat4 {
    
    static Float4 vf1 = new Float4(1.2f, 3.4f, 5.6f, 7.8f);
    static Float4 vf2 = new Float4(2.5f, 2.1f, -1.4f, 0.9f);
    static Int4 vi1 = new Int4(4, 2, 3, 1);
    
    @Test
    public void testPlus() {
        Float4 sum = vf1.plus(vf2);
        Assert.assertEquals(3.7f, sum.x, 0.00001f);
        Assert.assertEquals(5.5f, sum.y, 0.00001f);
        Assert.assertEquals(4.2f, sum.z, 0.00001f);
        Assert.assertEquals(8.7f, sum.w, 0.00001f);
    }
    
    @Test
    public void testPlusInt() {
        Float4 sum = vf1.plus(vi1);
        Assert.assertEquals(5.2f, sum.x, 0.00001f);
        Assert.assertEquals(5.4f, sum.y, 0.00001f);
        Assert.assertEquals(8.6f, sum.z, 0.00001f);
        Assert.assertEquals(8.8f, sum.w, 0.00001f);
    }
    
    @Test
    public void testPlusValues() {
        Float4 sum = vf1.plus(2.5f, 2.1f, -1.4f, 0.9f);
        Assert.assertEquals(3.7f, sum.x, 0.00001f);
        Assert.assertEquals(5.5f, sum.y, 0.00001f);
        Assert.assertEquals(4.2f, sum.z, 0.00001f);
        Assert.assertEquals(8.7f, sum.w, 0.00001f);
    }
    
    @Test
    public void testNegated() {
        Float4 v = vf1.negated();
        Assert.assertEquals(-1.2f, v.x, 0.00001f);
        Assert.assertEquals(-3.4f, v.y, 0.00001f);
        Assert.assertEquals(-5.6f, v.z, 0.00001f);
        Assert.assertEquals(-7.8f, v.w, 0.00001f);
    }
    
    @Test
    public void testMinus() {
        Float4 diff = vf1.minus(vf2);
        Assert.assertEquals(-1.3f, diff.x, 0.00001f);
        Assert.assertEquals(1.3f, diff.y, 0.00001f);
        Assert.assertEquals(7.0f, diff.z, 0.00001f);
        Assert.assertEquals(6.9f, diff.w, 0.00001f);
    }
    
    @Test
    public void testMinusInt() {
        Float4 diff = vf1.minus(vi1);
        Assert.assertEquals(-2.8f, diff.x, 0.00001f);
        Assert.assertEquals(1.4f, diff.y, 0.00001f);
        Assert.assertEquals(2.6f, diff.z, 0.00001f);
        Assert.assertEquals(6.8f, diff.w, 0.00001f);
    }
    
    @Test
    public void testMinusValues() {
        Float4 diff = vf1.minus(2.5f, 2.1f, -1.4f, 0.9f);
        Assert.assertEquals(-1.3f, diff.x, 0.00001f);
        Assert.assertEquals(1.3f, diff.y, 0.00001f);
        Assert.assertEquals(7.0f, diff.z, 0.00001f);
        Assert.assertEquals(6.9f, diff.w, 0.00001f);
    }
    
    @Test
    public void testTimes() {
        Float4 prod = vf1.times(1.5f);
        Assert.assertEquals(1.8f, prod.x, 0.00001f);
        Assert.assertEquals(5.1f, prod.y, 0.00001f);
        Assert.assertEquals(8.4f, prod.z, 0.00001f);
        Assert.assertEquals(11.7f, prod.w, 0.00001f);
    }
    
    @Test
    public void testDividedBy() {
        Float4 div = vf1.dividedBy(2.0f);
        Assert.assertEquals(0.6f, div.x, 0.00001f);
        Assert.assertEquals(1.7f, div.y, 0.00001f);
        Assert.assertEquals(2.8f, div.z, 0.00001f);
        Assert.assertEquals(3.9f, div.w, 0.00001f);
    }
    
    @Test
    public void testDotProduct() {
        float expected = 1.2f * 2.5f + 3.4f * 2.1f + 5.6f * -1.4f + 7.8f * 0.9f;
        Assert.assertEquals(expected, vf1.dotProduct(vf2), 0.00001f);
    }
    
    @Test
    public void testDotProductInt() {
        float expected = 1.2f * 4 + 3.4f * 2 + 5.6f * 3 + 7.8f * 1;
        Assert.assertEquals(expected, vf1.dotProduct(vi1), 0.00001f);
    }
    
    @Test
    public void testLengthSquared() {
        float expected = 1.2f * 1.2f + 3.4f * 3.4f + 5.6f * 5.6f + 7.8f * 7.8f;
        Assert.assertEquals(expected, vf1.lengthSquared(), 0.00001f);
    }
    
    @Test
    public void testLength() {
        float expected = (float) Math.sqrt(1.2f * 1.2f + 3.4f * 3.4f + 5.6f * 5.6f + 7.8f * 7.8f);
        Assert.assertEquals(expected, vf1.length(), 0.00001f);
    }
    
    @Test
    public void testNormalized() {
        Assert.assertEquals(1.0f, vf1.normalized().lengthSquared(), 0.00001f);
    }
    
    @Test
    public void testCastToInt() {
        Int4 expected = new Int4(1, 3, 5, 7);
        Assert.assertEquals(expected, vf1.castToInt());
    }
    
    @Test
    public void testEquals() {
        Assert.assertTrue(vf1.equals(1.2f, 3.4f, 5.6f, 7.8f));
    }
}
