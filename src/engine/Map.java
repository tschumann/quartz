package engine;

import engine.common.Vector;
import engine.exceptions.EngineException;
import engine.map.IMapLoader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private Logger logger;
    private String mapname;
    private List<String> lines;
    private List<IEntity> entities;

    public Map(String mapname) throws EngineException {
        this.logger = Logger.getLogger();
        this.mapname = mapname;
        this.entities = new ArrayList<IEntity>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.mapname));

            String line = reader.readLine();

            String headerParts[] = line.split(" ");

            if (headerParts.length != 2) {
                throw new EngineException("Unexpected number of items in map header");
            }

            if (!headerParts[0].equals("version")) {
                throw new EngineException("Unexpected item in map header");
            }

            String version = headerParts[1];
            IMapLoader mapLoader;

            try {
                mapLoader = (IMapLoader)Class.forName("engine.map.Version" + version + "MapLoader").newInstance();
            }
            catch (ClassNotFoundException e) {
                throw new EngineException("Unknown map version");
            }
            catch (InstantiationException|IllegalAccessException e) {
                throw new EngineException("Problem instantianing map loader");
            }

            mapLoader.loadMap(reader);
            this.entities.addAll(mapLoader.getEntities());

            this.logger.Debug("Map " + this.mapname + " has " + this.entities.size() + " entities");

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