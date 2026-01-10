import java.util.Scanner;

public class StartGame {
    public static void main(String[] args) {
        System.out.println("----------- Welcome to tic-tac-toe ----------------");
        System.out.println("Enter the Board Size : ");
        Scanner inp = new Scanner(System.in);
        int R = inp.nextInt();
        if(R < 0) {
            System.out.println(" R must be > 0 ");
            return;
        }
        new GameService(R).initiateGame();
    }
}
