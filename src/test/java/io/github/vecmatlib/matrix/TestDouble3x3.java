package io.github.vecmatlib.matrix;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import io.github.vecmatlib.vector.Double3;
import io.github.vecmatlib.vector.Float3;

public class TestDouble3x3 {

	static double a11 = 1.24, a12 = 0.56, a13 = 0.25;
	static double a21 = 0.73, a22 = 1.62, a23 = 0.44;
	static double a31 = 2.41, a32 = 0.03, a33 = 1.08;
	static Double3x3 a = new Double3x3(a11, a12, a13, a21, a22, a23, a31, a32, a33);

	static double b11 = 0.61, b12 = 1.21, b13 = 0.93;
	static double b21 = 0.34, b22 = 0.74, b23 = 0.25;
	static double b31 = 1.46, b32 = 2.58, b33 = 1.69;
	static Double3x3 b = new Double3x3(b11, b12, b13, b21, b22, b23, b31, b32, b33);

	static float c11 = 1.2f, c12 = 0.5f, c13 = 0.2f;
	static float c21 = 0.7f, c22 = 1.6f, c23 = 0.4f;
	static float c31 = 2.4f, c32 = 0.0f, c33 = 1.0f;
	static Float3x3 c = new Float3x3(c11, c12, c13, c21, c22, c23, c31, c32, c33);

	static Double3x3 s1 = new Double3x3(1.0, 2.0, 3.0, 2.0, 4.0, 5.0, 3.0, 5.0, 6.0);
	static Double3x3 s2 = new Double3x3(0.0, 1.0, 2.0, -1.0, 0.0, 3.0, -2.0, -3.0, 0.0);

	static Double3x3 n1 = null;
	static Float3x3 n2 = null;

	static Double3 vn1 = null;
	static Float3 vn2 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Double3x3 + Double3x3
			Arguments.of(new Double3x3(a11+b11, a12+b12, a13+b13, a21+b21, a22+b22, a23+b23, a31+b31, a32+b32, a33+b33), a.plus(b)),
			//2. Double3x3 + Float3x3
			Arguments.of(new Double3x3(a11+c11, a12+c12, a13+c13, a21+c21, a22+c22, a23+c23, a31+c31, a32+c32, a33+c33), a.plus(c)),
			//3. -Double3x3
			Arguments.of(new Double3x3(-a11, -a12, -a13, -a21, -a22, -a23, -a31, -a32, -a33), a.negative()),
			//4. Double3x3 - Double3x3
			Arguments.of(new Double3x3(a11-b11, a12-b12, a13-b13, a21-b21, a22-b22, a23-b23, a31-b31, a32-b32, a33-b33), a.minus(b)),
			//5. Double3x3 - Float3x3
			Arguments.of(new Double3x3(a11-c11, a12-c12, a13-c13, a21-c21, a22-c22, a23-c23, a31-c31, a32-c32, a33-c33), a.minus(c)),
			//6. Double3x3 * double
			Arguments.of(new Double3x3(a11*2.0, a12*2.0, a13*2.0, a21*2.0, a22*2.0, a23*2.0, a31*2.0, a32*2.0, a33*2.0), a.multipliedBy(2.0)),
			//7. Row1
			Arguments.of(new Double3(a11, a12, a13), a.row1()),
			//8. Row2
			Arguments.of(new Double3(a21, a22, a23), a.row2()),
			//9. Row3
			Arguments.of(new Double3(a31, a32, a33), a.row3()),
			//10. Column1
			Arguments.of(new Double3(a11, a21, a31), a.column1()),
			//11. Column2
			Arguments.of(new Double3(a12, a22, a32), a.column2()),
			//12. Column3
			Arguments.of(new Double3(a13, a23, a33), a.column3()),
			//13. Double3x3 * Double3
			Arguments.of(new Double3(a11*1.0+a12*2.0+a13*3.0, a21*1.0+a22*2.0+a23*3.0, a31*1.0+a32*2.0+a33*3.0), a.multiply(new Double3(1.0, 2.0, 3.0))),
			//14. Double3x3 * Float3
			Arguments.of(new Double3(a11*1.0f+a12*2.0f+a13*3.0f, a21*1.0f+a22*2.0f+a23*3.0f, a31*1.0f+a32*2.0f+a33*3.0f), a.multiply(new Float3(1.0f, 2.0f, 3.0f))),
			//15. Double3x3 ^ T
			Arguments.of(new Double3x3(a11, a21, a31, a12, a22, a32, a13, a23, a33), a.transposed()),
			//16. Double3x3 == Double3x3 ^ T
			Arguments.of(true, s1.isSymmetric()),
			//17. Double3x3 != Double3x3 ^ T
			Arguments.of(false, a.isSymmetric()),
			//18. Double3x3 == -(Double3x3 ^ T)
			Arguments.of(true, s2.isSkewSymmetric()),
			//19. Double3x3 != -(Double3x3 ^ T)
			Arguments.of(false, a.isSkewSymmetric()),
			//20. Double3x3 * Double3x3
			Arguments.of(new Double3x3(a.row1().dotProduct(b.column1()), a.row1().dotProduct(b.column2()), a.row1().dotProduct(b.column3()), a.row2().dotProduct(b.column1()), a.row2().dotProduct(b.column2()), a.row2().dotProduct(b.column3()), a.row3().dotProduct(b.column1()), a.row3().dotProduct(b.column2()), a.row3().dotProduct(b.column3())), a.multiply(b)),
			//21. Double3x3 * Float3x3
			Arguments.of(new Double3x3(a.row1().dotProduct(c.column1()), a.row1().dotProduct(c.column2()), a.row1().dotProduct(c.column3()), a.row2().dotProduct(c.column1()), a.row2().dotProduct(c.column2()), a.row2().dotProduct(c.column3()), a.row3().dotProduct(c.column1()), a.row3().dotProduct(c.column2()), a.row3().dotProduct(c.column3())), a.multiply(c)),
			//22. Double3x3 ^ int
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
			//1. Double3x3 + null (Double3x3)
			Arguments.of((Executable) () -> a.plus(n1)),
			//2. Double3x3 + null (Float3x3)
			Arguments.of((Executable) () -> a.plus(n2)),
			//3. Double3x3 - null (Double3x3)
			Arguments.of((Executable) () -> a.minus(n1)),
			//4. Double3x3 - null (Float3x3)
			Arguments.of((Executable) () -> a.minus(n2)),
			//5. Double3x3 * null (Double3)
			Arguments.of((Executable) () -> a.multiply(vn1)),
			//6. Double3x3 * null (Float3)
			Arguments.of((Executable) () -> a.multiply(vn2)),
			//7. Double3x3 * null (Double3x3)
			Arguments.of((Executable) () -> a.multiply(n1)),
			//8. Double3x3 * null (Float3x3)
			Arguments.of((Executable) () -> a.multiply(n2))
		);
	}

	@ParameterizedTest
	@MethodSource("testNullValuesSource")
	void testNullValues(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
