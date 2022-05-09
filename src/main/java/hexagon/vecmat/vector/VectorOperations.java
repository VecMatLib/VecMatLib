package hexagon.vecmat.vector;

public interface VectorOperations<V extends VectorOperations<V>> {

	V plus(V vector);

	V negated();

	default V minus(V vector) {
		return this.negated().plus(vector).negated();
	}

	double length();
}
