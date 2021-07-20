package hexagon.vecmat.vector;

public class Float2 implements FloatVector<Float2, Int2> {
    
    public final float x;
    public final float y;
    
    public Float2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public Float2 plus(Float2 operand) {
        return this.plus(operand.x, operand.y);
    }
    
    @Override
    public Float2 plus(Int2 operand) {
        return this.plus(operand.a, operand.b);
    }
    
    public Float2 plus(float x, float y) {
        return new Float2(this.x + x, this.y + y);
    }
    
    @Override
    public Float2 negated() {
        return new Float2(-this.x, -this.y);
    }
    
    public Float2 minus(float x, float y) {
        return this.plus(-x, -y);
    }
    
    @Override
    public Float2 times(float k) {
        return new Float2(this.x * k, this.y * k);
    }
    
    @Override
    public float dotProduct(Float2 vector) {
        return this.x * vector.x + this.y * vector.y;
    }
    
    @Override
    public float dotProduct(Int2 vector) {
        return this.x * vector.a + this.y * vector.b;
    }
    
    @Override
    public float lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public Int2 castToInt() {
        return new Int2((int) this.x, (int) this.y);
    }
    
    @Override
    public boolean equals(Float2 value) {
        return this.equals(value.x, value.y);
    }
    
    @Override
    public boolean equals(Int2 value) {
        return this.equals(value.a, value.b);
    }
    
    public boolean equals(float x, float y) {
        return this.x == x && this.y == y;
    }
    
    @Override
    public String toString() {
        return "Float2(" + x + ", " + y + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Float2 && ((Float2) object).equals(this);
    }
}
