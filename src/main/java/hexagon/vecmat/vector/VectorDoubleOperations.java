package hexagon.vecmat.vector;

public interface VectorDoubleOperations<D extends VectorDoubleOperations<D, F, I>, F extends VectorFloatOperations<F, D, I>, I extends VectorIntOperations<I, F, D>> extends VectorOperations<D> {

	default D plus(VectorAsDouble<D> vector) {
		return vector != null ? this.plus(vector.asDouble()) : this.multipliedBy(1);
	}

	default D minus(VectorAsDouble<D> vector) {
		return vector != null ? this.minus(vector.asDouble()) : this.multipliedBy(1);
	}

	D multipliedBy(double k);

	default D dividedBy(double k) {
		return this.multipliedBy(1.0 / k);
	}

	double dotProduct(D vector);

	default double dotProduct(VectorAsDouble<D> vector) {
		return vector != null ? this.dotProduct(vector.asDouble()) : 0.0;
	}

	double lengthSquared();

	@Override
	default double length() {
		return Math.sqrt(this.lengthSquared());
	}

	default D normalized() {
		return this.dividedBy(this.length());
	}

	default double angle(D vector) {
		return Math.acos(this.dotProduct(vector) / (this.length() * (vector != null ? vector.length() : 0.0)));
	}

	default double angle(VectorAsDouble<D> vector) {
		return vector != null ? this.angle(vector.asDouble()) : Double.NaN;
	}

	I castToInt();

	F castToFloat();
}
