package hexagon.vecmat.vector;

public interface IntVector<I extends IntVector<I, F, D>, F extends FloatVector<F, D, I>, D extends DoubleVector<D, F, I>> extends Vector<I>, VectorAsDouble<D>, VectorAsFloat<F> {

	I multipliedBy(int k);

	I dividedBy(int k);

	int dotProduct(I vector);

	int lengthSquared();

	@Override
	default double length() {
		return Math.sqrt(this.lengthSquared());
	}

	default D normalized() {
		return this.dividedBy(this.length());
	}

	default double angle(I vector) {
		return this.asDouble().angle(vector);
	}
}
