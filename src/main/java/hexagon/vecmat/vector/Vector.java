package hexagon.vecmat.vector;

public interface Vector<V extends Vector<V>> {

	V plus(V vector);

	V negated();

	default V minus(V vector) {
		return this.negated().plus(vector).negated();
	}

	double length();
}
