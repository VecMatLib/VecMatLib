package hexagon.vecmat.matrix;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import hexagon.vecmat.vector.Double4;
import hexagon.vecmat.vector.Float4;

public class TestDouble4x4 {

	static double a11 = 1.24, a12 = 0.56, a13 = 0.25, a14 = 0.12;
	static double a21 = 0.73, a22 = 1.62, a23 = 0.44, a24 = 0.21;
	static double a31 = 2.41, a32 = 0.03, a33 = 1.08, a34 = 0.05;
	static double a41 = 0.12, a42 = 0.34, a43 = 0.56, a44 = 1.24;
	static Double4x4 a = new Double4x4(a11, a12, a13, a14, a21, a22, a23, a24, a31, a32, a33, a34, a41, a42, a43, a44);

	static double b11 = 0.61, b12 = 1.21, b13 = 0.93, b14 = 0.12;
	static double b21 = 0.34, b22 = 0.74, b23 = 0.25, b24 = 0.34;
	static double b31 = 1.46, b32 = 2.58, b33 = 1.69, b34 = 0.12;
	static double b41 = 0.12, b42 = 0.34, b43 = 0.56, b44 = 1.24;
	static Double4x4 b = new Double4x4(b11, b12, b13, b14, b21, b22, b23, b24, b31, b32, b33, b34, b41, b42, b43, b44);

	static float c11 = 1.2f, c12 = 0.5f, c13 = 0.2f, c14 = 0.1f;
	static float c21 = 0.7f, c22 = 1.6f, c23 = 0.4f, c24 = 0.2f;
	static float c31 = 2.4f, c32 = 0.0f, c33 = 1.0f, c34 = 0.0f;
	static float c41 = 0.1f, c42 = 0.3f, c43 = 0.5f, c44 = 1.2f;
	static Float4x4 c = new Float4x4(c11, c12, c13, c14, c21, c22, c23, c24, c31, c32, c33, c34, c41, c42, c43, c44);

	static Double4x4 s1 = new Double4x4(1.0, 2.0, 3.0, 4.0, 2.0, 5.0, 6.0, 7.0, 3.0, 6.0, 8.0, 9.0, 4.0, 7.0, 9.0, 10.0);
	static Double4x4 s2 = new Double4x4(0.0, 1.0, 2.0, 3.0, -1.0, 0.0, 4.0, 5.0, -2.0, -4.0, 0.0, 6.0, -3.0, -5.0, -6.0, 0.0);

	static Double4x4 n1 = null;
	static Float4x4 n2 = null;

	static Double4 vn1 = null;
	static Float4 vn2 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Double4x4 + Double4x4
			Arguments.of(new Double4x4(a11+b11, a12+b12, a13+b13, a14+b14, a21+b21, a22+b22, a23+b23, a24+b24, a31+b31, a32+b32, a33+b33, a34+b34, a41+b41, a42+b42, a43+b43, a44+b44), a.plus(b)),
			//2. Double4x4 + null (Double4x4)
			Arguments.of(a, a.plus(n1)),
			//3. Double4x4 + Float4x4
			Arguments.of(new Double4x4(a11+c11, a12+c12, a13+c13, a14+c14, a21+c21, a22+c22, a23+c23, a24+c24, a31+c31, a32+c32, a33+c33, a34+c34, a41+c41, a42+c42, a43+c43, a44+c44), a.plus(c)),
			//4. Double4x4 + null (Float4x4)
			Arguments.of(a, a.plus(n2)),
			//5. -Double4x4
			Arguments.of(new Double4x4(-a11, -a12, -a13, -a14, -a21, -a22, -a23, -a24, -a31, -a32, -a33, -a34, -a41, -a42, -a43, -a44), a.negative()),
			//6. Double4x4 - Double4x4
			Arguments.of(new Double4x4(a11-b11, a12-b12, a13-b13, a14-b14, a21-b21, a22-b22, a23-b23, a24-b24, a31-b31, a32-b32, a33-b33, a34-b34, a41-b41, a42-b42, a43-b43, a44-b44), a.minus(b)),
			//7. Double4x4 - null (Double4x4)
			Arguments.of(a, a.minus(n1)),
			//8. Double4x4 - Float4x4
			Arguments.of(new Double4x4(a11-c11, a12-c12, a13-c13, a14-c14, a21-c21, a22-c22, a23-c23, a24-c24, a31-c31, a32-c32, a33-c33, a34-c34, a41-c41, a42-c42, a43-c43, a44-c44), a.minus(c)),
			//9. Double4x4 - null (Float4x4)
			Arguments.of(a, a.minus(n2)),
			//10. Double4x4 * double
			Arguments.of(new Double4x4(a11*2.0, a12*2.0, a13*2.0, a14*2.0, a21*2.0, a22*2.0, a23*2.0, a24*2.0, a31*2.0, a32*2.0, a33*2.0, a34*2.0, a41*2.0, a42*2.0, a43*2.0, a44*2.0), a.multipliedBy(2.0)),
			//11. Row1
			Arguments.of(new Double4(a11, a12, a13, a14), a.row1()),
			//12. Row2
			Arguments.of(new Double4(a21, a22, a23, a24), a.row2()),
			//13. Row3
			Arguments.of(new Double4(a31, a32, a33, a34), a.row3()),
			//14. Row4
			Arguments.of(new Double4(a41, a42, a43, a44), a.row4()),
			//15. Column1
			Arguments.of(new Double4(a11, a21, a31, a41), a.column1()),
			//16. Column2
			Arguments.of(new Double4(a12, a22, a32, a42), a.column2()),
			//17. Column3
			Arguments.of(new Double4(a13, a23, a33, a43), a.column3()),
			//18. Column4
			Arguments.of(new Double4(a14, a24, a34, a44), a.column4()),
			//19. Double4x4 * Double4
			Arguments.of(new Double4(a11*1.0+a12*2.0+a13*3.0+a14*4.0, a21*1.0+a22*2.0+a23*3.0+a24*4.0, a31*1.0+a32*2.0+a33*3.0+a34*4.0, a41*1.0+a42*2.0+a43*3.0+a44*4.0), a.multiply(new Double4(1.0, 2.0, 3.0, 4.0))),
			//20. Double4x4 * null (Double4)
			Arguments.of(Double4.ZERO, a.multiply(vn1)),
			//21. Double4x4 * Float4
			Arguments.of(new Double4(a11*1.0f+a12*2.0f+a13*3.0f+a14*4.0f, a21*1.0f+a22*2.0f+a23*3.0f+a24*4.0f, a31*1.0f+a32*2.0f+a33*3.0f+a34*4.0f, a41*1.0f+a42*2.0f+a43*3.0f+a44*4.0f), a.multiply(new Float4(1.0f, 2.0f, 3.0f, 4.0f))),
			//22. Double4x4 * null (Float4)
			Arguments.of(Double4.ZERO, a.multiply(vn2)),
			//23. Double4x4 ^ T
			Arguments.of(new Double4x4(a11, a21, a31, a41, a12, a22, a32, a42, a13, a23, a33, a43, a14, a24, a34, a44), a.transposed()),
			//24. Double4x4 == Double4x4 ^ T
			Arguments.of(true, s1.isSymmetric()),
			//25. Double4x4 != Double4x4 ^ T
			Arguments.of(false, a.isSymmetric()),
			//26. Double4x4 == -(Double4x4 ^ T)
			Arguments.of(true, s2.isSkewSymmetric()),
			//27. Double4x4 != -(Double4x4 ^ T)
			Arguments.of(false, a.isSkewSymmetric()),
			//28. Double4x4 * Double4x4
			Arguments.of(new Double4x4(a.row1().dotProduct(b.column1()), a.row1().dotProduct(b.column2()), a.row1().dotProduct(b.column3()), a.row1().dotProduct(b.column4()), a.row2().dotProduct(b.column1()), a.row2().dotProduct(b.column2()), a.row2().dotProduct(b.column3()), a.row2().dotProduct(b.column4()), a.row3().dotProduct(b.column1()), a.row3().dotProduct(b.column2()), a.row3().dotProduct(b.column3()), a.row3().dotProduct(b.column4()), a.row4().dotProduct(b.column1()), a.row4().dotProduct(b.column2()), a.row4().dotProduct(b.column3()), a.row4().dotProduct(b.column4())), a.multiply(b)),
			//29. Double4x4 * null (Double4x4)
			Arguments.of(Double4x4.ZERO, a.multiply(n1)),
			//30. Double4x4 * Float4x4
			Arguments.of(new Double4x4(a.row1().dotProduct(c.column1()), a.row1().dotProduct(c.column2()), a.row1().dotProduct(c.column3()), a.row1().dotProduct(c.column4()), a.row2().dotProduct(c.column1()), a.row2().dotProduct(c.column2()), a.row2().dotProduct(c.column3()), a.row2().dotProduct(c.column4()), a.row3().dotProduct(c.column1()), a.row3().dotProduct(c.column2()), a.row3().dotProduct(c.column3()), a.row3().dotProduct(c.column4()), a.row4().dotProduct(c.column1()), a.row4().dotProduct(c.column2()), a.row4().dotProduct(c.column3()), a.row4().dotProduct(c.column4())), a.multiply(c)),
			//31. Double4x4 * null (Float4x4)
			Arguments.of(Double4x4.ZERO, a.multiply(n2)),
			//32. Double4x4 ^ int
			Arguments.of(a.multiply(a).multiply(a), a.power(3))
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}
}
