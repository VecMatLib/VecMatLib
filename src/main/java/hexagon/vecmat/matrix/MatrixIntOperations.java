package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.VectorIntOperations;

public interface MatrixIntOperations<M extends MatrixIntOperations<M, V>, V extends VectorIntOperations<V>> extends MatrixOperations<M, V> {

	M multipliedBy(int k);
}
