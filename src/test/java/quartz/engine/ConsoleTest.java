package quartz.engine;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

public class ConsoleTest {

    @Test
    public void testHandleCommand() {
        Console console = new Console();

        Assert.assertFalse(console.handleCommand("quit"));
        Assert.assertFalse(console.handleCommand("nuke"));
    }

    @Test
    public void testGetOutput() {
        Console console = new Console();

        console.Debug("a message");
        console.Info("another message");
        console.Error("an error");

        Assert.assertEquals(console.getOutput(), new ArrayList<String>(Arrays.asList("a message", "another message", "an error")));
    }
}
