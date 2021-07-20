package hexagon.vecmat.vector;

public class Int2 implements IntVector<Int2, Float2> {
    
    public final int a;
    public final int b;
    
    public Int2(int a, int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public Int2 plus(Int2 operand) {
        return this.plus(operand.a, operand.b);
    }
    
    @Override
    public Float2 plus(Float2 operand) {
        return this.plus(operand.x, operand.y);
    }
    
    public Int2 plus(int a, int b) {
        return new Int2(this.a + a, this.b + b);
    }
    
    public Float2 plus(float x, float y) {
        return new Float2(this.a + x, this.b + y);
    }
    
    @Override
    public Int2 negated() {
        return new Int2(-this.a, -this.b);
    }
    
    public Int2 minus(int a, int b) {
        return this.plus(-a, -b);
    }
    
    public Float2 minus(float x, float y) {
        return this.plus(-x, -y);
    }
    
    @Override
    public Int2 times(int k) {
        return new Int2(this.a * k, this.b * k);
    }
    
    @Override
    public Float2 times(float k) {
        return new Float2(this.a * k, this.b * k);
    }
    
    @Override
    public Int2 dividedBy(int k) {
        return new Int2(this.a / k, this.b / k);
    }
    
    @Override
    public int dotProduct(Int2 vector) {
        return this.a * vector.a + this.b * vector.b;
    }
    
    @Override
    public float dotProduct(Float2 vector) {
        return this.a * vector.x + this.b * vector.y;
    }
    
    @Override
    public int lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public boolean equals(Int2 value) {
        return this.equals(value.a, value.b);
    }
    
    public boolean equals(int a, int b) {
        return this.a == a && this.b == b;
    }
    
    @Override
    public boolean equals(Float2 value) {
        return this.equals(value.x, value.y);
    }
    
    public boolean equals(float x, float y) {
        return this.a == x && this.b == y;
    }
    
    @Override
    public String toString() {
        return "Int2(" + a + ", " + b + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Int2 && ((Int2) object).equals(this);
    }
}
