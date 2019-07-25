import java.util.Random;

public class Board {
    private final Players players;
    private final Score score;

    public Board(Random randomRoll) {
        this.players = new Players(randomRoll);

        this.score = new Score();
    }

    public void addPlayer(String name) {
        players.addPlayer(name);
    }

    public void roll() {
        players.roll();
    }

    public boolean isWinnerCurrentPlayer() {
        Boolean isWinner = this.score.isWinner(players.player());

        players.changePlayer();

        return isWinner;
    }
}
