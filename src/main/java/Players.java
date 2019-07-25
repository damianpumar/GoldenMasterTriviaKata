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
        return getCurrentPlayer().roll(roll);
    }

    public void changePlayer() {
        currentPlayer++;

        if (currentPlayer == howManyPlayers())
            currentPlayer = 0;
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





    private int howManyPlayers() {
        return players.size();
    }

    public String currentPlayerName() {
        return getCurrentPlayer().name();
    }
}
