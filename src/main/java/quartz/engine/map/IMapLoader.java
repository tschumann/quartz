package quartz.engine.map;

import quartz.engine.IEntity;

import java.util.List;

public interface IMapLoader {

    public void loadEntities(EntitySection entitySection);
    public List<IEntity> getEntities();
}
