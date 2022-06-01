package hexagon.vecmat.matrix;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import hexagon.vecmat.vector.Double4;
import hexagon.vecmat.vector.Float4;
import hexagon.vecmat.vector.Int4;

public class TestFloat4x4 {

	static float a11 = 1.2f, a12 = 0.5f, a13 = 0.2f, a14 = 1.5f;
	static float a21 = 0.7f, a22 = 1.6f, a23 = 0.4f, a24 = 2.5f;
	static float a31 = 2.4f, a32 = 0.0f, a33 = 1.0f, a34 = 0.2f;
	static float a41 = 0.5f, a42 = 0.3f, a43 = 2.6f, a44 = 1.0f;
	static Float4x4 a = new Float4x4(a11, a12, a13, a14, a21, a22, a23, a24, a31, a32, a33, a34, a41, a42, a43, a44);

	static float b11 = 0.6f, b12 = 1.2f, b13 = 0.9f, b14 = 0.1f;
	static float b21 = 0.3f, b22 = 0.7f, b23 = 0.1f, b24 = 0.2f;
	static float b31 = 1.4f, b32 = 2.5f, b33 = 1.6f, b34 = 0.3f;
	static float b41 = 0.5f, b42 = 0.1f, b43 = 2.2f, b44 = 1.4f;
	static Float4x4 b = new Float4x4(b11, b12, b13, b14, b21, b22, b23, b24, b31, b32, b33, b34, b41, b42, b43, b44);

	static int c11 = 1, c12 = 2, c13 = 3, c14 = 4;
	static int c21 = 4, c22 = 5, c23 = 6, c24 = 7;
	static int c31 = 7, c32 = 8, c33 = 9, c34 = 10;
	static int c41 = 10, c42 = 11, c43 = 12, c44 = 13;
	static Int4x4 c = new Int4x4(c11, c12, c13, c14, c21, c22, c23, c24, c31, c32, c33, c34, c41, c42, c43, c44);

	static double d11 = 1.23, d12 = 0.52, d13 = 0.21, d14 = 1.54;
	static double d21 = 0.77, d22 = 1.69, d23 = 0.46, d24 = 2.53;
	static double d31 = 2.46, d32 = 0.05, d33 = 1.03, d34 = 0.21;
	static double d41 = 0.53, d42 = 0.31, d43 = 2.66, d44 = 1.03;
	static Double4x4 d = new Double4x4(d11, d12, d13, d14, d21, d22, d23, d24, d31, d32, d33, d34, d41, d42, d43, d44);

	static Double4x4 s1 = new Double4x4(0.0, 1.0, 2.0, 3.0, 1.0, 4.0, 5.0, 6.0, 2.0, 5.0, 7.0, 8.0, 3.0, 6.0, 8.0, 9.0);
	static Double4x4 s2 = new Double4x4(0.0, 1.0, 2.0, 3.0, -1.0, 4.0, 5.0, 6.0, -2.0, -5.0, 7.0, 8.0, -3.0, -6.0, -8.0, 9.0);

	static Int4x4 n1 = null;
	static Float4x4 n2 = null;
	static Double4x4 n3 = null;

	static Int4 vn1 = null;
	static Float4 vn2 = null;
	static Double4 vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Float4x4 + Float4x4
			Arguments.of(new Float4x4(a11+b11, a12+b12, a13+b13, a14+b14, a21+b21, a22+b22, a23+b23, a24+b24, a31+b31, a32+b32, a33+b33, a34+b34, a41+b41, a42+b42, a43+b43, a44+b44), a.plus(b)),
			//2. Float4x4 + null (Float4x4)
			Arguments.of(a, a.plus(n1)),
			//3. Float4x4 + Int4x4
			Arguments.of(new Float4x4(a11+c11, a12+c12, a13+c13, a14+c14, a21+c21, a22+c22, a23+c23, a24+c24, a31+c31, a32+c32, a33+c33, a34+c34, a41+c41, a42+c42, a43+c43, a44+c44), a.plus(c)),
			//4. Float4x4 + null (Int4x4)
			Arguments.of(a, a.plus(n2)),
			//5. Float4x4 + Double4x4
			Arguments.of(new Double4x4(a11+d11, a12+d12, a13+d13, a14+d14, a21+d21, a22+d22, a23+d23, a24+d24, a31+d31, a32+d32, a33+d33, a34+d34, a41+d41, a42+d42, a43+d43, a44+d44), a.plus(d)),
			//6. Float4x4 + null (Double4x4)
			Arguments.of(a.asDouble(), a.plus(n3)),
			//7. -Float4x4
			Arguments.of(new Float4x4(-a11, -a12, -a13, -a14, -a21, -a22, -a23, -a24, -a31, -a32, -a33, -a34, -a41, -a42, -a43, -a44), a.negative()),
			//8. Float4x4 - Float4x4
			Arguments.of(new Float4x4(a11-b11, a12-b12, a13-b13, a14-b14, a21-b21, a22-b22, a23-b23, a24-b24, a31-b31, a32-b32, a33-b33, a34-b34, a41-b41, a42-b42, a43-b43, a44-b44), a.minus(b)),
			//9. Float4x4 - null (Float4x4)
			Arguments.of(a, a.minus(n1)),
			//10. Float4x4 - Int4x4
			Arguments.of(new Float4x4(a11-c11, a12-c12, a13-c13, a14-c14, a21-c21, a22-c22, a23-c23, a24-c24, a31-c31, a32-c32, a33-c33, a34-c34, a41-c41, a42-c42, a43-c43, a44-c44), a.minus(c)),
			//11. Float4x4 - null (Int4x4)
			Arguments.of(a, a.minus(n2)),
			//12. Float4x4 - Double4x4
			Arguments.of(new Double4x4(a11-d11, a12-d12, a13-d13, a14-d14, a21-d21, a22-d22, a23-d23, a24-d24, a31-d31, a32-d32, a33-d33, a34-d34, a41-d41, a42-d42, a43-d43, a44-d44), a.minus(d)),
			//13. Float4x4 - null (Double4x4)
			Arguments.of(a.asDouble(), a.minus(n3)),
			//14. Float4x4 * float
			Arguments.of(new Float4x4(a11*2.0f, a12*2.0f, a13*2.0f, a14*2.0f, a21*2.0f, a22*2.0f, a23*2.0f, a24*2.0f, a31*2.0f, a32*2.0f, a33*2.0f, a34*2.0f, a41*2.0f, a42*2.0f, a43*2.0f, a44*2.0f), a.multipliedBy(2.0f)),
			//15. Float4x4 * double
			Arguments.of(new Double4x4(a11*2.0, a12*2.0, a13*2.0, a14*2.0, a21*2.0, a22*2.0, a23*2.0, a24*2.0, a31*2.0, a32*2.0, a33*2.0, a34*2.0, a41*2.0, a42*2.0, a43*2.0, a44*2.0), a.multipliedBy(2.0)),
			//16. Row1
			Arguments.of(new Float4(a11, a12, a13, a14), a.row1()),
			//17. Row2
			Arguments.of(new Float4(a21, a22, a23, a24), a.row2()),
			//18. Row3
			Arguments.of(new Float4(a31, a32, a33, a34), a.row3()),
			//19. Row4
			Arguments.of(new Float4(a41, a42, a43, a44), a.row4()),
			//20. Column1
			Arguments.of(new Float4(a11, a21, a31, a41), a.column1()),
			//21. Column2
			Arguments.of(new Float4(a12, a22, a32, a42), a.column2()),
			//22. Column3
			Arguments.of(new Float4(a13, a23, a33, a43), a.column3()),
			//23. Column4
			Arguments.of(new Float4(a14, a24, a34, a44), a.column4()),
			//24. Float4x4 * Float4
			Arguments.of(new Float4(a11*1.0f+a12*2.0f+a13*3.0f+a14*4.0f, a21*1.0f+a22*2.0f+a23*3.0f+a24*4.0f, a31*1.0f+a32*2.0f+a33*3.0f+a34*4.0f, a41*1.0f+a42*2.0f+a43*3.0f+a44*4.0f), a.multiply(new Float4(1.0f, 2.0f, 3.0f, 4.0f))),
			//25. Float4x4 * null (Float4)
			Arguments.of(Float4.ZERO, a.multiply(vn1)),
			//26. Float4x4 * Int4
			Arguments.of(new Float4(a11*1+a12*2+a13*3+a14*4, a21*1+a22*2+a23*3+a24*4, a31*1+a32*2+a33*3+a34*4, a41*1+a42*2+a43*3+a44*4), a.multiply(new Int4(1, 2, 3, 4))),
			//27. Float4x4 * null (Int4)
			Arguments.of(Float4.ZERO, a.multiply(vn2)),
			//28. Float4x4 * Double4
			Arguments.of(new Double4(a11*1.0+a12*2.0+a13*3.0+a14*4.0, a21*1.0+a22*2.0+a23*3.0+a24*4.0, a31*1.0+a32*2.0+a33*3.0+a34*4.0, a41*1.0+a42*2.0+a43*3.0+a44*4.0), a.multiply(new Double4(1.0, 2.0, 3.0, 4.0))),
			//29. Float4x4 * null (Double4)
			Arguments.of(Double4.ZERO, a.multiply(vn3)),
			//30. Float4x4 ^ T
			Arguments.of(new Float4x4(a11, a21, a31, a41, a12, a22, a32, a42, a13, a23, a33, a43, a14, a24, a34, a44), a.transposed()),
			//31. Float4x4 == Float4x4 ^ T
			Arguments.of(true, s1.isSymmetric()),
			//32. Float4x4 != Float4x4 ^ T
			Arguments.of(false, a.isSymmetric()),
			//33. Float4x4 == -(Float4x4 ^ T)
			Arguments.of(true, s2.isSkewSymmetric()),
			//34. Float4x4 != -(Float4x4 ^ T)
			Arguments.of(false, a.isSkewSymmetric()),
			//35. Float4x4 * Float4x4
			Arguments.of(new Float4x4(a.row1().dotProduct(b.column1()), a.row1().dotProduct(b.column2()), a.row1().dotProduct(b.column3()), a.row1().dotProduct(b.column4()), a.row2().dotProduct(b.column1()), a.row2().dotProduct(b.column2()), a.row2().dotProduct(b.column3()), a.row2().dotProduct(b.column4()), a.row3().dotProduct(b.column1()), a.row3().dotProduct(b.column2()), a.row3().dotProduct(b.column3()), a.row3().dotProduct(b.column4()), a.row4().dotProduct(b.column1()), a.row4().dotProduct(b.column2()), a.row4().dotProduct(b.column3()), a.row4().dotProduct(b.column4())), a.multiply(b)),
			//36. Float4x4 * null (Float4x4)
			Arguments.of(Float4x4.ZERO, a.multiply(n1)),
			//37. Float4x4 * Int4x4
			Arguments.of(new Float4x4(a.row1().dotProduct(c.column1()), a.row1().dotProduct(c.column2()), a.row1().dotProduct(c.column3()), a.row1().dotProduct(c.column4()), a.row2().dotProduct(c.column1()), a.row2().dotProduct(c.column2()), a.row2().dotProduct(c.column3()), a.row2().dotProduct(c.column4()), a.row3().dotProduct(c.column1()), a.row3().dotProduct(c.column2()), a.row3().dotProduct(c.column3()), a.row3().dotProduct(c.column4()), a.row4().dotProduct(c.column1()), a.row4().dotProduct(c.column2()), a.row4().dotProduct(c.column3()), a.row4().dotProduct(c.column4())), a.multiply(c)),
			//38. Float4x4 * null (Int4x4)
			Arguments.of(Float4x4.ZERO, a.multiply(n2)),
			//39. Float4x4 * Double4x4
			Arguments.of(new Double4x4(a.row1().dotProduct(d.column1()), a.row1().dotProduct(d.column2()), a.row1().dotProduct(d.column3()), a.row1().dotProduct(d.column4()), a.row2().dotProduct(d.column1()), a.row2().dotProduct(d.column2()), a.row2().dotProduct(d.column3()), a.row2().dotProduct(d.column4()), a.row3().dotProduct(d.column1()), a.row3().dotProduct(d.column2()), a.row3().dotProduct(d.column3()), a.row3().dotProduct(d.column4()), a.row4().dotProduct(d.column1()), a.row4().dotProduct(d.column2()), a.row4().dotProduct(d.column3()), a.row4().dotProduct(d.column4())), a.multiply(d)),
			//40. Float4x4 * null (Double4x4)
			Arguments.of(Double4x4.ZERO, a.multiply(n3)),
			//41. Float4x4 ^ int
			Arguments.of(a.multiply(a).multiply(a), a.power(3))
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}
}
