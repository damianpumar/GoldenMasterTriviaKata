import java.util.Random;

public class GameRunner {
    private final Game game;
    private final Random rand;

    public GameRunner(Random rand) {
        this.rand = rand;

        this.game = new Game();
    }

    public void run() {
        boolean notAWinner;

        game.addPlayer("Chet");
        game.addPlayer("Pat");
        game.addPlayer("Sue");

        do {

            game.roll(rand.nextInt(5) + 1);

            notAWinner = game.decideAnswer(rand.nextInt(9));

        } while (notAWinner);
    }

    public static void main(String[] args) {
        Random rand = new Random();

        new GameRunner(rand).run();
    }
}