package io.github.vecmatlib.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestDouble2 {

	static double x1 = 1.12, y1 = 0.57;
	static double x2 = 0.73, y2 = 1.46;
	static Double2 v1 = new Double2(x1, y1);
	static Double2 v2 = new Double2(x2, y2);

	static float x3 = 0.6f, y3 = 1.2f;
	static Float2 v3 = new Float2(x3, y3);

	static Double2 vn1 = null;
	static Float2 vn2 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Double2 + Double2
			Arguments.of(new Double2(x1 + x2, y1 + y2), v1.plus(v2)),
			//2. Double2 + (double, double)
			Arguments.of(new Double2(x1 + x2, y1 + y2), v1.plus(x2, y2)),
			//3. Double2 + Float2
			Arguments.of(new Double2(x1 + x3, y1 + y3), v1.plus(v3)),
			//4. -Double2
			Arguments.of(new Double2(-x1, -y1), v1.negated()),
			//5. Double2 - Double2
			Arguments.of(new Double2(x1 - x2, y1 - y2), v1.minus(v2)),
			//6. Double2 - (double, double)
			Arguments.of(new Double2(x1 - x2, y1 - y2), v1.minus(x2, y2)),
			//7. Double2 - Float2
			Arguments.of(new Double2(x1 - x3, y1 - y3), v1.minus(v3)),
			//8. Double2 * (double)
			Arguments.of(new Double2(x1 * 1.25, y1 * 1.25), v1.multipliedBy(1.25)),
			//9. Double2 / (double)
			Arguments.of(new Double2(x1 / 1.25, y1 / 1.25), v1.dividedBy(1.25)),
			//10. Double2 * Double2
			Arguments.of(x1 * x2 + y1 * y2, v1.dotProduct(v2)),
			//11. Double2 * (double, double)
			Arguments.of(x1 * x2 + y1 * y2, v1.dotProduct(x2, y2)),
			//12. Double2 * Float2
			Arguments.of(x1 * x3 + y1 * y3, v1.dotProduct(v3)),
			//13. |Double2|^2
			Arguments.of(2.0, Double2.ONE.lengthSquared()),
			//14. |Double2|
			Arguments.of(Math.sqrt(2), Double2.ONE.length()),
			//15. ||Double2||
			Arguments.of(new Double2(1 / Math.sqrt(2), 1 / Math.sqrt(2)), Double2.ONE.normalized()),
			//16. Double2 ^ Double2
			Arguments.of(Math.toRadians(90.0), Double2.UP.angle(Double2.RIGHT)),
			//17. Double2 ^ Double2
			Arguments.of(Math.toRadians(90.0), Double2.UP.angle(Double2.RIGHT)),
			//18. Double2 ^ (double, double)
			Arguments.of(Math.toRadians(90.0), Double2.UP.angle(1.0, 0.0))
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testExceptionsSource() {
		return Stream.of(
			//1. Double2 + null (Double2)
			Arguments.of((Executable) () -> v1.plus(vn1)),
			//2. Double2 + null (Float2)
			Arguments.of((Executable) () -> v1.plus(vn2)),
			//3. Double2 - null (Double2)
			Arguments.of((Executable) () -> v1.minus(vn1)),
			//4. Double2 - null (Float2)
			Arguments.of((Executable) () -> v1.minus(vn2)),
			//5. Double2 * null (Double2)
			Arguments.of((Executable) () -> v1.dotProduct(vn1)),
			//6. Double2 * null (Float2)
			Arguments.of((Executable) () -> v1.dotProduct(vn2)),
			//7. Double2 ^ null (Double2)
			Arguments.of((Executable) () -> Double2.UP.angle(vn1)),
			//8. Double2 ^ null (Float2)
			Arguments.of((Executable) () -> Double2.UP.angle(vn2))
		);
	}

	@ParameterizedTest
	@MethodSource("testExceptionsSource")
	void testExceptions(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
