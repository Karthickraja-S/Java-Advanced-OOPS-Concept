import obstacles.LadderObstacle;
import obstacles.Obstacle;
import obstacles.SnakeObstacle;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Board {
    private int size;
    private int sideLength;
    private final Cell[][] grid;

    public Board(int size) {
        this.size = size;
        this.sideLength = (int) Math.sqrt(size);
        this.grid  = new Cell[sideLength][sideLength];

        int position = 1;
        boolean leftToRight = true;
        // Think the board
        // N=9
        // 7 8 9
        // 6 5 4
        // 1 2 3
        for(int i=sideLength-1; i>=0 ; i--) {
            if(leftToRight) {
                for(int j=0;j<sideLength;j++) {
                    grid[i][j] = new Cell(position++);
                }
            } else {
                for(int j=sideLength-1;j>=0;j--) {
                    grid[i][j] = new Cell(position++);
                }
            }
            leftToRight = !leftToRight;
        }
    }

    private int getRow(int position) {
        // if i have the position, i need to return the row count.
        // why position-1 ? because we are starting the grid from 1 -> N, If 0->N-1 then position-1 not needed.
        // Position is enough.
        int row = (position - 1)/sideLength;
        return sideLength - row - 1;
    }

    private int getCol(int position) {
        int row = getRow(position);
        int col = (position -1) % sideLength;
        return row%2==0 ? sideLength-col-1 : col;
    }

    public boolean addObstacle(Obstacle obstacle) {
        Cell srcCell = getCell(obstacle.getSrc());
        Cell destCell = getCell(obstacle.getDesc());
        // if obstacle already present.
        if(srcCell.hasObstacle() || destCell.hasObstacle()) {
            return false;
        }
        srcCell.setObstacle(obstacle);
        return true;
    }
    public Cell getCell(int position) {
        return grid[getRow(position)][getCol(position)];
    }
    public int getNewPosition(Player player , int offset) {
        int newPosition =  player.getCurrentPosition() + offset;
        if(newPosition > size ) {
            System.out.println("New position extends the overall size. Better luck next time..");
            return player.getCurrentPosition();
        }
        Cell cell = grid[getRow(newPosition)][getCol(newPosition)];
        int finalPosition = cell.getFinalPosition();

        if(finalPosition < newPosition) {
            System.out.println("OOPS! Snake bitten.. your new position is : "+finalPosition);
        } else if(finalPosition > newPosition) {
            System.out.println("Congrats! A Ladder helped you to go to new position : "+finalPosition);
        } else {
            System.out.println(player.playerName+ " moved to new position : "+finalPosition);
        }
        return finalPosition;
    }
    public void printBoard(Queue<Player> playerQueue) {
        System.out.println("Current board state : \n");

        for(int i=0;i<sideLength;i++) {
            for(int j=0; j<sideLength;j++) {
                Cell cell = grid[i][j];
                String toPrint = getPrintableFormat(playerQueue,cell);
                System.out.print(toPrint+" | ");
            }
            System.out.println();
        }
    }

    private String getPrintableFormat(Queue<Player> playerQueue, Cell cell) {
        int position = cell.getPosition();
        List<String> playerName = new ArrayList<>();
        for(Player player : playerQueue) {
            if(player.getCurrentPosition() == position) {
                playerName.add(player.playerName);
            }
        }
        if(cell.hasObstacle()) {
            Obstacle obstacle = cell.getObstacle();
            if(obstacle instanceof SnakeObstacle) {
                return "🐍  ["+ position+"]";
            } else if(obstacle instanceof LadderObstacle) {
                return "🪜  ["+ position+"]";
            }
        }
        if(!playerName.isEmpty()) {
            return playerName.toString()+"    ";
        }
        return position+"      ";
    }

    public int getSize() {
        return size;
    }
}
