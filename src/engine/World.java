package engine;

import java.util.ArrayList;
import java.util.List;

public class World {

    private List<IEntity> entities;
    private Map map;

    public World() {
        this.entities = new ArrayList<IEntity>();
    }

    public void loadMap(Map map) {
        this.map = map;

        List<IEntity> mapEntities = this.map.getEntities();
        for (IEntity entity: mapEntities) {
            this.addEntity(entity);
        }
    }

    public String getMapName() {
        return this.map.getName();
    }

    public void addEntity(IEntity entity) {
        this.entities.add(entity);
    }

    public List<IEntity> getEntities() {
        return this.entities;
    }
}
