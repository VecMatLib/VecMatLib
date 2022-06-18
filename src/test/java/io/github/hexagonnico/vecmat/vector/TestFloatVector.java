package io.github.hexagonnico.vecmat.vector;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestFloatVector {

	static FloatVector v1 = new FloatVector(1.1f, 0.5f, 2.1f, 0.1f, 0.4f, 2.4f, 1.5f);
	static FloatVector v2 = new FloatVector(0.7f, 1.4f, 1.2f, 2.4f, 0.5f, 1.2f, 0.1f);

	static IntVector v3 = new IntVector(1, 2, 3, 4, 5, 6, 7);

	static DoubleVector v4 = new DoubleVector(1.14, 3.12, 1.14, 5.67, 0.34, 1.56, 0.97);

	static FloatVector vn1 = null;
	static IntVector vn2 = null;
	static DoubleVector vn3 = null;

	static Stream<Arguments> testSource() {
		return Stream.of(
			//1. FloatVector + FloatVector
			Arguments.of(new FloatVector(1.1f+0.7f, 0.5f+1.4f, 2.1f+1.2f, 0.1f+2.4f, 0.4f+0.5f, 2.4f+1.2f, 1.5f+0.1f), v1.plus(v2)),
			//2. FloatVector + IntVector
			Arguments.of(new FloatVector(1.1f+1, 0.5f+2, 2.1f+3, 0.1f+4, 0.4f+5, 2.4f+6, 1.5f+7), v1.plus(v3)),
			//3. FloatVector + DoubleVector
			Arguments.of(new DoubleVector(1.1f+1.14, 0.5f+3.12, 2.1f+1.14, 0.1f+5.67, 0.4f+0.34, 2.4f+1.56, 1.5f+0.97), v1.plus(v4)),
			//4. -FloatVector
			Arguments.of(new FloatVector(-1.1f, -0.5f, -2.1f, -0.1f, -0.4f, -2.4f, -1.5f), v1.negated()),
			//5. FloatVector - FloatVector
			Arguments.of(new FloatVector(1.1f-0.7f, 0.5f-1.4f, 2.1f-1.2f, 0.1f-2.4f, 0.4f-0.5f, 2.4f-1.2f, 1.5f-0.1f), v1.minus(v2)),
			//6. FloatVector - IntVector
			Arguments.of(new FloatVector(1.1f-1, 0.5f-2, 2.1f-3, 0.1f-4, 0.4f-5, 2.4f-6, 1.5f-7), v1.minus(v3)),
			//7. FloatVector - DoubleVector
			Arguments.of(new DoubleVector(1.1f-1.14, 0.5f-3.12, 2.1f-1.14, 0.1f-5.67, 0.4f-0.34, 2.4f-1.56, 1.5f-0.97), v1.minus(v4)),
			//8. FloatVector * (float)
			Arguments.of(new FloatVector(1.1f*1.5f, 0.5f*1.5f, 2.1f*1.5f, 0.1f*1.5f, 0.4f*1.5f, 2.4f*1.5f, 1.5f*1.5f), v1.multipliedBy(1.5f)),
			//9. FloatVector / (float)
			Arguments.of(new FloatVector(1.1f/1.5f, 0.5f/1.5f, 2.1f/1.5f, 0.1f/1.5f, 0.4f/1.5f, 2.4f/1.5f, 1.5f/1.5f), v1.dividedBy(1.5f)),
			//10. FloatVector * (double)
			Arguments.of(new DoubleVector(1.1f*1.25, 0.5f*1.25, 2.1f*1.25, 0.1f*1.25, 0.4f*1.25, 2.4f*1.25, 1.5f*1.25), v1.multipliedBy(1.25)),
			//11. FloatVector / (double)
			Arguments.of(new DoubleVector(1.1f/1.25, 0.5f/1.25, 2.1f/1.25, 0.1f/1.25, 0.4f/1.25, 2.4f/1.25, 1.5f/1.25), v1.dividedBy(1.25)),
			//12. FloatVector * FloatVector
			Arguments.of(1.1f*0.7f + 0.5f*1.4f + 2.1f*1.2f + 0.1f*2.4f + 0.4f*0.5f + 2.4f*1.2f + 1.5f*0.1f, v1.dotProduct(v2)),
			//13. FloatVector * IntVector
			Arguments.of(1.1f*1 + 0.5f*2 + 2.1f*3 + 0.1f*4 + 0.4f*5 + 2.4f*6 + 1.5f*7, v1.dotProduct(v3)),
			//14. FloatVector * DoubleVector
			Arguments.of(1.1f*1.14 + 0.5f*3.12 + 2.1f*1.14 + 0.1f*5.67 + 0.4f*0.34 + 2.4f*1.56 + 1.5f*0.97, v1.dotProduct(v4)),
			//15. |FloatVector|^2
			Arguments.of(7.0f, new FloatVector(1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).lengthSquared()),
			//16. |FloatVector|
			Arguments.of(Math.sqrt(7), new FloatVector(1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).length()),
			//17. ||FloatVector||
			Arguments.of(1.0, v1.normalized().length())
		);
	}

	@ParameterizedTest
	@MethodSource("testSource")
	void testEquals(Object expected, Object actual) {
		Assertions.assertEquals(expected, actual);
	}

	static Stream<Arguments> testExceptionsSource() {
		return Stream.of(
			//1. FloatVector + (float, float, float)
			Arguments.of((Executable) () -> v1.plus(new FloatVector(1.0f, 2.0f, 3.0f))),
			//2. FloatVector + (int, int, int)
			Arguments.of((Executable) () -> v1.plus(new IntVector(1, 2, 3))),
			//3. FloatVector + (double, double, double)
			Arguments.of((Executable) () -> v1.plus(new DoubleVector(1.0, 2.0, 3.0))),
			//4. FloatVector - (float, float, float)
			Arguments.of((Executable) () -> v1.minus(new FloatVector(1.0f, 2.0f, 3.0f))),
			//5. FloatVector - (int, int, int)
			Arguments.of((Executable) () -> v1.minus(new IntVector(1, 2, 3))),
			//6. FloatVector - (double, double, double)
			Arguments.of((Executable) () -> v1.minus(new DoubleVector(1.0, 2.0, 3.0))),
			//7. FloatVector * (float, float, float)
			Arguments.of((Executable) () -> v1.dotProduct(new FloatVector(1.0f, 2.0f, 3.0f))),
			//8. FloatVector * (int, int, int)
			Arguments.of((Executable) () -> v1.dotProduct(new IntVector(1, 2, 3))),
			//9. FloatVector * (double, double, double)
			Arguments.of((Executable) () -> v1.dotProduct(new DoubleVector(1.0, 2.0, 3.0))),
			//10. FloatVector ^ (float, float, float)
			Arguments.of((Executable) () -> v1.angle(new FloatVector(1.0f, 2.0f, 3.0f))),
			//11. FloatVector ^ (double, double, double)
			Arguments.of((Executable) () -> v1.angle(new DoubleVector(1.0, 2.0, 3.0)))
		);
	}

	@ParameterizedTest
	@MethodSource("testExceptionsSource")
	void testExceptions(Executable method) {
		Assertions.assertThrows(VectorMathException.class, method);
	}

	static Stream<Arguments> testNullValuesSource() {
		return Stream.of(
			//1. FloatVector + null (FloatVector)
			Arguments.of((Executable) () -> v1.plus(vn1)),
			//2. FloatVector + null (IntVector)
			Arguments.of((Executable) () -> v1.plus(vn2)),
			//3. FloatVector + null (DoubleVector)
			Arguments.of((Executable) () -> v1.plus(vn3)),
			//4. FloatVector - null (FloatVector)
			Arguments.of((Executable) () -> v1.minus(vn1)),
			//5. FloatVector - null (IntVector)
			Arguments.of((Executable) () -> v1.minus(vn2)),
			//6. FloatVector - null (DoubleVector)
			Arguments.of((Executable) () -> v1.minus(vn3)),
			//7. FloatVector * null (FloatVector)
			Arguments.of((Executable) () -> v1.dotProduct(vn1)),
			//8. FloatVector * null (IntVector)
			Arguments.of((Executable) () -> v1.dotProduct(vn2)),
			//9. FloatVector * null (DoubleVector)
			Arguments.of((Executable) () -> v1.dotProduct(vn3))
		);
	}

	@ParameterizedTest
	@MethodSource("testNullValuesSource")
	void testNullValues(Executable method) {
		Assertions.assertThrows(NullPointerException.class, method);
	}
}
