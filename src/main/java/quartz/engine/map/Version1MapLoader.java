package quartz.engine.map;

import quartz.engine.IEntity;
import quartz.engine.common.Vector;

import java.util.List;

public class Version1MapLoader extends BaseMapLoader {

    public static int ENTITY_PARTS_COUNT = 7;

    public void loadMap(List<String> lines) {
        // start from line 1 because line 0 is the version information
        // TODO: should probably fix this to not rely on the version string being element 0
        for (int i = 1; i < lines.size(); i++) {
            int lineNumber = i + 1;
            String line = lines.get(i);
            String parts[] = line.split(",");

            if (parts.length != ENTITY_PARTS_COUNT) {
                // TODO: ideally put line number in here
                this.logger.Error("Entity declaration on line " + lineNumber + " was " + parts.length + " items: expected " + ENTITY_PARTS_COUNT);
                continue;
            }

            IEntity entity = this.getEntityFromName(parts[0]);

            if (entity != null) {
                entity.setClassName(parts[0]);
                entity.setPosition(new Vector(new Float(parts[1]), new Float(parts[2]), new Float(parts[3])));
                entity.setAngles(new Vector(new Float(parts[4]), new Float(parts[5]), new Float(parts[6])));
                this.logger.Debug("Adding " + entity);
                this.entities.add(entity);
            } else {
                this.logger.Error("Unable to instantiate " + parts[0] + " on line " + lineNumber);
            }
        }
    }
}
