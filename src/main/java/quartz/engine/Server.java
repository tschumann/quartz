package quartz.engine;

public class Server {

    private World world;

    private long elapsed;
    private long seconds;
    private long ticks;
    private long frames;
    private float framesPerSecond;

    public Server() {
        this.elapsed = 0;
        this.seconds = 0;
        this.ticks = 0;
        this.frames = 0;
        this.framesPerSecond = 0;
    }

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
        long currentSeconds = System.currentTimeMillis() / 1000;
        if (this.elapsed + 1 < currentSeconds) {
            this.elapsed = currentSeconds;
            this.seconds++;
            this.framesPerSecond = this.frames;
            this.frames = 0;
        }
        this.ticks++;
        this.frames++;
    }

    public boolean shouldRun() {
        // TODO: expand on this
        return true;
    }
}
