package engine.map;

import engine.IEntity;
import engine.common.Vector;

import java.io.BufferedReader;
import java.io.IOException;

public class Version1MapLoader extends BaseMapLoader {

    public static int ENTITY_PARTS_COUNT = 7;

    // TODO: pass something better than a reader?
    public void loadMap(BufferedReader reader) throws IOException {
        String line;

        while ((line = reader.readLine()) != null) {
            String parts[] = line.split(",");

            if (parts.length != ENTITY_PARTS_COUNT) {
                // TODO: ideally put line number in here - instantiate reader in this method to do that?
                this.logger.Error("Entity declaration was " + parts.length + " items: expected " + ENTITY_PARTS_COUNT);
                continue;
            }

            IEntity entity = this.getEntityFromName(parts[0]);

            if (entity != null) {
                entity.setClassName(parts[0]);
                entity.setPosition(new Vector(new Float(parts[1]), new Float(parts[2]), new Float(parts[3])));
                entity.setAngles(new Vector(new Float(parts[4]), new Float(parts[5]), new Float(parts[6])));
                this.logger.Debug("Adding " + entity);
                this.entities.add(entity);
            }
        }
    }
}
