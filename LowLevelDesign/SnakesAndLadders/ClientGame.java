import java.util.Scanner;

public class ClientGame {
    static void main() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter board size : (Need to be a perfect square ) ");
        int boardSize = scanner.nextInt();

        System.out.println("Enter number of snakes : ");
        int snakeCount = scanner.nextInt(); // considering user input is < board size and a valid input

        System.out.println("Enter number of ladders : ");
        int ladderCount = scanner.nextInt();

        System.out.println("Enter number of players : ");
        int playerCount = scanner.nextInt();

        System.out.println("Enter number of dice : ");
        int diceCount = scanner.nextInt();
        scanner.nextLine(); //ByPass
        Game game = new Game(boardSize,ladderCount,snakeCount,diceCount);
        for(int i=0;i<playerCount;i++) {
            System.out.println("Enter the name of player : "+ (i+1) + " : ");
            String playerName = scanner.nextLine();
            Player player = new Player(playerName);
            game.addPlayer(player);
        }

        game.startGame();
    }
}
