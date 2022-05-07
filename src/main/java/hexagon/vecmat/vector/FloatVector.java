package hexagon.vecmat.vector;

public interface FloatVector<F extends FloatVector<F, D, I>, D extends DoubleVector<D, F, I>, I extends IntVector<I, F, D>> extends Vector<F>, VectorAsDouble<D> {

	default F plus(VectorAsFloat<F> vector) {
		return vector != null ? this.plus(vector.asFloat()) : this.multipliedBy(1);
	}

	default F minus(VectorAsFloat<F> vector) {
		return vector != null ? this.minus(vector.asFloat()) : this.multipliedBy(1);
	}

	F multipliedBy(float k);

	default F dividedBy(float k) {
		return this.multipliedBy(1.0f / k);
	}

	float dotProduct(F vector);

	default float dotProduct(VectorAsFloat<F> vector) {
		return vector != null ? this.dotProduct(vector.asFloat()) : 0.0f;
	}

	float lengthSquared();

	@Override
	default double length() {
		return Math.sqrt(this.lengthSquared());
	}

	default D normalized() {
		return this.dividedBy(this.length());
	}

	default double angle(F vector) {
		return this.asDouble().angle(vector);
	}

	default double angle(VectorAsFloat<F> vector) {
		return this.angle(vector.asFloat());
	}

	I castToInt();
}
