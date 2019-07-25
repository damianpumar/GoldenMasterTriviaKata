import java.util.ArrayList;

public class Players {
    private final CategorySelector categorySelector;
    private final QuestionSelector questionSelector;

    private final ArrayList<Player> players;

    private int currentPlayer = 0;

    public Players(int[] places, int[] purses, boolean[] inPenaltyBox) {
        this.players = new ArrayList();

        this.categorySelector = new CategorySelector();
        this.questionSelector = new QuestionSelector();
    }

    public void addPlayer(String name) {
        players.add(new Player(name, categorySelector, questionSelector));

        System.out.println("They are player number " + howManyPlayers());
    }

    public boolean roll(int roll) {
        System.out.println(getCurrentPlayer().name() + " is the current player");

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

    public void move(int roll) {
        Player player = getCurrentPlayer();

        player.move(roll);
    }

    public void increasePurse() {
        getCurrentPlayer().increasePurse();
    }

    public int currentPurse() {
        return getCurrentPlayer().currentPurse();
    }

    public void moveToPenaltyBox() {
        getCurrentPlayer().moveToPenaltyBox();
    }

    public boolean isInPenaltyBox() {
        return getCurrentPlayer().isInPenaltyBox();
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    private boolean stillInPenaltyBox() {
        System.out.println(getCurrentPlayer().name() + " is not getting out of the penalty box");

        return false;
    }

    private boolean gettingOutPenaltyBox(int roll) {
        System.out.println(getCurrentPlayer().name() + " is getting out of the penalty box");

        move(roll);

        return true;
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }

    private int howManyPlayers() {
        return players.size();
    }

    public String currentPlayerName() {
        return getCurrentPlayer().name();
    }
}
