import java.util.Random;

public class Player {
    private final CategorySelector categorySelector;
    private final QuestionSelector questionSelector;
    private final Random randomRoll;

    private final String name;
    private int place = 0;
    private int purse = 0;
    private boolean inPenaltyBox = false;
    private boolean isGettingOutOfPenaltyBox;

    public Player(String name, Random randomRoll, CategorySelector categorySelector, QuestionSelector questionSelector) {
        this.name = name;

        this.randomRoll = randomRoll;
        this.categorySelector = categorySelector;
        this.questionSelector = questionSelector;

        System.out.println(name + " was added");
    }

    public void roll() {
        int roll = randomRoll.nextInt(5) + 1;

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

        String chosenCategory = categorySelector.choiceCategory(place);

        questionSelector.askQuestion(chosenCategory);
    }

    public int answer() {
        return randomRoll.nextInt(9);
    }

    public String name() {
        return name;
    }

    public int purse() {
        return purse;
    }

    public void increasePurse() {
        purse++;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    public void moveToPenaltyBox() {
        inPenaltyBox = true;
    }

    public boolean isGettingOutOfPenaltyBox() {
        return isGettingOutOfPenaltyBox;
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }
}
