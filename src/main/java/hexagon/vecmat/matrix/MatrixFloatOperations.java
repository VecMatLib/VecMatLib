package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.VectorAsFloat;
import hexagon.vecmat.vector.VectorFloatOperations;

public interface MatrixFloatOperations<M extends MatrixFloatOperations<M, V>, V extends VectorFloatOperations<V>> extends MatrixOperations<M, V> {

	default M plus(MatrixAsFloat<M, V> matrix) {
		return matrix != null ? this.plus(matrix.asFloat()) : this.multipliedBy(1.0f);
	}

	default M minus(MatrixAsFloat<M, V> matrix) {
		return matrix != null ? this.minus(matrix.asFloat()) : this.multipliedBy(1.0f);
	}

	M multipliedBy(float k);

	V multiply(VectorAsFloat<V> vector);

	default M multiply(MatrixAsFloat<M, V> matrix) {
		return matrix != null ? this.multiply(matrix.asFloat()) : this.multipliedBy(0.0f);
	}
}
