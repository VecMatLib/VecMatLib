package hexagon.vecmat.vector;

public interface Vector2<N extends Number, V extends Vector2<N, V>> {

	N x();

	N y();

	V plus(N x, N y);

	V minus(N x, N y);

	N dotProduct(N x, N y);

	double angle(N x, N y);
}
