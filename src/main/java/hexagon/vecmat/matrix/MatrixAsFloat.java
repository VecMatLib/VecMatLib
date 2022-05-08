package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.FloatVector;

public interface MatrixAsFloat<M extends MatrixFloatOperations<M, V, ?, ?, ?>, V extends FloatVector<V, ?, ?>> {

	default M plus(M matrix) {
		return this.asFloat().plus(matrix);
	}

	default M minus(M matrix) {
		return this.asFloat().minus(matrix);
	}

	default M multipliedBy(float k) {
		return this.asFloat().multipliedBy(k);
	}

	default V multiply(V vector) {
		return this.asFloat().multiply(vector);
	}

	default M multiply(M matrix) {
		return this.asFloat().multiply(matrix);
	}

	M asFloat();
}
