package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.VectorIntOperations;

/**
 * Interface that defines all base operations for integer matrices.
 * 
 * @param <M> The same matrix that implements this interface
 * @param <V> A vector of the same type as this matrix
 * 
 * @author Nico
 */
public interface MatrixIntOperations<M extends MatrixIntOperations<M, V>, V extends VectorIntOperations<V>> extends MatrixOperations<M, V> {

	/**
	 * Multiplies this matrix with the given scalar.
	 * 
	 * <p> The product of a matrix m and a scalar k is a matrix m' such that
	 * every element m'-ij is the product of the element m-ij and k.
	 * 
	 * <p> Matrices are supposed to be immutable. This means that
	 * this method does not alter the object on which it is called,
	 * it returns a new matrix instead.
	 * 
	 * @param k The scalar to which this matrix is multiplied.
	 * 
	 * @return The product of this matrix and the given scalar.
	 */
	M multipliedBy(int k);
}
