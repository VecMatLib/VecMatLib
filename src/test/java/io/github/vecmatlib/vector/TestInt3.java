package io.github.vecmatlib.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import io.github.vecmatlib.vector.Double3;
import io.github.vecmatlib.vector.Float3;
import io.github.vecmatlib.vector.Int3;

public class TestInt3 {

	static int x1 = 1, y1 = 3, z1 = 2;
	static int x2 = 2, y2 = 4, z2 = 3;
	static Int3 v1 = new Int3(x1, y1, z1);
	static Int3 v2 = new Int3(x2, y2, z2);

	static float x3 = 0.5f, y3 = 1.2f, z3 = 1.8f;
	static Float3 v3 = new Float3(x3, y3, z3);

	static double x4 = 0.67, y4 = 1.23, z4 = 1.67;
	static Double3 v4 = new Double3(x4, y4, z4);

	static Int3 vn1 = null;
	static Float3 vn2 = null;
	static Double3 vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Int3 + Int3
			Arguments.of(new Int3(x1 + x2, y1 + y2, z1 + z2), v1.plus(v2)),
			//2. Int3 + (int, int, int)
			Arguments.of(new Int3(x1 + x2, y1 + y2, z1 + z2), v1.plus(x2, y2, z2)),
			//3. Int3 + Float3
			Arguments.of(new Float3(x1 + x3, y1 + y3, z1 + z3), v1.plus(v3)),
			//4. Int3 + (float, float, float)
			Arguments.of(new Float3(x1 + x3, y1 + y3, z1 + z3), v1.plus(x3, y3, z3)),
			//5. Int3 + Double3
			Arguments.of(new Double3(x1 + x4, y1 + y4, z1 + z4), v1.plus(v4)),
			//6. Int3 + (double, double, double)
			Arguments.of(new Double3(x1 + x4, y1 + y4, z1 + z4), v1.plus(x4, y4, z4)),
			//7. -Int3
			Arguments.of(new Int3(-x1, -y1, -z1), v1.negated()),
			//8. Int3 - Int3
			Arguments.of(new Int3(x1 - x2, y1 - y2, z1 - z2), v1.minus(v2)),
			//9. Int3 - (int, int, int)
			Arguments.of(new Int3(x1 - x2, y1 - y2, z1 - z2), v1.minus(x2, y2, z2)),
			//10. Int3 - Float3
			Arguments.of(new Float3(x1 - x3, y1 - y3, z1 - z3), v1.minus(v3)),
			//11. Int3 - (float, float, float)
			Arguments.of(new Float3(x1 - x3, y1 - y3, z1 - z3), v1.minus(x3, y3, z3)),
			//12. Int3 - Double3
			Arguments.of(new Double3(x1 - x4, y1 - y4, z1 - z4), v1.minus(v4)),
			//13. Int3 - (double, double, double)
			Arguments.of(new Double3(x1 - x4, y1 - y4, z1 - z4), v1.minus(x4, y4, z4)),
			//14. Int3 * (int)
			Arguments.of(new Int3(x1 * 2, y1 * 2, z1 * 2), v1.multipliedBy(2)),
			//15. Int3 / (int)
			Arguments.of(new Int3(x1 / 2, y1 / 2, z1 / 2), v1.dividedBy(2)),
			//16. Int3 * (float)
			Arguments.of(new Float3(x1 * 2.0f, y1 * 2.0f, z1 * 2.0f), v1.multipliedBy(2.0f)),
			//17. Int3 / (float)
			Arguments.of(new Float3(x1 / 2.0f, y1 / 2.0f, z1 / 2.0f), v1.dividedBy(2.0f)),
			//18. Int3 * (double)
			Arguments.of(new Double3(x1 * 1.25, y1 * 1.25, z1 * 1.25), v1.multipliedBy(1.25)),
			//19. Int3 / (double)
			Arguments.of(new Double3(x1 / 1.25, y1 / 1.25, z1 / 1.25), v1.dividedBy(1.25)),
			//20. Int3 * Int3
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2, v1.dotProduct(v2)),
			//21. Int3 * (int, int, int)
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2, v1.dotProduct(x2, y2, z2)),
			//22. Int3 * Float3
			Arguments.of(x1 * x3 + y1 * y3 + z1 * z3, v1.dotProduct(v3)),
			//23. Int3 * (float, float, float)
			Arguments.of(x1 * x3 + y1 * y3 + z1 * z3, v1.dotProduct(x3, y3, z3)),
			//24. Int3 * Double3
			Arguments.of(x1 * x4 + y1 * y4 + z1 * z4, v1.dotProduct(v4)),
			//25. Int3 * (double, double, double)
			Arguments.of(x1 * x4 + y1 * y4 + z1 * z4, v1.dotProduct(x4, y4, z4)),
			//26. Int3 X Int3
			Arguments.of(new Int3(y1 * z2 - z1 * y2, x2 * z1 - z2 * x1, x1 * y2 - y1 * x2), v1.crossProduct(v2)),
			//27. Int3 X (int, int, int)
			Arguments.of(new Int3(y1 * z2 - z1 * y2, x2 * z1 - z2 * x1, x1 * y2 - y1 * x2), v1.crossProduct(x2, y2, z2)),
			//28. Int3 X Float3
			Arguments.of(new Float3(y1 * z3 - z1 * y3, x3 * z1 - z3 * x1, x1 * y3 - y1 * x3), v1.crossProduct(v3)),
			//29. Int3 X (float, float, float)
			Arguments.of(new Float3(y1 * z3 - z1 * y3, x3 * z1 - z3 * x1, x1 * y3 - y1 * x3), v1.crossProduct(x3, y3, z3)),
			//30. Int3 X Double3
			Arguments.of(new Double3(y1 * z4 - z1 * y4, x4 * z1 - z4 * x1, x1 * y4 - y1 * x4), v1.crossProduct(v4)),
			//31. Int3 X (double, double, double)
			Arguments.of(new Double3(y1 * z4 - z1 * y4, x4 * z1 - z4 * x1, x1 * y4 - y1 * x4), v1.crossProduct(x4, y4, z4)),
			//32. |Int3|^2
			Arguments.of(3, Int3.ONE.lengthSquared()),
			//33. |Int3|
			Arguments.of(Math.sqrt(3), Int3.ONE.length()),
			//34. ||Int3||
			Arguments.of(new Double3(1 / Math.sqrt(3), 1 / Math.sqrt(3), 1 / Math.sqrt(3)), Int3.ONE.normalized()),
			//35. Int3 ^ Int3
			Arguments.of(Math.toRadians(90.0), Int3.UP.angle(Int3.FORWARD)),
			//36. Int3 ^ Float3
			Arguments.of(Math.toRadians(90.0), Int3.UP.angle(Float3.FORWARD)),
			//37. Int3 ^ Double3
			Arguments.of(Math.toRadians(90.0), Int3.UP.angle(Double3.FORWARD)),
			//38. Int3 ^ (double, double)
			Arguments.of(Math.toRadians(90.0), Int3.UP.angle(0.0, 0.0, 1.0))
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testExceptionsSource() {
		return Stream.of(
			//1. Int3 + null (Int3)
			Arguments.of((Executable) () -> v1.plus(vn1)),
			//2. Int3 + null (Float3)
			Arguments.of((Executable) () -> v1.plus(vn2)),
			//3. Int3 + null (Double3)
			Arguments.of((Executable) () -> v1.plus(vn3)),
			//4. Int3 - null (Int3)
			Arguments.of((Executable) () -> v1.minus(vn1)),
			//5. Int3 - null (Float3)
			Arguments.of((Executable) () -> v1.minus(vn2)),
			//6. Int3 - null (Double3)
			Arguments.of((Executable) () -> v1.minus(vn3)),
			//7. Int3 * null (Int3)
			Arguments.of((Executable) () -> v1.dotProduct(vn1)),
			//8. Int3 * null (Float3)
			Arguments.of((Executable) () -> v1.dotProduct(vn2)),
			//9. Int3 * null (Double3)
			Arguments.of((Executable) () -> v1.dotProduct(vn3)),
			//10. Int3 X null (Int3)
			Arguments.of((Executable) () -> v1.crossProduct(vn1)),
			//11. Int3 X null (Float3)
			Arguments.of((Executable) () -> v1.crossProduct(vn2)),
			//12. Int3 X null (Double3)
			Arguments.of((Executable) () -> v1.crossProduct(vn3)),
			//13. Int3 ^ null (Int3)
			Arguments.of((Executable) () -> Int3.UP.angle(vn1)),
			//14. Int3 ^ null (Float3)
			Arguments.of((Executable) () -> Int3.UP.angle(vn2)),
			//15. Int3 ^ null (Double3)
			Arguments.of((Executable) () -> Int3.UP.angle(vn3))
		);
	}

	@ParameterizedTest
	@MethodSource("testExceptionsSource")
	void testExceptions(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
