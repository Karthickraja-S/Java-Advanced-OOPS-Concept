package obstacles;

public class LadderObstacle extends Obstacle {
    public LadderObstacle(int up, int down) {
        super(down, up);
    }

    @Override
    public ObstacleType getObstacleType() {
        return ObstacleType.LADDER;
    }
}
