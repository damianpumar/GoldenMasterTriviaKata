import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList players = new ArrayList();
    int[] places = new int[6];
    int[] purses  = new int[6];
    boolean[] inPenaltyBox  = new boolean[6];

    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

    public  Game(){
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createRockQuestion(int index){
        return "Rock Question " + index;
    }

    public boolean addPlayer(String name) {
        players.add(name);
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        print(name + " was added");
        print("They are player number " + players.size());
        return true;
    }

    private int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        print(players.get(currentPlayer) + " is the current player");
        print("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            if (roll % 2 != 0) {
                isGettingOutOfPenaltyBox = true;

                print(players.get(currentPlayer) + " is getting out of the penalty box");

                changeLocation(roll);
            } else {
                print(players.get(currentPlayer) + " is not getting out of the penalty box");
                isGettingOutOfPenaltyBox = false;
            }

        } else {
            changeLocation(roll);
        }
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
        if (inPenaltyBox[currentPlayer]){
            if (isGettingOutOfPenaltyBox) {
                print("Answer was correct!!!!");
                purses[currentPlayer]++;
                print(players.get(currentPlayer)
                        + " now has "
                        + purses[currentPlayer]
                        + " Gold Coins.");

                boolean winner = didPlayerWin();
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;

                return winner;
            } else {
                currentPlayer++;
                if (currentPlayer == players.size()) currentPlayer = 0;
                return true;
            }



        } else {

            print("Answer was corrent!!!!");
            purses[currentPlayer]++;
            print(players.get(currentPlayer)
                    + " now has "
                    + purses[currentPlayer]
                    + " Gold Coins.");

            boolean winner = didPlayerWin();
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;

            return winner;
        }
    }

    private boolean wrongAnswer(){
        print("Question was incorrectly answered");
        print(players.get(currentPlayer)+ " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }

    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }

    private void print(Object value){
        System.out.println(value);
    }
}