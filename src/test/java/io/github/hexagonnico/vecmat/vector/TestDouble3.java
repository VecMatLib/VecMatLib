package io.github.hexagonnico.vecmat.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestDouble3 {

	static double x1 = 1.12, y1 = 0.57, z1 = 0.04;
	static double x2 = 0.73, y2 = 1.46, z2 = 2.31;
	static Double3 v1 = new Double3(x1, y1, z1);
	static Double3 v2 = new Double3(x2, y2, z2);

	static float x3 = 0.6f, y3 = 1.2f, z3 = 1.7f;
	static Float3 v3 = new Float3(x3, y3, z3);

	static Double3 vn1 = null;
	static Float3 vn2 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Double3 + Double3
			Arguments.of(new Double3(x1 + x2, y1 + y2, z1 + z2), v1.plus(v2)),
			//2. Double3 + (double, double, double)
			Arguments.of(new Double3(x1 + x2, y1 + y2, z1 + z2), v1.plus(x2, y2, z2)),
			//3. Double3 + Float3
			Arguments.of(new Double3(x1 + x3, y1 + y3, z1 + z3), v1.plus(v3)),
			//4. -Double3
			Arguments.of(new Double3(-x1, -y1, -z1), v1.negated()),
			//5. Double3 - Double3
			Arguments.of(new Double3(x1 - x2, y1 - y2, z1 - z2), v1.minus(v2)),
			//6. Double3 - (double, double, double)
			Arguments.of(new Double3(x1 - x2, y1 - y2, z1 - z2), v1.minus(x2, y2, z2)),
			//7. Double3 - Float3
			Arguments.of(new Double3(x1 - x3, y1 - y3, z1 - z3), v1.minus(v3)),
			//8. Double3 * (double)
			Arguments.of(new Double3(x1 * 1.25, y1 * 1.25, z1 * 1.25), v1.multipliedBy(1.25)),
			//9. Double3 / (double)
			Arguments.of(new Double3(x1 / 1.25, y1 / 1.25, z1 / 1.25), v1.dividedBy(1.25)),
			//10. Double3 * Double3
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2, v1.dotProduct(v2)),
			//11. Double3 * (double, double, double)
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2, v1.dotProduct(x2, y2, z2)),
			//12. Double3 * Float3
			Arguments.of(x1 * x3 + y1 * y3 + z1 * z3, v1.dotProduct(v3)),
			//13. Double3 X Double3
			Arguments.of(new Double3(y1 * z2 - z1 * y2, x2 * z1 - z2 * x1, x1 * y2 - y1 * x2), v1.crossProduct(v2)),
			//14. Double3 X (double, double, double)
			Arguments.of(new Double3(y1 * z2 - z1 * y2, x2 * z1 - z2 * x1, x1 * y2 - y1 * x2), v1.crossProduct(x2, y2, z2)),
			//15. Double3 X Float3
			Arguments.of(new Double3(y1 * z3 - z1 * y3, x3 * z1 - z3 * x1, x1 * y3 - y1 * x3), v1.crossProduct(v3)),
			//16. |Double3|^2
			Arguments.of(3.0, Double3.ONE.lengthSquared()),
			//17. |Double3|
			Arguments.of(Math.sqrt(3), Double3.ONE.length()),
			//18. ||Double3||
			Arguments.of(new Double3(1 / Math.sqrt(3), 1 / Math.sqrt(3), 1 / Math.sqrt(3)), Double3.ONE.normalized()),
			//19. Double3 ^ Double3
			Arguments.of(Math.toRadians(90.0), Double3.UP.angle(Double3.FORWARD)),
			//20. Double3 ^ Double3
			Arguments.of(Math.toRadians(90.0), Double3.UP.angle(Double3.FORWARD)),
			//21. Double3 ^ (double, double, double)
			Arguments.of(Math.toRadians(90.0), Double3.UP.angle(0.0, 0.0, 1.0))
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testExceptionsSource() {
		return Stream.of(
			//1. Double3 + null (Double3)
			Arguments.of((Executable) () -> v1.plus(vn1)),
			//2. Double3 + null (Float3)
			Arguments.of((Executable) () -> v1.plus(vn2)),
			//3. Double3 - null (Double3)
			Arguments.of((Executable) () -> v1.minus(vn1)),
			//4. Double3 - null (Float3)
			Arguments.of((Executable) () -> v1.minus(vn2)),
			//5. Double3 * null (Double3)
			Arguments.of((Executable) () -> v1.dotProduct(vn1)),
			//6. Double3 * null (Float3)
			Arguments.of((Executable) () -> v1.dotProduct(vn2)),
			//7. Double3 X null (Double3)
			Arguments.of((Executable) () -> v1.crossProduct(vn1)),
			//8. Double3 X null (Float3)
			Arguments.of((Executable) () -> v1.crossProduct(vn2)),
			//9. Double3 ^ null (Double3)
			Arguments.of((Executable) () -> Double3.UP.angle(vn1)),
			//10. Double3 ^ null (Float3)
			Arguments.of((Executable) () -> Double3.UP.angle(vn2))
		);
	}

	@ParameterizedTest
	@MethodSource("testExceptionsSource")
	void testExceptions(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
