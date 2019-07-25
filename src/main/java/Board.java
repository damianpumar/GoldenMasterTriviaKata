import java.util.ArrayList;
import java.util.Random;

public class Board {
    private final ArrayList<Player> players;
    private Rule rule;
    private final Score score;

    private int currentPlayer = 0;

    public Board(Rule rule) {
        this.players = new ArrayList();
        this.rule = rule;
        this.score = new Score();
    }

    public void addPlayer(String name) {
        players.add(new Player(name, rule));

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
