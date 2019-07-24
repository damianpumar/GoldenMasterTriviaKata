import java.util.Arrays;

public class Board {
    private final Players players;

    private Questions questions;
    private int[] places;
    private boolean[] inPenaltyBox;

    public Board(Players players, Questions questions, int[] places, boolean[] inPenaltyBox) {
        this.players = players;
        this.questions = questions;
        this.places = places;
        this.inPenaltyBox = inPenaltyBox;
    }

    public boolean roll(int roll) {
        System.out.println(players.getCurrentPlayer() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (!inPenaltyBox[players.currentPlayer]) {
            changeLocation(roll);

            return false;
        }

        if (isOdd(roll)) {
            System.out.println(players.getCurrentPlayer() + " is getting out of the penalty box");

            changeLocation(roll);

            return true;
        }

        System.out.println(players.getCurrentPlayer() + " is not getting out of the penalty box");

        return false;
    }

    private void changeLocation(int roll) {
        places[players.currentPlayer] += roll;

        if (currentPlace() > 11)
            places[players.currentPlayer] -= 12;

        System.out.println(this.players.getCurrentPlayer()
                + "'s new location is "
                + currentPlace());
        System.out.println("The category is " + currentCategory());

        questions.askQuestion(currentCategory());
    }

    private String currentCategory() {
        if (isCurrentPlace(0, 4, 8)) return "Pop";

        if (isCurrentPlace(1, 5, 9)) return "Science";

        if (isCurrentPlace(2, 6, 10)) return "Sports";

        return "Rock";
    }

    private boolean isCurrentPlace(int... places) {
        return Arrays.stream(places).anyMatch(p -> currentPlace() == p);
    }

    private int currentPlace() {
        return places[players.currentPlayer];
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }
}
