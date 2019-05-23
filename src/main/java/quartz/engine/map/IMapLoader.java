package quartz.engine.map;

import quartz.engine.IEntity;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public interface IMapLoader {

    public void loadMap(BufferedReader reader) throws IOException;
    public List<IEntity> getEntities();
}
