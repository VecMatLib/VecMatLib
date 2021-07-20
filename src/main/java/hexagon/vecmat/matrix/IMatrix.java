package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.FloatVector;

public interface IMatrix<M extends IMatrix<M, V>, V extends FloatVector<V, ?>> {
    
    M plus(M matrix);
    
    M minus(M matrix);
    
    M multiply(float constant);
    
    default M dividedBy(float constant) {
        return this.multiply(1.0f / constant);
    }
    
    V multiply(V vector);
    
    boolean isSquare();
    
    V getRow(int row);
    
    V getColumn(int column);
    
    M transposed();
    
    boolean isSymmetric();
    
    boolean isSkewSymmetric();
    
    M multiply(M matrix);
    
    M power(int exp);
}
