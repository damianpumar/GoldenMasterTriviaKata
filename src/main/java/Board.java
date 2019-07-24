public class Board {
    private final Players players;
    private final Answers answers;
    private final Questions questions;

    private int[] places;
    private boolean[] inPenaltyBox;
    private boolean isGettingOutOfPenaltyBox;

    private final int MAX_PLACES_PER_PLAYER = 11;

    public Board(int[] places, int[] purses, boolean[] inPenaltyBox) {
        this.players = new Players(places, purses, inPenaltyBox);
        this.answers = new Answers(players, purses, inPenaltyBox);
        this.questions = new Questions(players, places);
        this.places = places;
        this.inPenaltyBox = inPenaltyBox;
    }

    public void roll(int roll) {
        System.out.println(players.getCurrentPlayer() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (!inPenaltyBox[players.currentPlayer]) {
            changeLocation(roll);

            return;
        }

        if (isOdd(roll)) {
            System.out.println(players.getCurrentPlayer() + " is getting out of the penalty box");

            changeLocation(roll);

            isGettingOutOfPenaltyBox = true;
        } else {
            System.out.println(players.getCurrentPlayer() + " is not getting out of the penalty box");

            isGettingOutOfPenaltyBox = false;
        }
    }

    public void addPlayer(String name) {
        players.addPlayer(name);
    }

    public boolean answer(int nextValue) {
        return answers.answer(nextValue, isGettingOutOfPenaltyBox);
    }

    private void changeLocation(int roll) {
        places[players.currentPlayer] += roll;

        if (places[players.currentPlayer] > MAX_PLACES_PER_PLAYER)
            places[players.currentPlayer] -= 12;

        System.out.println(this.players.getCurrentPlayer()
                + "'s new location is "
                + places[players.currentPlayer]);

        questions.askQuestion();
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }
}
