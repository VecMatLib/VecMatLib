package hexagon.vecmat.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestIntVector {

	static IntVector v1 = new IntVector(1, 5, 4, 2, 3, 6, 9);
	static IntVector v2 = new IntVector(2, 4, 3, 1, 5, 7, 8);

	static FloatVector v3 = new FloatVector(0.6f, 1.2f, 0.1f, 2.4f, 1.9f, 0.5f, 1.0f);

	static DoubleVector v4 = new DoubleVector(1.14, 3.12, 1.14, 5.67, 0.34, 1.56, 0.97);

	static IntVector vn1 = null;
	static FloatVector vn2 = null;
	static DoubleVector vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. IntVector + IntVector
			Arguments.of(new IntVector(1+2, 5+4, 4+3, 2+1, 3+5, 6+7, 9+8), v1.plus(v2)),
			//2. IntVector + null (IntVector)
			Arguments.of(v1, v1.plus(vn1)),
			//3. IntVector + FloatVector
			Arguments.of(new FloatVector(1+0.6f, 5+1.2f, 4+0.1f, 2+2.4f, 3+1.9f, 6+0.5f, 9+1.0f), v1.plus(v3)),
			//4. IntVector + null (FloatVector)
			Arguments.of(v1.asFloat(), v1.plus(vn2)),
			//5. IntVector + DoubleVector
			Arguments.of(new DoubleVector(1+1.14, 5+3.12, 4+1.14, 2+5.67, 3+0.34, 6+1.56, 9+0.97), v1.plus(v4)),
			//6. IntVector + null (DoubleVector)
			Arguments.of(v1.asDouble(), v1.plus(vn3)),
			//7. -IntVector
			Arguments.of(new IntVector(-1, -5, -4, -2, -3, -6, -9), v1.negated()),
			//8. IntVector - IntVector
			Arguments.of(new IntVector(1-2, 5-4, 4-3, 2-1, 3-5, 6-7, 9-8), v1.minus(v2)),
			//9. IntVector - null (IntVector)
			Arguments.of(v1, v1.minus(vn1)),
			//10. IntVector - FloatVector
			Arguments.of(new FloatVector(1-0.6f, 5-1.2f, 4-0.1f, 2-2.4f, 3-1.9f, 6-0.5f, 9-1.0f), v1.minus(v3)),
			//11. IntVector - null (FloatVector)
			Arguments.of(v1.asFloat(), v1.minus(vn2)),
			//12. IntVector - DoubleVector
			Arguments.of(new DoubleVector(1-1.14, 5-3.12, 4-1.14, 2-5.67, 3-0.34, 6-1.56, 9-0.97), v1.minus(v4)),
			//13. IntVector - null (DoubleVector)
			Arguments.of(v1.asDouble(), v1.minus(vn3)),
			//14. IntVector * (int)
			Arguments.of(new IntVector(1*2, 5*2, 4*2, 2*2, 3*2, 6*2, 9*2), v1.multipliedBy(2)),
			//15. IntVector / (int)
			Arguments.of(new IntVector(1/2, 5/2, 4/2, 2/2, 3/2, 6/2, 9/2), v1.dividedBy(2)),
			//16. IntVector * (float)
			Arguments.of(new FloatVector(1*1.5f, 5*1.5f, 4*1.5f, 2*1.5f, 3*1.5f, 6*1.5f, 9*1.5f), v1.multipliedBy(1.5f)),
			//17. IntVector / (float)
			Arguments.of(new FloatVector(1/2.0f, 5/2.0f, 4/2.0f, 2/2.0f, 3/2.0f, 6/2.0f, 9/2.0f), v1.dividedBy(2.0f)),
			//18. IntVector * (double)
			Arguments.of(new DoubleVector(1*1.25, 5*1.25, 4*1.25, 2*1.25, 3*1.25, 6*1.25, 9*1.25), v1.multipliedBy(1.25)),
			//19. IntVector / (double)
			Arguments.of(new DoubleVector(1/1.25, 5/1.25, 4/1.25, 2/1.25, 3/1.25, 6/1.25, 9/1.25), v1.dividedBy(1.25)),
			//20. IntVector * IntVector
			Arguments.of(1*2 + 5*4 + 4*3 + 2*1 + 3*5 + 6*7 + 9*8, v1.dotProduct(v2)),
			//21. IntVector * null (IntVector)
			Arguments.of(0, v1.dotProduct(vn1)),
			//22. IntVector * FloatVector
			Arguments.of(1*0.6f + 5*1.2f + 4*0.1f + 2*2.4f + 3*1.9f + 6*0.5f + 9*1.0f, v1.dotProduct(v3)),
			//23. IntVector * null (FloatVector)
			Arguments.of(0.0f, v1.dotProduct(vn2)),
			//24. IntVector * DoubleVector
			Arguments.of(1*1.14 + 5*3.12 + 4*1.14 + 2*5.67 + 3*0.34 + 6*1.56 + 9*0.97, v1.dotProduct(v4)),
			//25. IntVector * null (DoubleVector)
			Arguments.of(0.0, v1.dotProduct(vn3)),
			//26. |IntVector|^2
			Arguments.of(7, new IntVector(1, 1, 1, 1, 1, 1, 1).lengthSquared()),
			//27. |IntVector|
			Arguments.of(Math.sqrt(7), new IntVector(1, 1, 1, 1, 1, 1, 1).length()),
			//14. ||IntVector||
			Arguments.of(1.0, v2.normalized().length())
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testExceptionsSource() {
		return Stream.of(
			//1. IntVector + (int, int, int)
			Arguments.of((Executable) () -> v1.plus(new IntVector(1, 2, 3))),
			//2. IntVector + (float, float, float)
			Arguments.of((Executable) () -> v1.plus(new FloatVector(1.0f, 2.0f, 3.0f))),
			//3. IntVector + (double, double, double)
			Arguments.of((Executable) () -> v1.plus(new DoubleVector(1.0, 2.0, 3.0))),
			//4. IntVector - (int, int, int)
			Arguments.of((Executable) () -> v1.minus(new IntVector(1, 2, 3))),
			//5. IntVector - (float, float, float)
			Arguments.of((Executable) () -> v1.minus(new FloatVector(1.0f, 2.0f, 3.0f))),
			//6. IntVector - (double, double, double)
			Arguments.of((Executable) () -> v1.minus(new DoubleVector(1.0, 2.0, 3.0))),
			//7. IntVector * (int, int, int)
			Arguments.of((Executable) () -> v1.dotProduct(new IntVector(1, 2, 3))),
			//8. IntVector * (float, float, float)
			Arguments.of((Executable) () -> v1.dotProduct(new FloatVector(1.0f, 2.0f, 3.0f))),
			//9. IntVector * (double, double, double)
			Arguments.of((Executable) () -> v1.dotProduct(new DoubleVector(1.0, 2.0, 3.0))),
			//10. IntVector ^ (float, float, float)
			Arguments.of((Executable) () -> v1.angle(new FloatVector(1.0f, 2.0f, 3.0f))),
			//11. IntVector ^ (double, double, double)
			Arguments.of((Executable) () -> v1.angle(new DoubleVector(1.0, 2.0, 3.0)))
		);
	}

	@ParameterizedTest
	@MethodSource("testExceptionsSource")
	void testExceptions(Executable method) {
		Assertions.assertThrows(VectorMathException.class, method);
	}
}
 