package hexagon.vecmat.vector;

public interface FloatVector<F extends FloatVector<F, I>, I extends IntVector<I, F>> extends Vector<F, Float> {

	default F plus(I vector) {
		return this.plus(vector.asFloat());
	}

	default F minus(I vector) {
		return this.minus(vector.asFloat());
	}

	default float dotProduct(I vector) {
		return this.dotProduct(vector.asFloat());
	}

	default F normalized() {
		return this.divide((float) this.length());
	}

	default double angle(I vector) {
		return Math.acos(this.dotProduct(vector) / (this.length() * vector.length()));
	}

	I castToInt();
}
