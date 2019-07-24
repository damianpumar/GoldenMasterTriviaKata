public class Board {
    private final Players players;
    private final Score score;

    private boolean isGettingOutOfPenaltyBox;

    public Board(int[] places, int[] purses, boolean[] inPenaltyBox) {
        this.players = new Players(places, purses, inPenaltyBox);

        this.score = new Score(players);
    }

    public void roll(int roll) {
        isGettingOutOfPenaltyBox = players.roll(roll);
    }

    public void addPlayer(String name) {
        players.addPlayer(name);
    }

    public boolean answer(int nextValue) {
        return this.score.answer(nextValue, isGettingOutOfPenaltyBox);
    }
}
