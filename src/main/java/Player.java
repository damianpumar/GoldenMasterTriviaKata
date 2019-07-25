import java.util.Random;

public class Player {
    private final Rule rule;

    private final String name;
    private int place = 0;
    private int purse = 0;
    private boolean inPenaltyBox = false;
    private boolean isGettingOutOfPenaltyBox;

    public Player(String name, Rule rule) {
        this.name = name;
        this.rule = rule;

        System.out.println(name + " was added");
    }

    public void roll() {
        int roll = rule.nextRoll();

        System.out.println(name + " is the current player");

        System.out.println("They have rolled a " + roll);

        if (!inPenaltyBox) {
            move(roll);

            return;
        }

        if (isOdd(roll)) {
            System.out.println(name + " is getting out of the penalty box");

            move(roll);

            isGettingOutOfPenaltyBox = true;
        } else {
            System.out.println(name + " is not getting out of the penalty box");

            isGettingOutOfPenaltyBox = false;
        }
    }

    public void move(int roll) {
        place += roll;

        if (place > 11)
            place -= 12;

        System.out.println(name
                + "'s new location is "
                + place);

        rule.askQuestion(place);
    }

    public int answer() {
        return rule.nextAnswer();
    }

    public void increasePurse() {
        purse++;

        System.out.println(name
                + " now has "
                + purse
                + " Gold Coins.");
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void moveToPenaltyBox() {
        System.out.println(name + " was sent to the penalty box");

        inPenaltyBox = true;
    }

    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }

    public boolean isWinner() {
        return purse == 6;
    }
}
