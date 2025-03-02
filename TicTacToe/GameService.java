import java.util.Arrays;
import java.util.Scanner;

public class GameService {

    char[][] matrix;
    int boardSize;
    public GameService(int R) {
        boardSize = R;
        matrix = new char[R][R];
        for(char[] arr : matrix) {
            Arrays.fill(arr,' ');
        }
    }
    private GameService(){}
    public void printMatrix() {
        String upBorder = "--";
        for(int r = 0;r<boardSize;r++) {
            for(int c=0;c<boardSize;c++) {
                System.out.print(matrix[r][c]);
                System.out.print("|");
            }
            System.out.println();
            System.out.print(upBorder.repeat(boardSize));
            System.out.println();
        }
    }
    public void initiateGame() {
        Scanner ip = new Scanner(System.in);
        boolean firstPlayer = true;
        int r;
        int c;
        printMatrix();
        do {
            char player = firstPlayer ? 'X' : 'O' ;
            System.out.println(String.format("***** Player %c ***** ",player) );
            boolean valid = true;
            do {
                System.out.println("Enter Row & column position : ");
                 r = ip.nextInt();
                 c = ip.nextInt();
                if (r >= boardSize || c >= boardSize) {
                    valid = false;
                    System.out.println("Invalid Input! Try Again");
                } else if(matrix[r][c] !=' ') {
                    valid = false;
                    System.out.println("Already The place is filled .. Try Again ");
                }
            } while (!valid);
            matrix[r][c] = player;
            firstPlayer = !firstPlayer;
        } while (!isGameEnd(r, c));
    }

    private boolean isGameEnd(int rowChosen , int colChosen) {
        printMatrix();
        if( playerWins('X',rowChosen,colChosen)) {
            System.out.println("Player X Wins....");
            return true;
        }

        if( playerWins('O',rowChosen,colChosen)) {
            System.out.println("Player O Wins....");
            return true;
        }

        for (int r=0;r<boardSize;r++) {
            for (int c = 0; c < boardSize; c++) {
                if (matrix[r][c] == ' ') {
                    return false;
                }
            }
        }
        System.out.println("Game Draw.... :( ");
        return true;
    }
    private boolean playerWins(char ch, int rowChosen, int colChosen) {
       if(GameValidator.validateRow(matrix,ch,rowChosen)) {
          // System.out.println("Row");
           return true;
       }
        if(GameValidator.validateCol(matrix,ch,colChosen)) {
          //  System.out.println("Col");
            return true;
        }
        return GameValidator.validateCross(matrix,ch);
    }
}
