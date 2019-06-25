package quartz.engine.map;

import quartz.engine.IEntity;
import quartz.engine.Console;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseMapLoader implements IMapLoader {

    protected Console logger;
    protected List<IEntity> entities;

    public BaseMapLoader() {
        this.logger = Console.getLogger();
        this.entities = new ArrayList<IEntity>();
    }

    public IEntity getEntityFromName(String name) {
        IEntity entity = null;

        try {
            entity = (IEntity)Class.forName("quartz.game." + name).newInstance();
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
        // don't return a reference to the internal entity list
        return new ArrayList<IEntity>(this.entities);
    }
}
