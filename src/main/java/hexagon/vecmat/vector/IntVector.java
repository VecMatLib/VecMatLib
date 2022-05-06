package hexagon.vecmat.vector;

public interface IntVector<I extends IntVector<I, F>, F extends FloatVector<F, I>> extends Vector<I> {

	default F plus(F vector) {
		return this.asFloat().plus(vector);
	}

	default F minus(F vector) {
		return this.asFloat().minus(vector);
	}

	I multipliedBy(int k);

	default F multipliedBy(float k) {
		return this.asFloat().multipliedBy(k);
	}

	I dividedBy(int k);

	default F dividedBy(float k) {
		return this.asFloat().dividedBy(k);
	}

	int dotProduct(I vector);

	default float dotProduct(F vector) {
		return this.asFloat().dotProduct(vector);
	}

	int lengthSquared();

	@Override
	default double length() {
		return Math.sqrt(this.lengthSquared());
	}

	default F normalized() {
		return this.dividedBy((float) this.length());
	}

	default double angle(I vector) {
		return Math.acos(this.dotProduct(vector) / (this.length() * (vector != null ? vector.length() : 0.0)));
	}

	default double angle(F vector) {
		return Math.acos(this.dotProduct(vector) / (this.length() * (vector != null ? vector.length() : 0.0)));
	}

	F asFloat();
}
