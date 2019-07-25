
public class GameRunner {
    private final Game game;

    public GameRunner(Game game) {
        this.game = game;
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
        new GameRunner(new Game()).run();
    }
}