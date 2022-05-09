package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.VectorDoubleOperations;
import hexagon.vecmat.vector.VectorFloatOperations;
import hexagon.vecmat.vector.VectorIntOperations;

public interface MatrixIntOperations<MI extends MatrixIntOperations<MI, VI, MF, VF, MD, VD>, VI extends VectorIntOperations<VI, VF, VD>, MF extends MatrixFloatOperations<MF, VF, MD, VD, MI>, VF extends VectorFloatOperations<VF, VD, VI>, MD extends MatrixDoubleOperations<MD, VD, MF, MI>, VD extends VectorDoubleOperations<VD, VF, VI>> extends MatrixOperations<MI, VI>, MatrixAsFloat<MF, VF>, MatrixAsDouble<MD, VD> {

	MI multipliedBy(int k);
}
