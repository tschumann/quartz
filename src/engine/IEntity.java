package engine;

import engine.common.Vector;

public interface IEntity {

    public String getClassName();
    public Vector getPosition();
    public void think();
}
