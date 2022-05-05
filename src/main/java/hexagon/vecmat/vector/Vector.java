package hexagon.vecmat.vector;

public interface Vector<V extends Vector<V, N>, N extends Number> {

	V plus(V vector);

	V negated();

	default V minus(V vector) {
		return this.plus(vector.negated());
	}

	V multiply(N k);

	V divide(N k);

	N dotProduct(V vector);

	N lengthSquared();

	default double length() {
		return Math.sqrt(this.lengthSquared().doubleValue());
	}

	default double angle(V vector) {
		return Math.acos(this.dotProduct(vector).doubleValue() / (this.length() * vector.length()));
	}
}
