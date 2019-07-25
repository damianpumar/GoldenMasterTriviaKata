public class Score {
    public boolean isWinner(Player currentPlayer) {
        if (currentPlayer.answer() == 7)
            return wrongAnswer(currentPlayer);

        return correctAnswer(currentPlayer);
    }

    private boolean wrongAnswer(Player currentPlayer) {
        System.out.println("Question was incorrectly answered");

        System.out.println(currentPlayer.name() + " was sent to the penalty box");

        currentPlayer.moveToPenaltyBox();

        return false;
    }

    private boolean correctAnswer(Player currentPlayer) {
        if (!currentPlayer.isInPenaltyBox()) {
            System.out.println("Answer was corrent!!!!");

            return decideIsWinner(currentPlayer);
        }

        if (currentPlayer.isGettingOutOfPenaltyBox()) {
            System.out.println("Answer was correct!!!!");

            return decideIsWinner(currentPlayer);
        }

        return false;
    }

    private boolean decideIsWinner(Player currentPlayer) {
        currentPlayer.increasePurse();

        System.out.println(currentPlayer.name()
                + " now has "
                + currentPlayer.purse()
                + " Gold Coins.");

        return currentPlayer.purse() == 6;
    }
}
