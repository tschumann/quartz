package quartz.engine;

public class Server {

    private World world;

    public void setWorld(World world) {
        this.world = world;
    }

    public String getMapName() {
        return this.world.getMapName();
    }

    public void mainLoop() {
        while (this.shouldRun()) {
            // get each iteration because entities can be added or removed
            for (IEntity entity: this.world.getEntities()) {
                entity.think();
            }
        }
    }

    public boolean shouldRun() {
        // TODO: expand on this
        return true;
    }
}
