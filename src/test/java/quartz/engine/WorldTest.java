package quartz.engine;

import org.junit.Test;
import quartz.engine.common.Vector;

import java.util.List;

import static org.junit.Assert.*;

public class WorldTest {

    @Test
    public void testGetEntitiesInRadius() {
        World world = new World();
        Entity entity = new Entity();
        entity.setPosition(new Vector(1, 1, 1));
        world.addEntity(entity);

        List<IEntity> entitiesInRadius = world.getEntitiesInRadius(new Vector(0, 0, 0), 2);
        assertEquals(entitiesInRadius.size(), 1);
    }
}
