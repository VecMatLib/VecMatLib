package hexagon.vecmat.tuple;

import hexagon.vecmat.BaseOperations;
import hexagon.vecmat.exceptions.VectorSizeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class to represent an immutable tuple of user-specified dimension
 *
 * @param <T> The class that extends this one.
 *  *           Needed to make methods accept the right parameter and return the right value.
 * @param <N> Number used in the tuple
 */
public abstract class NTuple<T extends BaseOperations<T, N>, N extends Number> implements BaseOperations<T, N> {

    protected final List<N> tuple;

    /**
     * Initializes a tuple with the given values
     *
     * @param values Elements of the tuple
     */
    public NTuple(N[] values) {
        if(values.length == 0)
            throw new VectorSizeException("N-Tuple cannot be empty");

        this.tuple = Arrays.asList(values);
    }

    /**
     * Gets the element at the specified position in the tuple
     *
     * @param at The position of the desired element
     * @return The element at the specified position
     */
    public N element(int at) {
        return this.tuple.get(at);
    }

    /**
     * Gets the dimensions of this tuple, a.k.a. the number of elements in the tuple
     *
     * @return The number of elements in the tuple
     */
    public int dimensions() {
        return this.tuple.size();
    }

    /**
     * Adds a number to all the elements of the tuple. <br>
     * This does not affect the object on which it is called,
     * it returns a new one instead.
     *
     * @param number The number to add
     * @return A new tuple with the same elements at the previous one plus the given number
     */
    public abstract T plus(N number);


    /**
     * Subtracts a number from all the elements of the tuple. <br>
     * This does not affect the object on which it is called,
     * it returns a new one instead.
     *
     * @param number The number to subtract
     * @return A new tuple with the same elements at the previous one minus the given number
     */
    public abstract T minus(N number);

    /**
     * Returns a stream with this tuple as source
     * @return A stream over the element of this tuple
     */
    public Stream<N> stream() {
        return this.tuple.stream();
    }

    @Override
    public String toString() {
        return this.tuple.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "(", ")"));
    }
}
