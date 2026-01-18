public class Player {
    private int currentPosition;
    String playerName;
    public Player(String playerName) {
        this.playerName = playerName;
        this.currentPosition = 1;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }
    public int getCurrentPosition() {
        return this.currentPosition;
    }

}
