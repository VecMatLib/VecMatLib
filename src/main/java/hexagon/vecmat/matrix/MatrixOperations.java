package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.Vector;

public interface MatrixOperations<M extends MatrixOperations<M, V>, V extends Vector<V>> {

	M plus(M matrix);

	M negative();

	default M minus(M matrix) {
		return this.negative().plus(matrix).negative();
	}

	V multiply(V vector);

	M transposed();

	boolean isSymmetric();

	boolean isSkewSymmetric();

	M multiply(M matrix);

	M power(int exponent);
}
