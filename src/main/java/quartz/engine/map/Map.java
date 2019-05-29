package quartz.engine.map;

import quartz.engine.IEntity;
import quartz.engine.Logger;
import quartz.engine.exceptions.EngineException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Map {

    private Logger logger;
    private String mapName;
    private List<String> lines;
    private List<IEntity> entities;

    public Map(String mapname) throws EngineException {
        this.logger = Logger.getLogger();
        this.mapName = mapname;
        this.entities = new ArrayList<IEntity>();

        try {
            this.lines = Files.readAllLines(Paths.get(this.mapName));

            if (this.lines.size() == 0) {
                throw new EngineException("No lines in map");
            }

            String headerParts[] = this.lines.get(0).split(" ");

            if (headerParts.length != 2) {
                throw new EngineException("Unexpected number of items in map header");
            }

            if (!headerParts[0].equals("version")) {
                throw new EngineException("Unexpected item in map header");
            }

            String version = headerParts[1];
            IMapLoader mapLoader;

            try {
                mapLoader = (IMapLoader)Class.forName("quartz.engine.map.Version" + version + "MapLoader").newInstance();
            }
            catch (ClassNotFoundException e) {
                throw new EngineException("Unknown map version: " + version);
            }
            catch (InstantiationException|IllegalAccessException e) {
                throw new EngineException("Problem instantiating map loader");
            }

            mapLoader.loadMap(this.lines);
            this.entities.addAll(mapLoader.getEntities());

            this.logger.Debug("Map " + this.mapName + " has " + this.entities.size() + " entities");
        }
        catch (IOException e) {
            throw new EngineException("Map file doesn't exist");
        }
    }

    public List<IEntity> getEntities() {
        // don't return a reference to the internal entity list
        return new ArrayList<IEntity>(this.entities);
    }

    public String getName() {
        return this.mapName;
    }
}