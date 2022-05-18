package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.VectorDoubleOperations;
import hexagon.vecmat.vector.VectorAsDouble;

public interface MatrixDoubleOperations<M extends MatrixDoubleOperations<M, V>, V extends VectorDoubleOperations<V>> extends MatrixOperations<M, V> {

	default M plus(MatrixAsDouble<M, V> matrix) {
		return matrix != null ? this.plus(matrix.asDouble()) : this.multipliedBy(1.0f);
	}

	default M minus(MatrixAsDouble<M, V> matrix) {
		return matrix != null ? this.minus(matrix.asDouble()) : this.multipliedBy(1.0f);
	}

	M multipliedBy(double k);

	V multiply(VectorAsDouble<V> vector);

	default M multiply(MatrixAsDouble<M, V> matrix) {
		return matrix != null ? this.multiply(matrix.asDouble()) : this.multipliedBy(0.0f);
	}
}
