public class Player {
    private final CategorySelector categorySelector;
    private final QuestionSelector questionSelector;

    private final String name;

    private int place = 0;
    private int purse = 0;
    private boolean inPenaltyBox = false;

    public Player(String name, CategorySelector categorySelector, QuestionSelector questionSelector) {
        this.categorySelector = categorySelector;
        this.questionSelector = questionSelector;

        this.name = name;

        System.out.println(name + " was added");
    }

    public boolean roll(int roll) {
        System.out.println(name + " is the current player");

        System.out.println("They have rolled a " + roll);

        if(!inPenaltyBox) {
            move(roll);

            return false;
        }

        if (isOdd(roll)) {
            return gettingOutPenaltyBox(roll);
        }

        return stillInPenaltyBox();
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

    public String name() {
        return name;
    }

    public void increasePurse() {
        purse++;
    }

    public int currentPurse() {
        return purse;
    }

    public void moveToPenaltyBox() {
        inPenaltyBox = true;
    }

    public boolean isInPenaltyBox() {
        return inPenaltyBox;
    }

    private boolean stillInPenaltyBox() {
        System.out.println(name + " is not getting out of the penalty box");

        return false;
    }

    private boolean gettingOutPenaltyBox(int roll) {
        System.out.println(name + " is getting out of the penalty box");

        move(roll);

        return true;
    }

    private boolean isOdd(int roll) {
        return roll % 2 != 0;
    }
}
