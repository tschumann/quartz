package quartz.engine.map;

import quartz.engine.IEntity;
import quartz.engine.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMapLoader implements IMapLoader {

    protected Logger logger;
    protected List<IEntity> entities;

    public BaseMapLoader() {
        this.logger = Logger.getLogger();
        this.entities = new ArrayList<IEntity>();
    }

    public IEntity getEntityFromName(String name) {
        IEntity entity = null;

        try {
            entity = (IEntity)Class.forName("main.java.quartz.game." + name).newInstance();
        }
        catch (ClassNotFoundException e) {
            this.logger.Error("Unknown entity " + name);
        }
        catch (InstantiationException|IllegalAccessException e) {
            this.logger.Error("Unable to instantiate " + name);
        }

        return entity;
    }

    public List<IEntity> getEntities() {
        return this.entities;
    }
}
