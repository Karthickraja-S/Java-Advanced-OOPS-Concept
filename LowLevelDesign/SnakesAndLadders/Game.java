import obstacles.Obstacle;
import obstacles.ObstacleFactory;
import obstacles.ObstacleType;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Random;

public class Game {
    private final int noOfSnakes;
    private final int noOfLadders;
    private final Board board;
    private final Queue<Player> playerQueue;
    private final Dice dice;

    public Game(int size,int noOfLadders,int noOfSnakes,int noOfDice) {
        this.noOfLadders = noOfLadders;
        this.noOfSnakes = noOfSnakes;
        this.dice = new Dice(noOfDice);
        this.board = new Board(size);

        playerQueue = new ArrayDeque<>();

        initBoardObstacles();
    }

    private void initBoardObstacles() {
        generateObstacle(noOfSnakes, ObstacleType.SNAKE);
        generateObstacle(noOfLadders,ObstacleType.LADDER);
    }

    private void generateObstacle(int count, ObstacleType obstacleType) {
        Random random = new Random();
        int size = board.getSize();
        while(count > 0)  {
            int up = random.nextInt(2,size - 1 ) + 2;
            int down = random.nextInt(2,up - 1) + 1;

            Obstacle obstacle = ObstacleFactory.getObstacle(obstacleType,up,down);
            if(board.addObstacle(obstacle)) {
                count--;
            }
        }
    }
    public void addPlayer(Player player) {
        playerQueue.add(player);
    }

    public void startGame() throws Exception{
        board.printBoard(playerQueue);

        while (playerQueue.size() >1) {
            Player player = playerQueue.poll();
            System.out.println("-----------------------------------------");

            int diceRolled = dice.rollDice();
            System.out.println("Current player : "+player.playerName+ " rolled dice : "+diceRolled);

            int newPosition = board.getNewPosition(player,diceRolled);
            if(newPosition == board.getSize()) {
                System.out.println("Player : "+player.playerName+" Reached the end .. ");
            } else {
                player.setCurrentPosition(newPosition);
                playerQueue.add(player);
            }
            board.printBoard(playerQueue);
        //    Thread.sleep(10 * 1000);
        }
    }

}
