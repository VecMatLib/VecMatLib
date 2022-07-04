package io.github.vecmatlib.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestInt4 {

	static int x1 = 1, y1 = 3, z1 = 2, w1 = 0;
	static int x2 = 2, y2 = 4, z2 = 3, w2 = 5;
	static Int4 v1 = new Int4(x1, y1, z1, w1);
	static Int4 v2 = new Int4(x2, y2, z2, w2);

	static float x3 = 0.5f, y3 = 1.2f, z3 = 1.8f, w3 = 2.4f;
	static Float4 v3 = new Float4(x3, y3, z3, w3);

	static double x4 = 0.67, y4 = 1.23, z4 = 1.67, w4 = 0.09;
	static Double4 v4 = new Double4(x4, y4, z4, w4);

	static Int4 vn1 = null;
	static Float4 vn2 = null;
	static Double4 vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Int4 + Int4
			Arguments.of(new Int4(x1 + x2, y1 + y2, z1 + z2, w1 + w2), v1.plus(v2)),
			//2. Int4 + (int, int, int, int)
			Arguments.of(new Int4(x1 + x2, y1 + y2, z1 + z2, w1 + w2), v1.plus(x2, y2, z2, w2)),
			//3. Int4 + Float4
			Arguments.of(new Float4(x1 + x3, y1 + y3, z1 + z3, w1 + w3), v1.plus(v3)),
			//4. Int4 + (float, float, float, float)
			Arguments.of(new Float4(x1 + x3, y1 + y3, z1 + z3, w1 + w3), v1.plus(x3, y3, z3, w3)),
			//5. Int4 + Double4
			Arguments.of(new Double4(x1 + x4, y1 + y4, z1 + z4, w1 + w4), v1.plus(v4)),
			//6. Int4 + (double, double, double, double)
			Arguments.of(new Double4(x1 + x4, y1 + y4, z1 + z4, w1 + w4), v1.plus(x4, y4, z4, w4)),
			//7. -Int4
			Arguments.of(new Int4(-x1, -y1, -z1, -w1), v1.negated()),
			//8. Int4 - Int4
			Arguments.of(new Int4(x1 - x2, y1 - y2, z1 - z2, w1 - w2), v1.minus(v2)),
			//9. Int4 - (int, int, int, int)
			Arguments.of(new Int4(x1 - x2, y1 - y2, z1 - z2, w1 - w2), v1.minus(x2, y2, z2, w2)),
			//10. Int4 - Float4
			Arguments.of(new Float4(x1 - x3, y1 - y3, z1 - z3, w1 - w3), v1.minus(v3)),
			//11. Int4 - (float, float, float, float)
			Arguments.of(new Float4(x1 - x3, y1 - y3, z1 - z3, w1 - w3), v1.minus(x3, y3, z3, w3)),
			//12. Int4 - Double4
			Arguments.of(new Double4(x1 - x4, y1 - y4, z1 - z4, w1 - w4), v1.minus(v4)),
			//13. Int4 - (double, double, double, double)
			Arguments.of(new Double4(x1 - x4, y1 - y4, z1 - z4, w1 - w4), v1.minus(x4, y4, z4, w4)),
			//14. Int4 * (int)
			Arguments.of(new Int4(x1 * 2, y1 * 2, z1 * 2, w1 * 2), v1.multipliedBy(2)),
			//15. Int4 / (int)
			Arguments.of(new Int4(x1 / 2, y1 / 2, z1 / 2, w1 / 2), v1.dividedBy(2)),
			//16. Int4 * (float)
			Arguments.of(new Float4(x1 * 2.0f, y1 * 2.0f, z1 * 2.0f, w1 * 2.0f), v1.multipliedBy(2.0f)),
			//17. Int4 / (float)
			Arguments.of(new Float4(x1 / 2.0f, y1 / 2.0f, z1 / 2.0f, w1 / 2.0f), v1.dividedBy(2.0f)),
			//18. Int4 * (double)
			Arguments.of(new Double4(x1 * 1.25, y1 * 1.25, z1 * 1.25, w1 * 1.25), v1.multipliedBy(1.25)),
			//19. Int4 / (double)
			Arguments.of(new Double4(x1 / 1.25, y1 / 1.25, z1 / 1.25, w1 / 1.25), v1.dividedBy(1.25)),
			//20. Int4 * Int4
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2, v1.dotProduct(v2)),
			//21. Int4 * (int, int, int)
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2, v1.dotProduct(x2, y2, z2, w2)),
			//22. Int4 * Float4
			Arguments.of(x1 * x3 + y1 * y3 + z1 * z3 + w1 * w3, v1.dotProduct(v3)),
			//23. Int4 * (float, float, float, float)
			Arguments.of(x1 * x3 + y1 * y3 + z1 * z3 + w1 * w3, v1.dotProduct(x3, y3, z3, w3)),
			//24. Int4 * Double4
			Arguments.of(x1 * x4 + y1 * y4 + z1 * z4 + w1 * w4, v1.dotProduct(v4)),
			//25. Int4 * (double, double, double, double)
			Arguments.of(x1 * x4 + y1 * y4 + z1 * z4 + w1 * w4, v1.dotProduct(x4, y4, z4, w4)),
			//26. |Int4|^2
			Arguments.of(4, Int4.ONE.lengthSquared()),
			//27. |Int4|
			Arguments.of(Math.sqrt(4), Int4.ONE.length()),
			//28. ||Int4||
			Arguments.of(new Double4(1 / Math.sqrt(4), 1 / Math.sqrt(4), 1 / Math.sqrt(4), 1 / Math.sqrt(4)), Int4.ONE.normalized())
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testExceptionsSource() {
		return Stream.of(
			//1. Int4 + null (Int4)
			Arguments.of((Executable) () -> v1.plus(vn1)),
			//2. Int4 + null (Float4)
			Arguments.of((Executable) () -> v1.plus(vn2)),
			//3. Int4 + null (Double4)
			Arguments.of((Executable) () -> v1.plus(vn3)),
			//4. Int4 - null (Int4)
			Arguments.of((Executable) () -> v1.minus(vn1)),
			//5. Int4 - null (Float4)
			Arguments.of((Executable) () -> v1.minus(vn2)),
			//6. Int4 - null (Double4)
			Arguments.of((Executable) () -> v1.minus(vn3)),
			//7. Int4 * null (Int4)
			Arguments.of((Executable) () -> v1.dotProduct(vn1)),
			//8. Int4 * null (Float4)
			Arguments.of((Executable) () -> v1.dotProduct(vn2)),
			//9. Int4 * null (Double4)
			Arguments.of((Executable) () -> v1.dotProduct(vn3))
		);
	}

	@ParameterizedTest
	@MethodSource("testExceptionsSource")
	void testExceptions(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
