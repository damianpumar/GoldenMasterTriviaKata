import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public Game() {
        for (int questionNumber = 0; questionNumber < 50; questionNumber++) {
            addQuestions(questionNumber);
        }
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

    private void addQuestions(int questionNumber) {
        popQuestions.addLast("Pop Question " + questionNumber);
        scienceQuestions.addLast(("Science Question " + questionNumber));
        sportsQuestions.addLast(("Sports Question " + questionNumber));
        rockQuestions.addLast("Rock Question "+ questionNumber);
    }

    private int howManyPlayers() {
        return players.size();
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }

    private void changeLocation(int roll) {
        places[currentPlayer] += roll;

        if (places[currentPlayer] > 11)
            places[currentPlayer] -= 12;

        print(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);
        print("The category is " + currentCategory());
        askQuestion();
    }

    public boolean decideAnswer(int nextValue) {
        if (nextValue == 7)
            return wrongAnswer();

        return wasCorrectlyAnswered();
    }

    private void askQuestion() {
        if (currentCategory() == "Pop")
            print(popQuestions.removeFirst());
        if (currentCategory() == "Science")
            print(scienceQuestions.removeFirst());
        if (currentCategory() == "Sports")
            print(sportsQuestions.removeFirst());
        if (currentCategory() == "Rock")
            print(rockQuestions.removeFirst());
    }

    private String currentCategory() {
        if (places[currentPlayer] == 0) return "Pop";
        if (places[currentPlayer] == 4) return "Pop";
        if (places[currentPlayer] == 8) return "Pop";
        if (places[currentPlayer] == 1) return "Science";
        if (places[currentPlayer] == 5) return "Science";
        if (places[currentPlayer] == 9) return "Science";
        if (places[currentPlayer] == 2) return "Sports";
        if (places[currentPlayer] == 6) return "Sports";
        if (places[currentPlayer] == 10) return "Sports";
        return "Rock";
    }

    private boolean wasCorrectlyAnswered() {
        if (inPenaltyBox[currentPlayer]) {
            if (isGettingOutOfPenaltyBox) {
                print("Answer was correct!!!!");

                return decideIsWinner();
            } else {
                resetCurrentPlayer();
                return true;
            }
        } else {

            print("Answer was corrent!!!!");

            return decideIsWinner();
        }
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
        return !(purses[currentPlayer] == 6);
    }

    private void print(Object value) {
        System.out.println(value);
    }
}