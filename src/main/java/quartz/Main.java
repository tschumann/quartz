package quartz;

import quartz.engine.Server;
import quartz.engine.World;
import quartz.engine.exceptions.EngineException;
import quartz.engine.map.Map;

public class Main {

    public static void main(String args[]) throws EngineException {
        World world = new World();
        Server server = new Server();
        server.setWorld(world);

        String mapname = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("map")) {
                if (args.length > i) {
                    mapname = args[i + 1];
                }
            }
        }

        if (mapname.equals("")) {
            throw new EngineException("No map provided");
        }

        System.out.println("Loading map " + mapname);
        Map map = new Map(mapname);
        world.loadMap(map);
        System.out.println("Server running map " + server.getMapName());

        while (server.shouldRun()) {
            server.mainLoop();
        }
    }
}