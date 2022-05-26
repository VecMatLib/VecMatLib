package hexagon.vecmat.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestDouble4 {

	static double x1 = 1.12, y1 = 0.57, z1 = 0.04, w1 = 2.31;
	static double x2 = 0.73, y2 = 1.46, z2 = 2.31, w2 = 1.34;
	static Double4 v1 = new Double4(x1, y1, z1, w1);
	static Double4 v2 = new Double4(x2, y2, z2, w2);

	static float x3 = 0.6f, y3 = 1.2f, z3 = 1.7f, w3 = 2.1f;
	static Float4 v3 = new Float4(x3, y3, z3, w3);

	static Double4 vn1 = null;
	static Float4 vn2 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. Double4 + Double4
			Arguments.of(new Double4(x1 + x2, y1 + y2, z1 + z2, w1 + w2), v1.plus(v2)),
			//2. Double4 + (double, double, double, double)
			Arguments.of(new Double4(x1 + x2, y1 + y2, z1 + z2, w1 + w2), v1.plus(x2, y2, z2, w2)),
			//3. Double4 + null (Double4)
			Arguments.of(v1, v1.plus(vn1)),
			//4. Double4 + Float4
			Arguments.of(new Double4(x1 + x3, y1 + y3, z1 + z3, w1 + w3), v1.plus(v3)),
			//5. Double4 + null (Float4)
			Arguments.of(v1, v1.plus(vn2)),
			//6. -Double4
			Arguments.of(new Double4(-x1, -y1, -z1, -w1), v1.negated()),
			//7. Double4 - Double4
			Arguments.of(new Double4(x1 - x2, y1 - y2, z1 - z2, w1 - w2), v1.minus(v2)),
			//8. Double4 - (double, double, double, double)
			Arguments.of(new Double4(x1 - x2, y1 - y2, z1 - z2, w1 - w2), v1.minus(x2, y2, z2, w2)),
			//9. Double4 - null (Double4)
			Arguments.of(v1, v1.minus(vn1)),
			//10. Double4 - Float4
			Arguments.of(new Double4(x1 - x3, y1 - y3, z1 - z3, w1 - w3), v1.minus(v3)),
			//11. Double4 - null (Float4)
			Arguments.of(v1, v1.minus(vn2)),
			//12. Double4 * (double)
			Arguments.of(new Double4(x1 * 1.25, y1 * 1.25, z1 * 1.25, w1 * 1.25), v1.multipliedBy(1.25)),
			//13. Double4 / (double)
			Arguments.of(new Double4(x1 / 1.25, y1 / 1.25, z1 / 1.25, w1 / 1.25), v1.dividedBy(1.25)),
			//14. Double4 * Double4
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2, v1.dotProduct(v2)),
			//15. Double4 * (double, double, double, double)
			Arguments.of(x1 * x2 + y1 * y2 + z1 * z2 + w1 * w2, v1.dotProduct(x2, y2, z2, w2)),
			//16. Double4 * null (Double4)
			Arguments.of(0.0, v1.dotProduct(vn1)),
			//17. Double4 * Float4
			Arguments.of(x1 * x3 + y1 * y3 + z1 * z3 + w1 * w3, v1.dotProduct(v3)),
			//18. Double4 * null (Float4)
			Arguments.of(0.0, v1.dotProduct(vn2)),
			//19. |Double4|^2
			Arguments.of(4.0, Double4.ONE.lengthSquared()),
			//20. |Double4|
			Arguments.of(Math.sqrt(4), Double4.ONE.length()),
			//21. ||Double4||
			Arguments.of(new Double4(1 / Math.sqrt(4), 1 / Math.sqrt(4), 1 / Math.sqrt(4), 1 / Math.sqrt(4)), Double4.ONE.normalized())
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}
}
