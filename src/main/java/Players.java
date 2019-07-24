import java.util.ArrayList;

public class Players {
    private final ArrayList players;
    public int currentPlayer = 0;

    public Players() {
        this.players = new ArrayList();
    }

    public ArrayList player() {
        return this.players;
    }

    public void addPlayer(String name) {
        players.add(name);

        System.out.println(name + " was added");
        System.out.println("They are player number " + howManyPlayers());
    }

    public int howManyPlayers() {
        return players.size();
    }

    public Object getCurrentPlayer() {
        return players.get(currentPlayer);
    }

    public void changePlayer() {
        currentPlayer++;
        if (currentPlayer == howManyPlayers()) currentPlayer = 0;
    }
}
