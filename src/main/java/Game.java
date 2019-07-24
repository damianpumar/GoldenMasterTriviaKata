import java.util.Arrays;

public class Game {
    private final Board board;

    private int[] places = new int[6];
    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];

    public Game() {
        this.board = new Board(places, purses, inPenaltyBox);
    }

    public void roll(int roll) {
        board.roll(roll);
    }

    public void addPlayer(String name) {
        board.addPlayer(name);
    }

    public boolean decideAnswer(int nextValue) {
        return board.answer(nextValue);
    }
}