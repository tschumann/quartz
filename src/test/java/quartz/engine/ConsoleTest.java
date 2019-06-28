package quartz.engine;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class ConsoleTest {

    @Test
    public void testHandleCommand() {
        Console console = new Console();

        assertFalse(console.handleCommand("quit"));
        assertFalse(console.handleCommand("nuke"));
    }

    @Test
    public void testGetOutput() {
        Console console = new Console();

        console.Debug("a message");
        console.Info("another message");
        console.Error("an error");

        assertEquals(console.getOutput(), new ArrayList<String>(Arrays.asList("a message", "another message", "an error")));
    }
}
