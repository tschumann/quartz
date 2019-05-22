package engine;

import engine.common.Vector;

public interface IEntity {

    public void setClassName(String className);
    public void setPosition(Vector position);
    public void setAngles(Vector angles);
    public String getClassName();
    public Vector getPosition();
    public Vector getAngles();
    public void think();
}
