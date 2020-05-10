package quartz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import quartz.engine.exceptions.EngineException;

public class MainTest {

    @Test
    public void testNoMap() {
        boolean threw = false;

        try {
            Main.main(new String[0]);
        }
        catch (EngineException e) {
            threw = true;
        }

        Assertions.assertTrue(threw);
    }
}
