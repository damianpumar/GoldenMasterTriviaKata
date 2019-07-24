import java.util.Arrays;

public class Game {
    private final Questions questions;
    private final Players players;
    private final Answers answers;

    private int[] places = new int[6];
    private int[] purses = new int[6];
    private boolean[] inPenaltyBox = new boolean[6];
    private boolean isGettingOutOfPenaltyBox;

    public Game() {
        this.questions = new Questions();
        this.players = new Players();
        this.answers = new Answers(this.players,purses, inPenaltyBox);
    }

    public void roll(int roll) {
        print(players.getCurrentPlayer() + " is the current player");
        print("They have rolled a " + roll);

        if (!inPenaltyBox[players.currentPlayer]) {
            changeLocation(roll);

            return;
        }

        if (isOdd(roll)) {
            isGettingOutOfPenaltyBox = true;

            print(players.getCurrentPlayer() + " is getting out of the penalty box");

            changeLocation(roll);
        } else {
            print(players.getCurrentPlayer() + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
        }
    }

    public void addPlayer(String name) {
        places[this.players.howManyPlayers()] = 0;
        purses[this.players.howManyPlayers()] = 0;
        inPenaltyBox[this.players.howManyPlayers()] = false;
        this.players.addPlayer(name);
    }

    public boolean decideAnswer(int nextValue) {
        return this.answers.answer(nextValue, isGettingOutOfPenaltyBox);
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }

    private void changeLocation(int roll) {
        places[players.currentPlayer] += roll;

        if (currentPlace() > 11)
            places[players.currentPlayer] -= 12;

        print(this.players.getCurrentPlayer()
                + "'s new location is "
                + currentPlace());
        print("The category is " + currentCategory());

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

    private void print(Object value) {
        System.out.println(value);
    }
}