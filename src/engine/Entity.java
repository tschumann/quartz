package engine;

import engine.common.Vector;

public class Entity implements IEntity{

    private String className;
    private Vector position;

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return this.className;
    }

    public void setPosition(Vector position) {
        this.position = position;
    }

    public Vector getPosition() {
        return this.position;
    }
}
