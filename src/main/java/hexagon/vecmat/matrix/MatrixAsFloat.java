package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.VectorFloatOperations;

public interface MatrixAsFloat<M extends MatrixFloatOperations<M, V, ?, ?, ?>, V extends VectorFloatOperations<V, ?, ?>> {

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
