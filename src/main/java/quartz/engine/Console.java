package quartz.engine;

import java.util.ArrayList;
import java.util.List;

public class Console {

    private static Console logger = null;

    private List<String> history;

    public static Console getLogger() {
        if (logger == null)
            logger = new Console();

        return logger;
    }

    public Console() {
        this.history = new ArrayList<String>();
    }

    public void Debug(String message) {
        System.out.println(message);
    }

    public void Info(String message) {
        System.out.println(message);
    }

    public void Error(String message) {
        System.err.println(message);
    }

    public boolean handleCommand(String command) {
        boolean handled = false;

        this.history.add(command);

        return handled;
    }
}
