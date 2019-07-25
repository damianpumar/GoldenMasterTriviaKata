public class Player {
    private final CategorySelector categorySelector;
    private final QuestionSelector questionSelector;

    private final String name;

    private int place = 0;
    private int purse = 0 ;
    private boolean inPenaltyBox = false;

    public Player(String name, CategorySelector categorySelector, QuestionSelector questionSelector) {
        this.categorySelector = categorySelector;
        this.questionSelector = questionSelector;

        this.name = name;

        System.out.println(name + " was added");
    }

    public void move(int roll) {
        place  += roll;

        if (place > 11)
            place -= 12;

        System.out.println(name
                + "'s new location is "
                + place);

        String chosenCategory = categorySelector.choiceCategory(place);

        questionSelector.askQuestion(chosenCategory);
    }

    public int place(){
        return place;
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
}
