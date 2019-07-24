public class Answers {
    private final Players players;
    private int[] purses;
    private boolean[] inPenaltyBox;

    public Answers(Players players, int[] purses, boolean[] inPenaltyBox) {
        this.players = players;
        this.purses = purses;
        this.inPenaltyBox = inPenaltyBox;
    }

    public boolean answer(int nextValue, boolean isGettingOutOfPenaltyBox) {
        if (nextValue == 7)
            return wrongAnswer();

        return wasCorrectlyAnswered(isGettingOutOfPenaltyBox);
    }

    private boolean wasCorrectlyAnswered(boolean isGettingOutOfPenaltyBox) {
        if (!inPenaltyBox[players.currentPlayer]) {
            System.out.println("Answer was corrent!!!!");

            return decideIsWinner();
        }

        if (isGettingOutOfPenaltyBox) {
            System.out.println("Answer was correct!!!!");

            return decideIsWinner();
        }

        players.changePlayer();

        return true;
    }

    private boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(this.players.getCurrentPlayer() + " was sent to the penalty box");
        inPenaltyBox[players.currentPlayer] = true;

        this.players.changePlayer();

        return true;
    }

    private boolean decideIsWinner() {
        purses[players.currentPlayer]++;
        System.out.println(players.getCurrentPlayer()
                + " now has "
                + purses[players.currentPlayer]
                + " Gold Coins.");

        boolean winner = didPlayerWin();

        players.changePlayer();

        return winner;
    }

    private boolean didPlayerWin() {
        return purses[players.currentPlayer] != 6;
    }
}
