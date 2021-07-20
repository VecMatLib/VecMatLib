package hexagon.vecmat.vector;

public class Int3 implements IntVector<Int3, Float3> {
    
    public final int a;
    public final int b;
    public final int c;
    
    public Int3(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public Int3 plus(Int3 operand) {
        return this.plus(operand.a, operand.b, operand.c);
    }
    
    @Override
    public Float3 plus(Float3 operand) {
        return this.plus(operand.x, operand.y, operand.z);
    }
    
    public Int3 plus(int a, int b, int c) {
        return new Int3(this.a + a, this.b + b, this.c + c);
    }
    
    public Float3 plus(float x, float y, float z) {
        return new Float3(this.a + x, this.b + y, this.c + z);
    }
    
    @Override
    public Int3 negated() {
        return new Int3(-this.a, -this.b, -this.c);
    }
    
    public Int3 minus(int a, int b, int c) {
        return this.plus(-a, -b, -c);
    }
    
    public Float3 minus(float x, float y, float z) {
        return this.plus(-x, -y, -z);
    }
    
    @Override
    public Int3 times(int k) {
        return new Int3(this.a * k, this.b * k, this.c * k);
    }
    
    @Override
    public Float3 times(float k) {
        return new Float3(this.a * k, this.b * k, this.c * k);
    }
    
    @Override
    public Int3 dividedBy(int k) {
        return new Int3(this.a / k, this.b / k, this.c / k);
    }
    
    @Override
    public int dotProduct(Int3 vector) {
        return this.a * vector.a + this.b * vector.b + this.c * vector.c;
    }
    
    @Override
    public float dotProduct(Float3 vector) {
        return this.a * vector.x + this.b * vector.y + this.c * vector.z;
    }
    
    public Int3 crossProduct(Int3 vector) {
        return new Int3(this.b * vector.c - this.c * vector.b, vector.a * this.c - vector.c * this.a, this.a * vector.b - this.b * vector.a);
    }
    
    public Float3 crossProduct(Float3 vector) {
        return new Float3(this.b * vector.z - this.c * vector.y, vector.x * this.c - vector.z * this.a, this.a * vector.y - this.b * vector.x);
    }
    
    @Override
    public int lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public boolean equals(Int3 value) {
        return this.a == value.a && this.b == value.b && this.c == value.c;
    }
    
    @Override
    public boolean equals(Float3 value) {
        return this.a == value.x && this.b == value.y && this.c == value.z;
    }
    
    @Override
    public String toString() {
        return "Int3(" + a + ", " + b + ", " + c + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Int3 && ((Int3) object).equals(this);
    }
}
