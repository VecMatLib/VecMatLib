package hexagon.vecmat.vector;

public interface IntVector<I extends IntVector<I, F>, F extends FloatVector<F, I>> {
    
    I plus(I operand);
    
    F plus(F operand);
    
    I negated();
    
    default I minus(I operand) {
        return this.plus(operand.negated());
    }
    
    default F minus(F operand) {
        return this.plus(operand.negated());
    }
    
    I times(int constant);
    
    F times(float constant);
    
    I dividedBy(int constant);
    
    default F dividedBy(float constant) {
        return this.times(1.0f / constant);
    }
    
    int dotProduct(I vector);
    
    float dotProduct(F vector);
    
    default float length() {
        return (float) Math.sqrt(this.lengthSquared());
    }
    
    int lengthSquared();
    
    default F normalized() {
        return this.dividedBy(this.length());
    }
    
    default float angle(I vector) {
        return (float) Math.acos(this.dotProduct(vector) / (this.length() * vector.length()));
    }
    
    default float angle(F vector) {
        return (float) Math.acos(this.dotProduct(vector) / (this.length() * vector.length()));
    }
    
    boolean equals(I value);
    
    boolean equals(F value);
}
