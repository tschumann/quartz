package quartz.engine.map;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Version1MapLoaderTest {

    @Test
    public void testLoadNoEntities() {
        List<String> entities = new ArrayList<String>();
        Version1MapLoader loader = new Version1MapLoader();
        loader.loadEntities(new EntitySection(0, entities));
        Assertions.assertEquals(0, loader.getEntities().size());
    }

    @Test
    public void testLoadInvalidEntities() {
        List<String> entities = new ArrayList<String>();
        entities.add("blah");
        entities.add("blah,blah,blah,blah");
        entities.add("blah,blah,blah,blah,blah,blah,blah,blah");
        Version1MapLoader loader = new Version1MapLoader();
        loader.loadEntities(new EntitySection(0, entities));
        Assertions.assertEquals(0, loader.getEntities().size());
    }

    @Test
    public void testLoadEntities() {
        List<String> entities = new ArrayList<String>();
        entities.add("SpawnEntity,0,0,0,0,0,0");
        Version1MapLoader loader = new Version1MapLoader();
        loader.loadEntities(new EntitySection(0, entities));
        Assertions.assertEquals(1, loader.getEntities().size());
    }
}
