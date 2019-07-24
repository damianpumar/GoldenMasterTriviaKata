import java.util.Random;

public class GameRunner {
    private boolean notAWinner;
    private final Game aGame;
    private final Random rand;

    public GameRunner(Random rand) {
        this.rand = rand;
        this.aGame = new Game();
    }

    public void run() {
        aGame.add("Chet");
        aGame.add("Pat");
        aGame.add("Sue");

        do {

            aGame.roll(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                notAWinner = aGame.wrongAnswer();
            } else {
                notAWinner = aGame.wasCorrectlyAnswered();
            }

        } while (notAWinner);
    }

    public static void main(String[] args) {
        Random rand = new Random();

        new GameRunner(rand).run();
    }
}