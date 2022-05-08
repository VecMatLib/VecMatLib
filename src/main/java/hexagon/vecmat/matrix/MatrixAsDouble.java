package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.DoubleVector;

public interface MatrixAsDouble<M extends MatrixDoubleOperations<M, V, ?, ?>, V extends DoubleVector<V, ?, ?>> {

	default M plus(M matrix) {
		return this.asDouble().plus(matrix);
	}

	default M minus(M matrix) {
		return this.asDouble().minus(matrix);
	}

	default M multipliedBy(double k) {
		return this.asDouble().multipliedBy(k);
	}

	default V multiply(V vector) {
		return this.asDouble().multiply(vector);
	}

	default M multiply(M matrix) {
		return this.asDouble().multiply(matrix);
	}

	M asDouble();
}
