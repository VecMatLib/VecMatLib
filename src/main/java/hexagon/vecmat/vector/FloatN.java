package hexagon.vecmat.vector;

import hexagon.vecmat.exceptions.UndefinedOperationException;
import hexagon.vecmat.exceptions.VectorSizeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FloatN implements FloatVector<FloatN, IntN> {
    
    private final List<Float> values;
    
    public FloatN(Float... values) {
        if(values.length == 0)
            throw new VectorSizeException("Vector cannot be empty");
        
        this.values = Arrays.asList(values);
    }
    
    @Override
    public FloatN plus(FloatN operand) {
        if(this.size() != operand.size())
            throw new UndefinedOperationException("Vectors can only be summed if they have the same size");
        
        return new FloatN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) + operand.element(i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public FloatN plus(IntN operand) {
        if(this.size() != operand.size())
            throw new UndefinedOperationException("Vectors can only be summed if they have the same size");
    
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
        if(this.size() != operand.size())
            throw new UndefinedOperationException("Vectors can only be summed if they have the same size");
    
        return new FloatN(
                IntStream.range(0, this.size())
                        .mapToObj(i -> this.element(i) - operand.element(i))
                        .toArray(Float[]::new)
        );
    }
    
    @Override
    public FloatN minus(IntN operand) {
        if(this.size() != operand.size())
            throw new UndefinedOperationException("Vectors can only be summed if they have the same size");
    
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
        if(this.size() != vector.size())
            throw new UndefinedOperationException("Dot product is only defined for vectors of the same size");
    
        return (float) IntStream.range(0, this.size())
                .mapToDouble(i -> this.element(i) * vector.element(i))
                .sum();
    }
    
    @Override
    public float dotProduct(IntN vector) {
        if(this.size() != vector.size())
            throw new UndefinedOperationException("Dot product is only defined for vectors of the same size");
    
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
    
    public Stream<Float> stream() {
        return this.values.stream();
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
