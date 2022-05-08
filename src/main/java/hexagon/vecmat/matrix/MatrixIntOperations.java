package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.DoubleVector;
import hexagon.vecmat.vector.FloatVector;
import hexagon.vecmat.vector.IntVector;

public interface MatrixIntOperations<MI extends MatrixIntOperations<MI, VI, MF, VF, MD, VD>, VI extends IntVector<VI, VF, VD>, MF extends MatrixFloatOperations<MF, VF, MD, VD, MI>, VF extends FloatVector<VF, VD, VI>, MD extends MatrixDoubleOperations<MD, VD, ?, ?>, VD extends DoubleVector<VD, VF, VI>> extends MatrixOperations<MI, VI>, MatrixAsFloat<MF, VF>, MatrixAsDouble<MD, VD> {

	MI multipliedBy(int k);
}
