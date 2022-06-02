package hexagon.vecmat.vector;

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
			//2. FloatVector + null (FloatVector)
			Arguments.of(v1, v1.plus(vn1)),
			//3. FloatVector + IntVector
			Arguments.of(new FloatVector(1.1f+1, 0.5f+2, 2.1f+3, 0.1f+4, 0.4f+5, 2.4f+6, 1.5f+7), v1.plus(v3)),
			//4. FloatVector + null (IntVector)
			Arguments.of(v1, v1.plus(vn2)),
			//5. FloatVector + DoubleVector
			Arguments.of(new DoubleVector(1.1f+1.14, 0.5f+3.12, 2.1f+1.14, 0.1f+5.67, 0.4f+0.34, 2.4f+1.56, 1.5f+0.97), v1.plus(v4)),
			//6. FloatVector + null (DoubleVector)
			Arguments.of(v1.asDouble(), v1.plus(vn3)),
			//7. -FloatVector
			Arguments.of(new FloatVector(-1.1f, -0.5f, -2.1f, -0.1f, -0.4f, -2.4f, -1.5f), v1.negated()),
			//8. FloatVector - FloatVector
			Arguments.of(new FloatVector(1.1f-0.7f, 0.5f-1.4f, 2.1f-1.2f, 0.1f-2.4f, 0.4f-0.5f, 2.4f-1.2f, 1.5f-0.1f), v1.minus(v2)),
			//9. FloatVector - null (FloatVector)
			Arguments.of(v1, v1.minus(vn1)),
			//10. FloatVector - IntVector
			Arguments.of(new FloatVector(1.1f-1, 0.5f-2, 2.1f-3, 0.1f-4, 0.4f-5, 2.4f-6, 1.5f-7), v1.minus(v3)),
			//11. FloatVector - null (IntVector)
			Arguments.of(v1, v1.minus(vn2)),
			//12. FloatVector - DoubleVector
			Arguments.of(new DoubleVector(1.1f-1.14, 0.5f-3.12, 2.1f-1.14, 0.1f-5.67, 0.4f-0.34, 2.4f-1.56, 1.5f-0.97), v1.minus(v4)),
			//13. FloatVector - null (DoubleVector)
			Arguments.of(v1.asDouble(), v1.minus(vn3)),
			//14. FloatVector * (float)
			Arguments.of(new FloatVector(1.1f*1.5f, 0.5f*1.5f, 2.1f*1.5f, 0.1f*1.5f, 0.4f*1.5f, 2.4f*1.5f, 1.5f*1.5f), v1.multipliedBy(1.5f)),
			//15. FloatVector / (float)
			Arguments.of(new FloatVector(1.1f/1.5f, 0.5f/1.5f, 2.1f/1.5f, 0.1f/1.5f, 0.4f/1.5f, 2.4f/1.5f, 1.5f/1.5f), v1.dividedBy(1.5f)),
			//16. FloatVector * (double)
			Arguments.of(new DoubleVector(1.1f*1.25, 0.5f*1.25, 2.1f*1.25, 0.1f*1.25, 0.4f*1.25, 2.4f*1.25, 1.5f*1.25), v1.multipliedBy(1.25)),
			//17. FloatVector / (double)
			Arguments.of(new DoubleVector(1.1f/1.25, 0.5f/1.25, 2.1f/1.25, 0.1f/1.25, 0.4f/1.25, 2.4f/1.25, 1.5f/1.25), v1.dividedBy(1.25)),
			//18. FloatVector * FloatVector
			Arguments.of(1.1f*0.7f + 0.5f*1.4f + 2.1f*1.2f + 0.1f*2.4f + 0.4f*0.5f + 2.4f*1.2f + 1.5f*0.1f, v1.dotProduct(v2)),
			//19. FloatVector * null (FloatVector)
			Arguments.of(0.0f, v1.dotProduct(vn1)),
			//20. FloatVector * IntVector
			Arguments.of(1.1f*1 + 0.5f*2 + 2.1f*3 + 0.1f*4 + 0.4f*5 + 2.4f*6 + 1.5f*7, v1.dotProduct(v3)),
			//21. FloatVector * null (IntVector)
			Arguments.of(0.0f, v1.dotProduct(vn2)),
			//22. FloatVector * DoubleVector
			Arguments.of(1.1f*1.14 + 0.5f*3.12 + 2.1f*1.14 + 0.1f*5.67 + 0.4f*0.34 + 2.4f*1.56 + 1.5f*0.97, v1.dotProduct(v4)),
			//23. FloatVector * null (DoubleVector)
			Arguments.of(0.0, v1.dotProduct(vn3)),
			//24. |FloatVector|^2
			Arguments.of(7.0f, new FloatVector(1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).lengthSquared()),
			//25. |FloatVector|
			Arguments.of(Math.sqrt(7), new FloatVector(1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f).length()),
			//14. ||FloatVector||
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
}
