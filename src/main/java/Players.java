import java.util.ArrayList;

public class Players {
    private final Category category;
    private final Questions questions;

    private final ArrayList players;
    public int currentPlayer = 0;
    private int[] places;
    private int[] purses;
    private boolean[] inPenaltyBox;

    public Players(int[] places, int[] purses, boolean[] inPenaltyBox) {
        this.category = new Category();
        this.questions = new Questions();
        this.places = places;
        this.purses = purses;
        this.inPenaltyBox = inPenaltyBox;
        this.players = new ArrayList();
    }

    public void addPlayer(String name) {
        places[this.howManyPlayers()] = 0;
        purses[this.howManyPlayers()] = 0;
        inPenaltyBox[this.howManyPlayers()] = false;
        players.add(name);

        System.out.println(name + " was added");
        System.out.println("They are player number " + howManyPlayers());
    }

    public String getCurrentPlayer() {
        return String.valueOf(players.get(currentPlayer));
    }

    public void move(int roll) {
        places[currentPlayer] += roll;

        if (places[currentPlayer] > 11)
            places[currentPlayer] -= 12;

        System.out.println(getCurrentPlayer()
                + "'s new location is "
                + places[currentPlayer]);

        String currentCategory = category.printAndReturnCategory(places[currentPlayer]);

        questions.askQuestion(currentCategory);
    }

    public boolean roll(int roll) {
        boolean isGettingOutOfPenaltyBox = false;

        System.out.println(getCurrentPlayer() + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (!isInPenaltyBox()) {
            move(roll);

            return isGettingOutOfPenaltyBox;
        }

        if (isOdd(roll)) {
            System.out.println(getCurrentPlayer() + " is getting out of the penalty box");

            move(roll);

            isGettingOutOfPenaltyBox = true;
        } else {
            System.out.println(getCurrentPlayer() + " is not getting out of the penalty box");

            isGettingOutOfPenaltyBox = false;
        }

        return isGettingOutOfPenaltyBox;
    }

    public void changePlayer() {
        currentPlayer++;

        if (currentPlayer == howManyPlayers())
            currentPlayer = 0;
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox[currentPlayer];
    }

    private int howManyPlayers() {
        return players.size();
    }
}
