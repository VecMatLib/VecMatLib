package io.github.hexagonnico.vecmat.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestInt2 {

	static int x1 = 1, y1 = 3;
	static int x2 = 2, y2 = 4;
	static Int2 v1 = new Int2(x1, y1);
	static Int2 v2 = new Int2(x2, y2);

	static float x3 = 0.5f, y3 = 1.2f;
	static Float2 v3 = new Float2(x3, y3);

	static double x4 = 0.67, y4 = 1.23;
	static Double2 v4 = new Double2(x4, y4);

	static Int2 vn1 = null;
	static Float2 vn2 = null;
	static Double2 vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Int2 + Int2
			Arguments.of(new Int2(x1 + x2, y1 + y2), v1.plus(v2)),
			//2. Int2 + (int, int)
			Arguments.of(new Int2(x1 + x2, y1 + y2), v1.plus(x2, y2)),
			//3. Int2 + Float2
			Arguments.of(new Float2(x1 + x3, y1 + y3), v1.plus(v3)),
			//4. Int2 + (float, float)
			Arguments.of(new Float2(x1 + x3, y1 + y3), v1.plus(x3, y3)),
			//5. Int2 + Double2
			Arguments.of(new Double2(x1 + x4, y1 + y4), v1.plus(v4)),
			//6. Int2 + (double, double)
			Arguments.of(new Double2(x1 + x4, y1 + y4), v1.plus(x4, y4)),
			//7. -Int2
			Arguments.of(new Int2(-x1, -y1), v1.negated()),
			//8. Int2 - Int2
			Arguments.of(new Int2(x1 - x2, y1 - y2), v1.minus(v2)),
			//9. Int2 - (int, int)
			Arguments.of(new Int2(x1 - x2, y1 - y2), v1.minus(x2, y2)),
			//10. Int2 - Float2
			Arguments.of(new Float2(x1 - x3, y1 - y3), v1.minus(v3)),
			//11. Int2 - (float, float)
			Arguments.of(new Float2(x1 - x3, y1 - y3), v1.minus(x3, y3)),
			//12. Int2 - Double2
			Arguments.of(new Double2(x1 - x4, y1 - y4), v1.minus(v4)),
			//13. Int2 - (double, double)
			Arguments.of(new Double2(x1 - x4, y1 - y4), v1.minus(x4, y4)),
			//14. Int2 * (int)
			Arguments.of(new Int2(x1 * 2, y1 * 2), v1.multipliedBy(2)),
			//15. Int2 / (int)
			Arguments.of(new Int2(x1 / 2, y1 / 2), v1.dividedBy(2)),
			//16. Int2 * (float)
			Arguments.of(new Float2(x1 * 2.0f, y1 * 2.0f), v1.multipliedBy(2.0f)),
			//17. Int2 / (float)
			Arguments.of(new Float2(x1 / 2.0f, y1 / 2.0f), v1.dividedBy(2.0f)),
			//18. Int2 * (double)
			Arguments.of(new Double2(x1 * 1.25, y1 * 1.25), v1.multipliedBy(1.25)),
			//19. Int2 / (double)
			Arguments.of(new Double2(x1 / 1.25, y1 / 1.25), v1.dividedBy(1.25)),
			//20. Int2 * Int2
			Arguments.of(x1 * x2 + y1 * y2, v1.dotProduct(v2)),
			//21. Int2 * (int, int)
			Arguments.of(x1 * x2 + y1 * y2, v1.dotProduct(x2, y2)),
			//22. Int2 * Float2
			Arguments.of(x1 * x3 + y1 * y3, v1.dotProduct(v3)),
			//23. Int2 * (float, float)
			Arguments.of(x1 * x3 + y1 * y3, v1.dotProduct(x3, y3)),
			//24. Int2 * Double2
			Arguments.of(x1 * x4 + y1 * y4, v1.dotProduct(v4)),
			//25. Int2 * (double, double)
			Arguments.of(x1 * x4 + y1 * y4, v1.dotProduct(x4, y4)),
			//26. |Int2|^2
			Arguments.of(2, Int2.ONE.lengthSquared()),
			//27. |Int2|
			Arguments.of(Math.sqrt(2), Int2.ONE.length()),
			//28. ||Int2||
			Arguments.of(new Double2(1 / Math.sqrt(2), 1 / Math.sqrt(2)), Int2.ONE.normalized()),
			//29. Int2 ^ Int2
			Arguments.of(Math.toRadians(90.0), Int2.UP.angle(Int2.RIGHT)),
			//30. Int2 ^ Float2
			Arguments.of(Math.toRadians(90.0), Int2.UP.angle(Float2.RIGHT)),
			//31. Int2 ^ Double2
			Arguments.of(Math.toRadians(90.0), Int2.UP.angle(Double2.RIGHT)),
			//32. Int2 ^ (double, double)
			Arguments.of(Math.toRadians(90.0), Int2.UP.angle(1.0, 0.0))
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testExceptionsSource() {
		return Stream.of(
			//1. Int2 + null (Int2)
			Arguments.of((Executable) () -> v1.plus(vn1)),
			//2. Int2 + null (Float2)
			Arguments.of((Executable) () -> v1.plus(vn2)),
			//3. Int2 + null (Double2)
			Arguments.of((Executable) () -> v1.plus(vn3)),
			//4. Int2 - null (Int2)
			Arguments.of((Executable) () -> v1.minus(vn1)),
			//5. Int2 - null (Float2)
			Arguments.of((Executable) () -> v1.minus(vn2)),
			//6. Int2 - null (Double2)
			Arguments.of((Executable) () -> v1.minus(vn3)),
			//7. Int2 * null (Int2)
			Arguments.of((Executable) () -> v1.dotProduct(vn1)),
			//8. Int2 * null (Float2)
			Arguments.of((Executable) () -> v1.dotProduct(vn2)),
			//9. Int2 * null (Double2)
			Arguments.of((Executable) () -> v1.dotProduct(vn3)),
			//10. Int2 ^ null (Int2)
			Arguments.of((Executable) () -> Int2.UP.angle(vn1)),
			//11. Int2 ^ null (Float2)
			Arguments.of((Executable) () -> Int2.UP.angle(vn2)),
			//12. Int2 ^ null (Double2)
			Arguments.of((Executable) () -> Int2.UP.angle(vn3))
		);
	}

	@ParameterizedTest
	@MethodSource("testExceptionsSource")
	void testExceptions(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
