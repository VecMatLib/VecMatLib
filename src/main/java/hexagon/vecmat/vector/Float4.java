package hexagon.vecmat.vector;

public class Float4 implements FloatVector<Float4, Int4> {
    
    public final float x;
    public final float y;
    public final float z;
    public final float w;
    
    public Float4(float x, float y, float z, float w) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }
    
    @Override
    public Float4 plus(Float4 operand) {
        return this.plus(operand.x, operand.y, operand.z, operand.w);
    }
    
    @Override
    public Float4 plus(Int4 operand) {
        return this.plus(operand.a, operand.b, operand.c, operand.d);
    }
    
    public Float4 plus(float x, float y, float z, float w) {
        return new Float4(this.x + x, this.y + y, this.z + z, this.w + w);
    }
    
    @Override
    public Float4 negated() {
        return new Float4(-this.x, -this.y, -this.z, -this.w);
    }
    
    public Float4 minus(float x, float y, float z) {
        return this.plus(-x, -y, -z, -w);
    }
    
    @Override
    public Float4 times(float k) {
        return new Float4(this.x * k, this.y * k, this.z * k, this.w * k);
    }
    
    @Override
    public float dotProduct(Float4 vector) {
        return this.x * vector.x + this.y * vector.y + this.z * vector.z + this.w * vector.w;
    }
    
    @Override
    public float dotProduct(Int4 vector) {
        return this.x * vector.a + this.y * vector.b + this.z * vector.c + this.w * vector.d;
    }
    
    @Override
    public float lengthSquared() {
        return this.dotProduct(this);
    }
    
    @Override
    public Int4 castToInt() {
        return new Int4((int) this.x, (int) this.y, (int) this.z, (int) this.w);
    }
    
    @Override
    public boolean equals(Float4 value) {
        return this.equals(value.x, value.y, value.z, value.w);
    }
    
    @Override
    public boolean equals(Int4 value) {
        return this.equals(value.a, value.b, value.c, value.d);
    }
    
    public boolean equals(float x, float y, float z, float w) {
        return this.x == x && this.y == y && this.z == z && this.w == w;
    }
    
    @Override
    public String toString() {
        return "Float4(" + x + ", " + y + ", " + z + ", " + w + ')';
    }
    
    @Override
    public boolean equals(Object object) {
        return object instanceof Float4 && ((Float4) object).equals(this);
    }
}
