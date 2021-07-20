package hexagon.vecmat.vector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntN implements IntVector<IntN, FloatN> {
    
    private final List<Integer> values;
    
    public IntN(Integer... values) {
        this.values = Arrays.asList(values);
    }
    
    @Override
    public IntN plus(IntN operand) {
        return new IntN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Integer[]::new)
        );
    }
    
    @Override
    public FloatN plus(FloatN operand) {
        return new FloatN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public IntN negated() {
        return new IntN(
                this.values.stream()
                        .map(i -> -i)
                        .toArray(Integer[]::new)
        );
    }
    
    @Override
    public IntN minus(IntN operand) {
        return new IntN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Integer[]::new)
        );
    }
    
    @Override
    public FloatN minus(FloatN operand) {
        return new FloatN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public IntN times(int constant) {
        return new IntN(
                this.values.stream()
                        .map(i -> i * constant)
                        .toArray(Integer[]::new)
        );
    }
    
    @Override
    public FloatN times(float constant) {
        return new FloatN(
                this.values.stream()
                        .map(i -> i * constant)
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public IntN dividedBy(int constant) {
        return new IntN(
                this.values.stream()
                        .map(i -> i / constant)
                        .toArray(Integer[]::new)
        );
    }
    
    @Override
    public int dotProduct(IntN vector) {
        return IntStream.range(0, this.size())
                .map(i -> this.element(i) * vector.element(i))
                .sum();
    }
    
    @Override
    public float dotProduct(FloatN vector) {
        return (float) IntStream.range(0, this.size())
                .mapToDouble(i -> this.element(i) * vector.element(i))
                .sum();
    }
    
    @Override
    public int lengthSquared() {
        return this.dotProduct(this);
    }
    
    public int size() {
        return this.values.size();
    }
    
    public int element(int i) {
        return this.values.get(i);
    }
    
    @Override
    public boolean equals(IntN value) {
        return this.values.equals(value.values);
    }
    
    @Override
    public boolean equals(FloatN value) {
        return IntStream.range(0, this.size()).allMatch(i -> this.element(i) == value.element(i));
    }
    
    @Override
    public String toString() {
        return "IntN" + this.values.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "(", ")"));
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof IntN && ((IntN) object).equals(this);
    }
}
