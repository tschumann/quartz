package quartz.engine;

import org.junit.Assert;
import org.junit.Test;
import quartz.engine.common.Vector;

public class EntityTest {

    @Test
    public void testAngles() {
        IEntity entity = new Entity();

        Vector angles = entity.getAngles();

        Assert.assertTrue(angles.equals(new Vector(0, 0, 0)));

        angles.set(1, 1, 1);

        Assert.assertTrue(entity.getAngles().equals(new Vector(0, 0, 0)));
    }

    @Test
    public void testPosition() {
        IEntity entity = new Entity();

        Vector position = entity.getPosition();

        Assert.assertTrue(position.equals(new Vector(0, 0, 0)));

        position.set(1, 1, 1);

        Assert.assertTrue(entity.getPosition().equals(new Vector(0, 0, 0)));
    }
}
