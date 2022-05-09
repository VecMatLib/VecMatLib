package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.VectorDoubleOperations;
import hexagon.vecmat.vector.VectorFloatOperations;
import hexagon.vecmat.vector.VectorAsFloat;

public interface MatrixFloatOperations<MF extends MatrixFloatOperations<MF, VF, MD, VD, MI>, VF extends VectorFloatOperations<VF, VD, ?>, MD extends MatrixDoubleOperations<MD, VD, MF, MI>, VD extends VectorDoubleOperations<VD, VF, ?>, MI extends MatrixIntOperations<MI, ?, MF, VF, MD, VD>> extends MatrixOperations<MF, VF>, MatrixAsDouble<MD, VD> {

	default MF plus(MatrixAsFloat<MF, VF> matrix) {
		return matrix != null ? this.plus(matrix.asFloat()) : this.multipliedBy(1.0f);
	}

	default MF minus(MatrixAsFloat<MF, VF> matrix) {
		return matrix != null ? this.minus(matrix.asFloat()) : this.multipliedBy(1.0f);
	}

	MF multipliedBy(float k);

	VF multiply(VectorAsFloat<VF> vector);

	default MF multiply(MatrixAsFloat<MF, VF> matrix) {
		return matrix != null ? this.multiply(matrix.asFloat()) : this.multipliedBy(0.0f);
	}

	MI castToInt();
}
