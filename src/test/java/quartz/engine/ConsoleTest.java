package quartz.engine;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConsoleTest {

    @Test
    public void testHandleCommand() {
        Console console = new Console();

        Assertions.assertFalse(console.handleCommand("quit"));
        Assertions.assertFalse(console.handleCommand("nuke"));
    }

    @Test
    public void testGetOutput() {
        Console console = new Console();

        console.Debug("a message");
        console.Info("another message");
        console.Error("an error");

        Assertions.assertEquals(console.getOutput(), new ArrayList<String>(Arrays.asList("a message", "another message", "an error")));
    }
}
