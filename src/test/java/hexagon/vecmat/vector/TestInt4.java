package hexagon.vecmat.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestInt4 {
    
    static Int4 vi1 = new Int4(1, 3, 2, 0);
    static Int4 vi2 = new Int4(2, 4, -1, 3);
    static Float4 vf1 = new Float4(1.2f, 3.4f, 5.6f, 7.8f);
    
    @Test
    public void testPlus() {
        Int4 expected = new Int4(3, 7, 1, 3);
        Assert.assertEquals(expected, vi1.plus(vi2));
    }
    
    @Test
    public void testPlusFloat() {
        Float4 sum = vi1.plus(vf1);
        Assert.assertEquals(2.2f, sum.x, 0.00001f);
        Assert.assertEquals(6.4f, sum.y, 0.00001f);
        Assert.assertEquals(7.6f, sum.z, 0.00001f);
        Assert.assertEquals(7.8f, sum.w, 0.00001f);
    }
    
    @Test
    public void testPlusValues() {
        Int4 expected = new Int4(3, 7, 1, 3);
        Assert.assertEquals(expected, vi1.plus(2, 4, -1, 3));
    }
    
    @Test
    public void testPlusValuesFloat() {
        Float4 sum = vi1.plus(1.2f, 3.4f, 5.6f, 7.8f);
        Assert.assertEquals(2.2f, sum.x, 0.00001f);
        Assert.assertEquals(6.4f, sum.y, 0.00001f);
        Assert.assertEquals(7.6f, sum.z, 0.00001f);
        Assert.assertEquals(7.8f, sum.w, 0.00001f);
    }
    
    @Test
    public void testNegated() {
        Int4 expected = new Int4(-1, -3, -2, 0);
        Assert.assertEquals(expected, vi1.negated());
    }
    
    @Test
    public void testMinus() {
        Int4 expected = new Int4(1, 1, -3, 3);
        Assert.assertEquals(expected, vi2.minus(vi1));
    }
    
    @Test
    public void testMinusFloat() {
        Float4 diff = vi2.minus(vf1);
        Assert.assertEquals(0.8f, diff.x, 0.00001f);
        Assert.assertEquals(0.6f, diff.y, 0.00001f);
        Assert.assertEquals(-6.6f, diff.z, 0.00001f);
        Assert.assertEquals(-4.8f, diff.w, 0.00001f);
    }
    
    @Test
    public void testMinusValues() {
        Int4 expected = new Int4(1, 1, -3, 3);
        Assert.assertEquals(expected, vi2.minus(1, 3, 2, 0));
    }
    
    @Test
    public void testMinusValuesFloat() {
        Float4 diff = vi2.minus(1.2f, 3.4f, 5.6f, 7.8f);
        Assert.assertEquals(0.8f, diff.x, 0.00001f);
        Assert.assertEquals(0.6f, diff.y, 0.00001f);
        Assert.assertEquals(-6.6f, diff.z, 0.00001f);
        Assert.assertEquals(-4.8f, diff.w, 0.00001f);
    }
    
    @Test
    public void testTimes() {
        Int4 expected = new Int4(3, 9, 6, 0);
        Assert.assertEquals(expected, vi1.times(3));
    }
    
    @Test
    public void testTimesFloat() {
        Float4 prod = vi1.times(1.5f);
        Assert.assertEquals(1.5f, prod.x, 0.00001f);
        Assert.assertEquals(4.5f, prod.y, 0.00001f);
        Assert.assertEquals(3.0f, prod.z, 0.00001f);
        Assert.assertEquals(0.0f, prod.w, 0.00001f);
    }
    
    @Test
    public void testDividedBy() {
        Int4 expected = new Int4(0, 1, 1, 0);
        Assert.assertEquals(expected, vi1.dividedBy(2));
    }
    
    @Test
    public void testDividedByFloat() {
        Float4 div = vi1.dividedBy(2.0f);
        Assert.assertEquals(0.5f, div.x, 0.00001f);
        Assert.assertEquals(1.5f, div.y, 0.00001f);
        Assert.assertEquals(1.0f, div.z, 0.00001f);
        Assert.assertEquals(0.0f, div.w, 0.00001f);
    }
    
    @Test
    public void testDotProduct() {
        Assert.assertEquals(12, vi1.dotProduct(vi2));
    }
    
    @Test
    public void testDotProductFloat() {
        float expected = 1 * 1.2f + 3 * 3.4f + 2 * 5.6f + 0 * 7.8f;
        Assert.assertEquals(expected, vi1.dotProduct(vf1), 0.00001f);
    }
    
    @Test
    public void testLengthSquared() {
        Assert.assertEquals(14, vi1.lengthSquared());
    }
    
    @Test
    public void testLength() {
        Assert.assertEquals(Math.sqrt(14), vi1.length(), 0.00001f);
    }
    
    @Test
    public void testNormalized() {
        Assert.assertEquals(1.0f, vi1.normalized().lengthSquared(), 0.00001f);
    }
    
    @Test
    public void testEquals() {
        Assert.assertTrue(vi1.equals(1, 3, 2, 0));
    }
}
