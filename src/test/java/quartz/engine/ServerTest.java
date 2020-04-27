package quartz.engine;

import org.junit.Assert;
import org.junit.Test;

public class ServerTest {

    @Test
    public void testHandleCommand() {
        Server server = new Server();

        Assert.assertTrue(server.handleCommand("quit"));
        Assert.assertFalse(server.handleCommand("nuke"));
    }
}
