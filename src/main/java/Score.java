public class Score {
    public boolean isWinner(Player currentPlayer) {
        if (currentPlayer.answer() == 7)
            return wrongAnswer(currentPlayer);

        return correctAnswer(currentPlayer);
    }

    private boolean wrongAnswer(Player currentPlayer) {
        System.out.println("Question was incorrectly answered");

        currentPlayer.moveToPenaltyBox();

        return false;
    }

    private boolean correctAnswer(Player currentPlayer) {
        if (!currentPlayer.isInPenaltyBox() || currentPlayer.isGettingOutOfPenaltyBox()) {
            System.out.println("Answer was correct!!!!");

            return decideIsWinner(currentPlayer);
        }

        return false;
    }

    private boolean decideIsWinner(Player currentPlayer) {
        currentPlayer.increasePurse();

        return currentPlayer.isWinner();
    }

}
