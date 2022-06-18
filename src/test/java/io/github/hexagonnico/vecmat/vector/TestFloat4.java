package io.github.hexagonnico.vecmat.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestFloat4 {

	static float x1 = 1.1f, y1 = 0.5f, z1 = 2.1f, w1 = 0.1f;
	static float x2 = 0.7f, y2 = 1.4f, z2 = 1.2f, w2 = 2.4f;
	static Float4 v1 = new Float4(x1, y1, z1, w1);
	static Float4 v2 = new Float4(x2, y2, z2, w2);

	static int x3 = 1, y3 = 2, z3 = 3, w3 = 4;
	static Int4 v3 = new Int4(x3, y3, z3, w3);

	static double x4 = 0.67, y4 = 1.23, z4 = 0.15, w4 = 0.98;
	static Double4 v4 = new Double4(x4, y4, z4, w4);

	static Float4 vn1 = null;
	static Int4 vn2 = null;
	static Double4 vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Float4 + Float4
			Arguments.of(new Float4(x1 + x2, y1 + y2, z1 + z2, w1 + w2), v1.plus(v2)),
			//2. Float4 + (float, float, float, float)
			Arguments.of(new Float4(x1 + x2, y1 + y2, z1 + z2, w1 + w2), v1.plus(x2, y2, z2, w2)),
			//3. Float4 + Int4
			Arguments.of(new Float4(x1 + x3, y1 + y3, z1 + z3, w1 + w3), v1.plus(v3)),
			//4. Float4 + Double4
			Arguments.of(new Double4(x1 + x4, y1 + y4, z1 + z4, w1 + w4), v1.plus(v4)),
			//5. Float4 + (double, double, double, double)
			Arguments.of(new Double4(x1 + x4, y1 + y4, z1 + z4, w1 + w4), v1.plus(x4, y4, z4, w4)),
			//6. -Float4
			Arguments.of(new Float4(-x1, -y1, -z1, -w1), v1.negated()),
			//7. Float4 - Float4
			Arguments.of(new Float4(x1 - x2, y1 - y2, z1 - z2, w1 - w2), v1.minus(v2)),
			//8. Float4 - (float, float, float, float)
			Arguments.of(new Float4(x1 - x2, y1 - y2, z1 - z2, w1 - w2), v1.minus(x2, y2, z2, w2)),
			//9. Float4 - Int4
			Arguments.of(new Float4(x1 - x3, y1 - y3, z1 - z3, w1 - w3), v1.minus(v3)),
			//10. Float4 - Double4
			Arguments.of(new Double4(x1 - x4, y1 - y4, z1 - z4, w1 - w4), v1.minus(v4)),
			//11. Float4 - (double, double, double, double)
			Arguments.of(new Double4(x1 - x4, y1 - y4, z1 - z4, w1 - w4), v1.minus(x4, y4, z4, w4)),
			//12. Float4 * (float)
			Arguments.of(new Float4(x1 * 1.5f, y1 * 1.5f, z1 * 1.5f, w1 * 1.5f), v1.multipliedBy(1.5f)),
			//13. Float4 / (float)
			Arguments.of(new Float4(x1 / 1.5f, y1 / 1.5f, z1 / 1.5f, w1 / 1.5f), v1.dividedBy(1.5f)),
			//14. Float4 * (double)
			Arguments.of(new Double4(x1 * 1.25, y1 * 1.25, z1 * 1.25, w1 * 1.25), v1.multipliedBy(1.25)),
			//15. Float4 / (double)
			Arguments.of(new Double4(x1 / 1.25, y1 / 1.25, z1 / 1.25, w1 / 1.25), v1.dividedBy(1.25)),
			//16. Float4 * Float4
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2, v1.dotProduct(v2)),
			//17. Float4 * (float, float, float, float)
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2, v1.dotProduct(x2, y2, z2, w2)),
			//18. Float4 * Int4
			Arguments.of(x1 * x3 + y1 * y3 + z1 * z3 + w1 * w3, v1.dotProduct(v3)),
			//19. Float4 * Double4
			Arguments.of(x1 * x4 + y1 * y4 + z1 * z4 + w1 * w4, v1.dotProduct(v4)),
			//20. Float4 * (double, double, double, double)
			Arguments.of(x1 * x4 + y1 * y4 + z1 * z4 + w1 * w4, v1.dotProduct(x4, y4, z4, w4)),
			//21. |Float4|^2
			Arguments.of(4.0f, Float4.ONE.lengthSquared()),
			//22. |Float4|
			Arguments.of(Math.sqrt(4), Float4.ONE.length()),
			//23. ||Float4||
			Arguments.of(new Double4(1 / Math.sqrt(4), 1 / Math.sqrt(4), 1 / Math.sqrt(4), 1 / Math.sqrt(4)), Float4.ONE.normalized())
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testExceptionsSource() {
		return Stream.of(
			//1. Float4 + null (Float4)
			Arguments.of((Executable) () -> v1.plus(vn1)),
			//2. Float4 + null (Int4)
			Arguments.of((Executable) () -> v1.plus(vn2)),
			//3. Float4 + null (Double4)
			Arguments.of((Executable) () -> v1.plus(vn3)),
			//4. Float4 - null (Float4)
			Arguments.of((Executable) () -> v1.minus(vn1)),
			//5. Float4 - null (Int4)
			Arguments.of((Executable) () -> v1.minus(vn2)),
			//6. Float4 - null (Double4)
			Arguments.of((Executable) () -> v1.minus(vn3)),
			//7. Float4 * null (Float4)
			Arguments.of((Executable) () -> v1.dotProduct(vn1)),
			//8. Float4 * null (Int4)
			Arguments.of((Executable) () -> v1.dotProduct(vn2)),
			//9. Float4 * null (Double4)
			Arguments.of((Executable) () -> v1.dotProduct(vn3))
		);
	}

	@ParameterizedTest
	@MethodSource("testExceptionsSource")
	void testExceptions(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
