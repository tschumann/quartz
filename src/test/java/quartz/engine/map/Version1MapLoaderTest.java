package quartz.engine.map;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Version1MapLoaderTest {

    @Test
    public void testLoadNoEntities() {
        List<String> entities = new ArrayList<String>();
        entities.add("version 1");
        Version1MapLoader loader = new Version1MapLoader();
        loader.loadMap(entities);
        assertEquals(0, loader.getEntities().size());
    }

    @Test
    public void testLoadInvalidEntities() {
        List<String> entities = new ArrayList<String>();
        entities.add("version 1");
        entities.add("blah");
        entities.add("blah,blah,blah,blah");
        entities.add("blah,blah,blah,blah,blah,blah,blah,blah");
        Version1MapLoader loader = new Version1MapLoader();
        loader.loadMap(entities);
        assertEquals(0, loader.getEntities().size());
    }

    @Test
    public void testLoadEntities() {
        List<String> entities = new ArrayList<String>();
        entities.add("version 1");
        entities.add("SpawnEntity,0,0,0,0,0,0");
        Version1MapLoader loader = new Version1MapLoader();
        loader.loadMap(entities);
        assertEquals(1, loader.getEntities().size());
    }
}
