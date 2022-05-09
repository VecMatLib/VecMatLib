package hexagon.vecmat.vector;

public interface VectorIntOperations<I extends VectorIntOperations<I, F, D>, F extends VectorFloatOperations<F, D, I>, D extends VectorDoubleOperations<D, F, I>> extends VectorOperations<I>, VectorAsDouble<D>, VectorAsFloat<F> {

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
