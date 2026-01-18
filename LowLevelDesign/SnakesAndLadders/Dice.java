import java.util.Random;

public class Dice {
    public int noOfDice;
    public Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }
    public int rollDice() {
        Random random = new Random();
        int sum = 0;
        int cnt = 1;
        while (cnt <= noOfDice) {
            int within6 = random.nextInt(1, 6);
            sum += within6;
            cnt++;
        }
        return sum;
    }
}
