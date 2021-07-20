package hexagon.vecmat.vector;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FloatN implements FloatVector<FloatN, IntN> {
    
    //TODO - Check not empty and sizes
    
    private final List<Float> values;
    
    public FloatN(Float... values) {
        this.values = Arrays.asList(values);
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
    public FloatN plus(IntN operand) {
        return new FloatN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public FloatN negated() {
        return new FloatN(
                this.values.stream()
                        .map(f -> -f)
                        .toArray(Float[]::new)
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
    public FloatN minus(IntN operand) {
        return new FloatN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public FloatN times(float constant) {
        return new FloatN(
                this.values.stream()
                        .map(f -> f * constant)
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public float dotProduct(FloatN vector) {
        return (float) IntStream.range(0, this.size())
                .mapToDouble(i -> this.element(i) * vector.element(i))
                .sum();
    }
    
    @Override
    public float dotProduct(IntN vector) {
        return (float) IntStream.range(0, this.size())
                .mapToDouble(i -> this.element(i) * vector.element(i))
                .sum();
    }
    
    @Override
    public float lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public IntN castToInt() {
        return new IntN(
                this.values.stream()
                        .mapToInt(Float::intValue)
                        .boxed()
                        .toArray(Integer[]::new)
        );
    }
    
    public int size() {
        return this.values.size();
    }
    
    public float element(int i) {
        return this.values.get(i);
    }
    
    @Override
    public boolean equals(FloatN value) {
        return this.values.equals(value.values);
    }
    
    @Override
    public boolean equals(IntN value) {
        return IntStream.range(0, this.size()).allMatch(i -> this.element(i) == value.element(i));
    }
    
    @Override
    public String toString() {
        return "FloatN" + this.values.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "(", ")"));
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof FloatN && ((FloatN) object).equals(this);
    }
}
