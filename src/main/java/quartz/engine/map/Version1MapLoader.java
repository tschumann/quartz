package quartz.engine.map;

import java.util.List;
import quartz.engine.IEntity;
import quartz.engine.common.Vector;

public class Version1MapLoader extends BaseMapLoader {

    public static int ENTITY_PARTS_COUNT = 7;

    public void loadEntities(EntitySection entitySection) {
        List<String> lines = entitySection.getLines();
        for (int i = 0; i < lines.size(); i++) {
            int lineNumber = entitySection.getStartLine() + i;
            String line = lines.get(i);
            String parts[] = line.split(",");

            if (parts.length != ENTITY_PARTS_COUNT) {
                this.logger.Error("Entity declaration on line " + lineNumber + " was " + parts.length + " items: expected " + ENTITY_PARTS_COUNT);
                continue;
            }

            IEntity entity = this.getEntityFromName(parts[0]);

            if (entity != null) {
                entity.setClassName(parts[0]);
                entity.setPosition(new Vector(Float.parseFloat(parts[1]), Float.parseFloat(parts[2]), Float.parseFloat(parts[3])));
                entity.setAngles(new Vector(Float.parseFloat(parts[4]), Float.parseFloat(parts[5]), Float.parseFloat(parts[6])));
                this.logger.Debug("Adding " + entity);
                this.entities.add(entity);
            } else {
                this.logger.Error("Unable to instantiate " + parts[0] + " on line " + lineNumber);
            }
        }
    }
}
