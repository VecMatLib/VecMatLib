package hexagon.vecmat.matrix;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import hexagon.vecmat.vector.Double4;
import hexagon.vecmat.vector.Float4;
import hexagon.vecmat.vector.Int4;

public class TestInt4x4 {

	static int a11 = 1, a12 = 5, a13 = 2, a14 = 4;
	static int a21 = 7, a22 = 6, a23 = 4, a24 = 5;
	static int a31 = 2, a32 = 0, a33 = 1, a34 = 6;
	static int a41 = 4, a42 = 3, a43 = 2, a44 = 1;
	static Int4x4 a = new Int4x4(a11, a12, a13, a14, a21, a22, a23, a24, a31, a32, a33, a34, a41, a42, a43, a44);

	static int b11 = 6, b12 = 2, b13 = 9, b14 = 1;
	static int b21 = 3, b22 = 7, b23 = 1, b24 = 4;
	static int b31 = 4, b32 = 5, b33 = 0, b34 = 2;
	static int b41 = 1, b42 = 3, b43 = 2, b44 = 1;
	static Int4x4 b = new Int4x4(b11, b12, b13, b14, b21, b22, b23, b24, b31, b32, b33, b34, b41, b42, b43, b44);

	static float c11 = 1.1f, c12 = 2.3f, c13 = 3.6f, c14 = 4.8f;
	static float c21 = 1.3f, c22 = 0.5f, c23 = 2.1f, c24 = 3.4f;
	static float c31 = 2.8f, c32 = 0.1f, c33 = 0.9f, c34 = 1.2f;
	static float c41 = 3.5f, c42 = 2.7f, c43 = 1.3f, c44 = 0.4f;
	static Float4x4 c = new Float4x4(c11, c12, c13, c14, c21, c22, c23, c24, c31, c32, c33, c34, c41, c42, c43, c44);

	static double d11 = 1.23, d12 = 0.52, d13 = 0.21, d14 = 0.34;
	static double d21 = 0.77, d22 = 1.69, d23 = 0.46, d24 = 0.78;
	static double d31 = 2.46, d32 = 0.05, d33 = 1.03, d34 = 0.12;
	static double d41 = 0.34, d42 = 0.56, d43 = 0.23, d44 = 0.14;
	static Double4x4 d = new Double4x4(d11, d12, d13, d14, d21, d22, d23, d24, d31, d32, d33, d34, d41, d42, d43, d44);

	static Int4x4 s1 = new Int4x4(1, 2, 3, 4, 2, 5, 6, 7, 3, 6, 8, 9, 4, 7, 9, 10);
	static Int4x4 s2 = new Int4x4(0, 1, 2, 3, -1, 0, 4, 5, -2, -4, 0, 6, -3, -5, -6, 0);

	static Int4x4 n1 = null;
	static Float4x4 n2 = null;
	static Double4x4 n3 = null;

	static Int4 vn1 = null;
	static Float4 vn2 = null;
	static Double4 vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Int4x4 + Int4x4
			Arguments.of(new Int4x4(a11+b11, a12+b12, a13+b13, a14+b14, a21+b21, a22+b22, a23+b23, a24+b24, a31+b31, a32+b32, a33+b33, a34+b34, a41+b41, a42+b42, a43+b43, a44+b44), a.plus(b)),
			//2. Int4x4 + Float4x4
			Arguments.of(new Float4x4(a11+c11, a12+c12, a13+c13, a14+c14, a21+c21, a22+c22, a23+c23, a24+c24, a31+c31, a32+c32, a33+c33, a34+c34, a41+c41, a42+c42, a43+c43, a44+c44), a.plus(c)),
			//3. Int4x4 + Double4x4
			Arguments.of(new Double4x4(a11+d11, a12+d12, a13+d13, a14+d14, a21+d21, a22+d22, a23+d23, a24+d24, a31+d31, a32+d32, a33+d33, a34+d34, a41+d41, a42+d42, a43+d43, a44+d44), a.plus(d)),
			//4. -Int4x4
			Arguments.of(new Int4x4(-a11, -a12, -a13, -a14, -a21, -a22, -a23, -a24, -a31, -a32, -a33, -a34, -a41, -a42, -a43, -a44), a.negative()),
			//5. Int4x4 - Int4x4
			Arguments.of(new Int4x4(a11-b11, a12-b12, a13-b13, a14-b14, a21-b21, a22-b22, a23-b23, a24-b24, a31-b31, a32-b32, a33-b33, a34-b34, a41-b41, a42-b42, a43-b43, a44-b44), a.minus(b)),
			//6. Int4x4 - Float4x4
			Arguments.of(new Float4x4(a11-c11, a12-c12, a13-c13, a14-c14, a21-c21, a22-c22, a23-c23, a24-c24, a31-c31, a32-c32, a33-c33, a34-c34, a41-c41, a42-c42, a43-c43, a44-c44), a.minus(c)),
			//7. Int4x4 - Double4x4
			Arguments.of(new Double4x4(a11-d11, a12-d12, a13-d13, a14-d14, a21-d21, a22-d22, a23-d23, a24-d24, a31-d31, a32-d32, a33-d33, a34-d34, a41-d41, a42-d42, a43-d43, a44-d44), a.minus(d)),
			//8. Int4x4 * int
			Arguments.of(new Int4x4(a11*2, a12*2, a13*2, a14*2, a21*2, a22*2, a23*2, a24*2, a31*2, a32*2, a33*2, a34*2, a41*2, a42*2, a43*2, a44*2), a.multipliedBy(2)),
			//9. Int4x4 * float
			Arguments.of(new Float4x4(a11*2.0f, a12*2.0f, a13*2.0f, a14*2.0f, a21*2.0f, a22*2.0f, a23*2.0f, a24*2.0f, a31*2.0f, a32*2.0f, a33*2.0f, a34*2.0f, a41*2.0f, a42*2.0f, a43*2.0f, a44*2.0f), a.multipliedBy(2.0f)),
			//10. Int4x4 * double
			Arguments.of(new Double4x4(a11*2.0, a12*2.0, a13*2.0, a14*2.0, a21*2.0, a22*2.0, a23*2.0, a24*2.0, a31*2.0, a32*2.0, a33*2.0, a34*2.0, a41*2.0, a42*2.0, a43*2.0, a44*2.0), a.multipliedBy(2.0)),
			//11. Row1
			Arguments.of(new Int4(a11, a12, a13, a14), a.row1()),
			//12. Row2
			Arguments.of(new Int4(a21, a22, a23, a24), a.row2()),
			//13. Row3
			Arguments.of(new Int4(a31, a32, a33, a34), a.row3()),
			//14. Row4
			Arguments.of(new Int4(a41, a42, a43, a44), a.row4()),
			//15. Column1
			Arguments.of(new Int4(a11, a21, a31, a41), a.column1()),
			//16. Column2
			Arguments.of(new Int4(a12, a22, a32, a42), a.column2()),
			//17. Column3
			Arguments.of(new Int4(a13, a23, a33, a43), a.column3()),
			//18. Column4
			Arguments.of(new Int4(a14, a24, a34, a44), a.column4()),
			//19. Int4x4 * Int4
			Arguments.of(new Int4(a11*1+a12*2+a13*3+a14*4, a21*1+a22*2+a23*3+a24*4, a31*1+a32*2+a33*3+a34*4, a41*1+a42*2+a43*3+a44*4), a.multiply(new Int4(1, 2, 3, 4))),
			//20. Int4x4 * Float4
			Arguments.of(new Float4(a11*1.0f+a12*2.0f+a13*3.0f+a14*4.0f, a21*1.0f+a22*2.0f+a23*3.0f+a24*4.0f, a31*1.0f+a32*2.0f+a33*3.0f+a34*4.0f, a41*1.0f+a42*2.0f+a43*3.0f+a44*4.0f), a.multiply(new Float4(1.0f, 2.0f, 3.0f, 4.0f))),
			//21. Int4x4 * Double4
			Arguments.of(new Double4(a11*1.0+a12*2.0+a13*3.0+a14*4.0, a21*1.0+a22*2.0+a23*3.0+a24*4.0, a31*1.0+a32*2.0+a33*3.0+a34*4.0, a41*1.0+a42*2.0+a43*3.0+a44*4.0), a.multiply(new Double4(1.0, 2.0, 3.0, 4.0))),
			//22. Int4x4 ^ T
			Arguments.of(new Int4x4(a11, a21, a31, a41, a12, a22, a32, a42, a13, a23, a33, a43, a14, a24, a34, a44), a.transposed()),
			//23. Int4x4 == Int4x4 ^ T
			Arguments.of(true, s1.isSymmetric()),
			//24. Int4x4 != Int4x4 ^ T
			Arguments.of(false, a.isSymmetric()),
			//25. Int4x4 == -(Int4x4 ^ T)
			Arguments.of(true, s2.isSkewSymmetric()),
			//26. Int4x4 != -(Int4x4 ^ T)
			Arguments.of(false, a.isSkewSymmetric()),
			//27. Int4x4 * Int4x4
			Arguments.of(new Int4x4(a.row1().dotProduct(b.column1()), a.row1().dotProduct(b.column2()), a.row1().dotProduct(b.column3()), a.row1().dotProduct(b.column4()), a.row2().dotProduct(b.column1()), a.row2().dotProduct(b.column2()), a.row2().dotProduct(b.column3()), a.row2().dotProduct(b.column4()), a.row3().dotProduct(b.column1()), a.row3().dotProduct(b.column2()), a.row3().dotProduct(b.column3()), a.row3().dotProduct(b.column4()), a.row4().dotProduct(b.column1()), a.row4().dotProduct(b.column2()), a.row4().dotProduct(b.column3()), a.row4().dotProduct(b.column4())), a.multiply(b)),
			//28. Int4x4 * Float4x4
			Arguments.of(new Float4x4(a.row1().dotProduct(c.column1()), a.row1().dotProduct(c.column2()), a.row1().dotProduct(c.column3()), a.row1().dotProduct(c.column4()), a.row2().dotProduct(c.column1()), a.row2().dotProduct(c.column2()), a.row2().dotProduct(c.column3()), a.row2().dotProduct(c.column4()), a.row3().dotProduct(c.column1()), a.row3().dotProduct(c.column2()), a.row3().dotProduct(c.column3()), a.row3().dotProduct(c.column4()), a.row4().dotProduct(c.column1()), a.row4().dotProduct(c.column2()), a.row4().dotProduct(c.column3()), a.row4().dotProduct(c.column4())), a.multiply(c)),
			//29. Int4x4 * Double4x4
			Arguments.of(new Double4x4(a.row1().dotProduct(d.column1()), a.row1().dotProduct(d.column2()), a.row1().dotProduct(d.column3()), a.row1().dotProduct(d.column4()), a.row2().dotProduct(d.column1()), a.row2().dotProduct(d.column2()), a.row2().dotProduct(d.column3()), a.row2().dotProduct(d.column4()), a.row3().dotProduct(d.column1()), a.row3().dotProduct(d.column2()), a.row3().dotProduct(d.column3()), a.row3().dotProduct(d.column4()), a.row4().dotProduct(d.column1()), a.row4().dotProduct(d.column2()), a.row4().dotProduct(d.column3()), a.row4().dotProduct(d.column4())), a.multiply(d)),
			//30. Int4x4 ^ int
			Arguments.of(a.multiply(a).multiply(a), a.power(3))
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testNullValuesSource() {
		return Stream.of(
			//1. Int4x4 + null (Int4x4)
			Arguments.of((Executable) () -> a.plus(n1)),
			//2. Int4x4 + null (Float4x4)
			Arguments.of((Executable) () -> a.plus(n2)),
			//3. Int4x4 + null (Double4x4)
			Arguments.of((Executable) () -> a.plus(n3)),
			//4. Int4x4 - null (Int4x4)
			Arguments.of((Executable) () -> a.minus(n1)),
			//5. Int4x4 - null (Float4x4)
			Arguments.of((Executable) () -> a.minus(n2)),
			//6. Int4x4 - null (Double4x4)
			Arguments.of((Executable) () -> a.minus(n3)),
			//7. Int4x4 * null (Int4)
			Arguments.of((Executable) () -> a.multiply(vn1)),
			//8. Int4x4 * null (Float4)
			Arguments.of((Executable) () -> a.multiply(vn2)),
			//9. Int4x4 * null (Double4)
			Arguments.of((Executable) () -> a.multiply(vn3)),
			//10. Int4x4 * null (Int4x4)
			Arguments.of((Executable) () -> a.multiply(n1)),
			//11. Int4x4 * null (Float4x4)
			Arguments.of((Executable) () -> a.multiply(n2)),
			//12. Int4x4 * null (Double4x4)
			Arguments.of((Executable) () -> a.multiply(n3))
		);
	}

	@ParameterizedTest
	@MethodSource("testNullValuesSource")
	void testNullValues(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
