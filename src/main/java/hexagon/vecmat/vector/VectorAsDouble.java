package hexagon.vecmat.vector;

public interface VectorAsDouble<D extends DoubleVector<D, ?, ?>> {

	default D plus(D vector) {
		return this.asDouble().plus(vector);
	}

	default D minus(D vector) {
		return this.asDouble().minus(vector);
	}

	default D multipliedBy(double k) {
		return this.asDouble().multipliedBy(k);
	}

	default D dividedBy(double k) {
		return this.asDouble().dividedBy(k);
	}

	default double dotProduct(D vector) {
		return this.asDouble().dotProduct(vector);
	}

	default double angle(D vector) {
		return this.asDouble().angle(vector);
	}

	D asDouble();
}
