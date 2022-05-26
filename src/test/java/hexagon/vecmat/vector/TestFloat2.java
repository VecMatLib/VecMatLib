package hexagon.vecmat.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestFloat2 {

	static float x1 = 1.1f, y1 = 0.5f;
	static float x2 = 0.7f, y2 = 1.4f;
	static Float2 v1 = new Float2(x1, y1);
	static Float2 v2 = new Float2(x2, y2);

	static int x3 = 1, y3 = 2;
	static Int2 v3 = new Int2(x3, y3);

	static double x4 = 0.67, y4 = 1.23;
	static Double2 v4 = new Double2(x4, y4);

	static Float2 vn1 = null;
	static Int2 vn2 = null;
	static Double2 vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Float2 + Float2
			Arguments.of(new Float2(x1 + x2, y1 + y2), v1.plus(v2)),
			//2. Float2 + (float, float)
			Arguments.of(new Float2(x1 + x2, y1 + y2), v1.plus(x2, y2)),
			//3. Float2 + null (Float2)
			Arguments.of(v1, v1.plus(vn1)),
			//4. Float2 + Int2
			Arguments.of(new Float2(x1 + x3, y1 + y3), v1.plus(v3)),
			//5. Float2 + null (Int2)
			Arguments.of(v1, v1.plus(vn2)),
			//6. Float2 + Double2
			Arguments.of(new Double2(x1 + x4, y1 + y4), v1.plus(v4)),
			//7. Float2 + (double, double)
			Arguments.of(new Double2(x1 + x4, y1 + y4), v1.plus(x4, y4)),
			//8. Float2 + null (Double2)
			Arguments.of(v1.asDouble(), v1.plus(vn3)),
			//9. -Float2
			Arguments.of(new Float2(-x1, -y1), v1.negated()),
			//10. Float2 - Float2
			Arguments.of(new Float2(x1 - x2, y1 - y2), v1.minus(v2)),
			//11. Float2 - (float, float)
			Arguments.of(new Float2(x1 - x2, y1 - y2), v1.minus(x2, y2)),
			//12. Float2 - null (Float2)
			Arguments.of(v1, v1.minus(vn1)),
			//13. Float2 - Int2
			Arguments.of(new Float2(x1 - x3, y1 - y3), v1.minus(v3)),
			//14. Float2 - null (Int2)
			Arguments.of(v1, v1.minus(vn2)),
			//15. Float2 - Double2
			Arguments.of(new Double2(x1 - x4, y1 - y4), v1.minus(v4)),
			//16. Float2 - (double, double)
			Arguments.of(new Double2(x1 - x4, y1 - y4), v1.minus(x4, y4)),
			//17. Float2 - null (Double2)
			Arguments.of(v1.asDouble(), v1.minus(vn3)),
			//18. Float2 * (float)
			Arguments.of(new Float2(x1 * 1.5f, y1 * 1.5f), v1.multipliedBy(1.5f)),
			//19. Float2 / (float)
			Arguments.of(new Float2(x1 / 1.5f, y1 / 1.5f), v1.dividedBy(1.5f)),
			//20. Float2 * (double)
			Arguments.of(new Double2(x1 * 1.25, y1 * 1.25), v1.multipliedBy(1.25)),
			//21. Float2 / (double)
			Arguments.of(new Double2(x1 / 1.25, y1 / 1.25), v1.dividedBy(1.25)),
			//22. Float2 * Float2
			Arguments.of(x1 * x2 + y1 * y2, v1.dotProduct(v2)),
			//23. Float2 * (float, float)
			Arguments.of(x1 * x2 + y1 * y2, v1.dotProduct(x2, y2)),
			//24. Float2 * null (Float2)
			Arguments.of(0.0f, v1.dotProduct(vn1)),
			//25. Float2 * Int2
			Arguments.of(x1 * x3 + y1 * y3, v1.dotProduct(v3)),
			//26. Float2 * null (Int2)
			Arguments.of(0.0f, v1.dotProduct(vn2)),
			//27. Float2 * Double2
			Arguments.of(x1 * x4 + y1 * y4, v1.dotProduct(v4)),
			//28. Float2 * (double, double)
			Arguments.of(x1 * x4 + y1 * y4, v1.dotProduct(x4, y4)),
			//29. Float2 * null (Double2)
			Arguments.of(0.0, v1.dotProduct(vn3)),
			//30. |Float2|^2
			Arguments.of(2.0f, Float2.ONE.lengthSquared()),
			//31. |Float2|
			Arguments.of(Math.sqrt(2), Float2.ONE.length()),
			//32. ||Float2||
			Arguments.of(new Double2(1 / Math.sqrt(2), 1 / Math.sqrt(2)), Float2.ONE.normalized()),
			//33. Float2 ^ Float2
			Arguments.of(Math.toRadians(90.0), Float2.UP.angle(Float2.RIGHT)),
			//34. Float2 ^ null (Float2)
			Arguments.of(Double.NaN, Float2.UP.angle(vn1)),
			//35. Float2 ^ Double2
			Arguments.of(Math.toRadians(90.0), Float2.UP.angle(Double2.RIGHT)),
			//36. Float2 ^ null (Double2)
			Arguments.of(Double.NaN, Float2.UP.angle(vn3)),
			//37. Float2 ^ (double, double)
			Arguments.of(Math.toRadians(90.0), Float2.UP.angle(1.0, 0.0))
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}
}
