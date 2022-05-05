package hexagon.vecmat.vector;

public interface IntVector<I extends IntVector<I, F>, F extends FloatVector<F, I>> extends Vector<I, Integer> {

	default F plus(F vector) {
		return this.asFloat().plus(vector);
	}

	default F minus(F vector) {
		return this.asFloat().minus(vector);
	}

	default F multiply(Float k) {
		return this.asFloat().multiply(k);
	}

	default F divide(Float k) {
		return this.asFloat().multiply(k);
	}

	default float dotProduct(F vector) {
		return this.asFloat().dotProduct(vector);
	}

	default F normalized() {
		return this.divide((float) this.length());
	}

	default double angle(F vector) {
		return Math.acos(this.dotProduct(vector) / (this.length() * vector.length()));
	}

	F asFloat();
}
