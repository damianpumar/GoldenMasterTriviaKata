import java.util.Random;

public class GameRunner {
    private final Game game;
    private final Random randomRoll;

    public GameRunner(Random randomRoll) {
        this.randomRoll = randomRoll;

        this.game = new Game(this.randomRoll);
    }

    public void run() {
        boolean aWinner;

        game.addPlayer("Chet");
        game.addPlayer("Pat");
        game.addPlayer("Sue");

        do {

            game.roll();

            aWinner = game.isWinnerCurrentPlayer();

        } while (!aWinner);
    }

    public static void main(String[] args) {
        Random rand = new Random();

        new GameRunner(rand).run();
    }
}