import java.util.Arrays;

public class Game {
    private final Board board;
    private final Players players;
    private final Answers answers;
    private final Questions questions;

    private int[] places = new int[6];
    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];
    private boolean isGettingOutOfPenaltyBox;

    public Game() {
        this.players = new Players(places, purses, inPenaltyBox);
        this.answers = new Answers(this.players,purses, inPenaltyBox);
        this.questions = new Questions();
        this.board= new Board(players, questions, places, inPenaltyBox);
    }

    public void roll(int roll) {
        isGettingOutOfPenaltyBox = board.roll(roll);
    }

    public void addPlayer(String name) {
        players.addPlayer(name);
    }

    public boolean decideAnswer(int nextValue) {
        return this.answers.answer(nextValue, isGettingOutOfPenaltyBox);
    }
}