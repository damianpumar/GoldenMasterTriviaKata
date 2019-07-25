import java.util.Random;

public class Game {
    private final Board board;

    public Game(Random randomRoll) {
        this.board = new Board(randomRoll);
    }

    public void addPlayer(String name) {
        board.addPlayer(name);
    }

    public void roll() {
        board.roll();
    }

    public boolean isWinnerCurrentPlayer() {
        return board.isWinnerCurrentPlayer();
    }
}