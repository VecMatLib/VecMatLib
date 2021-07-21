package hexagon.vecmat.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestInt2 {
    
    static Int2 vi1 = new Int2(1, 3);
    static Int2 vi2 = new Int2(2, 4);
    static Float2 vf1 = new Float2(1.2f, 3.4f);
    
    @Test
    public void testPlus() {
        Int2 expected = new Int2(3, 7);
        Assert.assertEquals(expected, vi1.plus(vi2));
    }
    
    @Test
    public void testPlusFloat() {
        Float2 sum = vi1.plus(vf1);
        Assert.assertEquals(2.2f, sum.x, 0.00001f);
        Assert.assertEquals(6.4f, sum.y, 0.00001f);
    }
    
    @Test
    public void testPlusValues() {
        Int2 expected = new Int2(3, 7);
        Assert.assertEquals(expected, vi1.plus(2, 4));
    }
    
    @Test
    public void testPlusValuesFloat() {
        Float2 sum = vi1.plus(1.2f, 3.4f);
        Assert.assertEquals(2.2f, sum.x, 0.00001f);
        Assert.assertEquals(6.4f, sum.y, 0.00001f);
    }
    
    @Test
    public void testNegated() {
        Int2 expected = new Int2(-1, -3);
        Assert.assertEquals(expected, vi1.negated());
    }
    
    @Test
    public void testMinus() {
        Int2 expected = new Int2(1, 1);
        Assert.assertEquals(expected, vi2.minus(vi1));
    }
    
    @Test
    public void testMinusFloat() {
        Float2 diff = vi2.minus(vf1);
        Assert.assertEquals(0.8f, diff.x, 0.00001f);
        Assert.assertEquals(0.6f, diff.y, 0.00001f);
    }
    
    @Test
    public void testMinusValues() {
        Int2 expected = new Int2(1, 1);
        Assert.assertEquals(expected, vi2.minus(1, 3));
    }
    
    @Test
    public void testMinusValuesFloat() {
        Float2 diff = vi2.minus(1.2f, 3.4f);
        Assert.assertEquals(0.8f, diff.x, 0.00001f);
        Assert.assertEquals(0.6f, diff.y, 0.00001f);
    }
    
    @Test
    public void testTimes() {
        Int2 expected = new Int2(3, 9);
        Assert.assertEquals(expected, vi1.times(3));
    }
    
    @Test
    public void testTimesFloat() {
        Float2 prod = vi1.times(1.5f);
        Assert.assertEquals(1.5f, prod.x, 0.00001f);
        Assert.assertEquals(4.5f, prod.y, 0.00001f);
    }
    
    @Test
    public void testDividedBy() {
        Int2 expected = new Int2(0, 1);
        Assert.assertEquals(expected, vi1.dividedBy(2));
    }
    
    @Test
    public void testDividedByFloat() {
        Float2 div = vi1.dividedBy(2.0f);
        Assert.assertEquals(0.5f, div.x, 0.00001f);
        Assert.assertEquals(1.5f, div.y, 0.00001f);
    }
    
    @Test
    public void testDotProduct() {
        Assert.assertEquals(14, vi1.dotProduct(vi2));
    }
    
    @Test
    public void testDotProductFloat() {
        float expected = 1 * 1.2f + 3 * 3.4f;
        Assert.assertEquals(expected, vi1.dotProduct(vf1), 0.00001f);
    }
    
    @Test
    public void testLengthSquared() {
        Assert.assertEquals(10, vi1.lengthSquared());
    }
    
    @Test
    public void testLength() {
        Assert.assertEquals(Math.sqrt(10), vi1.length(), 0.00001f);
    }
    
    @Test
    public void testNormalized() {
        Assert.assertEquals(1.0f, vi1.normalized().lengthSquared(), 0.00001f);
    }
    
    @Test
    public void testAngle() {
        Int2 v1 = new Int2(1, 0);
        Int2 v2 = new Int2(1, 1);
        Assert.assertEquals(Math.PI / 4, v1.angle(v2), 0.00001f);
    }
    
    @Test
    public void testAngleFloat() {
        Int2 v1 = new Int2(1, 0);
        Float2 v2 = new Float2(1.5f, 1.5f);
        Assert.assertEquals(Math.PI / 4, v1.angle(v2), 0.00001f);
    }
    
    @Test
    public void testEquals() {
        Assert.assertTrue(vi1.equals(1, 3));
    }
}
