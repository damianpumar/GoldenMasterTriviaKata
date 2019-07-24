import java.util.Random;

public class GameRunner {
    private final Game aGame;
    private final Random rand;

    public GameRunner(Random rand) {
        this.rand = rand;
        this.aGame = new Game();
    }

    public void run() {
        boolean notAWinner;

        aGame.addPlayer("Chet");
        aGame.addPlayer("Pat");
        aGame.addPlayer("Sue");

        do {

            aGame.roll(rand.nextInt(5) + 1);

            notAWinner = aGame.decideAnswer(rand.nextInt(9));

        } while (notAWinner);
    }

    public static void main(String[] args) {
        Random rand = new Random();

        new GameRunner(rand).run();
    }
}