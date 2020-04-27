package quartz.engine.map;

import java.util.List;
import quartz.engine.IEntity;

public interface IMapLoader {

    public void loadEntities(EntitySection entitySection);
    public List<IEntity> getEntities();
}
