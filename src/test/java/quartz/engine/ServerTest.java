package quartz.engine;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServerTest {

    @Test
    public void testHandleCommand() {
        Server server = new Server();

        assertTrue(server.handleCommand("quit"));
        assertFalse(server.handleCommand("nuke"));
    }
}
