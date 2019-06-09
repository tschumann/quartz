package quartz.engine.map;

import java.util.ArrayList;
import java.util.List;

public class EntitySection {

    private int startLine;
    private List<String> lines;

    private EntitySection() {
    }

    public EntitySection(int startLine, List<String> lines) {
        this.startLine = startLine;
        this.lines = lines;
    }

    public int getStartLine() {
        return this.startLine;
    }

    public List<String> getLines() {
        return new ArrayList<String>(this.lines);
    }
}
