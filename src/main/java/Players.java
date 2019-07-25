import java.util.ArrayList;
import java.util.Random;

public class Players {
    private final ArrayList<Player> players;

    private final Random randomRoll;
    private final CategorySelector categorySelector;
    private final QuestionSelector questionSelector;

    private int currentPlayer = 0;

    public Players(Random randomRoll) {
        this.players = new ArrayList();

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

    public Player player() {
        return players.get(currentPlayer);
    }

    private int howManyPlayers() {
        return players.size();
    }
}
