package quartz.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpawnEntityTest {

    @Test
    public void testGetClassname() {
        Assertions.assertEquals("spawn", new SpawnEntity().getClassName());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("spawn (0.0,0.0,0.0)", new SpawnEntity().toString());
    }
}
