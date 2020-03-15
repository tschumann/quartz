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

    public Vector(Vector vector) {
        this.x = vector.x;
        this.y = vector.y;
        this.z = vector.z;
    }

    public float getRoll() {
        return this.x;
    }

    public float getPitch() {
        return this.y;
    }

    public float getYaw() {
        return this.z;
    }

    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Vector)) {
            return false;
        }

        Vector vec = (Vector)obj;

        return (Math.abs(this.getRoll() - vec.getRoll()) < 0.0001) && (Math.abs(this.getPitch() - vec.getPitch()) < 0.0001) && (Math.abs(this.getYaw() - vec.getYaw()) < 0.0001);
    }

    public float distanceBetween(Vector vector) {
        float xComponentDifference = (this.x - vector.x);
        float yComponentDifference = (this.y - vector.y);
        float zComponentDifference = (this.z - vector.z);

        return (float)Math.sqrt((xComponentDifference * xComponentDifference) + (yComponentDifference * yComponentDifference) + (zComponentDifference * zComponentDifference));
    }

    public String toString() {
        return "(" + String.valueOf(this.x) + "," + String.valueOf(this.y) + "," + String.valueOf(this.z) + ")";
    }
}
