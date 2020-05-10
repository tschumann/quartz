package quartz.engine;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import quartz.engine.common.Vector;

public class WorldTest {

    @Test
    public void testGetEntitiesInRadius() {
        World world = new World();
        Entity entity = new Entity();
        entity.setPosition(new Vector(1, 1, 1));
        world.addEntity(entity);

        List<IEntity> entitiesInRadius = world.getEntitiesInRadius(new Vector(0, 0, 0), 2);
        Assertions.assertEquals(entitiesInRadius.size(), 1);
    }
}
