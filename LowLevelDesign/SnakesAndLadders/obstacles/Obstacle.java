package obstacles;

public abstract class Obstacle {
    private int src;
    private int desc;
    public Obstacle(int src , int desc) {
        this.src = src;
        this.desc = desc;
    }
    public abstract ObstacleType getObstacleType();
    public int movePlayer() {
        return this.desc;
    }

    public int getSrc() {
        return src;
    }

    public int getDesc() {
        return desc;
    }
}
