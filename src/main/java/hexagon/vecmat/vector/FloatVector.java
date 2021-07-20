package hexagon.vecmat.vector;

public interface FloatVector<F extends FloatVector<F, I>, I extends IntVector<I, F>> {
    
    F plus(F operand);
    
    F plus(I operand);
    
    F negated();
    
    default F minus(F operand) {
        return this.plus(operand.negated());
    }
    
    default F minus(I operand) {
        return this.plus(operand.negated());
    }
    
    F times(float constant);
    
    default F dividedBy(float constant) {
        return this.times(1.0f / constant);
    }
    
    float dotProduct(F vector);
    
    float dotProduct(I vector);
    
    default float length() {
        return (float) Math.sqrt(this.lengthSquared());
    }
    
    float lengthSquared();
    
    default F normalized() {
        return this.dividedBy(this.length());
    }
    
    I castToInt();
    
    default float angle(F vector) {
        return (float) Math.acos(this.dotProduct(vector) / (this.length() * vector.length()));
    }
    
    default float angle(I vector) {
        return (float) Math.acos(this.dotProduct(vector) / (this.length() * vector.length()));
    }
    
    boolean equals(F value);
    
    boolean equals(I value);
}
