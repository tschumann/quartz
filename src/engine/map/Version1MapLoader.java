package engine.map;

import engine.Entity;
import engine.common.Vector;

import java.io.BufferedReader;
import java.io.IOException;

public class Version1MapLoader extends BaseMapLoader {

    // TODO: pass something better than a reader?
    public void loadMap(BufferedReader reader) throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            String parts[] = line.split(",");
            Entity entity = new Entity();
            entity.setClassName(parts[0]);
            entity.setPosition(new Vector(new Float(parts[1]), new Float(parts[2]), new Float(parts[3])));
            this.logger.Debug("Adding " + entity);
            this.entities.add(entity);
        }
    }
}
