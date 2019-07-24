public class Score {
    private final Players players;
    
    public Score(Players players) {
        this.players = players;
    }

    public boolean answer(int nextValue, boolean isGettingOutOfPenaltyBox) {
        if (nextValue == 7)
            return wrongAnswer();

        return wasCorrectlyAnswered(isGettingOutOfPenaltyBox);
    }

    private boolean wasCorrectlyAnswered(boolean isGettingOutOfPenaltyBox) {
        if (!players.isInPenaltyBox()) {
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

        players.moveToPenaltyBox();

        players.changePlayer();

        return true;
    }

    private boolean decideIsWinner() {
        players.increasePurse();

        System.out.println(players.getCurrentPlayer()
                + " now has "
                + players.currentPurse()
                + " Gold Coins.");

        boolean winner = didPlayerWin();

        players.changePlayer();

        return winner;
    }

    private boolean didPlayerWin() {
        return players.currentPurse() != 6;
    }
}
