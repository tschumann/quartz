package engine.map;

import engine.IEntity;
import engine.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMapLoader implements IMapLoader {

    protected Logger logger;
    protected List<IEntity> entities;

    public BaseMapLoader() {
        this.logger = Logger.getLogger();
        this.entities = new ArrayList<IEntity>();
    }

    public List<IEntity> getEntities() {
        return this.entities;
    }
}
