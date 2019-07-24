import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Game {
    private final Questions questions;

    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        this.questions = new Questions();
    }

    public void roll(int roll) {
        print(players.get(currentPlayer) + " is the current player");
        print("They have rolled a " + roll);

        if (!inPenaltyBox[currentPlayer]) {
            changeLocation(roll);

            return;
        }

        if (isOdd(roll)) {
            isGettingOutOfPenaltyBox = true;

            print(players.get(currentPlayer) + " is getting out of the penalty box");

            changeLocation(roll);
        } else {
            print(players.get(currentPlayer) + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
        }
    }

    public void addPlayer(String name) {
        players.add(name);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        print(name + " was added");
        print("They are player number " + howManyPlayers());
    }

    private int howManyPlayers() {
        return players.size();
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }

    private void changeLocation(int roll) {
        places[currentPlayer] += roll;

        if (currentPlace() > 11)
            places[currentPlayer] -= 12;

        print(players.get(currentPlayer)
                + "'s new location is "
                + currentPlace());
        print("The category is " + currentCategory());

        questions.askQuestion(currentCategory());
    }

    private String currentCategory() {
        if (isCurrentPlace(0, 4,8)) return "Pop";

        if (isCurrentPlace(1,5,9)) return "Science";

        if (isCurrentPlace(2, 6,10)) return "Sports";

        return "Rock";
    }

    private boolean isCurrentPlace(int... places) {
        return Arrays.stream(places).anyMatch(p->currentPlace() == p);
    }

    public boolean decideAnswer(int nextValue) {
        if (nextValue == 7)
            return wrongAnswer();

        return wasCorrectlyAnswered();
    }

    private int currentPlace() {
        return places[currentPlayer];
    }

    private boolean wasCorrectlyAnswered() {
        if (!inPenaltyBox[currentPlayer]) {
            print("Answer was corrent!!!!");

            return decideIsWinner();
        }

        if (isGettingOutOfPenaltyBox) {
            print("Answer was correct!!!!");

            return decideIsWinner();
        }

        resetCurrentPlayer();

        return true;
    }

    private boolean decideIsWinner() {
        purses[currentPlayer]++;
        print(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");

        boolean winner = didPlayerWin();

        resetCurrentPlayer();

        return winner;
    }

    private void resetCurrentPlayer() {
        currentPlayer++;
        if (currentPlayer == howManyPlayers()) currentPlayer = 0;
    }

    private boolean wrongAnswer() {
        print("Question was incorrectly answered");
        print(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        resetCurrentPlayer();

        return true;
    }

    private boolean didPlayerWin() {
        return purses[currentPlayer] != 6;
    }

    private void print(Object value) {
        System.out.println(value);
    }
}