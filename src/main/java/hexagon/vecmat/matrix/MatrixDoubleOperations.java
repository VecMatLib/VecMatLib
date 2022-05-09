package hexagon.vecmat.matrix;

import hexagon.vecmat.vector.VectorDoubleOperations;
import hexagon.vecmat.vector.VectorAsDouble;

public interface MatrixDoubleOperations<MD extends MatrixDoubleOperations<MD, VD, MF, MI>, VD extends VectorDoubleOperations<VD, ?, ?>, MF extends MatrixFloatOperations<MF, ?, MD, VD, MI>, MI extends MatrixIntOperations<MI, ?, MF, ?, MD, VD>> extends MatrixOperations<MD, VD> {

	default MD plus(MatrixAsDouble<MD, VD> matrix) {
		return matrix != null ? this.plus(matrix.asDouble()) : this.multipliedBy(1.0f);
	}

	default MD minus(MatrixAsDouble<MD, VD> matrix) {
		return matrix != null ? this.minus(matrix.asDouble()) : this.multipliedBy(1.0f);
	}

	MD multipliedBy(double k);

	VD multiply(VectorAsDouble<VD> vector);

	default MD multiply(MatrixAsDouble<MD, VD> matrix) {
		return matrix != null ? this.multiply(matrix.asDouble()) : this.multipliedBy(0.0f);
	}

	MF castToFloat();

	MI castToInt();
}
