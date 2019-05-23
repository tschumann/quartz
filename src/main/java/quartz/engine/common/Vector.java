package quartz.engine.common;

public class Vector {

    private float x;
    private float y;
    private float z;

    public Vector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String toString() {
        return "(" + String.valueOf(this.x) + "," + String.valueOf(this.y) + "," + String.valueOf(this.z) + ")";
    }
}
