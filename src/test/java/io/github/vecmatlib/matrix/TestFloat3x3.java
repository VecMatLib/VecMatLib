package io.github.vecmatlib.matrix;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import io.github.vecmatlib.matrix.Double3x3;
import io.github.vecmatlib.matrix.Float3x3;
import io.github.vecmatlib.matrix.Int3x3;
import io.github.vecmatlib.vector.Double3;
import io.github.vecmatlib.vector.Float3;
import io.github.vecmatlib.vector.Int3;

public class TestFloat3x3 {

	static float a11 = 1.2f, a12 = 0.5f, a13 = 0.2f;
	static float a21 = 0.7f, a22 = 1.6f, a23 = 0.4f;
	static float a31 = 2.4f, a32 = 0.0f, a33 = 1.0f;
	static Float3x3 a = new Float3x3(a11, a12, a13, a21, a22, a23, a31, a32, a33);

	static float b11 = 0.6f, b12 = 1.2f, b13 = 0.9f;
	static float b21 = 0.3f, b22 = 0.7f, b23 = 0.1f;
	static float b31 = 1.4f, b32 = 2.5f, b33 = 1.6f;
	static Float3x3 b = new Float3x3(b11, b12, b13, b21, b22, b23, b31, b32, b33);

	static int c11 = 1, c12 = 2, c13 = 3;
	static int c21 = 4, c22 = 5, c23 = 6;
	static int c31 = 7, c32 = 8, c33 = 9;
	static Int3x3 c = new Int3x3(c11, c12, c13, c21, c22, c23, c31, c32, c33);

	static double d11 = 1.23, d12 = 0.52, d13 = 0.21;
	static double d21 = 0.77, d22 = 1.69, d23 = 0.46;
	static double d31 = 2.46, d32 = 0.05, d33 = 1.03;
	static Double3x3 d = new Double3x3(d11, d12, d13, d21, d22, d23, d31, d32, d33);

	static Float3x3 s1 = new Float3x3(1.0f, 2.0f, 3.0f, 2.0f, 4.0f, 5.0f, 3.0f, 5.0f, 6.0f);
	static Float3x3 s2 = new Float3x3(0.0f, 1.0f, 2.0f, -1.0f, 0.0f, 3.0f, -2.0f, -3.0f, 0.0f);

	static Float3x3 n1 = null;
	static Int3x3 n2 = null;
	static Double3x3 n3 = null;

	static Float3 vn1 = null;
	static Int3 vn2 = null;
	static Double3 vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Float3x3 + Float3x3
			Arguments.of(new Float3x3(a11+b11, a12+b12, a13+b13, a21+b21, a22+b22, a23+b23, a31+b31, a32+b32, a33+b33), a.plus(b)),
			//2. Float3x3 + Int3x3
			Arguments.of(new Float3x3(a11+c11, a12+c12, a13+c13, a21+c21, a22+c22, a23+c23, a31+c31, a32+c32, a33+c33), a.plus(c)),
			//3. Float3x3 + Double3x3
			Arguments.of(new Double3x3(a11+d11, a12+d12, a13+d13, a21+d21, a22+d22, a23+d23, a31+d31, a32+d32, a33+d33), a.plus(d)),
			//4. -Float3x3
			Arguments.of(new Float3x3(-a11, -a12, -a13, -a21, -a22, -a23, -a31, -a32, -a33), a.negative()),
			//5. Float3x3 - Float3x3
			Arguments.of(new Float3x3(a11-b11, a12-b12, a13-b13, a21-b21, a22-b22, a23-b23, a31-b31, a32-b32, a33-b33), a.minus(b)),
			//6. Float3x3 - Int3x3
			Arguments.of(new Float3x3(a11-c11, a12-c12, a13-c13, a21-c21, a22-c22, a23-c23, a31-c31, a32-c32, a33-c33), a.minus(c)),
			//7. Float3x3 - Double3x3
			Arguments.of(new Double3x3(a11-d11, a12-d12, a13-d13, a21-d21, a22-d22, a23-d23, a31-d31, a32-d32, a33-d33), a.minus(d)),
			//8. Float3x3 * float
			Arguments.of(new Float3x3(a11*2.0f, a12*2.0f, a13*2.0f, a21*2.0f, a22*2.0f, a23*2.0f, a31*2.0f, a32*2.0f, a33*2.0f), a.multipliedBy(2.0f)),
			//9. Float3x3 * double
			Arguments.of(new Double3x3(a11*2.0, a12*2.0, a13*2.0, a21*2.0, a22*2.0, a23*2.0, a31*2.0, a32*2.0, a33*2.0), a.multipliedBy(2.0)),
			//10. Row1
			Arguments.of(new Float3(a11, a12, a13), a.row1()),
			//11. Row2
			Arguments.of(new Float3(a21, a22, a23), a.row2()),
			//12. Row3
			Arguments.of(new Float3(a31, a32, a33), a.row3()),
			//13. Column1
			Arguments.of(new Float3(a11, a21, a31), a.column1()),
			//14. Column2
			Arguments.of(new Float3(a12, a22, a32), a.column2()),
			//15. Column3
			Arguments.of(new Float3(a13, a23, a33), a.column3()),
			//16. Float3x3 * Float3
			Arguments.of(new Float3(a11*1.0f+a12*2.0f+a13*3.0f, a21*1.0f+a22*2.0f+a23*3.0f, a31*1.0f+a32*2.0f+a33*3.0f), a.multiply(new Float3(1.0f, 2.0f, 3.0f))),
			//17. Float3x3 * Int3
			Arguments.of(new Float3(a11*1+a12*2+a13*3, a21*1+a22*2+a23*3, a31*1+a32*2+a33*3), a.multiply(new Int3(1, 2, 3))),
			//18. Float3x3 * Double3
			Arguments.of(new Double3(a11*1.0+a12*2.0+a13*3.0, a21*1.0+a22*2.0+a23*3.0, a31*1.0+a32*2.0+a33*3.0), a.multiply(new Double3(1.0, 2.0, 3.0))),
			//19. Float3x3 ^ T
			Arguments.of(new Float3x3(a11, a21, a31, a12, a22, a32, a13, a23, a33), a.transposed()),
			//20. Float3x3 == Float3x3 ^ T
			Arguments.of(true, s1.isSymmetric()),
			//21. Float3x3 != Float3x3 ^ T
			Arguments.of(false, a.isSymmetric()),
			//22. Float3x3 == -(Float3x3 ^ T)
			Arguments.of(true, s2.isSkewSymmetric()),
			//23. Float3x3 != -(Float3x3 ^ T)
			Arguments.of(false, a.isSkewSymmetric()),
			//24. Float3x3 * Float3x3
			Arguments.of(new Float3x3(a.row1().dotProduct(b.column1()), a.row1().dotProduct(b.column2()), a.row1().dotProduct(b.column3()), a.row2().dotProduct(b.column1()), a.row2().dotProduct(b.column2()), a.row2().dotProduct(b.column3()), a.row3().dotProduct(b.column1()), a.row3().dotProduct(b.column2()), a.row3().dotProduct(b.column3())), a.multiply(b)),
			//25. Float3x3 * Int3x3
			Arguments.of(new Float3x3(a.row1().dotProduct(c.column1()), a.row1().dotProduct(c.column2()), a.row1().dotProduct(c.column3()), a.row2().dotProduct(c.column1()), a.row2().dotProduct(c.column2()), a.row2().dotProduct(c.column3()), a.row3().dotProduct(c.column1()), a.row3().dotProduct(c.column2()), a.row3().dotProduct(c.column3())), a.multiply(c)),
			//26. Float3x3 * Double3x3
			Arguments.of(new Double3x3(a.row1().dotProduct(d.column1()), a.row1().dotProduct(d.column2()), a.row1().dotProduct(d.column3()), a.row2().dotProduct(d.column1()), a.row2().dotProduct(d.column2()), a.row2().dotProduct(d.column3()), a.row3().dotProduct(d.column1()), a.row3().dotProduct(d.column2()), a.row3().dotProduct(d.column3())), a.multiply(d)),
			//27. Float3x3 ^ int
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
			//1. Float3x3 + null (Float3x3)
			Arguments.of((Executable) () -> a.plus(n1)),
			//2. Float3x3 + null (Int3x3)
			Arguments.of((Executable) () -> a.plus(n2)),
			//3. Float3x3 + null (Double3x3)
			Arguments.of((Executable) () -> a.plus(n3)),
			//4. Float3x3 - null (Float3x3)
			Arguments.of((Executable) () -> a.minus(n1)),
			//5. Float3x3 - null (Int3x3)
			Arguments.of((Executable) () -> a.minus(n2)),
			//6. Float3x3 - null (Double3x3)
			Arguments.of((Executable) () -> a.minus(n3)),
			//7. Float3x3 * null (Float4)
			Arguments.of((Executable) () -> a.multiply(vn1)),
			//8. Float3x3 * null (Int4)
			Arguments.of((Executable) () -> a.multiply(vn2)),
			//9. Float3x3 * null (Double4)
			Arguments.of((Executable) () -> a.multiply(vn3)),
			//10. Float3x3 * null (Float3x3)
			Arguments.of((Executable) () -> a.multiply(n1)),
			//11. Float3x3 * null (Int3x3)
			Arguments.of((Executable) () -> a.multiply(n2)),
			//12. Float3x3 * null (Double3x3)
			Arguments.of((Executable) () -> a.multiply(n3))
		);
	}

	@ParameterizedTest
	@MethodSource("testNullValuesSource")
	void testNullValues(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
