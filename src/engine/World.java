package engine;

import java.util.ArrayList;
import java.util.Collection;

public class World {

    private Collection<IEntity> entities;
    private Map map;

    public World() {
        this.entities = new ArrayList<IEntity>();
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
