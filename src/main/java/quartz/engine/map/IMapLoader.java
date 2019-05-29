package quartz.engine.map;

import quartz.engine.IEntity;

import java.util.List;

public interface IMapLoader {

    public void loadMap(List<String> lines);
    public List<IEntity> getEntities();
}
