package hexagon.vecmat.vector;

public class Float3 implements FloatVector<Float3, Int3> {
    
    public final float x;
    public final float y;
    public final float z;
    
    public Float3(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    @Override
    public Float3 plus(Float3 operand) {
        return this.plus(operand.x, operand.y, operand.z);
    }
    
    @Override
    public Float3 plus(Int3 operand) {
        return this.plus(operand.a, operand.b, operand.c);
    }
    
    public Float3 plus(float x, float y, float z) {
        return new Float3(this.x + x, this.y + y, this.z + z);
    }
    
    @Override
    public Float3 negated() {
        return new Float3(-this.x, -this.y, -this.z);
    }
    
    public Float3 minus(float x, float y, float z) {
        return this.plus(-x, -y, -z);
    }
    
    @Override
    public Float3 times(float k) {
        return new Float3(this.x * k, this.y * k, this.z * k);
    }
    
    @Override
    public float dotProduct(Float3 vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z;
    }
    
    @Override
    public float dotProduct(Int3 vector) {
        return this.x * vector.a + this.y * vector.b + this.z * vector.c;
    }
    
    public Float3 crossProduct(Float3 vector) {
        return new Float3(this.y * vector.z - this.z * vector.y, vector.x * this.z - vector.z * this.x, this.x * vector.y - this.y * vector.x);
    }
    
    public Float3 crossProduct(Int3 vector) {
        return new Float3(this.y * vector.c - this.z * vector.b, vector.a * this.z - vector.c * this.x, this.x * vector.b - this.y * vector.a);
    }
    
    @Override
    public float lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public Int3 castToInt() {
        return new Int3((int) this.x, (int) this.y, (int) this.z);
    }
    
    @Override
    public boolean equals(Float3 value) {
        return this.equals(value.x, value.y, value.z);
    }
    
    @Override
    public boolean equals(Int3 value) {
        return this.equals(value.a, value.b, value.c);
    }
    
    public boolean equals(float x, float y, float z) {
        return this.x == x && this.y == y && this.z == z;
    }
    
    @Override
    public String toString() {
        return "Float3(" + x + ", " + y + ", " + z + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Float3 && ((Float3) object).equals(this);
    }
}
