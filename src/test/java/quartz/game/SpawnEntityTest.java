package quartz.game;

import org.junit.Assert;
import org.junit.Test;

public class SpawnEntityTest {

    @Test
    public void testGetClassname() {
        Assert.assertEquals("spawn", new SpawnEntity().getClassName());
    }

    @Test
    public void testToString() {
        Assert.assertEquals("spawn (0.0,0.0,0.0)", new SpawnEntity().toString());
    }
}
