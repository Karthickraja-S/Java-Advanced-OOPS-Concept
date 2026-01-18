package obstacles;

public class ObstacleFactory {
    public static Obstacle getObstacle(ObstacleType type , int up , int down) {
        return
                switch (type) {
                    case SNAKE -> new SnakeObstacle(up,down);
                    case LADDER -> new LadderObstacle(up,down);
                    default -> throw new IllegalArgumentException("Invalid Type");
                };
    }
}
