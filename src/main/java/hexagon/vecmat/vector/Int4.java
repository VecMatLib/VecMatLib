package hexagon.vecmat.vector;

public class Int4 implements IntVector<Int4, Float4> {
    
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    
    public Int4(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public Int4 plus(Int4 operand) {
        return this.plus(operand.a, operand.b, operand.c, operand.d);
    }
    
    @Override
    public Float4 plus(Float4 operand) {
        return this.plus(operand.x, operand.y, operand.z, operand.w);
    }
    
    public Int4 plus(int a, int b, int c, int d) {
        return new Int4(this.a + a, this.b + b, this.c + c, this.d + d);
    }
    
    public Float4 plus(float x, float y, float z, float w) {
        return new Float4(this.a + x, this.b + y, this.c + z, this.d + w);
    }
    
    @Override
    public Int4 negated() {
        return new Int4(-this.a, -this.b, -this.c, -this.d);
    }
    
    public Int4 minus(int a, int b, int c, int d) {
        return this.plus(-a, -b, -c, -d);
    }
    
    public Float4 minus(float x, float y, float z, float w) {
        return this.plus(-x, -y, -z, -w);
    }
    
    @Override
    public Int4 times(int k) {
        return new Int4(this.a * k, this.b * k, this.c * k, this.d * k);
    }
    
    @Override
    public Float4 times(float k) {
        return new Float4(this.a * k, this.b * k, this.c * k, this.d * k);
    }
    
    @Override
    public Int4 dividedBy(int k) {
        return new Int4(this.a / k, this.b / k, this.c / k, this.d / k);
    }
    
    @Override
    public int dotProduct(Int4 vector) {
        return this.a * vector.a + this.b * vector.b + this.c * vector.c + this.d * vector.d;
    }
    
    @Override
    public float dotProduct(Float4 vector) {
        return this.a * vector.x + this.b * vector.y + this.c * vector.z + this.d * vector.w;
    }
    
    @Override
    public int lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public boolean equals(Int4 value) {
        return this.a == value.a && this.b == value.b && this.c == value.c && this.d == value.d;
    }
    
    @Override
    public boolean equals(Float4 value) {
        return this.a == value.x && this.b == value.y && this.c == value.z && this.d == value.w;
    }
    
    @Override
    public String toString() {
        return "Int4(" + a + ", " + b + ", " + c + ", " + d + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Int4 && ((Int4) object).equals(this);
    }
}
