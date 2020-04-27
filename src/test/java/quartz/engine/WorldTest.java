package quartz.engine;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import quartz.engine.common.Vector;

public class WorldTest {

    @Test
    public void testGetEntitiesInRadius() {
        World world = new World();
        Entity entity = new Entity();
        entity.setPosition(new Vector(1, 1, 1));
        world.addEntity(entity);

        List<IEntity> entitiesInRadius = world.getEntitiesInRadius(new Vector(0, 0, 0), 2);
        Assert.assertEquals(entitiesInRadius.size(), 1);
    }
}
