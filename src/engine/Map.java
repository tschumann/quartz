package engine;

import engine.exceptions.EngineException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Map {

    private String mapname;
    private List<String> lines;

    public Map(String mapname) throws EngineException {
        this.mapname = mapname;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.mapname));

            String line;

            while ((line = reader.readLine()) != null) {
                this.lines.add(line);
            }

            reader.close();
        }
        catch (IOException e) {
            throw new EngineException("Map file doesn't exist");
        }
    }
}