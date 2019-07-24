import java.util.ArrayList;

public class Players {
    private final ArrayList players;

    private final Category category;
    private final Questions questions;

    private int currentPlayer = 0;
    private int[] places;
    private int[] purses;
    private boolean[] inPenaltyBox;

    public Players(int[] places, int[] purses, boolean[] inPenaltyBox) {
        this.players = new ArrayList();

        this.category = new Category();
        this.questions = new Questions();

        this.places = places;
        this.purses = purses;
        this.inPenaltyBox = inPenaltyBox;
    }

    public void addPlayer(String name) {
        initializePlayer(name);

        System.out.println(name + " was added");
        System.out.println("They are player number " + howManyPlayers());
    }

    public boolean roll(int roll) {
        System.out.println(getCurrentPlayer() + " is the current player");

        System.out.println("They have rolled a " + roll);

        if (!isInPenaltyBox()) {
            move(roll);

            return false;
        }

        if (isOdd(roll)) {
            return gettingOutPenaltyBox(roll);
        }

        return stillInPenaltyBox();
    }

    public void changePlayer() {
        currentPlayer++;

        if (currentPlayer == howManyPlayers())
            currentPlayer = 0;
    }

    public String getCurrentPlayer() {
        return String.valueOf(players.get(currentPlayer));
    }

    public void move(int roll) {
        movePlayerNextPlace(roll);

        System.out.println(getCurrentPlayer()
                + "'s new location is "
                + currentPlace());

        String currentCategory = category.printAndReturnCategory(currentPlace());

        questions.askQuestion(currentCategory);
    }

    private void initializePlayer(String name) {
        places[howManyPlayers()] = 0;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;

        players.add(name);
    }

    private void movePlayerNextPlace(int roll) {
        places[currentPlayer] += roll;

        if (places[currentPlayer] > 11)
            places[currentPlayer] -= 12;
    }

    private int currentPlace() {
        return places[currentPlayer];
    }

    public void increasePurse() {
        purses[currentPlayer]++;
    }

    public int currentPurse() {
        return purses[currentPlayer];
    }

    public void moveToPenaltyBox() {
        inPenaltyBox[currentPlayer] = true;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox[currentPlayer];
    }

    private boolean stillInPenaltyBox() {
        System.out.println(getCurrentPlayer() + " is not getting out of the penalty box");

        return false;
    }

    private boolean gettingOutPenaltyBox(int roll) {
        System.out.println(getCurrentPlayer() + " is getting out of the penalty box");

        move(roll);

        return true;
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }

    private int howManyPlayers() {
        return players.size();
    }
}
