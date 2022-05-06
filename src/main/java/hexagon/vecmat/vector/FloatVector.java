package hexagon.vecmat.vector;

public interface FloatVector<F extends FloatVector<F, I>, I extends IntVector<I, F>> extends Vector<F> {

	default F plus(I vector) {
		return vector != null ? this.plus(vector.asFloat()) : this.multipliedBy(1);
	}

	default F minus(I vector) {
		return vector != null ? this.minus(vector.asFloat()) : this.multipliedBy(1);
	}

	F multipliedBy(float k);

	default F dividedBy(float k) {
		return this.multipliedBy(1.0f / k);
	}

	float dotProduct(F vector);

	default float dotProduct(I vector) {
		return vector != null ? this.dotProduct(vector.asFloat()) : 0.0f;
	}

	float lengthSquared();

	@Override
	default double length() {
		return Math.sqrt(this.lengthSquared());
	}

	default F normalized() {
		return this.dividedBy((float) this.length());
	}

	default double angle(F vector) {
		return Math.acos(this.dotProduct(vector) / (this.length() * (vector != null ? vector.length() : 0.0)));
	}

	default double angle(I vector) {
		return Math.acos(this.dotProduct(vector) / (this.length() * (vector != null ? vector.length() : 0.0)));
	}

	I castToInt();
}
