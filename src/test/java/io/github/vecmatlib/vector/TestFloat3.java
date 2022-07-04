package io.github.vecmatlib.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestFloat3 {

	static float x1 = 1.1f, y1 = 0.5f, z1 = 2.1f;
	static float x2 = 0.7f, y2 = 1.4f, z2 = 1.2f;
	static Float3 v1 = new Float3(x1, y1, z1);
	static Float3 v2 = new Float3(x2, y2, z2);

	static int x3 = 1, y3 = 2, z3 = 3;
	static Int3 v3 = new Int3(x3, y3, z3);

	static double x4 = 0.67, y4 = 1.23, z4 = 0.15;
	static Double3 v4 = new Double3(x4, y4, z4);

	static Float3 vn1 = null;
	static Int3 vn2 = null;
	static Double3 vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Float3 + Float3
			Arguments.of(new Float3(x1 + x2, y1 + y2, z1 + z2), v1.plus(v2)),
			//2. Float3 + (float, float, float)
			Arguments.of(new Float3(x1 + x2, y1 + y2, z1 + z2), v1.plus(x2, y2, z2)),
			//3. Float3 + Int3
			Arguments.of(new Float3(x1 + x3, y1 + y3, z1 + z3), v1.plus(v3)),
			//4. Float3 + Double3
			Arguments.of(new Double3(x1 + x4, y1 + y4, z1 + z4), v1.plus(v4)),
			//5. Float3 + (double, double, double)
			Arguments.of(new Double3(x1 + x4, y1 + y4, z1 + z4), v1.plus(x4, y4, z4)),
			//6. -Float3
			Arguments.of(new Float3(-x1, -y1, -z1), v1.negated()),
			//7. Float3 - Float3
			Arguments.of(new Float3(x1 - x2, y1 - y2, z1 - z2), v1.minus(v2)),
			//8. Float3 - (float, float, float)
			Arguments.of(new Float3(x1 - x2, y1 - y2, z1 - z2), v1.minus(x2, y2, z2)),
			//9. Float3 - Int3
			Arguments.of(new Float3(x1 - x3, y1 - y3, z1 - z3), v1.minus(v3)),
			//10. Float3 - Double3
			Arguments.of(new Double3(x1 - x4, y1 - y4, z1 - z4), v1.minus(v4)),
			//11. Float3 - (double, double, double)
			Arguments.of(new Double3(x1 - x4, y1 - y4, z1 - z4), v1.minus(x4, y4, z4)),
			//12. Float3 * (float)
			Arguments.of(new Float3(x1 * 1.5f, y1 * 1.5f, z1 * 1.5f), v1.multipliedBy(1.5f)),
			//13. Float3 / (float)
			Arguments.of(new Float3(x1 / 1.5f, y1 / 1.5f, z1 / 1.5f), v1.dividedBy(1.5f)),
			//14. Float3 * (double)
			Arguments.of(new Double3(x1 * 1.25, y1 * 1.25, z1 * 1.25), v1.multipliedBy(1.25)),
			//15. Float3 / (double)
			Arguments.of(new Double3(x1 / 1.25, y1 / 1.25, z1 / 1.25), v1.dividedBy(1.25)),
			//16. Float3 * Float3
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2, v1.dotProduct(v2)),
			//17. Float3 * (float, float, float)
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2, v1.dotProduct(x2, y2, z2)),
			//18. Float3 * Int3
			Arguments.of(x1 * x3 + y1 * y3 + z1 * z3, v1.dotProduct(v3)),
			//19. Float3 * Double3
			Arguments.of(x1 * x4 + y1 * y4 + z1 * z4, v1.dotProduct(v4)),
			//20. Float3 * (double, double, double)
			Arguments.of(x1 * x4 + y1 * y4 + z1 * z4, v1.dotProduct(x4, y4, z4)),
			//21. Float3 X Float3
			Arguments.of(new Float3(y1 * z2 - z1 * y2, x2 * z1 - z2 * x1, x1 * y2 - y1 * x2), v1.crossProduct(v2)),
			//22. Float3 X (float, float, float)
			Arguments.of(new Float3(y1 * z2 - z1 * y2, x2 * z1 - z2 * x1, x1 * y2 - y1 * x2), v1.crossProduct(x2, y2, z2)),
			//23. Float3 X Int3
			Arguments.of(new Float3(y1 * z3 - z1 * y3, x3 * z1 - z3 * x1, x1 * y3 - y1 * x3), v1.crossProduct(v3)),
			//24. Float3 X Double3
			Arguments.of(new Double3(y1 * z4 - z1 * y4, x4 * z1 - z4 * x1, x1 * y4 - y1 * x4), v1.crossProduct(v4)),
			//25. Float3 X (double, double, double)
			Arguments.of(new Double3(y1 * z4 - z1 * y4, x4 * z1 - z4 * x1, x1 * y4 - y1 * x4), v1.crossProduct(x4, y4, z4)),
			//26. |Float3|^2
			Arguments.of(3.0f, Float3.ONE.lengthSquared()),
			//27. |Float3|
			Arguments.of(Math.sqrt(3), Float3.ONE.length()),
			//28. ||Float3||
			Arguments.of(new Double3(1 / Math.sqrt(3), 1 / Math.sqrt(3), 1 / Math.sqrt(3)), Float3.ONE.normalized()),
			//29. Float3 ^ Float3
			Arguments.of(Math.toRadians(90.0), Float3.UP.angle(Float3.FORWARD)),
			//30. Float3 ^ Double3
			Arguments.of(Math.toRadians(90.0), Float3.UP.angle(Double3.FORWARD)),
			//31. Float3 ^ (double, double, double)
			Arguments.of(Math.toRadians(90.0), Float3.UP.angle(0.0, 0.0, 1.0))
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testExceptionsSource() {
		return Stream.of(
			//1. Float3 + null (Float3)
			Arguments.of((Executable) () -> v1.plus(vn1)),
			//2. Float3 + null (Int3)
			Arguments.of((Executable) () -> v1.plus(vn2)),
			//3. Float3 + null (Double3)
			Arguments.of((Executable) () -> v1.plus(vn3)),
			//4. Float3 - null (Float3)
			Arguments.of((Executable) () -> v1.minus(vn1)),
			//5. Float3 - null (Int3)
			Arguments.of((Executable) () -> v1.minus(vn2)),
			//6. Float3 - null (Double3)
			Arguments.of((Executable) () -> v1.minus(vn3)),
			//7. Float3 * null (Float3)
			Arguments.of((Executable) () -> v1.dotProduct(vn1)),
			//8. Float3 * null (Int3)
			Arguments.of((Executable) () -> v1.dotProduct(vn2)),
			//9. Float3 * null (Double3)
			Arguments.of((Executable) () -> v1.dotProduct(vn3)),
			//10. Float3 X null (Float3)
			Arguments.of((Executable) () -> v1.crossProduct(vn1)),
			//11. Float3 X null (Int3)
			Arguments.of((Executable) () -> v1.crossProduct(vn2)),
			//12. Float3 X null (Double3)
			Arguments.of((Executable) () -> v1.crossProduct(vn3)),
			//13. Float3 ^ null (Float3)
			Arguments.of((Executable) () -> Float3.UP.angle(vn1)),
			//14. Float3 ^ null (Double3)
			Arguments.of((Executable) () -> Float3.UP.angle(vn3))
		);
	}

	@ParameterizedTest
	@MethodSource("testExceptionsSource")
	void testExceptions(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
