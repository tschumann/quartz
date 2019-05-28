package quartz.engine;

import quartz.engine.common.Vector;
import quartz.engine.map.Map;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        // don't return a reference to the internal entity list
        return new ArrayList<IEntity>(this.entities);
    }

    public List<IEntity> getEntitiesInRadius(Vector position, float radius) {
        IEntity entities[] = this.entities.toArray(new Entity[this.entities.size()]);

        List<IEntity> entitiesInRadius = Stream.of(entities)
                .filter(e -> Math.abs(e.getPosition().distanceBetween(position)) < radius)
                .collect(Collectors.toList());

        return entitiesInRadius;
    }
}
