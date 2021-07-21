package hexagon.vecmat.vector;

import org.junit.Assert;
import org.junit.Test;

public class TestFloatN {
    
    static FloatN vf1 = new FloatN(1.0f, 3.0f, 2.0f, 5.0f, 4.0f);
    static FloatN vf2 = new FloatN(3.0f, -1.0f, 5.0f, 4.0f, 2.0f);
    static IntN vi1 = new IntN(1, 2, 3, 4, 5);
    
    @Test
    public void testPlus() {
        FloatN expected = new FloatN(4.0f, 2.0f, 7.0f, 9.0f, 6.0f);
        Assert.assertEquals(expected, vf1.plus(vf2));
    }
    
    @Test
    public void testPlusInt() {
        FloatN expected = new FloatN(2.0f, 5.0f, 5.0f, 9.0f, 9.0f);
        Assert.assertEquals(expected, vf1.plus(vi1));
    }
    
    @Test
    public void testNegated() {
        FloatN expected = new FloatN(-3.0f, 1.0f, -5.0f, -4.0f, -2.0f);
        Assert.assertEquals(expected, vf2.negated());
    }
    
    @Test
    public void testMinus() {
        FloatN expected = new FloatN(-2.0f, 4.0f, -3.0f, 1.0f, 2.0f);
        Assert.assertEquals(expected, vf1.minus(vf2));
    }
    
    @Test
    public void testMinusInt() {
        FloatN expected = new FloatN(0.0f, 1.0f, -1.0f, 1.0f, -1.0f);
        Assert.assertEquals(expected, vf1.minus(vi1));
    }
    
    @Test
    public void testTimes() {
        FloatN expected = new FloatN(1.5f, 4.5f, 3.0f, 7.5f, 6.0f);
        Assert.assertEquals(expected, vf1.times(1.5f));
    }
    
    @Test
    public void testDividedBy() {
        FloatN expected = new FloatN(0.5f, 1.5f, 1.0f, 2.5f, 2.0f);
        Assert.assertEquals(expected, vf1.dividedBy(2.0f));
    }
    
    @Test
    public void testDotProduct() {
        Assert.assertEquals(38.0f, vf1.dotProduct(vf2), 0.00001f);
    }
    
    @Test
    public void testDotProductInt() {
        Assert.assertEquals(53, vf1.dotProduct(vi1), 0.00001f);
    }
    
    @Test
    public void testLengthSquared() {
        Assert.assertEquals(55, vf1.lengthSquared(), 0.00001f);
    }
    
    @Test
    public void testLength() {
        Assert.assertEquals(Math.sqrt(55), vf1.length(), 0.00001f);
    }
    
    @Test
    public void testCastToInt() {
        FloatN v = new FloatN(1.1f, 3.9f, 2.5f, 5.3f, 4.8f);
        IntN expected = new IntN(1, 3, 2, 5, 4);
        Assert.assertEquals(expected, v.castToInt());
    }
}
