package quartz.engine;

import java.util.ArrayList;
import java.util.List;

public class Console {

    private List<String> history;

    public Console() {
        this.history = new ArrayList<String>();
    }

    public boolean handleCommand(String command) {
        boolean handled = false;

        this.history.add(command);

        return handled;
    }
}
