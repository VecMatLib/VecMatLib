package hexagon.vecmat.vector;

public interface VectorAsFloat<F extends VectorFloatOperations<F, ?, ?>> {

	default F plus(F vector) {
		return this.asFloat().plus(vector);
	}

	default F minus(F vector) {
		return this.asFloat().minus(vector);
	}

	default F multipliedBy(float k) {
		return this.asFloat().multipliedBy(k);
	}

	default F dividedBy(float k) {
		return this.asFloat().dividedBy(k);
	}

	default double dotProduct(F vector) {
		return this.asFloat().dotProduct(vector);
	}

	default double angle(F vector) {
		return this.asFloat().angle(vector);
	}

	F asFloat();
}
