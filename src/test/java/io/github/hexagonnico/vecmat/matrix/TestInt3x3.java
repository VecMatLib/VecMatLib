package io.github.hexagonnico.vecmat.matrix;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import io.github.hexagonnico.vecmat.vector.Double3;
import io.github.hexagonnico.vecmat.vector.Float3;
import io.github.hexagonnico.vecmat.vector.Int3;

public class TestInt3x3 {

	static int a11 = 1, a12 = 5, a13 = 2;
	static int a21 = 7, a22 = 6, a23 = 4;
	static int a31 = 2, a32 = 0, a33 = 1;
	static Int3x3 a = new Int3x3(a11, a12, a13, a21, a22, a23, a31, a32, a33);

	static int b11 = 6, b12 = 2, b13 = 9;
	static int b21 = 3, b22 = 7, b23 = 1;
	static int b31 = 4, b32 = 5, b33 = 0;
	static Int3x3 b = new Int3x3(b11, b12, b13, b21, b22, b23, b31, b32, b33);

	static float c11 = 1.1f, c12 = 2.3f, c13 = 3.6f;
	static float c21 = 1.3f, c22 = 0.5f, c23 = 2.1f;
	static float c31 = 2.8f, c32 = 0.1f, c33 = 0.9f;
	static Float3x3 c = new Float3x3(c11, c12, c13, c21, c22, c23, c31, c32, c33);

	static double d11 = 1.23, d12 = 0.52, d13 = 0.21;
	static double d21 = 0.77, d22 = 1.69, d23 = 0.46;
	static double d31 = 2.46, d32 = 0.05, d33 = 1.03;
	static Double3x3 d = new Double3x3(d11, d12, d13, d21, d22, d23, d31, d32, d33);

	static Int3x3 s1 = new Int3x3(1, 2, 3, 2, 4, 5, 3, 5, 6);
	static Int3x3 s2 = new Int3x3(0, 1, 2, -1, 0, 3, -2, -3, 0);

	static Int3x3 n1 = null;
	static Float3x3 n2 = null;
	static Double3x3 n3 = null;

	static Int3 vn1 = null;
	static Float3 vn2 = null;
	static Double3 vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Int3x3 + Int3x3
			Arguments.of(new Int3x3(a11+b11, a12+b12, a13+b13, a21+b21, a22+b22, a23+b23, a31+b31, a32+b32, a33+b33), a.plus(b)),
			//2. Int3x3 + Float3x3
			Arguments.of(new Float3x3(a11+c11, a12+c12, a13+c13, a21+c21, a22+c22, a23+c23, a31+c31, a32+c32, a33+c33), a.plus(c)),
			//3. Int3x3 + Double3x3
			Arguments.of(new Double3x3(a11+d11, a12+d12, a13+d13, a21+d21, a22+d22, a23+d23, a31+d31, a32+d32, a33+d33), a.plus(d)),
			//4. -Int3x3
			Arguments.of(new Int3x3(-a11, -a12, -a13, -a21, -a22, -a23, -a31, -a32, -a33), a.negative()),
			//5. Int3x3 - Int3x3
			Arguments.of(new Int3x3(a11-b11, a12-b12, a13-b13, a21-b21, a22-b22, a23-b23, a31-b31, a32-b32, a33-b33), a.minus(b)),
			//6. Int3x3 - Float3x3
			Arguments.of(new Float3x3(a11-c11, a12-c12, a13-c13, a21-c21, a22-c22, a23-c23, a31-c31, a32-c32, a33-c33), a.minus(c)),
			//7. Int3x3 - Double3x3
			Arguments.of(new Double3x3(a11-d11, a12-d12, a13-d13, a21-d21, a22-d22, a23-d23, a31-d31, a32-d32, a33-d33), a.minus(d)),
			//8. Int3x3 * int
			Arguments.of(new Int3x3(a11*2, a12*2, a13*2, a21*2, a22*2, a23*2, a31*2, a32*2, a33*2), a.multipliedBy(2)),
			//9. Int3x3 * float
			Arguments.of(new Float3x3(a11*2.0f, a12*2.0f, a13*2.0f, a21*2.0f, a22*2.0f, a23*2.0f, a31*2.0f, a32*2.0f, a33*2.0f), a.multipliedBy(2.0f)),
			//10. Int3x3 * double
			Arguments.of(new Double3x3(a11*2.0, a12*2.0, a13*2.0, a21*2.0, a22*2.0, a23*2.0, a31*2.0, a32*2.0, a33*2.0), a.multipliedBy(2.0)),
			//11. Row1
			Arguments.of(new Int3(a11, a12, a13), a.row1()),
			//12. Row2
			Arguments.of(new Int3(a21, a22, a23), a.row2()),
			//13. Row3
			Arguments.of(new Int3(a31, a32, a33), a.row3()),
			//14. Column1
			Arguments.of(new Int3(a11, a21, a31), a.column1()),
			//15. Column2
			Arguments.of(new Int3(a12, a22, a32), a.column2()),
			//16. Column3
			Arguments.of(new Int3(a13, a23, a33), a.column3()),
			//17. Int3x3 * Int3
			Arguments.of(new Int3(a11*1+a12*2+a13*3, a21*1+a22*2+a23*3, a31*1+a32*2+a33*3), a.multiply(new Int3(1, 2, 3))),
			//18. Int3x3 * Float3
			Arguments.of(new Float3(a11*1.0f+a12*2.0f+a13*3.0f, a21*1.0f+a22*2.0f+a23*3.0f, a31*1.0f+a32*2.0f+a33*3.0f), a.multiply(new Float3(1.0f, 2.0f, 3.0f))),
			//19. Int3x3 * Double3
			Arguments.of(new Double3(a11*1.0+a12*2.0+a13*3.0, a21*1.0+a22*2.0+a23*3.0, a31*1.0+a32*2.0+a33*3.0), a.multiply(new Double3(1.0, 2.0, 3.0))),
			//20. Int3x3 ^ T
			Arguments.of(new Int3x3(a11, a21, a31, a12, a22, a32, a13, a23, a33), a.transposed()),
			//21. Int3x3 == Int3x3 ^ T
			Arguments.of(true, s1.isSymmetric()),
			//22. Int3x3 != Int3x3 ^ T
			Arguments.of(false, a.isSymmetric()),
			//23. Int3x3 == -(Int3x3 ^ T)
			Arguments.of(true, s2.isSkewSymmetric()),
			//24. Int3x3 != -(Int3x3 ^ T)
			Arguments.of(false, a.isSkewSymmetric()),
			//25. Int3x3 * Int3x3
			Arguments.of(new Int3x3(a.row1().dotProduct(b.column1()), a.row1().dotProduct(b.column2()), a.row1().dotProduct(b.column3()), a.row2().dotProduct(b.column1()), a.row2().dotProduct(b.column2()), a.row2().dotProduct(b.column3()), a.row3().dotProduct(b.column1()), a.row3().dotProduct(b.column2()), a.row3().dotProduct(b.column3())), a.multiply(b)),
			//26. Int3x3 * Float3x3
			Arguments.of(new Float3x3(a.row1().dotProduct(c.column1()), a.row1().dotProduct(c.column2()), a.row1().dotProduct(c.column3()), a.row2().dotProduct(c.column1()), a.row2().dotProduct(c.column2()), a.row2().dotProduct(c.column3()), a.row3().dotProduct(c.column1()), a.row3().dotProduct(c.column2()), a.row3().dotProduct(c.column3())), a.multiply(c)),
			//27. Int3x3 * Double3x3
			Arguments.of(new Double3x3(a.row1().dotProduct(d.column1()), a.row1().dotProduct(d.column2()), a.row1().dotProduct(d.column3()), a.row2().dotProduct(d.column1()), a.row2().dotProduct(d.column2()), a.row2().dotProduct(d.column3()), a.row3().dotProduct(d.column1()), a.row3().dotProduct(d.column2()), a.row3().dotProduct(d.column3())), a.multiply(d)),
			//28. Int3x3 ^ int
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
			//1. Int3x3 + null (Int3x3)
			Arguments.of((Executable) () -> a.plus(n1)),
			//2. Int3x3 + null (Float3x3)
			Arguments.of((Executable) () -> a.plus(n2)),
			//3. Int3x3 + null (Double3x3)
			Arguments.of((Executable) () -> a.plus(n3)),
			//4. Int3x3 - null (Int3x3)
			Arguments.of((Executable) () -> a.minus(n1)),
			//5. Int3x3 - null (Float3x3)
			Arguments.of((Executable) () -> a.minus(n2)),
			//6. Int3x3 - null (Double3x3)
			Arguments.of((Executable) () -> a.minus(n3)),
			//7. Int3x3 * null (Int3)
			Arguments.of((Executable) () -> a.multiply(vn1)),
			//8. Int3x3 * null (Float3)
			Arguments.of((Executable) () -> a.multiply(vn2)),
			//9. Int3x3 * null (Double3)
			Arguments.of((Executable) () -> a.multiply(vn3)),
			//10. Int3x3 * null (Int3x3)
			Arguments.of((Executable) () -> a.multiply(n1)),
			//11. Int3x3 * null (Float3x3)
			Arguments.of((Executable) () -> a.multiply(n2)),
			//12. Int3x3 * null (Double3x3)
			Arguments.of((Executable) () -> a.multiply(n3))
		);
	}

	@ParameterizedTest
	@MethodSource("testNullValuesSource")
	void testNullValues(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
