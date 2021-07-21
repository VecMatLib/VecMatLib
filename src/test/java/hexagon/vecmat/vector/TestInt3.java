package hexagon.vecmat.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestInt3 {
    
    static Int3 vi1 = new Int3(1, 3, 2);
    static Int3 vi2 = new Int3(2, 4, -1);
    static Float3 vf1 = new Float3(1.2f, 3.4f, 5.6f);
    
    @Test
    public void testPlus() {
        Int3 expected = new Int3(3, 7, 1);
        Assert.assertEquals(expected, vi1.plus(vi2));
    }
    
    @Test
    public void testPlusFloat() {
        Float3 sum = vi1.plus(vf1);
        Assert.assertEquals(2.2f, sum.x, 0.00001f);
        Assert.assertEquals(6.4f, sum.y, 0.00001f);
        Assert.assertEquals(7.6f, sum.z, 0.00001f);
    }
    
    @Test
    public void testPlusValues() {
        Int3 expected = new Int3(3, 7, 1);
        Assert.assertEquals(expected, vi1.plus(2, 4, -1));
    }
    
    @Test
    public void testPlusValuesFloat() {
        Float3 sum = vi1.plus(1.2f, 3.4f, 5.6f);
        Assert.assertEquals(2.2f, sum.x, 0.00001f);
        Assert.assertEquals(6.4f, sum.y, 0.00001f);
        Assert.assertEquals(7.6f, sum.z, 0.00001f);
    }
    
    @Test
    public void testNegated() {
        Int3 expected = new Int3(-1, -3, -2);
        Assert.assertEquals(expected, vi1.negated());
    }
    
    @Test
    public void testMinus() {
        Int3 expected = new Int3(1, 1, -3);
        Assert.assertEquals(expected, vi2.minus(vi1));
    }
    
    @Test
    public void testMinusFloat() {
        Float3 diff = vi2.minus(vf1);
        Assert.assertEquals(0.8f, diff.x, 0.00001f);
        Assert.assertEquals(0.6f, diff.y, 0.00001f);
        Assert.assertEquals(-6.6f, diff.z, 0.00001f);
    }
    
    @Test
    public void testMinusValues() {
        Int3 expected = new Int3(1, 1, -3);
        Assert.assertEquals(expected, vi2.minus(1, 3, 2));
    }
    
    @Test
    public void testMinusValuesFloat() {
        Float3 diff = vi2.minus(1.2f, 3.4f, 5.6f);
        Assert.assertEquals(0.8f, diff.x, 0.00001f);
        Assert.assertEquals(0.6f, diff.y, 0.00001f);
        Assert.assertEquals(-6.6f, diff.z, 0.00001f);
    }
    
    @Test
    public void testTimes() {
        Int3 expected = new Int3(3, 9, 6);
        Assert.assertEquals(expected, vi1.times(3));
    }
    
    @Test
    public void testTimesFloat() {
        Float3 prod = vi1.times(1.5f);
        Assert.assertEquals(1.5f, prod.x, 0.00001f);
        Assert.assertEquals(4.5f, prod.y, 0.00001f);
        Assert.assertEquals(3.0f, prod.z, 0.00001f);
    }
    
    @Test
    public void testDividedBy() {
        Int3 expected = new Int3(0, 1, 1);
        Assert.assertEquals(expected, vi1.dividedBy(2));
    }
    
    @Test
    public void testDividedByFloat() {
        Float3 div = vi1.dividedBy(2.0f);
        Assert.assertEquals(0.5f, div.x, 0.00001f);
        Assert.assertEquals(1.5f, div.y, 0.00001f);
        Assert.assertEquals(1.0f, div.z, 0.00001f);
    }
    
    @Test
    public void testDotProduct() {
        Assert.assertEquals(12, vi1.dotProduct(vi2));
    }
    
    @Test
    public void testDotProductFloat() {
        float expected = 1 * 1.2f + 3 * 3.4f + 2 * 5.6f;
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
    public void testAngle() {
        Int3 v1 = new Int3(1, 0, 0);
        Int3 v2 = new Int3(0, 0, 1);
        Assert.assertEquals(Math.PI / 2, v1.angle(v2), 0.00001f);
    }
    
    @Test
    public void testAngleFloat() {
        Int3 v1 = new Int3(1, 0, 0);
        Float3 v2 = new Float3(0.0f, 0.0f, 1.4f);
        Assert.assertEquals(Math.PI / 2, v1.angle(v2), 0.00001f);
    }
    
    @Test
    public void testEquals() {
        Assert.assertTrue(vi1.equals(1, 3, 2));
    }
}
