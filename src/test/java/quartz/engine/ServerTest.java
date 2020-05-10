package quartz.engine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ServerTest {

    @Test
    public void testHandleCommand() {
        Server server = new Server();

        Assertions.assertTrue(server.handleCommand("quit"));
        Assertions.assertFalse(server.handleCommand("nuke"));
    }
}
