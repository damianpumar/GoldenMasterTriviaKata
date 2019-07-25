
public class Game {
    private final Board board;
    
    public Game() {
        this(new Rule());
    }

    Game(Rule rule) {
        this.board = new Board(rule);
    }

    public void addPlayer(String name) {
        board.addPlayer(name);
    }

    public void roll() {
        board.roll();
    }

    public boolean isWinnerCurrentPlayer() {
        return board.isWinnerCurrentPlayer();
    }
}