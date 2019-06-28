package quartz.engine;

import java.util.ArrayList;
import java.util.List;

public class Console {

    private static Console logger = null;

    private List<String> history;
    private List<String> output;

    public static Console getLogger() {
        if (logger == null)
            logger = new Console();

        return logger;
    }

    public Console() {
        this.history = new ArrayList<String>();
        this.output = new ArrayList<String>();
    }

    public void Debug(String message) {
        this.appendToOutput(message);
        System.out.println(message);
    }

    public void Info(String message) {
        this.appendToOutput(message);
        System.out.println(message);
    }

    public void Error(String message) {
        this.appendToOutput(message);
        System.err.println(message);
    }

    private void appendToOutput(String line) {
        this.output.add(line);
    }

    public boolean handleCommand(String command) {
        // TODO: offload to engine then game to work out if handled
        boolean handled = false;

        this.history.add(command);

        return handled;
    }

    public List<String> getOutput() {
        return new ArrayList<String>(this.output);
    }
}
