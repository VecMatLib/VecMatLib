package hexagon.vecmat.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestDoubleVector {

	static DoubleVector v1 = new DoubleVector(1.12, 2.34, 3.56, 0.01, 0.52, 1.97, 1.43);
	static DoubleVector v2 = new DoubleVector(0.75, 1.32, 2.43, 3.21, 0.99, 1.16, 0.12);

	static FloatVector v3 = new FloatVector(0.5f, 1.2f, 3.4f, 0.9f, 1.6f, 2.3f, 0.1f);

	static DoubleVector vn1 = null;
	static FloatVector vn2 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. DoubleVector + DoubleVector
			Arguments.of(new DoubleVector(1.12+0.75, 2.34+1.32, 3.56+2.43, 0.01+3.21, 0.52+0.99, 1.97+1.16, 1.43+0.12), v1.plus(v2)),
			//2. DoubleVector + null (DoubleVector)
			Arguments.of(v1, v1.plus(vn1)),
			//3. DoubleVector + FloatVector
			Arguments.of(new DoubleVector(1.12+0.5f, 2.34+1.2f, 3.56+3.4f, 0.01+0.9f, 0.52+1.6f, 1.97+2.3f, 1.43+0.1f), v1.plus(v3)),
			//4. DoubleVector + null (FloatVector)
			Arguments.of(v1, v1.plus(vn2)),
			//5. -DoubleVector
			Arguments.of(new DoubleVector(-1.12, -2.34, -3.56, -0.01, -0.52, -1.97, -1.43), v1.negated()),
			//6. DoubleVector - DoubleVector
			Arguments.of(new DoubleVector(1.12-0.75, 2.34-1.32, 3.56-2.43, 0.01-3.21, 0.52-0.99, 1.97-1.16, 1.43-0.12), v1.minus(v2)),
			//7. DoubleVector - null (DoubleVector)
			Arguments.of(v1, v1.minus(vn1)),
			//8. DoubleVector - FloatVector
			Arguments.of(new DoubleVector(1.12-0.5f, 2.34-1.2f, 3.56-3.4f, 0.01-0.9f, 0.52-1.6f, 1.97-2.3f, 1.43-0.1f), v1.minus(v3)),
			//9. DoubleVector - null (FloatVector)
			Arguments.of(v1, v1.minus(vn2)),
			//10. DoubleVector * (double)
			Arguments.of(new DoubleVector(1.12*1.25, 2.34*1.25, 3.56*1.25, 0.01*1.25, 0.52*1.25, 1.97*1.25, 1.43*1.25), v1.multipliedBy(1.25)),
			//11. DoubleVector / (double)
			Arguments.of(new DoubleVector(1.12/1.25, 2.34/1.25, 3.56/1.25, 0.01/1.25, 0.52/1.25, 1.97/1.25, 1.43/1.25), v1.dividedBy(1.25)),
			//12. |DoubleVector|^2
			Arguments.of(7.0, new DoubleVector(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0).lengthSquared()),
			//13. |DoubleVector|
			Arguments.of(Math.sqrt(7), new DoubleVector(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0).length())
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testPrecisionSource() {
		return Stream.of(
			//1. DoubleVector * DoubleVector
			Arguments.of(1.12*0.75 + 2.34*1.32 + 3.56*2.43 + 0.01*3.21 + 0.52*0.99 + 1.97*1.16 + 1.43*0.12, v1.dotProduct(v2)),
			//2. DoubleVector * null (DoubleVector)
			Arguments.of(0.0, v1.dotProduct(vn1)),
			//3. DoubleVector * FloatVector
			Arguments.of(1.12*0.5f + 2.34*1.2f + 3.56*3.4f + 0.01*0.9f + 0.52*1.6f + 1.97*2.3f + 1.43*0.1f, v1.dotProduct(v3)),
			//4. DoubleVector * null (FloatVector)
			Arguments.of(0.0, v1.dotProduct(vn2))
		);
	}

	@ParameterizedTest
	@MethodSource("testPrecisionSource")
	void testEqualsWithPrecision(double expected, double actual) {
		Assertions.assertEquals(expected, actual, 0.000000001);
	}

	static Stream<Arguments> testExceptionsSource() {
		return Stream.of(
			//1. DoubleVector + (double, double, double)
			Arguments.of((Executable) () -> v1.plus(new DoubleVector(1.0, 2.0, 3.0))),
			//2. DoubleVector + (float, float, float)
			Arguments.of((Executable) () -> v1.plus(new FloatVector(1.0f, 2.0f, 3.0f))),
			//3. DoubleVector - (double, double, double)
			Arguments.of((Executable) () -> v1.minus(new DoubleVector(1.0, 2.0, 3.0))),
			//4. DoubleVector - (float, float, float)
			Arguments.of((Executable) () -> v1.minus(new FloatVector(1.0f, 2.0f, 3.0f))),
			//5. DoubleVector * (double, double, double)
			Arguments.of((Executable) () -> v1.dotProduct(new DoubleVector(1.0, 2.0, 3.0))),
			//6. DoubleVector * (float, float, float)
			Arguments.of((Executable) () -> v1.dotProduct(new FloatVector(1.0f, 2.0f, 3.0f))),
			//7. DoubleVector ^ (double, double, double)
			Arguments.of((Executable) () -> v1.angle(new DoubleVector(1.0, 2.0, 3.0))),
			//8. DoubleVector ^ (float, float, float)
			Arguments.of((Executable) () -> v1.angle(new FloatVector(1.0f, 2.0f, 3.0f)))
		);
	}

	@ParameterizedTest
	@MethodSource("testExceptionsSource")
	void testExceptions(Executable method) {
		Assertions.assertThrows(VectorMathException.class, method);
	}
}
