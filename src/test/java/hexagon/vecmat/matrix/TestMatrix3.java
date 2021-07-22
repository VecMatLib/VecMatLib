package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Float3;
import hexagon.vecmat.vector.Int3;
import org.junit.Assert;
import org.junit.Test;

public class TestMatrix3 {
    
    static Matrix3 matA = Matrix3.fromRows(
            new Float3(1.0f, 3.0f, 2.0f),
            new Float3(2.0f, 1.0f, 3.0f),
            new Float3(3.0f, 2.0f, 1.0f)
    );
    
    static Matrix3 matB = Matrix3.fromRows(
            new Float3(5.0f, 4.0f, 6.0f),
            new Float3(4.0f, 6.0f, 5.0f),
            new Float3(6.0f, 5.0f, 4.0f)
    );
    
    @Test
    public void testPlus() {
        Matrix3 expected = Matrix3.fromRows(
                new Float3(6.0f, 7.0f, 8.0f),
                new Float3(6.0f, 7.0f, 8.0f),
                new Float3(9.0f, 7.0f, 5.0f)
        );
        Assert.assertEquals(expected, matA.plus(matB));
    }
    
    @Test
    public void testMinus() {
        Matrix3 expected = Matrix3.fromRows(
                new Float3(4.0f, 1.0f, 4.0f),
                new Float3(2.0f, 5.0f, 2.0f),
                new Float3(3.0f, 3.0f, 3.0f)
        );
        Assert.assertEquals(expected, matB.minus(matA));
    }
    
    @Test
    public void testNegative() {
        Matrix3 expected = Matrix3.ZERO;
        Assert.assertEquals(expected, matA.plus(matA.negative()));
    }
    
    @Test
    public void testMultiplyByConstant() {
        Matrix3 expected = Matrix3.fromRows(
                new Float3(2.0f, 6.0f, 4.0f),
                new Float3(4.0f, 2.0f, 6.0f),
                new Float3(6.0f, 4.0f, 2.0f)
        );
        Assert.assertEquals(expected, matA.multiply(2.0f));
    }
    
    @Test
    public void testDividedBy() {
        Matrix3 expected = Matrix3.fromRows(
                new Float3(0.5f, 1.5f, 1.0f),
                new Float3(1.0f, 0.5f, 1.5f),
                new Float3(1.5f, 1.0f, 0.5f)
        );
        Assert.assertEquals(expected, matA.dividedBy(2.0f));
    }
    
    @Test
    public void testMultiplyVector() {
        Float3 vector = new Float3(1.0f, 2.0f, 3.0f);
        Float3 expected = new Float3(13.0f, 13.0f, 10.0f);
        Assert.assertEquals(expected, matA.multiply(vector));
    }
    
    @Test
    public void testMultiplyVectorInt() {
        Int3 vector = new Int3(1, 2, 3);
        Float3 expected = new Float3(13.0f, 13.0f, 10.0f);
        Assert.assertEquals(expected, matA.multiply(vector));
    }
    
    @Test
    public void testGetRow() {
        Float3 row = new Float3(4.0f, 6.0f, 5.0f);
        Assert.assertEquals(row, matB.getRow(1));
    }
    
    @Test
    public void testGetColumn() {
        Float3 col = new Float3(4.0f, 6.0f, 5.0f);
        Assert.assertEquals(col, matB.getColumn(1));
    }
    
    @Test
    public void testTransposed() {
        Matrix3 expected = Matrix3.fromColumns(
                new Float3(5.0f, 4.0f, 6.0f),
                new Float3(4.0f, 6.0f, 5.0f),
                new Float3(6.0f, 5.0f, 4.0f)
        );
        Assert.assertEquals(expected, matB.transposed());
    }
    
    @Test
    public void testSymmetric() {
        Matrix3 matrix = Matrix3.fromRows(
                new Float3(1.0f, 2.0f, 3.0f),
                new Float3(2.0f, 4.0f, 5.0f),
                new Float3(3.0f, 5.0f, 6.0f)
        );
        Assert.assertTrue(matrix.isSymmetric());
    }
    
    @Test
    public void testSkewSymmetric() {
        Matrix3 matrix = Matrix3.fromRows(
                new Float3(0.0f, -2.0f, -3.0f),
                new Float3(2.0f, 0.0f, -5.0f),
                new Float3(3.0f, 5.0f, 0.0f)
        );
        Assert.assertTrue(matrix.isSkewSymmetric());
    }
    
    @Test
    public void testMatrixMultiplication() {
        Matrix3 expected = Matrix3.fromRows(
                new Float3(29.0f, 32.0f, 29.0f),
                new Float3(32.0f, 29.0f, 29.0f),
                new Float3(29.0f, 29.0f, 32.0f)
        );
        Assert.assertEquals(expected, matA.multiply(matB));
    }
    
    @Test
    public void testPower() {
        Matrix3 expected = matB.multiply(matB).multiply(matB);
        Assert.assertEquals(expected, matB.power(3));
    }
}
