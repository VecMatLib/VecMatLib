package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Float4;
import hexagon.vecmat.vector.Int4;
import org.junit.Assert;
import org.junit.Test;

public class TestMatrix4 {
    
    static Matrix4 matA = Matrix4.fromRows(
            new Float4(2.0f, 1.0f, 4.0f, 3.0f),
            new Float4(1.0f, 3.0f, 2.0f, 4.0f),
            new Float4(3.0f, 4.0f, 1.0f, 2.0f),
            new Float4(4.0f, 2.0f, 3.0f, 1.0f)
    );
    
    static Matrix4 matB = Matrix4.fromRows(
            new Float4(5.0f, 7.0f, 6.0f, 8.0f),
            new Float4(7.0f, 6.0f, 8.0f, 5.0f),
            new Float4(8.0f, 5.0f, 7.0f, 6.0f),
            new Float4(6.0f, 8.0f, 5.0f, 7.0f)
    );
    
    @Test
    public void testPlus() {
        Matrix4 expected = Matrix4.fromRows(
                new Float4(7.0f, 8.0f, 10.0f, 11.0f),
                new Float4(8.0f, 9.0f, 10.0f, 9.0f),
                new Float4(11.0f, 9.0f, 8.0f, 8.0f),
                new Float4(10.0f, 10.0f, 8.0f, 8.0f)
        );
        Assert.assertEquals(expected, matA.plus(matB));
    }
    
    @Test
    public void testMinus() {
        Matrix4 expected = Matrix4.fromRows(
                new Float4(3.0f, 6.0f, 2.0f, 5.0f),
                new Float4(6.0f, 3.0f, 6.0f, 1.0f),
                new Float4(5.0f, 1.0f, 6.0f, 4.0f),
                new Float4(2.0f, 6.0f, 2.0f, 6.0f)
        );
        Assert.assertEquals(expected, matB.minus(matA));
    }
    
    @Test
    public void testNegative() {
        Matrix4 expected = Matrix4.ZERO;
        Assert.assertEquals(expected, matA.plus(matA.negative()));
    }
    
    @Test
    public void testMultiplyByConstant() {
        Matrix4 expected = Matrix4.fromRows(
                new Float4(4.0f, 2.0f, 8.0f, 6.0f),
                new Float4(2.0f, 6.0f, 4.0f, 8.0f),
                new Float4(6.0f, 8.0f, 2.0f, 4.0f),
                new Float4(8.0f, 4.0f, 6.0f, 2.0f)
        );
        Assert.assertEquals(expected, matA.multiply(2.0f));
    }
    
    @Test
    public void testDividedBy() {
        Matrix4 expected = Matrix4.fromRows(
                new Float4(1.0f, 0.5f, 2.0f, 1.5f),
                new Float4(0.5f, 1.5f, 1.0f, 2.0f),
                new Float4(1.5f, 2.0f, 0.5f, 1.0f),
                new Float4(2.0f, 1.0f, 1.5f, 0.5f)
        );
        Assert.assertEquals(expected, matA.dividedBy(2.0f));
    }
    
    @Test
    public void testMultiplyVector() {
        Float4 vector = new Float4(1.0f, 2.0f, 3.0f, 4.0f);
        Float4 expected = new Float4(28.0f, 29.0f, 22.0f, 21.0f);
        Assert.assertEquals(expected, matA.multiply(vector));
    }
    
    @Test
    public void testMultiplyVectorInt() {
        Int4 vector = new Int4(1, 2, 3, 4);
        Float4 expected = new Float4(28.0f, 29.0f, 22.0f, 21.0f);
        Assert.assertEquals(expected, matA.multiply(vector));
    }
    
    @Test
    public void testGetRow() {
        Float4 row = new Float4(1.0f, 3.0f, 2.0f, 4.0f);
        Assert.assertEquals(row, matA.getRow(1));
    }
    
    @Test
    public void testGetColumn() {
        Float4 col = new Float4(4.0f, 2.0f, 1.0f, 3.0f);
        Assert.assertEquals(col, matA.getColumn(2));
    }
    
    @Test
    public void testTransposed() {
        Matrix4 expected = Matrix4.fromColumns(
                new Float4(5.0f, 7.0f, 6.0f, 8.0f),
                new Float4(7.0f, 6.0f, 8.0f, 5.0f),
                new Float4(8.0f, 5.0f, 7.0f, 6.0f),
                new Float4(6.0f, 8.0f, 5.0f, 7.0f)
        );
        Assert.assertEquals(expected, matB.transposed());
    }
    
    @Test
    public void testSymmetric() {
        Matrix4 matrix = Matrix4.fromRows(
                new Float4(1.0f, 2.0f, 3.0f, 7.0f),
                new Float4(2.0f, 4.0f, 5.0f, 8.0f),
                new Float4(3.0f, 5.0f, 6.0f, 9.0f),
                new Float4(7.0f, 8.0f, 9.0f, 0.0f)
        );
        Assert.assertTrue(matrix.isSymmetric());
    }
    
    @Test
    public void testSkewSymmetric() {
        Matrix4 matrix = Matrix4.fromRows(
                new Float4(0.0f, -2.0f, -3.0f, -7.0f),
                new Float4(2.0f, 0.0f, -5.0f, -8.0f),
                new Float4(3.0f, 5.0f, 0.0f, -9.0f),
                new Float4(7.0f, 8.0f, 9.0f, 0.0f)
        );
        Assert.assertTrue(matrix.isSkewSymmetric());
    }
    
    @Test
    public void testMatrixMultiplication() {
        Matrix4 expected = Matrix4.fromRows(
                new Float4(67.0f, 64.0f, 63.0f, 66.0f),
                new Float4(66.0f, 67.0f, 64.0f, 63.0f),
                new Float4(63.0f, 66.0f, 67.0f, 64.0f),
                new Float4(64.0f, 63.0f, 66.0f, 67.0f)
        );
        Assert.assertEquals(expected, matA.multiply(matB));
    }
    
    @Test
    public void testPower() {
        Matrix4 expected = matB.multiply(matB).multiply(matB);
        Assert.assertEquals(expected, matB.power(3));
    }
}
