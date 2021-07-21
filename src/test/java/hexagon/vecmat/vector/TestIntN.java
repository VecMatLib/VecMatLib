package hexagon.vecmat.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestIntN {
    
    static IntN vi1 = new IntN(1, 3, 2, 5, 4);
    static IntN vi2 = new IntN(5, 4, 3, 2, 1);
    static FloatN vf1 = new FloatN(2.1f, 3.2f, 1.5f, 2.3f, 1.7f);
    
    @Test
    public void testPlus() {
        IntN expected = new IntN(6, 7, 5, 7, 5);
        Assert.assertEquals(expected, vi1.plus(vi2));
    }
    
    @Test
    public void testFloat() {
        FloatN expected = new FloatN(3.1f, 6.2f, 3.5f, 7.3f, 5.7f);
        Assert.assertEquals(expected, vi1.plus(vf1));
    }
    
    @Test
    public void testNegated() {
        IntN expected = new IntN(-1, -3, -2, -5, -4);
        Assert.assertEquals(expected, vi1.negated());
    }
    
    @Test
    public void testMinus() {
        IntN expected = new IntN(-4, -1, -1, 3, 3);
        Assert.assertEquals(expected, vi1.minus(vi2));
    }
    
    @Test
    public void testMinusFloat() {
        FloatN v = new FloatN(2.0f, 1.0f, 4.0f, 3.0f, 1.0f);
        FloatN expected = new FloatN(-1.0f, 2.0f, -2.0f, 2.0f, 3.0f);
        Assert.assertEquals(expected, vi1.minus(v));
    }
    
    @Test
    public void testTimes() {
        IntN expected = new IntN(2, 6, 4, 10, 8);
        Assert.assertEquals(expected, vi1.times(2));
    }
    
    @Test
    public void testTimesFloat() {
        FloatN expected = new FloatN(1.5f, 4.5f, 3.0f, 7.5f, 6.0f);
        Assert.assertEquals(expected, vi1.times(1.5f));
    }
    
    @Test
    public void testDividedBy() {
        IntN expected = new IntN(0, 1, 1, 2, 2);
        Assert.assertEquals(expected, vi1.dividedBy(2));
    }
    
    @Test
    public void testDividedByFloat() {
        FloatN expected = new FloatN(0.5f, 1.5f, 1.0f, 2.5f, 2.0f);
        Assert.assertEquals(expected, vi1.dividedBy(2.0f));
    }
    
    @Test
    public void testDotProduct() {
        Assert.assertEquals(37, vi1.dotProduct(vi2));
    }
    
    @Test
    public void testDotProductFloat() {
        Assert.assertEquals(33.0f, vi1.dotProduct(vf1), 0.00001f);
    }
    
    @Test
    public void testLengthSquared() {
        Assert.assertEquals(55, vi1.lengthSquared());
    }
    
    @Test
    public void testLength() {
        Assert.assertEquals(Math.sqrt(55), vi1.length(), 0.00001f);
    }
}
