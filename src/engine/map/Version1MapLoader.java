package engine.map;

import engine.IEntity;
import engine.common.Vector;

import java.io.BufferedReader;
import java.io.IOException;

public class Version1MapLoader extends BaseMapLoader {

    // TODO: pass something better than a reader?
    public void loadMap(BufferedReader reader) throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            String parts[] = line.split(",");

            IEntity entity;

            try {
                entity = (IEntity)Class.forName("game." + parts[0]).newInstance();
            }
            catch (ClassNotFoundException e) {
                this.logger.Error("Unknown entity " + parts[0]);
                continue;
            }
            catch (InstantiationException|IllegalAccessException e) {
                this.logger.Error("Unable to instantiate " + parts[0]);
                continue;
            }

            entity.setClassName(parts[0]);
            entity.setPosition(new Vector(new Float(parts[1]), new Float(parts[2]), new Float(parts[3])));
            this.logger.Debug("Adding " + entity);
            this.entities.add(entity);
        }
    }
}
