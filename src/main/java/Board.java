import java.util.ArrayList;
import java.util.Random;

public class Board {
    private final ArrayList<Player> players;
    private final Score score;

    private final Random randomRoll;
    private final CategorySelector categorySelector;
    private final QuestionSelector questionSelector;

    private int currentPlayer = 0;

    public Board(Random randomRoll) {
        this.players = new ArrayList();
        this.score = new Score();

        this.randomRoll = randomRoll;
        this.categorySelector = new CategorySelector();
        this.questionSelector = new QuestionSelector();
    }

    public void addPlayer(String name) {
        players.add(new Player(name, randomRoll, categorySelector, questionSelector));

        System.out.println("They are player number " + howManyPlayers());
    }

    public void roll() {
        player().roll();
    }

    public void changePlayer() {
        currentPlayer++;

        if (currentPlayer == howManyPlayers())
            currentPlayer = 0;
    }

    public boolean isWinnerCurrentPlayer() {
        Boolean isWinner = this.score.isWinner(player());

        changePlayer();

        return isWinner;
    }

    private Player player() {
        return players.get(currentPlayer);
    }

    private int howManyPlayers() {
        return players.size();
    }
}
