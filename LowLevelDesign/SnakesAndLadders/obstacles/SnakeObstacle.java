package obstacles;

public class SnakeObstacle extends Obstacle {
    public SnakeObstacle(int up, int down) {
        super(up, down);
    }

    @Override
    public ObstacleType getObstacleType() {
        return ObstacleType.SNAKE;
    }
}
