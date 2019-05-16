package engine;

import engine.common.Vector;
import engine.exceptions.EngineException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private String mapname;
    private List<String> lines;
    private List<IEntity> entities;

    public Map(String mapname) throws EngineException {
        this.mapname = mapname;
        this.entities = new ArrayList<IEntity>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.mapname));

            String line;

            while ((line = reader.readLine()) != null) {
                String parts[] = line.split(",");
                Entity entity = new Entity();
                entity.setClassName(parts[0]);
                entity.setPosition(new Vector(new Float(parts[0]), new Float(parts[1]), new Float(parts[2])));
                this.entities.add(entity);
            }

            reader.close();
        }
        catch (IOException e) {
            throw new EngineException("Map file doesn't exist");
        }
    }

    public List<IEntity> getEntities() {
        return this.entities;
    }
}