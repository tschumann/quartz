package quartz.engine;

import quartz.engine.common.Vector;

public class Entity implements IEntity {

    private String className;
    private Vector position;
    private Vector angles;

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public void setAngles(Vector angles) {
        this.angles = angles;
    }

    public Vector getPosition() {
        return new Vector(this.position);
    }

    public Vector getAngles() {
        return new Vector(this.angles);
    }

    public String toString() {
        return this.className + " " + this.position;
    }

    public void think() {
    }
}
